class n272875 {
	private static void readAndRewrite(File boeddhk2, File L9hnc6e7) throws IOException {
		ImageInputStream p2IRIeIO = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(boeddhk2)));
		DcmParser xC7gMZnn = DcmParserFactory.getInstance().newDcmParser(p2IRIeIO);
		Dataset MEK9fMz3 = DcmObjectFactory.getInstance().newDataset();
		xC7gMZnn.setDcmHandler(MEK9fMz3.getDcmHandler());
		xC7gMZnn.parseDcmFile(null, Tags.PixelData);
		PixelDataReader tqDWNkAM = pdFact.newReader(MEK9fMz3, p2IRIeIO, xC7gMZnn.getDcmDecodeParam().byteOrder,
				xC7gMZnn.getReadVR());
		System.out.println("reading " + boeddhk2 + "...");
		tqDWNkAM.readPixelData(false);
		ImageOutputStream isGYsSn8 = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(L9hnc6e7)));
		DcmEncodeParam eP7iHuW2 = DcmEncodeParam.IVR_LE;
		MEK9fMz3.writeDataset(isGYsSn8, eP7iHuW2);
		MEK9fMz3.writeHeader(isGYsSn8, eP7iHuW2, Tags.PixelData, xC7gMZnn.getReadVR(), xC7gMZnn.getReadLength());
		System.out.println("writing " + L9hnc6e7 + "...");
		PixelDataWriter K2abhh6W = pdFact.newWriter(tqDWNkAM.getPixelDataArray(), false, MEK9fMz3, isGYsSn8,
				xC7gMZnn.getDcmDecodeParam().byteOrder, xC7gMZnn.getReadVR());
		K2abhh6W.writePixelData();
		isGYsSn8.flush();
		isGYsSn8.close();
		System.out.println("done!");
	}

}