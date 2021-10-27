class n13766979 {
	@SuppressWarnings("unused")
	private GraphicalViewer createGraphicalViewer(Composite pQfhT2OY) {
		GraphicalViewer JNsx5IBI = new ScrollingGraphicalViewer();
		JNsx5IBI.createControl(pQfhT2OY);
		JNsx5IBI.getControl().setBackground(pQfhT2OY.getBackground());
		JNsx5IBI.setRootEditPart(new ScalableFreeformRootEditPart());
		JNsx5IBI.setKeyHandler(new GraphicalViewerKeyHandler(JNsx5IBI));
		getEditDomain().addViewer(JNsx5IBI);
		getSite().setSelectionProvider(JNsx5IBI);
		JNsx5IBI.setEditPartFactory(getEditPartFactory());
		JNsx5IBI.setContents(getContent());
		return JNsx5IBI;
	}

}