class n414463 {
	private static void readAndRewrite(File fUypRAKO, File OICibDsC) throws IOException {
		ImageInputStream nHg7s6Px = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(fUypRAKO)));
		DcmParser bbR5d6cF = DcmParserFactory.getInstance().newDcmParser(nHg7s6Px);
		Dataset Ua6mpTN7 = DcmObjectFactory.getInstance().newDataset();
		bbR5d6cF.setDcmHandler(Ua6mpTN7.getDcmHandler());
		bbR5d6cF.parseDcmFile(null, Tags.PixelData);
		PixelDataReader wh5OSNkq = pdFact.newReader(Ua6mpTN7, nHg7s6Px, bbR5d6cF.getDcmDecodeParam().byteOrder,
				bbR5d6cF.getReadVR());
		System.out.println("reading " + fUypRAKO + "...");
		wh5OSNkq.readPixelData(false);
		ImageOutputStream X8XcqdD8 = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(OICibDsC)));
		DcmEncodeParam dBtv3Vo8 = DcmEncodeParam.IVR_LE;
		Ua6mpTN7.writeDataset(X8XcqdD8, dBtv3Vo8);
		Ua6mpTN7.writeHeader(X8XcqdD8, dBtv3Vo8, Tags.PixelData, bbR5d6cF.getReadVR(), bbR5d6cF.getReadLength());
		System.out.println("writing " + OICibDsC + "...");
		PixelDataWriter z9mYV3Bt = pdFact.newWriter(wh5OSNkq.getPixelDataArray(), false, Ua6mpTN7, X8XcqdD8,
				bbR5d6cF.getDcmDecodeParam().byteOrder, bbR5d6cF.getReadVR());
		z9mYV3Bt.writePixelData();
		X8XcqdD8.flush();
		X8XcqdD8.close();
		System.out.println("done!");
	}

}