class n841724 {
	private static void readAndRewrite(File Pnf8Klpt, File yXFkTRD4) throws IOException {
		ImageInputStream z3ArJn5m = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(Pnf8Klpt)));
		DcmParser TeIau4lY = DcmParserFactory.getInstance().newDcmParser(z3ArJn5m);
		Dataset EEekF2ts = DcmObjectFactory.getInstance().newDataset();
		TeIau4lY.setDcmHandler(EEekF2ts.getDcmHandler());
		TeIau4lY.parseDcmFile(null, Tags.PixelData);
		PixelDataReader k9ljlh1n = pdFact.newReader(EEekF2ts, z3ArJn5m, TeIau4lY.getDcmDecodeParam().byteOrder,
				TeIau4lY.getReadVR());
		System.out.println("reading " + Pnf8Klpt + "...");
		k9ljlh1n.readPixelData(false);
		ImageOutputStream Xq4W6dZ6 = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(yXFkTRD4)));
		DcmEncodeParam rCmCXhbs = DcmEncodeParam.IVR_LE;
		EEekF2ts.writeDataset(Xq4W6dZ6, rCmCXhbs);
		EEekF2ts.writeHeader(Xq4W6dZ6, rCmCXhbs, Tags.PixelData, TeIau4lY.getReadVR(), TeIau4lY.getReadLength());
		System.out.println("writing " + yXFkTRD4 + "...");
		PixelDataWriter KtS9Z0Wa = pdFact.newWriter(k9ljlh1n.getPixelDataArray(), false, EEekF2ts, Xq4W6dZ6,
				TeIau4lY.getDcmDecodeParam().byteOrder, TeIau4lY.getReadVR());
		KtS9Z0Wa.writePixelData();
		Xq4W6dZ6.flush();
		Xq4W6dZ6.close();
		System.out.println("done!");
	}

}