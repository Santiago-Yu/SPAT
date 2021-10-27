class n17806538 {
	public void run(IAction action) {
		int style = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell().getStyle();
		Shell shell;
		if ((style & SWT.MIRRORED) != 0)
			shell = new Shell(SWT.RIGHT_TO_LEFT);
		else
			shell = new Shell(SWT.NONE);
		GraphicalViewer viewer = new ScrollingGraphicalViewer();
		viewer.createControl(shell);
		viewer.setEditDomain(new DefaultEditDomain(null));
		viewer.setRootEditPart(new ScalableFreeformRootEditPart());
		viewer.setEditPartFactory(new ProjectEditPartFactory());
		viewer.setContents(getContents());
		viewer.flush();
		int printMode = new PrintModeDialog(shell).open();
		if (printMode == -1)
			return;
		PrintDialog dialog = new PrintDialog(shell, SWT.NULL);
		PrinterData data = dialog.open();
		if (data != null) {
			PrintGraphicalViewerOperation op = new PrintGraphicalViewerOperation(new Printer(data), viewer);
			op.setPrintMode(printMode);
			op.run(selectedFile.getName());
		}
	}

}