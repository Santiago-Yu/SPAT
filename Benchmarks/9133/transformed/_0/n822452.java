class n822452 {
	private static void readAndRewrite(File AIUoOenc, File jBdYwUXq) throws IOException {
		ImageInputStream pbAooWXc = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(AIUoOenc)));
		DcmParser OWWBrejW = DcmParserFactory.getInstance().newDcmParser(pbAooWXc);
		Dataset sSFpHe7h = DcmObjectFactory.getInstance().newDataset();
		OWWBrejW.setDcmHandler(sSFpHe7h.getDcmHandler());
		OWWBrejW.parseDcmFile(null, Tags.PixelData);
		PixelDataReader dFR1nyEr = pdFact.newReader(sSFpHe7h, pbAooWXc, OWWBrejW.getDcmDecodeParam().byteOrder,
				OWWBrejW.getReadVR());
		System.out.println("reading " + AIUoOenc + "...");
		dFR1nyEr.readPixelData(false);
		ImageOutputStream wTOLmkg4 = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(jBdYwUXq)));
		DcmEncodeParam iR82tsF5 = DcmEncodeParam.IVR_LE;
		sSFpHe7h.writeDataset(wTOLmkg4, iR82tsF5);
		sSFpHe7h.writeHeader(wTOLmkg4, iR82tsF5, Tags.PixelData, OWWBrejW.getReadVR(), OWWBrejW.getReadLength());
		System.out.println("writing " + jBdYwUXq + "...");
		PixelDataWriter oRg38BGU = pdFact.newWriter(dFR1nyEr.getPixelDataArray(), false, sSFpHe7h, wTOLmkg4,
				OWWBrejW.getDcmDecodeParam().byteOrder, OWWBrejW.getReadVR());
		oRg38BGU.writePixelData();
		wTOLmkg4.flush();
		wTOLmkg4.close();
		System.out.println("done!");
	}

}