class n161844 {
	private static void readAndRewrite(File p1vu1YxI, File K26qejqx) throws IOException {
		ImageInputStream XMtPQqF6 = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(p1vu1YxI)));
		DcmParser F6fCUJta = DcmParserFactory.getInstance().newDcmParser(XMtPQqF6);
		Dataset LBxlWNUp = DcmObjectFactory.getInstance().newDataset();
		F6fCUJta.setDcmHandler(LBxlWNUp.getDcmHandler());
		F6fCUJta.parseDcmFile(null, Tags.PixelData);
		PixelDataReader KEsE4dal = pdFact.newReader(LBxlWNUp, XMtPQqF6, F6fCUJta.getDcmDecodeParam().byteOrder,
				F6fCUJta.getReadVR());
		System.out.println("reading " + p1vu1YxI + "...");
		KEsE4dal.readPixelData(false);
		ImageOutputStream PSd1L9yH = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(K26qejqx)));
		DcmEncodeParam xdjiFfXE = DcmEncodeParam.IVR_LE;
		LBxlWNUp.writeDataset(PSd1L9yH, xdjiFfXE);
		LBxlWNUp.writeHeader(PSd1L9yH, xdjiFfXE, Tags.PixelData, F6fCUJta.getReadVR(), F6fCUJta.getReadLength());
		System.out.println("writing " + K26qejqx + "...");
		PixelDataWriter OKLmBfoY = pdFact.newWriter(KEsE4dal.getPixelDataArray(), false, LBxlWNUp, PSd1L9yH,
				F6fCUJta.getDcmDecodeParam().byteOrder, F6fCUJta.getReadVR());
		OKLmBfoY.writePixelData();
		PSd1L9yH.flush();
		PSd1L9yH.close();
		System.out.println("done!");
	}

}