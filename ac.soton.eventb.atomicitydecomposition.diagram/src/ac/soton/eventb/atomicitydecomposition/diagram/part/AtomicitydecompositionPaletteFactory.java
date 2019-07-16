package ac.soton.eventb.atomicitydecomposition.diagram.part;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import org.eclipse.gmf.tooling.runtime.part.DefaultLinkToolEntry;
import org.eclipse.gmf.tooling.runtime.part.DefaultNodeToolEntry;
import ac.soton.eventb.atomicitydecomposition.diagram.providers.AtomicitydecompositionElementTypes;

/**
 * @generated
 */
public class AtomicitydecompositionPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createObjects1Group());
		paletteRoot.add(createConnections2Group());
	}

	/**
	 * Creates "Objects" palette tool group
	 * @generated NOT
	 */
	private PaletteContainer createObjects1Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Objects1Group_title);
		paletteContainer.setId("createObjects1Group"); //$NON-NLS-1$
		paletteContainer.add(createAll1CreationTool());
		paletteContainer.add(createAnd2CreationTool());
		paletteContainer.add(createLeaf3CreationTool());
		paletteContainer.add(createLoop4CreationTool());
		paletteContainer.add(createOne5CreationTool());
		paletteContainer.add(createOr6CreationTool());
		paletteContainer.add(createPar7CreationTool());
		paletteContainer.add(createSome8CreationTool());
		paletteContainer.add(createXor9CreationTool());
		paletteContainer.add(createInterrupt10CreationTool());
		paletteContainer.add(createRetry11CreationTool());

		//		paletteContainer.add(createFlowDiagram10CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Connections" palette tool group
	 * @generated NOT
	 */
	private PaletteContainer createConnections2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Connections2Group_title);
		paletteContainer.setId("createConnections2Group"); //$NON-NLS-1$
		//		paletteContainer.add(createAllLink1CreationTool());
		//		paletteContainer.add(createAndLink2CreationTool());
		//		paletteContainer.add(createLoopLink3CreationTool());
		//		paletteContainer.add(createNewParameter4CreationTool());
		//		paletteContainer.add(createNewParameter5CreationTool());
		//		paletteContainer.add(createNewParameter6CreationTool());
		//		paletteContainer.add(createOneLink7CreationTool());
		//		paletteContainer.add(createOrLink8CreationTool());
		//		paletteContainer.add(createParLink9CreationTool());
		//		paletteContainer.add(createRefine10CreationTool());
		//		paletteContainer.add(createSomeLink11CreationTool());
		//		paletteContainer.add(createXorLink12CreationTool());
		//		paletteContainer.add(createDecomposeLink13CreationTool());
		paletteContainer.add(createCreateLink16CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAll1CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				Messages.All1CreationTool_title,
				Messages.All1CreationTool_desc,
				Collections
						.singletonList(AtomicitydecompositionElementTypes.All_2004));
		entry.setId("createAll1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(AtomicitydecompositionElementTypes
				.getImageDescriptor(AtomicitydecompositionElementTypes.All_2004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAnd2CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				Messages.And2CreationTool_title,
				Messages.And2CreationTool_desc,
				Collections
						.singletonList(AtomicitydecompositionElementTypes.And_2002));
		entry.setId("createAnd2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(AtomicitydecompositionElementTypes
				.getImageDescriptor(AtomicitydecompositionElementTypes.And_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createLeaf3CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				Messages.Leaf3CreationTool_title,
				Messages.Leaf3CreationTool_desc,
				Collections
						.singletonList(AtomicitydecompositionElementTypes.Leaf_2001));
		entry.setId("createLeaf3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(AtomicitydecompositionElementTypes
				.getImageDescriptor(AtomicitydecompositionElementTypes.Leaf_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createLoop4CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				Messages.Loop4CreationTool_title,
				Messages.Loop4CreationTool_desc,
				Collections
						.singletonList(AtomicitydecompositionElementTypes.Loop_2003));
		entry.setId("createLoop4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(AtomicitydecompositionElementTypes
				.getImageDescriptor(AtomicitydecompositionElementTypes.Loop_2003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createOne5CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				Messages.One5CreationTool_title,
				Messages.One5CreationTool_desc,
				Collections
						.singletonList(AtomicitydecompositionElementTypes.One_2008));
		entry.setId("createOne5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(AtomicitydecompositionElementTypes
				.getImageDescriptor(AtomicitydecompositionElementTypes.One_2008));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createOr6CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				Messages.Or6CreationTool_title,
				Messages.Or6CreationTool_desc,
				Collections
						.singletonList(AtomicitydecompositionElementTypes.Or_2006));
		entry.setId("createOr6CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(AtomicitydecompositionElementTypes
				.getImageDescriptor(AtomicitydecompositionElementTypes.Or_2006));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPar7CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				Messages.Par7CreationTool_title,
				Messages.Par7CreationTool_desc,
				Collections
						.singletonList(AtomicitydecompositionElementTypes.Par_2009));
		entry.setId("createPar7CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(AtomicitydecompositionElementTypes
				.getImageDescriptor(AtomicitydecompositionElementTypes.Par_2009));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSome8CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				Messages.Some8CreationTool_title,
				Messages.Some8CreationTool_desc,
				Collections
						.singletonList(AtomicitydecompositionElementTypes.Some_2005));
		entry.setId("createSome8CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(AtomicitydecompositionElementTypes
				.getImageDescriptor(AtomicitydecompositionElementTypes.Some_2005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createXor9CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				Messages.Xor9CreationTool_title,
				Messages.Xor9CreationTool_desc,
				Collections
						.singletonList(AtomicitydecompositionElementTypes.Xor_2007));
		entry.setId("createXor9CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(AtomicitydecompositionElementTypes
				.getImageDescriptor(AtomicitydecompositionElementTypes.Xor_2007));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInterrupt10CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				Messages.Interrupt10CreationTool_title,
				Messages.Interrupt10CreationTool_desc,
				Collections
						.singletonList(AtomicitydecompositionElementTypes.Interrupt_2012));
		entry.setId("createInterrupt10CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(AtomicitydecompositionElementTypes
				.getImageDescriptor(AtomicitydecompositionElementTypes.Interrupt_2012));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRetry11CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				Messages.Retry11CreationTool_title,
				Messages.Retry11CreationTool_desc,
				Collections
						.singletonList(AtomicitydecompositionElementTypes.Retry_2013));
		entry.setId("createRetry11CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(AtomicitydecompositionElementTypes
				.getImageDescriptor(AtomicitydecompositionElementTypes.Retry_2013));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createFlowDiagram12CreationTool() {
		ToolEntry entry = new ToolEntry(
				Messages.FlowDiagram12CreationTool_title,
				Messages.FlowDiagram12CreationTool_desc, null, null) {
		};
		entry.setId("createFlowDiagram12CreationTool"); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createTypedParameterExpression13CreationTool() {
		ToolEntry entry = new ToolEntry(
				Messages.TypedParameterExpression13CreationTool_title,
				Messages.TypedParameterExpression13CreationTool_desc, null,
				null) {
		};
		entry.setId("createTypedParameterExpression13CreationTool"); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAllLink1CreationTool() {
		ToolEntry entry = new ToolEntry(Messages.AllLink1CreationTool_title,
				Messages.AllLink1CreationTool_desc, null, null) {
		};
		entry.setId("createAllLink1CreationTool"); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAndLink2CreationTool() {
		ToolEntry entry = new ToolEntry(Messages.AndLink2CreationTool_title,
				Messages.AndLink2CreationTool_desc, null, null) {
		};
		entry.setId("createAndLink2CreationTool"); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createLoopLink3CreationTool() {
		ToolEntry entry = new ToolEntry(Messages.LoopLink3CreationTool_title,
				Messages.LoopLink3CreationTool_desc, null, null) {
		};
		entry.setId("createLoopLink3CreationTool"); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createNewParameter4CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(AtomicitydecompositionElementTypes.AllNewParameter_4005);
		types.add(AtomicitydecompositionElementTypes.OneNewParameter_4011);
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				Messages.NewParameter4CreationTool_title,
				Messages.NewParameter4CreationTool_desc, types);
		entry.setId("createNewParameter4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(AtomicitydecompositionElementTypes
				.getImageDescriptor(AtomicitydecompositionElementTypes.AllNewParameter_4005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createNewParameter5CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				Messages.NewParameter5CreationTool_title,
				Messages.NewParameter5CreationTool_desc,
				Collections
						.singletonList(AtomicitydecompositionElementTypes.SomeNewParameter_4007));
		entry.setId("createNewParameter5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(AtomicitydecompositionElementTypes
				.getImageDescriptor(AtomicitydecompositionElementTypes.SomeNewParameter_4007));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createNewParameter6CreationTool() {
		ToolEntry entry = new ToolEntry(
				Messages.NewParameter6CreationTool_title,
				Messages.NewParameter6CreationTool_desc, null, null) {
		};
		entry.setId("createNewParameter6CreationTool"); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createOneLink7CreationTool() {
		ToolEntry entry = new ToolEntry(Messages.OneLink7CreationTool_title,
				Messages.OneLink7CreationTool_desc, null, null) {
		};
		entry.setId("createOneLink7CreationTool"); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createOrLink8CreationTool() {
		ToolEntry entry = new ToolEntry(Messages.OrLink8CreationTool_title,
				Messages.OrLink8CreationTool_desc, null, null) {
		};
		entry.setId("createOrLink8CreationTool"); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createParLink9CreationTool() {
		ToolEntry entry = new ToolEntry(Messages.ParLink9CreationTool_title,
				Messages.ParLink9CreationTool_desc, null, null) {
		};
		entry.setId("createParLink9CreationTool"); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRefine10CreationTool() {
		ToolEntry entry = new ToolEntry(Messages.Refine10CreationTool_title,
				Messages.Refine10CreationTool_desc, null, null) {
		};
		entry.setId("createRefine10CreationTool"); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSomeLink11CreationTool() {
		ToolEntry entry = new ToolEntry(Messages.SomeLink11CreationTool_title,
				Messages.SomeLink11CreationTool_desc, null, null) {
		};
		entry.setId("createSomeLink11CreationTool"); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createXorLink12CreationTool() {
		ToolEntry entry = new ToolEntry(Messages.XorLink12CreationTool_title,
				Messages.XorLink12CreationTool_desc, null, null) {
		};
		entry.setId("createXorLink12CreationTool"); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createNormalLink13CreationTool() {
		ToolEntry entry = new ToolEntry(
				Messages.NormalLink13CreationTool_title,
				Messages.NormalLink13CreationTool_desc, null, null) {
		};
		entry.setId("createNormalLink13CreationTool"); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInterruptingLink14CreationTool() {
		ToolEntry entry = new ToolEntry(
				Messages.InterruptingLink14CreationTool_title,
				Messages.InterruptingLink14CreationTool_desc, null, null) {
		};
		entry.setId("createInterruptingLink14CreationTool"); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDecomposeLink15CreationTool() {
		ToolEntry entry = new ToolEntry(
				Messages.DecomposeLink15CreationTool_title,
				Messages.DecomposeLink15CreationTool_desc, null, null) {
		};
		entry.setId("createDecomposeLink15CreationTool"); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCreateLink16CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(13);
		types.add(AtomicitydecompositionElementTypes.AndAndLink_4002);
		types.add(AtomicitydecompositionElementTypes.LoopLoopLink_4003);
		types.add(AtomicitydecompositionElementTypes.AllAllLink_4004);
		types.add(AtomicitydecompositionElementTypes.SomeSomeLink_4006);
		types.add(AtomicitydecompositionElementTypes.OrOrLink_4008);
		types.add(AtomicitydecompositionElementTypes.XorXorLink_4009);
		types.add(AtomicitydecompositionElementTypes.OneOneLink_4010);
		types.add(AtomicitydecompositionElementTypes.ParParLink_4012);
		types.add(AtomicitydecompositionElementTypes.FlowDiagramRefine_4014);
		types.add(AtomicitydecompositionElementTypes.InterruptInterruptNormalLink_4019);
		types.add(AtomicitydecompositionElementTypes.InterruptInterruptInterruptingLink_4020);
		types.add(AtomicitydecompositionElementTypes.RetryRetryNormalLink_4021);
		types.add(AtomicitydecompositionElementTypes.RetryRetryInterruptingLink_4022);
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				Messages.CreateLink16CreationTool_title,
				Messages.CreateLink16CreationTool_desc, types);
		entry.setId("createCreateLink16CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(AtomicitydecompositionElementTypes
				.getImageDescriptor(AtomicitydecompositionElementTypes.AndAndLink_4002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}
}
