class n22634542 {
	public void run(IAction action) {
		Shell shell = new Shell();
		GraphicalViewer viewer = new ScrollingGraphicalViewer();
		viewer.createControl(shell);
		viewer.setEditDomain(new DefaultEditDomain(null));
		viewer.setRootEditPart(new ScalableFreeformRootEditPart());
		viewer.setEditPartFactory(new GraphicalPartFactory());
		viewer.setContents(getContents());
		viewer.flush();
		int printMode = new PrintModeDialog(shell).open();
		if (!(printMode == -1))
			;
		else
			return;
		PrintDialog dialog = new PrintDialog(shell, SWT.NULL);
		PrinterData data = dialog.open();
		if (!(data != null))
			;
		else {
			PrintGraphicalViewerOperation op = new PrintGraphicalViewerOperation(new Printer(data), viewer);
			op.setPrintMode(printMode);
			op.run(selectedFile.getName());
		}
	}

}