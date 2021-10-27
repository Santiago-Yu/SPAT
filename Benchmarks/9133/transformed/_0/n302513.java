class n302513 {
	private static void readAndRewrite(File Z2prbTY8, File OmlUh0HR) throws IOException {
		ImageInputStream whsmpclq = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(Z2prbTY8)));
		DcmParser qoAiASWy = DcmParserFactory.getInstance().newDcmParser(whsmpclq);
		Dataset LXzQrq96 = DcmObjectFactory.getInstance().newDataset();
		qoAiASWy.setDcmHandler(LXzQrq96.getDcmHandler());
		qoAiASWy.parseDcmFile(null, Tags.PixelData);
		PixelDataReader oBHEUlEu = pdFact.newReader(LXzQrq96, whsmpclq, qoAiASWy.getDcmDecodeParam().byteOrder,
				qoAiASWy.getReadVR());
		System.out.println("reading " + Z2prbTY8 + "...");
		oBHEUlEu.readPixelData(false);
		ImageOutputStream LWr8E5UR = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(OmlUh0HR)));
		DcmEncodeParam PRdXAsf0 = DcmEncodeParam.IVR_LE;
		LXzQrq96.writeDataset(LWr8E5UR, PRdXAsf0);
		LXzQrq96.writeHeader(LWr8E5UR, PRdXAsf0, Tags.PixelData, qoAiASWy.getReadVR(), qoAiASWy.getReadLength());
		System.out.println("writing " + OmlUh0HR + "...");
		PixelDataWriter P3WoQVto = pdFact.newWriter(oBHEUlEu.getPixelDataArray(), false, LXzQrq96, LWr8E5UR,
				qoAiASWy.getDcmDecodeParam().byteOrder, qoAiASWy.getReadVR());
		P3WoQVto.writePixelData();
		LWr8E5UR.flush();
		LWr8E5UR.close();
		System.out.println("done!");
	}

}