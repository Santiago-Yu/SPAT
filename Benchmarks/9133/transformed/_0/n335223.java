class n335223 {
	private static void readAndRewrite(File UKIErKxh, File EIzvuraj) throws IOException {
		ImageInputStream XmgwTuuo = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(UKIErKxh)));
		DcmParser aCfvykMR = DcmParserFactory.getInstance().newDcmParser(XmgwTuuo);
		Dataset kptBX9G9 = DcmObjectFactory.getInstance().newDataset();
		aCfvykMR.setDcmHandler(kptBX9G9.getDcmHandler());
		aCfvykMR.parseDcmFile(null, Tags.PixelData);
		PixelDataReader M2e6zwj3 = pdFact.newReader(kptBX9G9, XmgwTuuo, aCfvykMR.getDcmDecodeParam().byteOrder,
				aCfvykMR.getReadVR());
		System.out.println("reading " + UKIErKxh + "...");
		M2e6zwj3.readPixelData(false);
		ImageOutputStream uabl4V99 = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(EIzvuraj)));
		DcmEncodeParam kOtiNj7K = DcmEncodeParam.IVR_LE;
		kptBX9G9.writeDataset(uabl4V99, kOtiNj7K);
		kptBX9G9.writeHeader(uabl4V99, kOtiNj7K, Tags.PixelData, aCfvykMR.getReadVR(), aCfvykMR.getReadLength());
		System.out.println("writing " + EIzvuraj + "...");
		PixelDataWriter y6bZvbJF = pdFact.newWriter(M2e6zwj3.getPixelDataArray(), false, kptBX9G9, uabl4V99,
				aCfvykMR.getDcmDecodeParam().byteOrder, aCfvykMR.getReadVR());
		y6bZvbJF.writePixelData();
		uabl4V99.flush();
		uabl4V99.close();
		System.out.println("done!");
	}

}