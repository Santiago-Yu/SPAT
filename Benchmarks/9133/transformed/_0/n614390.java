class n614390 {
	private static void readAndRewrite(File xdUDYgLA, File Py0jYErf) throws IOException {
		ImageInputStream N2RtTz99 = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(xdUDYgLA)));
		DcmParser o7s5t2c1 = DcmParserFactory.getInstance().newDcmParser(N2RtTz99);
		Dataset XSzvaPDQ = DcmObjectFactory.getInstance().newDataset();
		o7s5t2c1.setDcmHandler(XSzvaPDQ.getDcmHandler());
		o7s5t2c1.parseDcmFile(null, Tags.PixelData);
		PixelDataReader XZinrF2H = pdFact.newReader(XSzvaPDQ, N2RtTz99, o7s5t2c1.getDcmDecodeParam().byteOrder,
				o7s5t2c1.getReadVR());
		System.out.println("reading " + xdUDYgLA + "...");
		XZinrF2H.readPixelData(false);
		ImageOutputStream adP5rS37 = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(Py0jYErf)));
		DcmEncodeParam pwFE2n2l = DcmEncodeParam.IVR_LE;
		XSzvaPDQ.writeDataset(adP5rS37, pwFE2n2l);
		XSzvaPDQ.writeHeader(adP5rS37, pwFE2n2l, Tags.PixelData, o7s5t2c1.getReadVR(), o7s5t2c1.getReadLength());
		System.out.println("writing " + Py0jYErf + "...");
		PixelDataWriter TNP4zBbW = pdFact.newWriter(XZinrF2H.getPixelDataArray(), false, XSzvaPDQ, adP5rS37,
				o7s5t2c1.getDcmDecodeParam().byteOrder, o7s5t2c1.getReadVR());
		TNP4zBbW.writePixelData();
		adP5rS37.flush();
		adP5rS37.close();
		System.out.println("done!");
	}

}