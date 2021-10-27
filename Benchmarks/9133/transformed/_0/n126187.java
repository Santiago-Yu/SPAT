class n126187 {
	private static void readAndRewrite(File RUORv2w6, File gR3WniaK) throws IOException {
		ImageInputStream XDm8R0ZD = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(RUORv2w6)));
		DcmParser g9ihqRRT = DcmParserFactory.getInstance().newDcmParser(XDm8R0ZD);
		Dataset C6YiaYWE = DcmObjectFactory.getInstance().newDataset();
		g9ihqRRT.setDcmHandler(C6YiaYWE.getDcmHandler());
		g9ihqRRT.parseDcmFile(null, Tags.PixelData);
		PixelDataReader Jn6SEJj1 = pdFact.newReader(C6YiaYWE, XDm8R0ZD, g9ihqRRT.getDcmDecodeParam().byteOrder,
				g9ihqRRT.getReadVR());
		System.out.println("reading " + RUORv2w6 + "...");
		Jn6SEJj1.readPixelData(false);
		ImageOutputStream sL9awLXs = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(gR3WniaK)));
		DcmEncodeParam zNHs4Lex = DcmEncodeParam.IVR_LE;
		C6YiaYWE.writeDataset(sL9awLXs, zNHs4Lex);
		C6YiaYWE.writeHeader(sL9awLXs, zNHs4Lex, Tags.PixelData, g9ihqRRT.getReadVR(), g9ihqRRT.getReadLength());
		System.out.println("writing " + gR3WniaK + "...");
		PixelDataWriter hYvdn3x2 = pdFact.newWriter(Jn6SEJj1.getPixelDataArray(), false, C6YiaYWE, sL9awLXs,
				g9ihqRRT.getDcmDecodeParam().byteOrder, g9ihqRRT.getReadVR());
		hYvdn3x2.writePixelData();
		sL9awLXs.flush();
		sL9awLXs.close();
		System.out.println("done!");
	}

}