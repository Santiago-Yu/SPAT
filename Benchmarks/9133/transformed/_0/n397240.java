class n397240 {
	private static void readAndRewrite(File NWzswWYZ, File IPiJjJQv) throws IOException {
		ImageInputStream ZY1hYBhd = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(NWzswWYZ)));
		DcmParser s6RPzHfc = DcmParserFactory.getInstance().newDcmParser(ZY1hYBhd);
		Dataset jW3mMyRx = DcmObjectFactory.getInstance().newDataset();
		s6RPzHfc.setDcmHandler(jW3mMyRx.getDcmHandler());
		s6RPzHfc.parseDcmFile(null, Tags.PixelData);
		PixelDataReader qOYKmPSn = pdFact.newReader(jW3mMyRx, ZY1hYBhd, s6RPzHfc.getDcmDecodeParam().byteOrder,
				s6RPzHfc.getReadVR());
		System.out.println("reading " + NWzswWYZ + "...");
		qOYKmPSn.readPixelData(false);
		ImageOutputStream K7vm8zk1 = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(IPiJjJQv)));
		DcmEncodeParam qlYNxavP = DcmEncodeParam.IVR_LE;
		jW3mMyRx.writeDataset(K7vm8zk1, qlYNxavP);
		jW3mMyRx.writeHeader(K7vm8zk1, qlYNxavP, Tags.PixelData, s6RPzHfc.getReadVR(), s6RPzHfc.getReadLength());
		System.out.println("writing " + IPiJjJQv + "...");
		PixelDataWriter wUCRjIr8 = pdFact.newWriter(qOYKmPSn.getPixelDataArray(), false, jW3mMyRx, K7vm8zk1,
				s6RPzHfc.getDcmDecodeParam().byteOrder, s6RPzHfc.getReadVR());
		wUCRjIr8.writePixelData();
		K7vm8zk1.flush();
		K7vm8zk1.close();
		System.out.println("done!");
	}

}