class n606859 {
	private static void readAndRewrite(File pH4tZ8cG, File QDy6h8Tw) throws IOException {
		ImageInputStream X9lWXHzE = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(pH4tZ8cG)));
		DcmParser PifhjXWC = DcmParserFactory.getInstance().newDcmParser(X9lWXHzE);
		Dataset lTM5MjYc = DcmObjectFactory.getInstance().newDataset();
		PifhjXWC.setDcmHandler(lTM5MjYc.getDcmHandler());
		PifhjXWC.parseDcmFile(null, Tags.PixelData);
		PixelDataReader xfww1XGq = pdFact.newReader(lTM5MjYc, X9lWXHzE, PifhjXWC.getDcmDecodeParam().byteOrder,
				PifhjXWC.getReadVR());
		System.out.println("reading " + pH4tZ8cG + "...");
		xfww1XGq.readPixelData(false);
		ImageOutputStream kDjUxR2d = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(QDy6h8Tw)));
		DcmEncodeParam toz1qaK2 = DcmEncodeParam.IVR_LE;
		lTM5MjYc.writeDataset(kDjUxR2d, toz1qaK2);
		lTM5MjYc.writeHeader(kDjUxR2d, toz1qaK2, Tags.PixelData, PifhjXWC.getReadVR(), PifhjXWC.getReadLength());
		System.out.println("writing " + QDy6h8Tw + "...");
		PixelDataWriter JwICc5Md = pdFact.newWriter(xfww1XGq.getPixelDataArray(), false, lTM5MjYc, kDjUxR2d,
				PifhjXWC.getDcmDecodeParam().byteOrder, PifhjXWC.getReadVR());
		JwICc5Md.writePixelData();
		kDjUxR2d.flush();
		kDjUxR2d.close();
		System.out.println("done!");
	}

}