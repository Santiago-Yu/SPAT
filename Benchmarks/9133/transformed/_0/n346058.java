class n346058 {
	private static void readAndRewrite(File SiDSfRg2, File HLcRNGsP) throws IOException {
		ImageInputStream HtDhjjUM = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(SiDSfRg2)));
		DcmParser DAaJCFbb = DcmParserFactory.getInstance().newDcmParser(HtDhjjUM);
		Dataset jUqkqsv5 = DcmObjectFactory.getInstance().newDataset();
		DAaJCFbb.setDcmHandler(jUqkqsv5.getDcmHandler());
		DAaJCFbb.parseDcmFile(null, Tags.PixelData);
		PixelDataReader zlAyanjb = pdFact.newReader(jUqkqsv5, HtDhjjUM, DAaJCFbb.getDcmDecodeParam().byteOrder,
				DAaJCFbb.getReadVR());
		System.out.println("reading " + SiDSfRg2 + "...");
		zlAyanjb.readPixelData(false);
		ImageOutputStream UUQggwhQ = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(HLcRNGsP)));
		DcmEncodeParam RJSTvHwJ = DcmEncodeParam.IVR_LE;
		jUqkqsv5.writeDataset(UUQggwhQ, RJSTvHwJ);
		jUqkqsv5.writeHeader(UUQggwhQ, RJSTvHwJ, Tags.PixelData, DAaJCFbb.getReadVR(), DAaJCFbb.getReadLength());
		System.out.println("writing " + HLcRNGsP + "...");
		PixelDataWriter jO3LRhGz = pdFact.newWriter(zlAyanjb.getPixelDataArray(), false, jUqkqsv5, UUQggwhQ,
				DAaJCFbb.getDcmDecodeParam().byteOrder, DAaJCFbb.getReadVR());
		jO3LRhGz.writePixelData();
		UUQggwhQ.flush();
		UUQggwhQ.close();
		System.out.println("done!");
	}

}