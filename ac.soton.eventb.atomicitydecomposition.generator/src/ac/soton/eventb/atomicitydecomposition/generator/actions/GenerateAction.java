/**
 * Copyright (c) 2012 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package ac.soton.eventb.atomicitydecomposition.generator.actions;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.expressions.EvaluationContext;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eventb.emf.core.AbstractExtension;
import org.eventb.emf.core.EventBElement;

import ac.soton.eventb.atomicitydecomposition.FlowDiagram;
import ac.soton.eventb.emf.diagrams.generator.Activator;
import ac.soton.eventb.emf.diagrams.generator.command.GenerateCommand;
import ac.soton.eventb.emf.diagrams.generator.impl.GeneratorFactory;
import ac.soton.eventb.emf.diagrams.generator.impl.Messages;
import ac.soton.eventb.roseEditor.RoseEditor;

/**
 * Generate action handler.
 * 
 * @author colin 
 *
 */
public class GenerateAction extends AbstractHandler {

	private boolean enabled = false;
	@Override
	public boolean isEnabled(){
		return enabled && super.isEnabled();
	}

	@Override
	public void setEnabled(Object evaluationContext) {		
		super.setEnabled(evaluationContext);
		enabled = false;
		if (evaluationContext instanceof EvaluationContext){
			EvaluationContext ec = (EvaluationContext)evaluationContext;
			Object editor = ec.getVariable("activeEditor");
			//Object editorID = ec.getVariable("activeEditorId");
			if (editor instanceof RoseEditor) {
				final RoseEditor roseEditor = (RoseEditor)editor;
				IStructuredSelection selection = (IStructuredSelection)roseEditor.getSelection();
				if (selection.getFirstElement() instanceof EventBElement){
					EventBElement sourceElement = (EventBElement)selection.getFirstElement();
					for(AbstractExtension abs: sourceElement.getExtensions()){
						enabled |=  GeneratorFactory.getFactory().canGenerate(abs.eClass());					
					}

				}
			}
		}	
	}



	/* (non-Javadoc)
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		IEditorPart editor = HandlerUtil.getActiveEditorChecked(event);
		if (editor instanceof RoseEditor) {
			final RoseEditor roseEditor = (RoseEditor)editor;
			IStructuredSelection selection = (IStructuredSelection)roseEditor.getSelection();
			if (selection.getFirstElement() instanceof EventBElement){
				final EventBElement eventBElement = (EventBElement) selection.getFirstElement();
				
				ResourceSet resourceSet = eventBElement.eResource().getResourceSet();
				
				if (editor.isDirty())
					editor.doSave(new NullProgressMonitor());

				// first validate, then transform
				//	if (ValidateAction.validate(diagramDocumentEditor)){


				for(AbstractExtension abs : eventBElement.getExtensions()){
					TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain();
					
					
					AbstractExtension absExt;
					if(abs.eIsProxy()){
						absExt = (AbstractExtension) resourceSet.getEObject(EcoreUtil.getURI(abs),false);
					}
					else
						absExt = abs;
	
					
					if(absExt instanceof FlowDiagram){
						//If there is no extension, set as being the name
						if(absExt.getExtensionId() == null || absExt.getExtensionId().equals("")){
							absExt.setExtensionId(((FlowDiagram) absExt).getName()); 
						}
						
						final GenerateCommand generateCommand = new GenerateCommand(
								editingDomain, 
								absExt);
						if (generateCommand.canExecute()) {	
							// run with progress
							ProgressMonitorDialog dialog = new ProgressMonitorDialog(roseEditor.getSite().getShell());
							try {
								dialog.run(true, true, new IRunnableWithProgress(){
									public void run(IProgressMonitor monitor) { 
										monitor.beginTask(Messages.GENERATOR_MSG_05, IProgressMonitor.UNKNOWN);
										try {
											generateCommand.execute(monitor, roseEditor);
										} catch (ExecutionException e) {
											Activator.logError(Messages.GENERATOR_MSG_06, e);
										}
										monitor.done();
									}
								});
							} catch (InvocationTargetException e) {
								Activator.logError(Messages.GENERATOR_MSG_07, e);
								return null;
							} catch (InterruptedException e) {
								Activator.logError(Messages.GENERATOR_MSG_08, e);
								return null;
							} 
							// error feedback
							if (false == generateCommand.getCommandResult().getStatus().isOK())
								MessageDialog
								.openError(editor.getSite().getShell(),
										Messages.GENERATOR_MSG_09,
										Messages.GENERATOR_MSG_10);
						}
					}
				}
			}
		}
		return null;
	}
}
