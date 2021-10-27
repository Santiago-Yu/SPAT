class n601908 {
	private static void readAndRewrite(File gdWVWqAH, File xGownTEX) throws IOException {
		ImageInputStream SEaJ3gKy = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(gdWVWqAH)));
		DcmParser HtqAAxGw = DcmParserFactory.getInstance().newDcmParser(SEaJ3gKy);
		Dataset j26PdtT3 = DcmObjectFactory.getInstance().newDataset();
		HtqAAxGw.setDcmHandler(j26PdtT3.getDcmHandler());
		HtqAAxGw.parseDcmFile(null, Tags.PixelData);
		PixelDataReader NCwIkPBd = pdFact.newReader(j26PdtT3, SEaJ3gKy, HtqAAxGw.getDcmDecodeParam().byteOrder,
				HtqAAxGw.getReadVR());
		System.out.println("reading " + gdWVWqAH + "...");
		NCwIkPBd.readPixelData(false);
		ImageOutputStream VG9XoAzY = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(xGownTEX)));
		DcmEncodeParam jkBRgFdX = DcmEncodeParam.IVR_LE;
		j26PdtT3.writeDataset(VG9XoAzY, jkBRgFdX);
		j26PdtT3.writeHeader(VG9XoAzY, jkBRgFdX, Tags.PixelData, HtqAAxGw.getReadVR(), HtqAAxGw.getReadLength());
		System.out.println("writing " + xGownTEX + "...");
		PixelDataWriter xhMdIkZE = pdFact.newWriter(NCwIkPBd.getPixelDataArray(), false, j26PdtT3, VG9XoAzY,
				HtqAAxGw.getDcmDecodeParam().byteOrder, HtqAAxGw.getReadVR());
		xhMdIkZE.writePixelData();
		VG9XoAzY.flush();
		VG9XoAzY.close();
		System.out.println("done!");
	}

}