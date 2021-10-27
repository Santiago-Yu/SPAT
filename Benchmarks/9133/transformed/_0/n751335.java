class n751335 {
	private static void readAndRewrite(File qA4oNd7n, File EGZigVTk) throws IOException {
		ImageInputStream WFwpqkSY = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(qA4oNd7n)));
		DcmParser dXEpGjNV = DcmParserFactory.getInstance().newDcmParser(WFwpqkSY);
		Dataset oi9jYuFP = DcmObjectFactory.getInstance().newDataset();
		dXEpGjNV.setDcmHandler(oi9jYuFP.getDcmHandler());
		dXEpGjNV.parseDcmFile(null, Tags.PixelData);
		PixelDataReader ymj0yCTN = pdFact.newReader(oi9jYuFP, WFwpqkSY, dXEpGjNV.getDcmDecodeParam().byteOrder,
				dXEpGjNV.getReadVR());
		System.out.println("reading " + qA4oNd7n + "...");
		ymj0yCTN.readPixelData(false);
		ImageOutputStream HOW7qqLt = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(EGZigVTk)));
		DcmEncodeParam eu89uOP8 = DcmEncodeParam.IVR_LE;
		oi9jYuFP.writeDataset(HOW7qqLt, eu89uOP8);
		oi9jYuFP.writeHeader(HOW7qqLt, eu89uOP8, Tags.PixelData, dXEpGjNV.getReadVR(), dXEpGjNV.getReadLength());
		System.out.println("writing " + EGZigVTk + "...");
		PixelDataWriter MZIYVI64 = pdFact.newWriter(ymj0yCTN.getPixelDataArray(), false, oi9jYuFP, HOW7qqLt,
				dXEpGjNV.getDcmDecodeParam().byteOrder, dXEpGjNV.getReadVR());
		MZIYVI64.writePixelData();
		HOW7qqLt.flush();
		HOW7qqLt.close();
		System.out.println("done!");
	}

}