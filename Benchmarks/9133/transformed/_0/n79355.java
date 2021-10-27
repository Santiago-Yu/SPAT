class n79355 {
	private static void readAndRewrite(File WaSEl7J7, File tha6Lcyn) throws IOException {
		ImageInputStream DZgnSU4m = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(WaSEl7J7)));
		DcmParser AFIZbT5x = DcmParserFactory.getInstance().newDcmParser(DZgnSU4m);
		Dataset eX7iz8RA = DcmObjectFactory.getInstance().newDataset();
		AFIZbT5x.setDcmHandler(eX7iz8RA.getDcmHandler());
		AFIZbT5x.parseDcmFile(null, Tags.PixelData);
		PixelDataReader J6GzHzv8 = pdFact.newReader(eX7iz8RA, DZgnSU4m, AFIZbT5x.getDcmDecodeParam().byteOrder,
				AFIZbT5x.getReadVR());
		System.out.println("reading " + WaSEl7J7 + "...");
		J6GzHzv8.readPixelData(false);
		ImageOutputStream HSEffzMD = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(tha6Lcyn)));
		DcmEncodeParam z9jWLbr0 = DcmEncodeParam.IVR_LE;
		eX7iz8RA.writeDataset(HSEffzMD, z9jWLbr0);
		eX7iz8RA.writeHeader(HSEffzMD, z9jWLbr0, Tags.PixelData, AFIZbT5x.getReadVR(), AFIZbT5x.getReadLength());
		System.out.println("writing " + tha6Lcyn + "...");
		PixelDataWriter XJIrw8sa = pdFact.newWriter(J6GzHzv8.getPixelDataArray(), false, eX7iz8RA, HSEffzMD,
				AFIZbT5x.getDcmDecodeParam().byteOrder, AFIZbT5x.getReadVR());
		XJIrw8sa.writePixelData();
		HSEffzMD.flush();
		HSEffzMD.close();
		System.out.println("done!");
	}

}