class n258490 {
	private static void readAndRewrite(File U6j0FIr8, File IE213Wwv) throws IOException {
		ImageInputStream gTHcYdas = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(U6j0FIr8)));
		DcmParser yKo9K6r7 = DcmParserFactory.getInstance().newDcmParser(gTHcYdas);
		Dataset DNPQPjbs = DcmObjectFactory.getInstance().newDataset();
		yKo9K6r7.setDcmHandler(DNPQPjbs.getDcmHandler());
		yKo9K6r7.parseDcmFile(null, Tags.PixelData);
		PixelDataReader K0MuNAC3 = pdFact.newReader(DNPQPjbs, gTHcYdas, yKo9K6r7.getDcmDecodeParam().byteOrder,
				yKo9K6r7.getReadVR());
		System.out.println("reading " + U6j0FIr8 + "...");
		K0MuNAC3.readPixelData(false);
		ImageOutputStream PP8DR5OV = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(IE213Wwv)));
		DcmEncodeParam XIArsnjT = DcmEncodeParam.IVR_LE;
		DNPQPjbs.writeDataset(PP8DR5OV, XIArsnjT);
		DNPQPjbs.writeHeader(PP8DR5OV, XIArsnjT, Tags.PixelData, yKo9K6r7.getReadVR(), yKo9K6r7.getReadLength());
		System.out.println("writing " + IE213Wwv + "...");
		PixelDataWriter l7KC4Ndb = pdFact.newWriter(K0MuNAC3.getPixelDataArray(), false, DNPQPjbs, PP8DR5OV,
				yKo9K6r7.getDcmDecodeParam().byteOrder, yKo9K6r7.getReadVR());
		l7KC4Ndb.writePixelData();
		PP8DR5OV.flush();
		PP8DR5OV.close();
		System.out.println("done!");
	}

}