class n21517335 {
	public void run() {
		Shell DHmiOW7C = new Shell(display);
		DHmiOW7C.setLayout(new GridLayout(1, false));
		ERDiagramEditPartFactory laSEVMEu = new ERDiagramEditPartFactory();
		viewer = new ScrollingGraphicalViewer();
		viewer.setControl(new FigureCanvas(DHmiOW7C));
		ScalableFreeformRootEditPart vfyq9Yka = new PagableFreeformRootEditPart(diagram);
		viewer.setRootEditPart(vfyq9Yka);
		viewer.setEditPartFactory(laSEVMEu);
		viewer.setContents(diagram);
	}

}