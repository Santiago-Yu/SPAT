class n820905 {
	private static void readAndRewrite(File NJAf0YM7, File V4DmuWsC) throws IOException {
		ImageInputStream qwpEueRm = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(NJAf0YM7)));
		DcmParser ym5a2lue = DcmParserFactory.getInstance().newDcmParser(qwpEueRm);
		Dataset WMtYDT9A = DcmObjectFactory.getInstance().newDataset();
		ym5a2lue.setDcmHandler(WMtYDT9A.getDcmHandler());
		ym5a2lue.parseDcmFile(null, Tags.PixelData);
		PixelDataReader XIJMCe6z = pdFact.newReader(WMtYDT9A, qwpEueRm, ym5a2lue.getDcmDecodeParam().byteOrder,
				ym5a2lue.getReadVR());
		System.out.println("reading " + NJAf0YM7 + "...");
		XIJMCe6z.readPixelData(false);
		ImageOutputStream XJfRcGT6 = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(V4DmuWsC)));
		DcmEncodeParam JvBGSvPZ = DcmEncodeParam.IVR_LE;
		WMtYDT9A.writeDataset(XJfRcGT6, JvBGSvPZ);
		WMtYDT9A.writeHeader(XJfRcGT6, JvBGSvPZ, Tags.PixelData, ym5a2lue.getReadVR(), ym5a2lue.getReadLength());
		System.out.println("writing " + V4DmuWsC + "...");
		PixelDataWriter wUBE5CxP = pdFact.newWriter(XIJMCe6z.getPixelDataArray(), false, WMtYDT9A, XJfRcGT6,
				ym5a2lue.getDcmDecodeParam().byteOrder, ym5a2lue.getReadVR());
		wUBE5CxP.writePixelData();
		XJfRcGT6.flush();
		XJfRcGT6.close();
		System.out.println("done!");
	}

}