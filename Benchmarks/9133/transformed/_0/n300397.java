class n300397 {
	private static void readAndRewrite(File MzOnyYWO, File ZEAP9xvf) throws IOException {
		ImageInputStream JWWFoTrF = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(MzOnyYWO)));
		DcmParser VWuckdkq = DcmParserFactory.getInstance().newDcmParser(JWWFoTrF);
		Dataset EZVVoYGQ = DcmObjectFactory.getInstance().newDataset();
		VWuckdkq.setDcmHandler(EZVVoYGQ.getDcmHandler());
		VWuckdkq.parseDcmFile(null, Tags.PixelData);
		PixelDataReader F7rvUoxy = pdFact.newReader(EZVVoYGQ, JWWFoTrF, VWuckdkq.getDcmDecodeParam().byteOrder,
				VWuckdkq.getReadVR());
		System.out.println("reading " + MzOnyYWO + "...");
		F7rvUoxy.readPixelData(false);
		ImageOutputStream aNQxXYrI = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(ZEAP9xvf)));
		DcmEncodeParam YC4aXVtp = DcmEncodeParam.IVR_LE;
		EZVVoYGQ.writeDataset(aNQxXYrI, YC4aXVtp);
		EZVVoYGQ.writeHeader(aNQxXYrI, YC4aXVtp, Tags.PixelData, VWuckdkq.getReadVR(), VWuckdkq.getReadLength());
		System.out.println("writing " + ZEAP9xvf + "...");
		PixelDataWriter po5L4VH6 = pdFact.newWriter(F7rvUoxy.getPixelDataArray(), false, EZVVoYGQ, aNQxXYrI,
				VWuckdkq.getDcmDecodeParam().byteOrder, VWuckdkq.getReadVR());
		po5L4VH6.writePixelData();
		aNQxXYrI.flush();
		aNQxXYrI.close();
		System.out.println("done!");
	}

}