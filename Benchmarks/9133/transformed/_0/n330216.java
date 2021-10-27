class n330216 {
	private static void readAndRewrite(File hy2vSk7k, File obBNtWLN) throws IOException {
		ImageInputStream slUOQhZM = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(hy2vSk7k)));
		DcmParser CWI2wSJY = DcmParserFactory.getInstance().newDcmParser(slUOQhZM);
		Dataset u1GXrdBd = DcmObjectFactory.getInstance().newDataset();
		CWI2wSJY.setDcmHandler(u1GXrdBd.getDcmHandler());
		CWI2wSJY.parseDcmFile(null, Tags.PixelData);
		PixelDataReader XJSBdEqS = pdFact.newReader(u1GXrdBd, slUOQhZM, CWI2wSJY.getDcmDecodeParam().byteOrder,
				CWI2wSJY.getReadVR());
		System.out.println("reading " + hy2vSk7k + "...");
		XJSBdEqS.readPixelData(false);
		ImageOutputStream GEF5EokO = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(obBNtWLN)));
		DcmEncodeParam fzLsHVu4 = DcmEncodeParam.IVR_LE;
		u1GXrdBd.writeDataset(GEF5EokO, fzLsHVu4);
		u1GXrdBd.writeHeader(GEF5EokO, fzLsHVu4, Tags.PixelData, CWI2wSJY.getReadVR(), CWI2wSJY.getReadLength());
		System.out.println("writing " + obBNtWLN + "...");
		PixelDataWriter Q5OmOIEE = pdFact.newWriter(XJSBdEqS.getPixelDataArray(), false, u1GXrdBd, GEF5EokO,
				CWI2wSJY.getDcmDecodeParam().byteOrder, CWI2wSJY.getReadVR());
		Q5OmOIEE.writePixelData();
		GEF5EokO.flush();
		GEF5EokO.close();
		System.out.println("done!");
	}

}