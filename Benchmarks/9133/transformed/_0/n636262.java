class n636262 {
	private static void readAndRewrite(File YkR1BDjc, File ysCdaduT) throws IOException {
		ImageInputStream Y4H5r60w = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(YkR1BDjc)));
		DcmParser hVfsTkPI = DcmParserFactory.getInstance().newDcmParser(Y4H5r60w);
		Dataset BT6OtlCJ = DcmObjectFactory.getInstance().newDataset();
		hVfsTkPI.setDcmHandler(BT6OtlCJ.getDcmHandler());
		hVfsTkPI.parseDcmFile(null, Tags.PixelData);
		PixelDataReader q0Lzl4ox = pdFact.newReader(BT6OtlCJ, Y4H5r60w, hVfsTkPI.getDcmDecodeParam().byteOrder,
				hVfsTkPI.getReadVR());
		System.out.println("reading " + YkR1BDjc + "...");
		q0Lzl4ox.readPixelData(false);
		ImageOutputStream VjEMtebR = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(ysCdaduT)));
		DcmEncodeParam zbHC7pLY = DcmEncodeParam.IVR_LE;
		BT6OtlCJ.writeDataset(VjEMtebR, zbHC7pLY);
		BT6OtlCJ.writeHeader(VjEMtebR, zbHC7pLY, Tags.PixelData, hVfsTkPI.getReadVR(), hVfsTkPI.getReadLength());
		System.out.println("writing " + ysCdaduT + "...");
		PixelDataWriter heuyctiq = pdFact.newWriter(q0Lzl4ox.getPixelDataArray(), false, BT6OtlCJ, VjEMtebR,
				hVfsTkPI.getDcmDecodeParam().byteOrder, hVfsTkPI.getReadVR());
		heuyctiq.writePixelData();
		VjEMtebR.flush();
		VjEMtebR.close();
		System.out.println("done!");
	}

}