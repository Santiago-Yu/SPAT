class n33845 {
	private static void readAndRewrite(File L0lh7R50, File whIr9rKm) throws IOException {
		ImageInputStream FJ8Grkwr = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(L0lh7R50)));
		DcmParser aflkhGNW = DcmParserFactory.getInstance().newDcmParser(FJ8Grkwr);
		Dataset Mu9ps853 = DcmObjectFactory.getInstance().newDataset();
		aflkhGNW.setDcmHandler(Mu9ps853.getDcmHandler());
		aflkhGNW.parseDcmFile(null, Tags.PixelData);
		PixelDataReader eaC5OMDa = pdFact.newReader(Mu9ps853, FJ8Grkwr, aflkhGNW.getDcmDecodeParam().byteOrder,
				aflkhGNW.getReadVR());
		System.out.println("reading " + L0lh7R50 + "...");
		eaC5OMDa.readPixelData(false);
		ImageOutputStream Xl3W2TER = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(whIr9rKm)));
		DcmEncodeParam ZAD8t3b7 = DcmEncodeParam.IVR_LE;
		Mu9ps853.writeDataset(Xl3W2TER, ZAD8t3b7);
		Mu9ps853.writeHeader(Xl3W2TER, ZAD8t3b7, Tags.PixelData, aflkhGNW.getReadVR(), aflkhGNW.getReadLength());
		System.out.println("writing " + whIr9rKm + "...");
		PixelDataWriter hPrh4gBY = pdFact.newWriter(eaC5OMDa.getPixelDataArray(), false, Mu9ps853, Xl3W2TER,
				aflkhGNW.getDcmDecodeParam().byteOrder, aflkhGNW.getReadVR());
		hPrh4gBY.writePixelData();
		Xl3W2TER.flush();
		Xl3W2TER.close();
		System.out.println("done!");
	}

}