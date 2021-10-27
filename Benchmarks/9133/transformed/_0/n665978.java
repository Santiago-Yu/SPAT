class n665978 {
	private static void readAndRewrite(File fGCgfG7Y, File V9dltGvl) throws IOException {
		ImageInputStream wOPiTMzj = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(fGCgfG7Y)));
		DcmParser pEzRB9Gy = DcmParserFactory.getInstance().newDcmParser(wOPiTMzj);
		Dataset KMqqqNL3 = DcmObjectFactory.getInstance().newDataset();
		pEzRB9Gy.setDcmHandler(KMqqqNL3.getDcmHandler());
		pEzRB9Gy.parseDcmFile(null, Tags.PixelData);
		PixelDataReader M6zOLZ09 = pdFact.newReader(KMqqqNL3, wOPiTMzj, pEzRB9Gy.getDcmDecodeParam().byteOrder,
				pEzRB9Gy.getReadVR());
		System.out.println("reading " + fGCgfG7Y + "...");
		M6zOLZ09.readPixelData(false);
		ImageOutputStream YptJ1yPL = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(V9dltGvl)));
		DcmEncodeParam c16JG5y0 = DcmEncodeParam.IVR_LE;
		KMqqqNL3.writeDataset(YptJ1yPL, c16JG5y0);
		KMqqqNL3.writeHeader(YptJ1yPL, c16JG5y0, Tags.PixelData, pEzRB9Gy.getReadVR(), pEzRB9Gy.getReadLength());
		System.out.println("writing " + V9dltGvl + "...");
		PixelDataWriter dUELdMex = pdFact.newWriter(M6zOLZ09.getPixelDataArray(), false, KMqqqNL3, YptJ1yPL,
				pEzRB9Gy.getDcmDecodeParam().byteOrder, pEzRB9Gy.getReadVR());
		dUELdMex.writePixelData();
		YptJ1yPL.flush();
		YptJ1yPL.close();
		System.out.println("done!");
	}

}