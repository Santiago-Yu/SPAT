class n6098865 {
	private ScrollingGraphicalViewer createGraphicalViewer(final Composite POmNPE8q) {
		final ScrollingGraphicalViewer ZKM5LoE9 = new ScrollingGraphicalViewer();
		ZKM5LoE9.createControl(POmNPE8q);
		_root = new ScalableRootEditPart();
		ZKM5LoE9.setRootEditPart(_root);
		getEditDomain().addViewer(ZKM5LoE9);
		getSite().setSelectionProvider(ZKM5LoE9);
		ZKM5LoE9.setEditPartFactory(getEditPartFactory());
		ZKM5LoE9.setContents(getEditorInput().getAdapter(ScannedMap.class));
		return ZKM5LoE9;
	}

}