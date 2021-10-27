class n305886 {
	private static void readAndRewrite(File ivEjY7Ek, File Zg9bSlK7) throws IOException {
		ImageInputStream PQk89WYT = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(ivEjY7Ek)));
		DcmParser fAv11WsU = DcmParserFactory.getInstance().newDcmParser(PQk89WYT);
		Dataset DdKzlJWW = DcmObjectFactory.getInstance().newDataset();
		fAv11WsU.setDcmHandler(DdKzlJWW.getDcmHandler());
		fAv11WsU.parseDcmFile(null, Tags.PixelData);
		PixelDataReader i7TpvR8U = pdFact.newReader(DdKzlJWW, PQk89WYT, fAv11WsU.getDcmDecodeParam().byteOrder,
				fAv11WsU.getReadVR());
		System.out.println("reading " + ivEjY7Ek + "...");
		i7TpvR8U.readPixelData(false);
		ImageOutputStream JdEz6rcd = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(Zg9bSlK7)));
		DcmEncodeParam MEe2i8sc = DcmEncodeParam.IVR_LE;
		DdKzlJWW.writeDataset(JdEz6rcd, MEe2i8sc);
		DdKzlJWW.writeHeader(JdEz6rcd, MEe2i8sc, Tags.PixelData, fAv11WsU.getReadVR(), fAv11WsU.getReadLength());
		System.out.println("writing " + Zg9bSlK7 + "...");
		PixelDataWriter QtpvTpH7 = pdFact.newWriter(i7TpvR8U.getPixelDataArray(), false, DdKzlJWW, JdEz6rcd,
				fAv11WsU.getDcmDecodeParam().byteOrder, fAv11WsU.getReadVR());
		QtpvTpH7.writePixelData();
		JdEz6rcd.flush();
		JdEz6rcd.close();
		System.out.println("done!");
	}

}