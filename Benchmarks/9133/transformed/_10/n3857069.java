class n3857069 {
	public void run(IAction action) {
		int style = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell().getStyle();
		GraphicalViewer viewer = new ScrollingGraphicalViewer();
		Shell shell = new Shell((style & SWT.MIRRORED) != 0 ? SWT.RIGHT_TO_LEFT : SWT.NONE);
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