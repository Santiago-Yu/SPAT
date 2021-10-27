class n470160 {
	private static void readAndRewrite(File aMhoVwpT, File gGM78itP) throws IOException {
		ImageInputStream QVn6eJfK = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(aMhoVwpT)));
		DcmParser AQlkmrBl = DcmParserFactory.getInstance().newDcmParser(QVn6eJfK);
		Dataset MzlylvJM = DcmObjectFactory.getInstance().newDataset();
		AQlkmrBl.setDcmHandler(MzlylvJM.getDcmHandler());
		AQlkmrBl.parseDcmFile(null, Tags.PixelData);
		PixelDataReader o94eMoH3 = pdFact.newReader(MzlylvJM, QVn6eJfK, AQlkmrBl.getDcmDecodeParam().byteOrder,
				AQlkmrBl.getReadVR());
		System.out.println("reading " + aMhoVwpT + "...");
		o94eMoH3.readPixelData(false);
		ImageOutputStream eBFcZP3v = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(gGM78itP)));
		DcmEncodeParam WtOEijWQ = DcmEncodeParam.IVR_LE;
		MzlylvJM.writeDataset(eBFcZP3v, WtOEijWQ);
		MzlylvJM.writeHeader(eBFcZP3v, WtOEijWQ, Tags.PixelData, AQlkmrBl.getReadVR(), AQlkmrBl.getReadLength());
		System.out.println("writing " + gGM78itP + "...");
		PixelDataWriter jDH548hF = pdFact.newWriter(o94eMoH3.getPixelDataArray(), false, MzlylvJM, eBFcZP3v,
				AQlkmrBl.getDcmDecodeParam().byteOrder, AQlkmrBl.getReadVR());
		jDH548hF.writePixelData();
		eBFcZP3v.flush();
		eBFcZP3v.close();
		System.out.println("done!");
	}

}