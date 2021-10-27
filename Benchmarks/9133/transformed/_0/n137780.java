class n137780 {
	private static void readAndRewrite(File TypoDTYe, File eDgYnbYE) throws IOException {
		ImageInputStream POqtjVS4 = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(TypoDTYe)));
		DcmParser BydElGad = DcmParserFactory.getInstance().newDcmParser(POqtjVS4);
		Dataset tR2nRiNd = DcmObjectFactory.getInstance().newDataset();
		BydElGad.setDcmHandler(tR2nRiNd.getDcmHandler());
		BydElGad.parseDcmFile(null, Tags.PixelData);
		PixelDataReader pcFPTDnh = pdFact.newReader(tR2nRiNd, POqtjVS4, BydElGad.getDcmDecodeParam().byteOrder,
				BydElGad.getReadVR());
		System.out.println("reading " + TypoDTYe + "...");
		pcFPTDnh.readPixelData(false);
		ImageOutputStream SIyk4jHF = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(eDgYnbYE)));
		DcmEncodeParam E2IMQqgp = DcmEncodeParam.IVR_LE;
		tR2nRiNd.writeDataset(SIyk4jHF, E2IMQqgp);
		tR2nRiNd.writeHeader(SIyk4jHF, E2IMQqgp, Tags.PixelData, BydElGad.getReadVR(), BydElGad.getReadLength());
		System.out.println("writing " + eDgYnbYE + "...");
		PixelDataWriter lNcPTtcL = pdFact.newWriter(pcFPTDnh.getPixelDataArray(), false, tR2nRiNd, SIyk4jHF,
				BydElGad.getDcmDecodeParam().byteOrder, BydElGad.getReadVR());
		lNcPTtcL.writePixelData();
		SIyk4jHF.flush();
		SIyk4jHF.close();
		System.out.println("done!");
	}

}