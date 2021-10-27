class n370982 {
	private static void readAndRewrite(File Xidd0VO2, File YGWLic49) throws IOException {
		ImageInputStream bgCRAjPR = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(Xidd0VO2)));
		DcmParser zEWhgbKI = DcmParserFactory.getInstance().newDcmParser(bgCRAjPR);
		Dataset gdCgsUul = DcmObjectFactory.getInstance().newDataset();
		zEWhgbKI.setDcmHandler(gdCgsUul.getDcmHandler());
		zEWhgbKI.parseDcmFile(null, Tags.PixelData);
		PixelDataReader LOEBx4gC = pdFact.newReader(gdCgsUul, bgCRAjPR, zEWhgbKI.getDcmDecodeParam().byteOrder,
				zEWhgbKI.getReadVR());
		System.out.println("reading " + Xidd0VO2 + "...");
		LOEBx4gC.readPixelData(false);
		ImageOutputStream XYIscjVj = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(YGWLic49)));
		DcmEncodeParam aky4hiUi = DcmEncodeParam.IVR_LE;
		gdCgsUul.writeDataset(XYIscjVj, aky4hiUi);
		gdCgsUul.writeHeader(XYIscjVj, aky4hiUi, Tags.PixelData, zEWhgbKI.getReadVR(), zEWhgbKI.getReadLength());
		System.out.println("writing " + YGWLic49 + "...");
		PixelDataWriter s7mLOlvE = pdFact.newWriter(LOEBx4gC.getPixelDataArray(), false, gdCgsUul, XYIscjVj,
				zEWhgbKI.getDcmDecodeParam().byteOrder, zEWhgbKI.getReadVR());
		s7mLOlvE.writePixelData();
		XYIscjVj.flush();
		XYIscjVj.close();
		System.out.println("done!");
	}

}