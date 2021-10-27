class n567313 {
	private static void readAndRewrite(File czsdybNc, File ED32xzpN) throws IOException {
		ImageInputStream tWqJDG2z = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(czsdybNc)));
		DcmParser IGEDDvTi = DcmParserFactory.getInstance().newDcmParser(tWqJDG2z);
		Dataset duQFvEWs = DcmObjectFactory.getInstance().newDataset();
		IGEDDvTi.setDcmHandler(duQFvEWs.getDcmHandler());
		IGEDDvTi.parseDcmFile(null, Tags.PixelData);
		PixelDataReader TRc5hxoF = pdFact.newReader(duQFvEWs, tWqJDG2z, IGEDDvTi.getDcmDecodeParam().byteOrder,
				IGEDDvTi.getReadVR());
		System.out.println("reading " + czsdybNc + "...");
		TRc5hxoF.readPixelData(false);
		ImageOutputStream aNco85xP = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(ED32xzpN)));
		DcmEncodeParam LmGGeLo4 = DcmEncodeParam.IVR_LE;
		duQFvEWs.writeDataset(aNco85xP, LmGGeLo4);
		duQFvEWs.writeHeader(aNco85xP, LmGGeLo4, Tags.PixelData, IGEDDvTi.getReadVR(), IGEDDvTi.getReadLength());
		System.out.println("writing " + ED32xzpN + "...");
		PixelDataWriter YyXqvE1W = pdFact.newWriter(TRc5hxoF.getPixelDataArray(), false, duQFvEWs, aNco85xP,
				IGEDDvTi.getDcmDecodeParam().byteOrder, IGEDDvTi.getReadVR());
		YyXqvE1W.writePixelData();
		aNco85xP.flush();
		aNco85xP.close();
		System.out.println("done!");
	}

}