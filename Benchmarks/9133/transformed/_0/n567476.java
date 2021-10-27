class n567476 {
	private static void readAndRewrite(File L38KAdUY, File GQOKq6oP) throws IOException {
		ImageInputStream d1nyO3VW = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(L38KAdUY)));
		DcmParser I76fisB8 = DcmParserFactory.getInstance().newDcmParser(d1nyO3VW);
		Dataset x9s1yLct = DcmObjectFactory.getInstance().newDataset();
		I76fisB8.setDcmHandler(x9s1yLct.getDcmHandler());
		I76fisB8.parseDcmFile(null, Tags.PixelData);
		PixelDataReader vPJfC9Cd = pdFact.newReader(x9s1yLct, d1nyO3VW, I76fisB8.getDcmDecodeParam().byteOrder,
				I76fisB8.getReadVR());
		System.out.println("reading " + L38KAdUY + "...");
		vPJfC9Cd.readPixelData(false);
		ImageOutputStream I8y6NWcL = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(GQOKq6oP)));
		DcmEncodeParam a13cKgkv = DcmEncodeParam.IVR_LE;
		x9s1yLct.writeDataset(I8y6NWcL, a13cKgkv);
		x9s1yLct.writeHeader(I8y6NWcL, a13cKgkv, Tags.PixelData, I76fisB8.getReadVR(), I76fisB8.getReadLength());
		System.out.println("writing " + GQOKq6oP + "...");
		PixelDataWriter ZypnslUJ = pdFact.newWriter(vPJfC9Cd.getPixelDataArray(), false, x9s1yLct, I8y6NWcL,
				I76fisB8.getDcmDecodeParam().byteOrder, I76fisB8.getReadVR());
		ZypnslUJ.writePixelData();
		I8y6NWcL.flush();
		I8y6NWcL.close();
		System.out.println("done!");
	}

}