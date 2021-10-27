class n431295 {
	private static void readAndRewrite(File jf9ruySC, File TmJFPyyu) throws IOException {
		ImageInputStream UURhTbDx = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(jf9ruySC)));
		DcmParser rN3zBK47 = DcmParserFactory.getInstance().newDcmParser(UURhTbDx);
		Dataset OsyvCGdJ = DcmObjectFactory.getInstance().newDataset();
		rN3zBK47.setDcmHandler(OsyvCGdJ.getDcmHandler());
		rN3zBK47.parseDcmFile(null, Tags.PixelData);
		PixelDataReader x9hfbfYh = pdFact.newReader(OsyvCGdJ, UURhTbDx, rN3zBK47.getDcmDecodeParam().byteOrder,
				rN3zBK47.getReadVR());
		System.out.println("reading " + jf9ruySC + "...");
		x9hfbfYh.readPixelData(false);
		ImageOutputStream LDC6gjrx = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(TmJFPyyu)));
		DcmEncodeParam rjL77WMA = DcmEncodeParam.IVR_LE;
		OsyvCGdJ.writeDataset(LDC6gjrx, rjL77WMA);
		OsyvCGdJ.writeHeader(LDC6gjrx, rjL77WMA, Tags.PixelData, rN3zBK47.getReadVR(), rN3zBK47.getReadLength());
		System.out.println("writing " + TmJFPyyu + "...");
		PixelDataWriter f78lLTKF = pdFact.newWriter(x9hfbfYh.getPixelDataArray(), false, OsyvCGdJ, LDC6gjrx,
				rN3zBK47.getDcmDecodeParam().byteOrder, rN3zBK47.getReadVR());
		f78lLTKF.writePixelData();
		LDC6gjrx.flush();
		LDC6gjrx.close();
		System.out.println("done!");
	}

}