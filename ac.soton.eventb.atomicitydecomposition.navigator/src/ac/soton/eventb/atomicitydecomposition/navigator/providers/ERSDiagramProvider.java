/**
 * Copyright (c) 2011 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.atomicitydecomposition.navigator.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eventb.emf.core.machine.Machine;

import ac.soton.eventb.atomicitydecomposition.Child;
import ac.soton.eventb.atomicitydecomposition.FlowDiagram;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.FlowDiagramEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.part.AtomicitydecompositionDiagramEditor;
import ac.soton.eventb.atomicitydecomposition.diagram.part.AtomicitydecompositionDiagramEditorPlugin;
import ac.soton.eventb.emf.diagrams.navigator.provider.IDiagramProvider;

/**
 * Diagram provider for ERS.
 * 
 * @author vitaly
 *
 */
public class ERSDiagramProvider implements IDiagramProvider {

	private static final String fileExtension = "ersd";
	
	@Override
	public String getDiagramFileName(EObject element) {
		if (element instanceof FlowDiagram) {
			String filename = "";
			FlowDiagram rootFlowDiagram = (FlowDiagram) element;
			
			// find a root FlowDiagram
			while (rootFlowDiagram.eContainer() instanceof Child
					&& rootFlowDiagram.eContainer().eContainer() instanceof FlowDiagram)
				rootFlowDiagram = (FlowDiagram) rootFlowDiagram.eContainer().eContainer();
			//construct filename
			filename = rootFlowDiagram.getName() + "."+fileExtension;
			// prefix with machine name
			EObject root = EcoreUtil.getRootContainer(element);
			if (root != null && root instanceof Machine)
				filename = ((Machine) root).getName() + "." + filename;
			
			return filename;
		}
		return null;
	}

	@Override
	public PreferencesHint getPreferencesHint() {
		return AtomicitydecompositionDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT;
	}

	@Override
	public String getDiagramKind() {
		return FlowDiagramEditPart.MODEL_ID;
	}

	@Override
	public String getEditorId() {
		return AtomicitydecompositionDiagramEditor.ID;
	}


	@Override
	public String getFileExtension() {
		return fileExtension;
	}
}
