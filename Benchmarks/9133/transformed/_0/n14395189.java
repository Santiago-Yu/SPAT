class n14395189 {
	public void test2() throws Exception {
		SpreadsheetDocument HF3VP3gu = new SpreadsheetDocument();
		Sheet gSz559ar = new Sheet("Planilha 1");
		gSz559ar.setLandscape(true);
		Row lWm0Trbw = new Row();
		lWm0Trbw.setHeight(20);
		gSz559ar.getMerges().add(new IntegerCellMerge(0, 0, 0, 5));
		gSz559ar.getImages().add(new Image(new FileInputStream("D:/image001.jpg"), 0, 0, ImageType.JPEG, 80, 60));
		for (int yXPNJHag = 0; yXPNJHag < 10; yXPNJHag++) {
			Cell MHHgkW4C = new Cell();
			MHHgkW4C.setValue("Celula " + yXPNJHag);
			MHHgkW4C.setBackgroundColor(new Color(192, 192, 192));
			MHHgkW4C.setUnderline(true);
			MHHgkW4C.setBold(true);
			MHHgkW4C.setItalic(true);
			MHHgkW4C.setFont("Times New Roman");
			MHHgkW4C.setFontSize(10);
			MHHgkW4C.setFontColor(new Color(255, 0, 0));
			Border NBJlAVNk = new Border();
			NBJlAVNk.setWidth(1);
			NBJlAVNk.setColor(new Color(0, 0, 0));
			MHHgkW4C.setLeftBorder(NBJlAVNk);
			MHHgkW4C.setTopBorder(NBJlAVNk);
			MHHgkW4C.setRightBorder(NBJlAVNk);
			MHHgkW4C.setBottomBorder(NBJlAVNk);
			lWm0Trbw.getCells().add(MHHgkW4C);
			gSz559ar.getColumnsWith().put(new Integer(yXPNJHag), new Integer(25));
		}
		gSz559ar.getRows().add(lWm0Trbw);
		HF3VP3gu.getSheets().add(gSz559ar);
		FileOutputStream ZIzTFXjN = new FileOutputStream("D:/teste2.xls");
		SpreadsheetDocumentWriter xrrqmWSm = HSSFSpreadsheetDocumentWriter.getInstance();
		xrrqmWSm.write(HF3VP3gu, ZIzTFXjN);
		ZIzTFXjN.close();
	}

}