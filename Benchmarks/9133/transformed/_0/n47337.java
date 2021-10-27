class n47337 {
	private static void readAndRewrite(File Ec9vb8J2, File GsCF0tos) throws IOException {
		ImageInputStream X9JdYJFK = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(Ec9vb8J2)));
		DcmParser a885x9Ro = DcmParserFactory.getInstance().newDcmParser(X9JdYJFK);
		Dataset vPLwvcc4 = DcmObjectFactory.getInstance().newDataset();
		a885x9Ro.setDcmHandler(vPLwvcc4.getDcmHandler());
		a885x9Ro.parseDcmFile(null, Tags.PixelData);
		PixelDataReader AYBdFFAK = pdFact.newReader(vPLwvcc4, X9JdYJFK, a885x9Ro.getDcmDecodeParam().byteOrder,
				a885x9Ro.getReadVR());
		System.out.println("reading " + Ec9vb8J2 + "...");
		AYBdFFAK.readPixelData(false);
		ImageOutputStream Ymmjh4xL = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(GsCF0tos)));
		DcmEncodeParam sHvUURyC = DcmEncodeParam.IVR_LE;
		vPLwvcc4.writeDataset(Ymmjh4xL, sHvUURyC);
		vPLwvcc4.writeHeader(Ymmjh4xL, sHvUURyC, Tags.PixelData, a885x9Ro.getReadVR(), a885x9Ro.getReadLength());
		System.out.println("writing " + GsCF0tos + "...");
		PixelDataWriter ikHhf42f = pdFact.newWriter(AYBdFFAK.getPixelDataArray(), false, vPLwvcc4, Ymmjh4xL,
				a885x9Ro.getDcmDecodeParam().byteOrder, a885x9Ro.getReadVR());
		ikHhf42f.writePixelData();
		Ymmjh4xL.flush();
		Ymmjh4xL.close();
		System.out.println("done!");
	}

}