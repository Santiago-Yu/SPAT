class n116038 {
	private static void readAndRewrite(File bnluSD7T, File dhWIn2Jv) throws IOException {
		ImageInputStream OomCi6BY = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(bnluSD7T)));
		DcmParser vTlv426u = DcmParserFactory.getInstance().newDcmParser(OomCi6BY);
		Dataset EBd0eexA = DcmObjectFactory.getInstance().newDataset();
		vTlv426u.setDcmHandler(EBd0eexA.getDcmHandler());
		vTlv426u.parseDcmFile(null, Tags.PixelData);
		PixelDataReader CSqpdZGu = pdFact.newReader(EBd0eexA, OomCi6BY, vTlv426u.getDcmDecodeParam().byteOrder,
				vTlv426u.getReadVR());
		System.out.println("reading " + bnluSD7T + "...");
		CSqpdZGu.readPixelData(false);
		ImageOutputStream AlKZBg8Z = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(dhWIn2Jv)));
		DcmEncodeParam cpAMqYaf = DcmEncodeParam.IVR_LE;
		EBd0eexA.writeDataset(AlKZBg8Z, cpAMqYaf);
		EBd0eexA.writeHeader(AlKZBg8Z, cpAMqYaf, Tags.PixelData, vTlv426u.getReadVR(), vTlv426u.getReadLength());
		System.out.println("writing " + dhWIn2Jv + "...");
		PixelDataWriter Ynmz0YBD = pdFact.newWriter(CSqpdZGu.getPixelDataArray(), false, EBd0eexA, AlKZBg8Z,
				vTlv426u.getDcmDecodeParam().byteOrder, vTlv426u.getReadVR());
		Ynmz0YBD.writePixelData();
		AlKZBg8Z.flush();
		AlKZBg8Z.close();
		System.out.println("done!");
	}

}