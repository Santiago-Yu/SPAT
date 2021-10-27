class n288978 {
	private static void readAndRewrite(File Q439zsuR, File STV1A4X9) throws IOException {
		ImageInputStream qqOdAIkh = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(Q439zsuR)));
		DcmParser T69kMSEz = DcmParserFactory.getInstance().newDcmParser(qqOdAIkh);
		Dataset uEdvKPqi = DcmObjectFactory.getInstance().newDataset();
		T69kMSEz.setDcmHandler(uEdvKPqi.getDcmHandler());
		T69kMSEz.parseDcmFile(null, Tags.PixelData);
		PixelDataReader FzxMeqJB = pdFact.newReader(uEdvKPqi, qqOdAIkh, T69kMSEz.getDcmDecodeParam().byteOrder,
				T69kMSEz.getReadVR());
		System.out.println("reading " + Q439zsuR + "...");
		FzxMeqJB.readPixelData(false);
		ImageOutputStream AtBRSCfB = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(STV1A4X9)));
		DcmEncodeParam eluZ8RTN = DcmEncodeParam.IVR_LE;
		uEdvKPqi.writeDataset(AtBRSCfB, eluZ8RTN);
		uEdvKPqi.writeHeader(AtBRSCfB, eluZ8RTN, Tags.PixelData, T69kMSEz.getReadVR(), T69kMSEz.getReadLength());
		System.out.println("writing " + STV1A4X9 + "...");
		PixelDataWriter IzcparSG = pdFact.newWriter(FzxMeqJB.getPixelDataArray(), false, uEdvKPqi, AtBRSCfB,
				T69kMSEz.getDcmDecodeParam().byteOrder, T69kMSEz.getReadVR());
		IzcparSG.writePixelData();
		AtBRSCfB.flush();
		AtBRSCfB.close();
		System.out.println("done!");
	}

}