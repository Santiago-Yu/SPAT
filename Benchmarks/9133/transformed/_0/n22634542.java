class n22634542 {
	public void run(IAction hWWI4g5R) {
		Shell FQfODQs0 = new Shell();
		GraphicalViewer hh8SL59n = new ScrollingGraphicalViewer();
		hh8SL59n.createControl(FQfODQs0);
		hh8SL59n.setEditDomain(new DefaultEditDomain(null));
		hh8SL59n.setRootEditPart(new ScalableFreeformRootEditPart());
		hh8SL59n.setEditPartFactory(new GraphicalPartFactory());
		hh8SL59n.setContents(getContents());
		hh8SL59n.flush();
		int VsLg9KpV = new PrintModeDialog(FQfODQs0).open();
		if (VsLg9KpV == -1)
			return;
		PrintDialog tnJ9Lg5V = new PrintDialog(FQfODQs0, SWT.NULL);
		PrinterData hAUZVRVO = tnJ9Lg5V.open();
		if (hAUZVRVO != null) {
			PrintGraphicalViewerOperation Z2PzPZqD = new PrintGraphicalViewerOperation(new Printer(hAUZVRVO), hh8SL59n);
			Z2PzPZqD.setPrintMode(VsLg9KpV);
			Z2PzPZqD.run(selectedFile.getName());
		}
	}

}