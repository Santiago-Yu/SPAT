class n9857940 {
	public void run(IAction OPuJMDKr) {
		int onKSq0FC = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell().getStyle();
		Shell MjjZ41nA = new Shell((onKSq0FC & SWT.MIRRORED) != 0 ? SWT.RIGHT_TO_LEFT : SWT.NONE);
		GraphicalViewer QIkuEcia = new ScrollingGraphicalViewer();
		QIkuEcia.createControl(MjjZ41nA);
		QIkuEcia.setEditDomain(new DefaultEditDomain(null));
		QIkuEcia.setRootEditPart(new ScalableFreeformRootEditPart());
		QIkuEcia.setEditPartFactory(new ProjectEditPartFactory());
		QIkuEcia.setContents(getContents());
		QIkuEcia.flush();
		int OYAxzhjM = new PrintModeDialog(MjjZ41nA).open();
		if (OYAxzhjM == -1)
			return;
		PrintDialog MnY2gSMK = new PrintDialog(MjjZ41nA, SWT.NULL);
		PrinterData jOQSI7Qb = MnY2gSMK.open();
		if (jOQSI7Qb != null) {
			PrintGraphicalViewerOperation NwrPDo3p = new PrintGraphicalViewerOperation(new Printer(jOQSI7Qb), QIkuEcia);
			NwrPDo3p.setPrintMode(OYAxzhjM);
			NwrPDo3p.run(selectedFile.getName());
		}
	}

}