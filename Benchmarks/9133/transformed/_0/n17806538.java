class n17806538 {
	public void run(IAction F4NUTLlg) {
		int qHIVlIa9 = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell().getStyle();
		Shell GkLK0o4x = new Shell((qHIVlIa9 & SWT.MIRRORED) != 0 ? SWT.RIGHT_TO_LEFT : SWT.NONE);
		GraphicalViewer OGvqSEuy = new ScrollingGraphicalViewer();
		OGvqSEuy.createControl(GkLK0o4x);
		OGvqSEuy.setEditDomain(new DefaultEditDomain(null));
		OGvqSEuy.setRootEditPart(new ScalableFreeformRootEditPart());
		OGvqSEuy.setEditPartFactory(new ProjectEditPartFactory());
		OGvqSEuy.setContents(getContents());
		OGvqSEuy.flush();
		int skoyjBQm = new PrintModeDialog(GkLK0o4x).open();
		if (skoyjBQm == -1)
			return;
		PrintDialog e2jelOYR = new PrintDialog(GkLK0o4x, SWT.NULL);
		PrinterData toP9UMvJ = e2jelOYR.open();
		if (toP9UMvJ != null) {
			PrintGraphicalViewerOperation JZhgjJo1 = new PrintGraphicalViewerOperation(new Printer(toP9UMvJ), OGvqSEuy);
			JZhgjJo1.setPrintMode(skoyjBQm);
			JZhgjJo1.run(selectedFile.getName());
		}
	}

}