class n832329 {
	private static void readAndRewrite(File JIlD0GVn, File QIwRnMtR) throws IOException {
		ImageInputStream jQZJXm1i = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(JIlD0GVn)));
		DcmParser DBneicpM = DcmParserFactory.getInstance().newDcmParser(jQZJXm1i);
		Dataset uNqXGYQh = DcmObjectFactory.getInstance().newDataset();
		DBneicpM.setDcmHandler(uNqXGYQh.getDcmHandler());
		DBneicpM.parseDcmFile(null, Tags.PixelData);
		PixelDataReader jyfE7VZv = pdFact.newReader(uNqXGYQh, jQZJXm1i, DBneicpM.getDcmDecodeParam().byteOrder,
				DBneicpM.getReadVR());
		System.out.println("reading " + JIlD0GVn + "...");
		jyfE7VZv.readPixelData(false);
		ImageOutputStream AyK161cW = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(QIwRnMtR)));
		DcmEncodeParam Aoj6VEDh = DcmEncodeParam.IVR_LE;
		uNqXGYQh.writeDataset(AyK161cW, Aoj6VEDh);
		uNqXGYQh.writeHeader(AyK161cW, Aoj6VEDh, Tags.PixelData, DBneicpM.getReadVR(), DBneicpM.getReadLength());
		System.out.println("writing " + QIwRnMtR + "...");
		PixelDataWriter Z9rxUoKc = pdFact.newWriter(jyfE7VZv.getPixelDataArray(), false, uNqXGYQh, AyK161cW,
				DBneicpM.getDcmDecodeParam().byteOrder, DBneicpM.getReadVR());
		Z9rxUoKc.writePixelData();
		AyK161cW.flush();
		AyK161cW.close();
		System.out.println("done!");
	}

}