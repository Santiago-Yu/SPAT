class n777609 {
	private static void readAndRewrite(File AXCTgXY0, File OeBP9iPj) throws IOException {
		ImageInputStream Gkdlwdve = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(AXCTgXY0)));
		DcmParser qzPsWyOU = DcmParserFactory.getInstance().newDcmParser(Gkdlwdve);
		Dataset dIuFfImb = DcmObjectFactory.getInstance().newDataset();
		qzPsWyOU.setDcmHandler(dIuFfImb.getDcmHandler());
		qzPsWyOU.parseDcmFile(null, Tags.PixelData);
		PixelDataReader LIlEv8ky = pdFact.newReader(dIuFfImb, Gkdlwdve, qzPsWyOU.getDcmDecodeParam().byteOrder,
				qzPsWyOU.getReadVR());
		System.out.println("reading " + AXCTgXY0 + "...");
		LIlEv8ky.readPixelData(false);
		ImageOutputStream SAokixXR = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(OeBP9iPj)));
		DcmEncodeParam PuAegU2g = DcmEncodeParam.IVR_LE;
		dIuFfImb.writeDataset(SAokixXR, PuAegU2g);
		dIuFfImb.writeHeader(SAokixXR, PuAegU2g, Tags.PixelData, qzPsWyOU.getReadVR(), qzPsWyOU.getReadLength());
		System.out.println("writing " + OeBP9iPj + "...");
		PixelDataWriter M9pScFvJ = pdFact.newWriter(LIlEv8ky.getPixelDataArray(), false, dIuFfImb, SAokixXR,
				qzPsWyOU.getDcmDecodeParam().byteOrder, qzPsWyOU.getReadVR());
		M9pScFvJ.writePixelData();
		SAokixXR.flush();
		SAokixXR.close();
		System.out.println("done!");
	}

}