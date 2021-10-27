class n586503 {
	private static void readAndRewrite(File Y6d45C2J, File z6acxqsu) throws IOException {
		ImageInputStream kumQhZdx = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(Y6d45C2J)));
		DcmParser NAQuRrAL = DcmParserFactory.getInstance().newDcmParser(kumQhZdx);
		Dataset cSlbdCEB = DcmObjectFactory.getInstance().newDataset();
		NAQuRrAL.setDcmHandler(cSlbdCEB.getDcmHandler());
		NAQuRrAL.parseDcmFile(null, Tags.PixelData);
		PixelDataReader ME7BYUal = pdFact.newReader(cSlbdCEB, kumQhZdx, NAQuRrAL.getDcmDecodeParam().byteOrder,
				NAQuRrAL.getReadVR());
		System.out.println("reading " + Y6d45C2J + "...");
		ME7BYUal.readPixelData(false);
		ImageOutputStream DRKKoQi5 = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(z6acxqsu)));
		DcmEncodeParam GhhFZXYf = DcmEncodeParam.IVR_LE;
		cSlbdCEB.writeDataset(DRKKoQi5, GhhFZXYf);
		cSlbdCEB.writeHeader(DRKKoQi5, GhhFZXYf, Tags.PixelData, NAQuRrAL.getReadVR(), NAQuRrAL.getReadLength());
		System.out.println("writing " + z6acxqsu + "...");
		PixelDataWriter CJu4grW2 = pdFact.newWriter(ME7BYUal.getPixelDataArray(), false, cSlbdCEB, DRKKoQi5,
				NAQuRrAL.getDcmDecodeParam().byteOrder, NAQuRrAL.getReadVR());
		CJu4grW2.writePixelData();
		DRKKoQi5.flush();
		DRKKoQi5.close();
		System.out.println("done!");
	}

}