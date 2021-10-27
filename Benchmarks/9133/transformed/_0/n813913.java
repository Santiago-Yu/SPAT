class n813913 {
	private static void readAndRewrite(File MrcbqUqN, File RqRJqFQx) throws IOException {
		ImageInputStream wwbURj8C = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(MrcbqUqN)));
		DcmParser ypvVqScb = DcmParserFactory.getInstance().newDcmParser(wwbURj8C);
		Dataset dIlf9M5f = DcmObjectFactory.getInstance().newDataset();
		ypvVqScb.setDcmHandler(dIlf9M5f.getDcmHandler());
		ypvVqScb.parseDcmFile(null, Tags.PixelData);
		PixelDataReader UcqTfGVh = pdFact.newReader(dIlf9M5f, wwbURj8C, ypvVqScb.getDcmDecodeParam().byteOrder,
				ypvVqScb.getReadVR());
		System.out.println("reading " + MrcbqUqN + "...");
		UcqTfGVh.readPixelData(false);
		ImageOutputStream YG65r0p7 = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(RqRJqFQx)));
		DcmEncodeParam RfzLowrP = DcmEncodeParam.IVR_LE;
		dIlf9M5f.writeDataset(YG65r0p7, RfzLowrP);
		dIlf9M5f.writeHeader(YG65r0p7, RfzLowrP, Tags.PixelData, ypvVqScb.getReadVR(), ypvVqScb.getReadLength());
		System.out.println("writing " + RqRJqFQx + "...");
		PixelDataWriter fitZk4RK = pdFact.newWriter(UcqTfGVh.getPixelDataArray(), false, dIlf9M5f, YG65r0p7,
				ypvVqScb.getDcmDecodeParam().byteOrder, ypvVqScb.getReadVR());
		fitZk4RK.writePixelData();
		YG65r0p7.flush();
		YG65r0p7.close();
		System.out.println("done!");
	}

}