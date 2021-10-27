class n810724 {
	private static void readAndRewrite(File xqxgkTtA, File GGJXpYP2) throws IOException {
		ImageInputStream T8kIxPQ3 = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(xqxgkTtA)));
		DcmParser V8V2mdcs = DcmParserFactory.getInstance().newDcmParser(T8kIxPQ3);
		Dataset qxZZOI2c = DcmObjectFactory.getInstance().newDataset();
		V8V2mdcs.setDcmHandler(qxZZOI2c.getDcmHandler());
		V8V2mdcs.parseDcmFile(null, Tags.PixelData);
		PixelDataReader oFWFwRQ1 = pdFact.newReader(qxZZOI2c, T8kIxPQ3, V8V2mdcs.getDcmDecodeParam().byteOrder,
				V8V2mdcs.getReadVR());
		System.out.println("reading " + xqxgkTtA + "...");
		oFWFwRQ1.readPixelData(false);
		ImageOutputStream x11GKGKu = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(GGJXpYP2)));
		DcmEncodeParam cH0IwSWI = DcmEncodeParam.IVR_LE;
		qxZZOI2c.writeDataset(x11GKGKu, cH0IwSWI);
		qxZZOI2c.writeHeader(x11GKGKu, cH0IwSWI, Tags.PixelData, V8V2mdcs.getReadVR(), V8V2mdcs.getReadLength());
		System.out.println("writing " + GGJXpYP2 + "...");
		PixelDataWriter kgD4Eyr5 = pdFact.newWriter(oFWFwRQ1.getPixelDataArray(), false, qxZZOI2c, x11GKGKu,
				V8V2mdcs.getDcmDecodeParam().byteOrder, V8V2mdcs.getReadVR());
		kgD4Eyr5.writePixelData();
		x11GKGKu.flush();
		x11GKGKu.close();
		System.out.println("done!");
	}

}