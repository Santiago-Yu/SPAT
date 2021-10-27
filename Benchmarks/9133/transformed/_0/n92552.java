class n92552 {
	private static void readAndRewrite(File V0cIf57x, File iE81Q8l3) throws IOException {
		ImageInputStream HeAUQuvA = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(V0cIf57x)));
		DcmParser ivkxpeOq = DcmParserFactory.getInstance().newDcmParser(HeAUQuvA);
		Dataset JGFtSOg9 = DcmObjectFactory.getInstance().newDataset();
		ivkxpeOq.setDcmHandler(JGFtSOg9.getDcmHandler());
		ivkxpeOq.parseDcmFile(null, Tags.PixelData);
		PixelDataReader LWpeI8eL = pdFact.newReader(JGFtSOg9, HeAUQuvA, ivkxpeOq.getDcmDecodeParam().byteOrder,
				ivkxpeOq.getReadVR());
		System.out.println("reading " + V0cIf57x + "...");
		LWpeI8eL.readPixelData(false);
		ImageOutputStream UHlvUPrf = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(iE81Q8l3)));
		DcmEncodeParam xWPsVJvN = DcmEncodeParam.IVR_LE;
		JGFtSOg9.writeDataset(UHlvUPrf, xWPsVJvN);
		JGFtSOg9.writeHeader(UHlvUPrf, xWPsVJvN, Tags.PixelData, ivkxpeOq.getReadVR(), ivkxpeOq.getReadLength());
		System.out.println("writing " + iE81Q8l3 + "...");
		PixelDataWriter BJPgpGEY = pdFact.newWriter(LWpeI8eL.getPixelDataArray(), false, JGFtSOg9, UHlvUPrf,
				ivkxpeOq.getDcmDecodeParam().byteOrder, ivkxpeOq.getReadVR());
		BJPgpGEY.writePixelData();
		UHlvUPrf.flush();
		UHlvUPrf.close();
		System.out.println("done!");
	}

}