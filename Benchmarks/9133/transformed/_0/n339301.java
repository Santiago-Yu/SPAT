class n339301 {
	private static void readAndRewrite(File xuMKMndl, File pwEkNiTd) throws IOException {
		ImageInputStream NzOfdG5X = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(xuMKMndl)));
		DcmParser aH13Jm7y = DcmParserFactory.getInstance().newDcmParser(NzOfdG5X);
		Dataset pXTLekGq = DcmObjectFactory.getInstance().newDataset();
		aH13Jm7y.setDcmHandler(pXTLekGq.getDcmHandler());
		aH13Jm7y.parseDcmFile(null, Tags.PixelData);
		PixelDataReader r7nUFGZN = pdFact.newReader(pXTLekGq, NzOfdG5X, aH13Jm7y.getDcmDecodeParam().byteOrder,
				aH13Jm7y.getReadVR());
		System.out.println("reading " + xuMKMndl + "...");
		r7nUFGZN.readPixelData(false);
		ImageOutputStream U3SRNUfY = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(pwEkNiTd)));
		DcmEncodeParam NJpEUDSw = DcmEncodeParam.IVR_LE;
		pXTLekGq.writeDataset(U3SRNUfY, NJpEUDSw);
		pXTLekGq.writeHeader(U3SRNUfY, NJpEUDSw, Tags.PixelData, aH13Jm7y.getReadVR(), aH13Jm7y.getReadLength());
		System.out.println("writing " + pwEkNiTd + "...");
		PixelDataWriter ojSOw7uQ = pdFact.newWriter(r7nUFGZN.getPixelDataArray(), false, pXTLekGq, U3SRNUfY,
				aH13Jm7y.getDcmDecodeParam().byteOrder, aH13Jm7y.getReadVR());
		ojSOw7uQ.writePixelData();
		U3SRNUfY.flush();
		U3SRNUfY.close();
		System.out.println("done!");
	}

}