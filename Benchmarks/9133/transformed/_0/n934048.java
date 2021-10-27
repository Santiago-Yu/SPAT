class n934048 {
	private static void readAndRewrite(File HXeIKxn1, File RslvvS86) throws IOException {
		ImageInputStream z3S1tGSD = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(HXeIKxn1)));
		DcmParser tR7hOxoB = DcmParserFactory.getInstance().newDcmParser(z3S1tGSD);
		Dataset buvmDkt1 = DcmObjectFactory.getInstance().newDataset();
		tR7hOxoB.setDcmHandler(buvmDkt1.getDcmHandler());
		tR7hOxoB.parseDcmFile(null, Tags.PixelData);
		PixelDataReader otTK7lGF = pdFact.newReader(buvmDkt1, z3S1tGSD, tR7hOxoB.getDcmDecodeParam().byteOrder,
				tR7hOxoB.getReadVR());
		System.out.println("reading " + HXeIKxn1 + "...");
		otTK7lGF.readPixelData(false);
		ImageOutputStream oQnCz0Km = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(RslvvS86)));
		DcmEncodeParam rAZgxXgF = DcmEncodeParam.IVR_LE;
		buvmDkt1.writeDataset(oQnCz0Km, rAZgxXgF);
		buvmDkt1.writeHeader(oQnCz0Km, rAZgxXgF, Tags.PixelData, tR7hOxoB.getReadVR(), tR7hOxoB.getReadLength());
		System.out.println("writing " + RslvvS86 + "...");
		PixelDataWriter rEjrhgib = pdFact.newWriter(otTK7lGF.getPixelDataArray(), false, buvmDkt1, oQnCz0Km,
				tR7hOxoB.getDcmDecodeParam().byteOrder, tR7hOxoB.getReadVR());
		rEjrhgib.writePixelData();
		oQnCz0Km.flush();
		oQnCz0Km.close();
		System.out.println("done!");
	}

}