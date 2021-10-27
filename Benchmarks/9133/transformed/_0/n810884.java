class n810884 {
	private static void readAndRewrite(File QT9GgnGU, File DpQHr47U) throws IOException {
		ImageInputStream mHh3H0mg = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(QT9GgnGU)));
		DcmParser f39tIKL1 = DcmParserFactory.getInstance().newDcmParser(mHh3H0mg);
		Dataset futgOD1A = DcmObjectFactory.getInstance().newDataset();
		f39tIKL1.setDcmHandler(futgOD1A.getDcmHandler());
		f39tIKL1.parseDcmFile(null, Tags.PixelData);
		PixelDataReader ysgdyFrk = pdFact.newReader(futgOD1A, mHh3H0mg, f39tIKL1.getDcmDecodeParam().byteOrder,
				f39tIKL1.getReadVR());
		System.out.println("reading " + QT9GgnGU + "...");
		ysgdyFrk.readPixelData(false);
		ImageOutputStream wGNfUNRt = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(DpQHr47U)));
		DcmEncodeParam c2OjyzS4 = DcmEncodeParam.IVR_LE;
		futgOD1A.writeDataset(wGNfUNRt, c2OjyzS4);
		futgOD1A.writeHeader(wGNfUNRt, c2OjyzS4, Tags.PixelData, f39tIKL1.getReadVR(), f39tIKL1.getReadLength());
		System.out.println("writing " + DpQHr47U + "...");
		PixelDataWriter JMSP7oqz = pdFact.newWriter(ysgdyFrk.getPixelDataArray(), false, futgOD1A, wGNfUNRt,
				f39tIKL1.getDcmDecodeParam().byteOrder, f39tIKL1.getReadVR());
		JMSP7oqz.writePixelData();
		wGNfUNRt.flush();
		wGNfUNRt.close();
		System.out.println("done!");
	}

}