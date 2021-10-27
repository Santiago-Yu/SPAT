class n22634542 {
	public void run(IAction action) {
		GraphicalViewer viewer = new ScrollingGraphicalViewer();
		Shell shell = new Shell();
		viewer.createControl(shell);
		viewer.setEditDomain(new DefaultEditDomain(null));
		viewer.setRootEditPart(new ScalableFreeformRootEditPart());
		viewer.setEditPartFactory(new GraphicalPartFactory());
		viewer.setContents(getContents());
		viewer.flush();
		int printMode = new PrintModeDialog(shell).open();
		PrintDialog dialog = new PrintDialog(shell, SWT.NULL);
		if (printMode == -1)
			return;
		PrinterData data = dialog.open();
		if (data != null) {
			PrintGraphicalViewerOperation op = new PrintGraphicalViewerOperation(new Printer(data), viewer);
			op.setPrintMode(printMode);
			op.run(selectedFile.getName());
		}
	}

}