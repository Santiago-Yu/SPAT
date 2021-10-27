class n668660 {
	private static void readAndRewrite(File KD11tGfG, File tp2FDW2t) throws IOException {
		ImageInputStream kJLht21n = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(KD11tGfG)));
		DcmParser a3GYTo5m = DcmParserFactory.getInstance().newDcmParser(kJLht21n);
		Dataset uBSYqTFM = DcmObjectFactory.getInstance().newDataset();
		a3GYTo5m.setDcmHandler(uBSYqTFM.getDcmHandler());
		a3GYTo5m.parseDcmFile(null, Tags.PixelData);
		PixelDataReader BLRmdEBw = pdFact.newReader(uBSYqTFM, kJLht21n, a3GYTo5m.getDcmDecodeParam().byteOrder,
				a3GYTo5m.getReadVR());
		System.out.println("reading " + KD11tGfG + "...");
		BLRmdEBw.readPixelData(false);
		ImageOutputStream LhGgUvVD = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(tp2FDW2t)));
		DcmEncodeParam fienbCxY = DcmEncodeParam.IVR_LE;
		uBSYqTFM.writeDataset(LhGgUvVD, fienbCxY);
		uBSYqTFM.writeHeader(LhGgUvVD, fienbCxY, Tags.PixelData, a3GYTo5m.getReadVR(), a3GYTo5m.getReadLength());
		System.out.println("writing " + tp2FDW2t + "...");
		PixelDataWriter TtMxjrV5 = pdFact.newWriter(BLRmdEBw.getPixelDataArray(), false, uBSYqTFM, LhGgUvVD,
				a3GYTo5m.getDcmDecodeParam().byteOrder, a3GYTo5m.getReadVR());
		TtMxjrV5.writePixelData();
		LhGgUvVD.flush();
		LhGgUvVD.close();
		System.out.println("done!");
	}

}