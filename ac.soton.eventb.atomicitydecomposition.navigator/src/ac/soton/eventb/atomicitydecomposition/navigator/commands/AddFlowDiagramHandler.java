package ac.soton.eventb.atomicitydecomposition.navigator.commands;

import java.util.Collections;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eventb.core.IMachineRoot;
import org.eventb.emf.core.machine.Machine;

import ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionFactory;
import ac.soton.eventb.atomicitydecomposition.FlowDiagram;
import ac.soton.eventb.atomicitydecomposition.navigator.Activator;


public class AddFlowDiagramHandler extends AbstractHandler {

	// name validator
	static final IInputValidator nameValidator = new IInputValidator(){

		@Override
		public String isValid(String name) {
			if (name.trim().isEmpty())
				return "";
			return null;
		}
	};

	/**
	 * EMF command for adding a Flow Diagram to a machine.
	 * 
	 * @author vitaly/mgt1g13
	 *
	 */
	public class AddFlowDiagramCommand extends AbstractEMFOperation {

		private URI machineURI;
		private FlowDiagram flowdiagram;

		public AddFlowDiagramCommand(URI machineURI, FlowDiagram flowdiagram) {
			super(TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(), "Add Flow Diagram");
			this.machineURI = machineURI;
			this.flowdiagram = flowdiagram;
		}

		@Override
		protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info)
				throws ExecutionException {
			monitor.beginTask("Creating Flow Diagram", IProgressMonitor.UNKNOWN);

			TransactionalEditingDomain editingDomain = getEditingDomain();

			try {
				Resource resource = editingDomain.getResourceSet().getResource(machineURI, true);

				if (resource != null && resource.isLoaded()) {
					Machine machine = (Machine) resource.getContents().get(0);
					machine.getExtensions().add(flowdiagram);
					resource.save(Collections.emptyMap());
				}
			} catch (Exception e) {
				return new Status(Status.ERROR, Activator.PLUGIN_ID, "Failed to add Flow Diagram", e);
			} finally {
				monitor.done();
			}
			return Status.OK_STATUS;
		}

	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelectionChecked(event);
		if (selection instanceof IStructuredSelection) {
			Object element = ((IStructuredSelection) selection).getFirstElement();
			if (element instanceof IMachineRoot) {
				IMachineRoot machineRoot = (IMachineRoot) element;
				IFile file = machineRoot.getResource();

				if (file != null && file.exists()) {
					InputDialog dialog = new InputDialog(Display.getCurrent().getActiveShell(), 
							"New Flow Diagram", 
							"Enter Flow Diagram name: ",
							null, nameValidator);
					if (dialog.open() == InputDialog.CANCEL)
						return null;
					String name = dialog.getValue().trim();

					URI machineURI = URI.createPlatformResourceURI(file.getFullPath().toOSString(), true);
					FlowDiagram flowdiagram = AtomicitydecompositionFactory.eINSTANCE.createFlowDiagram();
					flowdiagram.setName(name);
					try {
						AddFlowDiagramCommand command = new AddFlowDiagramCommand(machineURI, flowdiagram);
						if (command.canExecute())
							command.execute(new NullProgressMonitor(), null);
					} catch (Exception e) {
						Activator.getDefault().logError("Creating Flow diagram failed", e);
					}
				}
			}
		}
		return null;
	}

}
