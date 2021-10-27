class n689689 {
	private static void readAndRewrite(File oO3Kuw2f, File QNPeUqEV) throws IOException {
		ImageInputStream Fza2M521 = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(oO3Kuw2f)));
		DcmParser GyacMLjH = DcmParserFactory.getInstance().newDcmParser(Fza2M521);
		Dataset dHulU7Ht = DcmObjectFactory.getInstance().newDataset();
		GyacMLjH.setDcmHandler(dHulU7Ht.getDcmHandler());
		GyacMLjH.parseDcmFile(null, Tags.PixelData);
		PixelDataReader w1ACvpPY = pdFact.newReader(dHulU7Ht, Fza2M521, GyacMLjH.getDcmDecodeParam().byteOrder,
				GyacMLjH.getReadVR());
		System.out.println("reading " + oO3Kuw2f + "...");
		w1ACvpPY.readPixelData(false);
		ImageOutputStream BH6TsP4k = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(QNPeUqEV)));
		DcmEncodeParam JXL0qYsf = DcmEncodeParam.IVR_LE;
		dHulU7Ht.writeDataset(BH6TsP4k, JXL0qYsf);
		dHulU7Ht.writeHeader(BH6TsP4k, JXL0qYsf, Tags.PixelData, GyacMLjH.getReadVR(), GyacMLjH.getReadLength());
		System.out.println("writing " + QNPeUqEV + "...");
		PixelDataWriter z5YQrvPd = pdFact.newWriter(w1ACvpPY.getPixelDataArray(), false, dHulU7Ht, BH6TsP4k,
				GyacMLjH.getDcmDecodeParam().byteOrder, GyacMLjH.getReadVR());
		z5YQrvPd.writePixelData();
		BH6TsP4k.flush();
		BH6TsP4k.close();
		System.out.println("done!");
	}

}