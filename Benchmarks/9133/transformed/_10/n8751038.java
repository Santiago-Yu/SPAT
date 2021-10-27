class n8751038 {
	public static IFigure render(IDiagram diagram) {
		Diagram realDiagram;
		ScrollingGraphicalViewer viewer = new ScrollingGraphicalViewer();
		try {
			realDiagram = ((Diagram.IDiagramImpl) diagram).getDiagram();
		} catch (ClassCastException x) {
			throw new IllegalArgumentException("invalid diagram parameter");
		}
		viewer.createControl(RMBenchPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow().getShell());
		viewer.setRootEditPart(new ScalableFreeformRootEditPart());
		viewer.setEditPartFactory(new CustomEditPartFactory());
		viewer.setContents(realDiagram);
		AbstractGraphicalEditPart aep = (AbstractGraphicalEditPart) viewer.getRootEditPart();
		refresh(aep);
		IFigure root = ((AbstractGraphicalEditPart) viewer.getRootEditPart()).getFigure();
		setPreferedSize(root);
		return root;
	}

}