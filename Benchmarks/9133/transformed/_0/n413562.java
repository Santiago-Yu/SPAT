class n413562 {
	private static void readAndRewrite(File kE4rNvc8, File Urh9x8D0) throws IOException {
		ImageInputStream ytlBv4VO = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(kE4rNvc8)));
		DcmParser rOMsYuyA = DcmParserFactory.getInstance().newDcmParser(ytlBv4VO);
		Dataset NFLnPM7Q = DcmObjectFactory.getInstance().newDataset();
		rOMsYuyA.setDcmHandler(NFLnPM7Q.getDcmHandler());
		rOMsYuyA.parseDcmFile(null, Tags.PixelData);
		PixelDataReader bcCLSaUT = pdFact.newReader(NFLnPM7Q, ytlBv4VO, rOMsYuyA.getDcmDecodeParam().byteOrder,
				rOMsYuyA.getReadVR());
		System.out.println("reading " + kE4rNvc8 + "...");
		bcCLSaUT.readPixelData(false);
		ImageOutputStream cPyPyEpa = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(Urh9x8D0)));
		DcmEncodeParam qwSYEDxV = DcmEncodeParam.IVR_LE;
		NFLnPM7Q.writeDataset(cPyPyEpa, qwSYEDxV);
		NFLnPM7Q.writeHeader(cPyPyEpa, qwSYEDxV, Tags.PixelData, rOMsYuyA.getReadVR(), rOMsYuyA.getReadLength());
		System.out.println("writing " + Urh9x8D0 + "...");
		PixelDataWriter jH162D4j = pdFact.newWriter(bcCLSaUT.getPixelDataArray(), false, NFLnPM7Q, cPyPyEpa,
				rOMsYuyA.getDcmDecodeParam().byteOrder, rOMsYuyA.getReadVR());
		jH162D4j.writePixelData();
		cPyPyEpa.flush();
		cPyPyEpa.close();
		System.out.println("done!");
	}

}