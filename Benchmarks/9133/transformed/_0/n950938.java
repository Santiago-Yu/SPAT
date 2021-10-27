class n950938 {
	private static void readAndRewrite(File HxHrMv1s, File XNhNZajt) throws IOException {
		ImageInputStream ou0nPAbB = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(HxHrMv1s)));
		DcmParser V9fT27LU = DcmParserFactory.getInstance().newDcmParser(ou0nPAbB);
		Dataset jHbo02hW = DcmObjectFactory.getInstance().newDataset();
		V9fT27LU.setDcmHandler(jHbo02hW.getDcmHandler());
		V9fT27LU.parseDcmFile(null, Tags.PixelData);
		PixelDataReader AYmTIxHD = pdFact.newReader(jHbo02hW, ou0nPAbB, V9fT27LU.getDcmDecodeParam().byteOrder,
				V9fT27LU.getReadVR());
		System.out.println("reading " + HxHrMv1s + "...");
		AYmTIxHD.readPixelData(false);
		ImageOutputStream ER1QAG1v = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(XNhNZajt)));
		DcmEncodeParam i1TBtmd4 = DcmEncodeParam.IVR_LE;
		jHbo02hW.writeDataset(ER1QAG1v, i1TBtmd4);
		jHbo02hW.writeHeader(ER1QAG1v, i1TBtmd4, Tags.PixelData, V9fT27LU.getReadVR(), V9fT27LU.getReadLength());
		System.out.println("writing " + XNhNZajt + "...");
		PixelDataWriter zhsqqtJt = pdFact.newWriter(AYmTIxHD.getPixelDataArray(), false, jHbo02hW, ER1QAG1v,
				V9fT27LU.getDcmDecodeParam().byteOrder, V9fT27LU.getReadVR());
		zhsqqtJt.writePixelData();
		ER1QAG1v.flush();
		ER1QAG1v.close();
		System.out.println("done!");
	}

}