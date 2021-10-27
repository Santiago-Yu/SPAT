class n7843322 {
	public void run(IAction vtgrd63S) {
		int CwhAUKBk = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell().getStyle();
		Shell lFSjPkeZ = new Shell((CwhAUKBk & SWT.MIRRORED) != 0 ? SWT.RIGHT_TO_LEFT : SWT.NONE);
		GraphicalViewer rh97SpPv = new ScrollingGraphicalViewer();
		rh97SpPv.createControl(lFSjPkeZ);
		rh97SpPv.setEditDomain(new DefaultEditDomain(null));
		rh97SpPv.setRootEditPart(new ScalableFreeformRootEditPart());
		rh97SpPv.setEditPartFactory(new TableEditPartFactory());
		rh97SpPv.setContents(getContents());
		rh97SpPv.flush();
		int SpKjJt3c = new PrintModeDialog(lFSjPkeZ).open();
		if (SpKjJt3c == -1)
			return;
		PrintDialog jduPTVxu = new PrintDialog(lFSjPkeZ, SWT.NULL);
		PrinterData fCpKX4bD = jduPTVxu.open();
		if (fCpKX4bD != null) {
			PrintGraphicalViewerOperation P748RkUi = new PrintGraphicalViewerOperation(new Printer(fCpKX4bD), rh97SpPv);
			P748RkUi.setPrintMode(SpKjJt3c);
			P748RkUi.run(selectedFile.getName());
		}
	}

}