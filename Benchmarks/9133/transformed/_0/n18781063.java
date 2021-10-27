class n18781063 {
	private void createGraphicalViewer(Composite nby5BFg8) {
		viewer = new ScrollingGraphicalViewer();
		viewer.createControl(nby5BFg8);
		viewer.getControl().setBackground(nby5BFg8.getBackground());
		viewer.setRootEditPart(new ScalableFreeformRootEditPart());
		viewer.setKeyHandler(new GraphicalViewerKeyHandler(viewer));
		registerEditPartViewer(viewer);
		configureEditPartViewer(viewer);
		viewer.setEditPartFactory(new GraphicalEditPartsFactory(getSite().getShell()));
		viewer.setContents(getContractEditor().getContract());
		ContextMenuProvider VtO6f0Y9 = new ContractContextMenuProvider(getGraphicalViewer(),
				getContractEditor().getActionRegistry());
		getGraphicalViewer().setContextMenu(VtO6f0Y9);
		getSite().registerContextMenu(VtO6f0Y9, getGraphicalViewer());
	}

}