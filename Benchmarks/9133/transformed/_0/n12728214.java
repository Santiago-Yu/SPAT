class n12728214 {
	protected GraphicalViewer createGraphicalViewer(Composite eUKZUIM0) {
		GraphicalViewer SiGkrIu0 = new ScrollingGraphicalViewer();
		SiGkrIu0.createControl(eUKZUIM0);
		SiGkrIu0.getControl().setBackground(eUKZUIM0.getBackground());
		SiGkrIu0.setRootEditPart(new ScalableFreeformRootEditPart());
		GraphicalViewerKeyHandler xsbNFDdE = new GraphicalViewerKeyHandler(SiGkrIu0);
		KeyHandler qpwNzDyc = xsbNFDdE.setParent(getCommonKeyHandler());
		SiGkrIu0.setKeyHandler(qpwNzDyc);
		getEditDomain().addViewer(SiGkrIu0);
		getSite().setSelectionProvider(SiGkrIu0);
		ContextMenuProvider vqGbsJVw = new TestContextMenuProvider(SiGkrIu0, getActionRegistry());
		SiGkrIu0.setContextMenu(vqGbsJVw);
		getSite().registerContextMenu("cubicTestPlugin.editor.contextmenu", vqGbsJVw, SiGkrIu0);
		SiGkrIu0.addDropTargetListener(
				new DataEditDropTargetListner(((IFileEditorInput) getEditorInput()).getFile().getProject(), SiGkrIu0));
		SiGkrIu0.addDropTargetListener(new FileTransferDropTargetListener(SiGkrIu0));
		SiGkrIu0.setEditPartFactory(getEditPartFactory());
		SiGkrIu0.setContents(getContent());
		return SiGkrIu0;
	}

}