class n8751038 {
	public static IFigure render(IDiagram aLIGzFM8) {
		Diagram GtzMxTRq;
		try {
			GtzMxTRq = ((Diagram.IDiagramImpl) aLIGzFM8).getDiagram();
		} catch (ClassCastException rSfB5niy) {
			throw new IllegalArgumentException("invalid diagram parameter");
		}
		ScrollingGraphicalViewer rZcHHK3t = new ScrollingGraphicalViewer();
		rZcHHK3t.createControl(RMBenchPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow().getShell());
		rZcHHK3t.setRootEditPart(new ScalableFreeformRootEditPart());
		rZcHHK3t.setEditPartFactory(new CustomEditPartFactory());
		rZcHHK3t.setContents(GtzMxTRq);
		AbstractGraphicalEditPart cIcNlUPB = (AbstractGraphicalEditPart) rZcHHK3t.getRootEditPart();
		refresh(cIcNlUPB);
		IFigure JkEtDk5Q = ((AbstractGraphicalEditPart) rZcHHK3t.getRootEditPart()).getFigure();
		setPreferedSize(JkEtDk5Q);
		return JkEtDk5Q;
	}

}