class n949221 {
	private static void readAndRewrite(File e9XXJYfJ, File dVMCzPAq) throws IOException {
		ImageInputStream Jbap3zkc = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(e9XXJYfJ)));
		DcmParser UMBlKvp8 = DcmParserFactory.getInstance().newDcmParser(Jbap3zkc);
		Dataset FIgWHQMZ = DcmObjectFactory.getInstance().newDataset();
		UMBlKvp8.setDcmHandler(FIgWHQMZ.getDcmHandler());
		UMBlKvp8.parseDcmFile(null, Tags.PixelData);
		PixelDataReader H14Y710O = pdFact.newReader(FIgWHQMZ, Jbap3zkc, UMBlKvp8.getDcmDecodeParam().byteOrder,
				UMBlKvp8.getReadVR());
		System.out.println("reading " + e9XXJYfJ + "...");
		H14Y710O.readPixelData(false);
		ImageOutputStream QIEwkAdu = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(dVMCzPAq)));
		DcmEncodeParam A6DtgXMB = DcmEncodeParam.IVR_LE;
		FIgWHQMZ.writeDataset(QIEwkAdu, A6DtgXMB);
		FIgWHQMZ.writeHeader(QIEwkAdu, A6DtgXMB, Tags.PixelData, UMBlKvp8.getReadVR(), UMBlKvp8.getReadLength());
		System.out.println("writing " + dVMCzPAq + "...");
		PixelDataWriter QdKEy3Mt = pdFact.newWriter(H14Y710O.getPixelDataArray(), false, FIgWHQMZ, QIEwkAdu,
				UMBlKvp8.getDcmDecodeParam().byteOrder, UMBlKvp8.getReadVR());
		QdKEy3Mt.writePixelData();
		QIEwkAdu.flush();
		QIEwkAdu.close();
		System.out.println("done!");
	}

}