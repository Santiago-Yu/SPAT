class n189963 {
	private static void readAndRewrite(File KONuS3pU, File WcCLSjb8) throws IOException {
		ImageInputStream eD6sma2c = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(KONuS3pU)));
		DcmParser Sj2D9fZ1 = DcmParserFactory.getInstance().newDcmParser(eD6sma2c);
		Dataset iqWGWtbh = DcmObjectFactory.getInstance().newDataset();
		Sj2D9fZ1.setDcmHandler(iqWGWtbh.getDcmHandler());
		Sj2D9fZ1.parseDcmFile(null, Tags.PixelData);
		PixelDataReader LguvjhDE = pdFact.newReader(iqWGWtbh, eD6sma2c, Sj2D9fZ1.getDcmDecodeParam().byteOrder,
				Sj2D9fZ1.getReadVR());
		System.out.println("reading " + KONuS3pU + "...");
		LguvjhDE.readPixelData(false);
		ImageOutputStream pPBE89oN = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(WcCLSjb8)));
		DcmEncodeParam MwE7h7cv = DcmEncodeParam.IVR_LE;
		iqWGWtbh.writeDataset(pPBE89oN, MwE7h7cv);
		iqWGWtbh.writeHeader(pPBE89oN, MwE7h7cv, Tags.PixelData, Sj2D9fZ1.getReadVR(), Sj2D9fZ1.getReadLength());
		System.out.println("writing " + WcCLSjb8 + "...");
		PixelDataWriter KexkXrNk = pdFact.newWriter(LguvjhDE.getPixelDataArray(), false, iqWGWtbh, pPBE89oN,
				Sj2D9fZ1.getDcmDecodeParam().byteOrder, Sj2D9fZ1.getReadVR());
		KexkXrNk.writePixelData();
		pPBE89oN.flush();
		pPBE89oN.close();
		System.out.println("done!");
	}

}