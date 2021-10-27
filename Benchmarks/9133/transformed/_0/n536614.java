class n536614 {
	private static void readAndRewrite(File REEKeW4o, File VTibIXvk) throws IOException {
		ImageInputStream fEbdd9S1 = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(REEKeW4o)));
		DcmParser nrUNA3Bp = DcmParserFactory.getInstance().newDcmParser(fEbdd9S1);
		Dataset RkF4EohB = DcmObjectFactory.getInstance().newDataset();
		nrUNA3Bp.setDcmHandler(RkF4EohB.getDcmHandler());
		nrUNA3Bp.parseDcmFile(null, Tags.PixelData);
		PixelDataReader DzmmJJf6 = pdFact.newReader(RkF4EohB, fEbdd9S1, nrUNA3Bp.getDcmDecodeParam().byteOrder,
				nrUNA3Bp.getReadVR());
		System.out.println("reading " + REEKeW4o + "...");
		DzmmJJf6.readPixelData(false);
		ImageOutputStream OeAQQdV9 = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(VTibIXvk)));
		DcmEncodeParam Z2t8u9mt = DcmEncodeParam.IVR_LE;
		RkF4EohB.writeDataset(OeAQQdV9, Z2t8u9mt);
		RkF4EohB.writeHeader(OeAQQdV9, Z2t8u9mt, Tags.PixelData, nrUNA3Bp.getReadVR(), nrUNA3Bp.getReadLength());
		System.out.println("writing " + VTibIXvk + "...");
		PixelDataWriter oSDh2FrF = pdFact.newWriter(DzmmJJf6.getPixelDataArray(), false, RkF4EohB, OeAQQdV9,
				nrUNA3Bp.getDcmDecodeParam().byteOrder, nrUNA3Bp.getReadVR());
		oSDh2FrF.writePixelData();
		OeAQQdV9.flush();
		OeAQQdV9.close();
		System.out.println("done!");
	}

}