class n168607 {
	private static void readAndRewrite(File THQ5hx87, File YuqIjg9C) throws IOException {
		ImageInputStream y7kniB1Y = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(THQ5hx87)));
		DcmParser Xj5P6gEx = DcmParserFactory.getInstance().newDcmParser(y7kniB1Y);
		Dataset F8ssqRZ9 = DcmObjectFactory.getInstance().newDataset();
		Xj5P6gEx.setDcmHandler(F8ssqRZ9.getDcmHandler());
		Xj5P6gEx.parseDcmFile(null, Tags.PixelData);
		PixelDataReader D0yZqcK9 = pdFact.newReader(F8ssqRZ9, y7kniB1Y, Xj5P6gEx.getDcmDecodeParam().byteOrder,
				Xj5P6gEx.getReadVR());
		System.out.println("reading " + THQ5hx87 + "...");
		D0yZqcK9.readPixelData(false);
		ImageOutputStream hPJjBL1S = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(YuqIjg9C)));
		DcmEncodeParam x0MK1mhk = DcmEncodeParam.IVR_LE;
		F8ssqRZ9.writeDataset(hPJjBL1S, x0MK1mhk);
		F8ssqRZ9.writeHeader(hPJjBL1S, x0MK1mhk, Tags.PixelData, Xj5P6gEx.getReadVR(), Xj5P6gEx.getReadLength());
		System.out.println("writing " + YuqIjg9C + "...");
		PixelDataWriter K8xwOsRp = pdFact.newWriter(D0yZqcK9.getPixelDataArray(), false, F8ssqRZ9, hPJjBL1S,
				Xj5P6gEx.getDcmDecodeParam().byteOrder, Xj5P6gEx.getReadVR());
		K8xwOsRp.writePixelData();
		hPJjBL1S.flush();
		hPJjBL1S.close();
		System.out.println("done!");
	}

}