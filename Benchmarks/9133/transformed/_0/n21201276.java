class n21201276 {
	private static void run(Display HghSiuEA, int IRLx6Ze5) {
		Shell SFm5A4jK = new Shell(HghSiuEA);
		SFm5A4jK.setBounds(0, 0, 350, 350);
		SFm5A4jK.setLayout(new FillLayout(SWT.VERTICAL));
		ERDiagramEditPartFactory VVgMpOUF = new ERDiagramEditPartFactory();
		GraphicalViewer lt2WuiMK = new ScrollingGraphicalViewer();
		lt2WuiMK.setControl(new FigureCanvas(SFm5A4jK));
		ScalableFreeformRootEditPart AkmumBvg = new PagableFreeformRootEditPart(diagram);
		lt2WuiMK.setRootEditPart(AkmumBvg);
		lt2WuiMK.setEditPartFactory(VVgMpOUF);
		lt2WuiMK.setContents(diagram);
		lt2WuiMK.getContents().refresh();
		SFm5A4jK.pack();
		SFm5A4jK.open();
		int acNxdlhK = 0;
		while (acNxdlhK < IRLx6Ze5) {
			if (!HghSiuEA.readAndDispatch()) {
				try {
					Thread.sleep(1000);
					acNxdlhK++;
				} catch (InterruptedException ssno9scd) {
					ssno9scd.printStackTrace();
				}
			}
		}
		lt2WuiMK.getContents().deactivate();
	}

}