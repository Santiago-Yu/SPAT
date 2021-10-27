class n228925 {
	private static void readAndRewrite(File rKyz67EL, File fIlHDK4y) throws IOException {
		ImageInputStream AZxQ2xQr = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(rKyz67EL)));
		DcmParser tzC9Y7o9 = DcmParserFactory.getInstance().newDcmParser(AZxQ2xQr);
		Dataset srtgcu0x = DcmObjectFactory.getInstance().newDataset();
		tzC9Y7o9.setDcmHandler(srtgcu0x.getDcmHandler());
		tzC9Y7o9.parseDcmFile(null, Tags.PixelData);
		PixelDataReader o9CeJaTP = pdFact.newReader(srtgcu0x, AZxQ2xQr, tzC9Y7o9.getDcmDecodeParam().byteOrder,
				tzC9Y7o9.getReadVR());
		System.out.println("reading " + rKyz67EL + "...");
		o9CeJaTP.readPixelData(false);
		ImageOutputStream P79erHvl = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(fIlHDK4y)));
		DcmEncodeParam otKb8fED = DcmEncodeParam.IVR_LE;
		srtgcu0x.writeDataset(P79erHvl, otKb8fED);
		srtgcu0x.writeHeader(P79erHvl, otKb8fED, Tags.PixelData, tzC9Y7o9.getReadVR(), tzC9Y7o9.getReadLength());
		System.out.println("writing " + fIlHDK4y + "...");
		PixelDataWriter CxoADJhW = pdFact.newWriter(o9CeJaTP.getPixelDataArray(), false, srtgcu0x, P79erHvl,
				tzC9Y7o9.getDcmDecodeParam().byteOrder, tzC9Y7o9.getReadVR());
		CxoADJhW.writePixelData();
		P79erHvl.flush();
		P79erHvl.close();
		System.out.println("done!");
	}

}