class n621362 {
	private static void readAndRewrite(File oo1UcLm0, File uVflLriB) throws IOException {
		ImageInputStream EIKrt4FA = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(oo1UcLm0)));
		DcmParser TIDYYrVG = DcmParserFactory.getInstance().newDcmParser(EIKrt4FA);
		Dataset jEAesWvO = DcmObjectFactory.getInstance().newDataset();
		TIDYYrVG.setDcmHandler(jEAesWvO.getDcmHandler());
		TIDYYrVG.parseDcmFile(null, Tags.PixelData);
		PixelDataReader bVmtng2d = pdFact.newReader(jEAesWvO, EIKrt4FA, TIDYYrVG.getDcmDecodeParam().byteOrder,
				TIDYYrVG.getReadVR());
		System.out.println("reading " + oo1UcLm0 + "...");
		bVmtng2d.readPixelData(false);
		ImageOutputStream gpwih7a6 = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(uVflLriB)));
		DcmEncodeParam bB3vSkOH = DcmEncodeParam.IVR_LE;
		jEAesWvO.writeDataset(gpwih7a6, bB3vSkOH);
		jEAesWvO.writeHeader(gpwih7a6, bB3vSkOH, Tags.PixelData, TIDYYrVG.getReadVR(), TIDYYrVG.getReadLength());
		System.out.println("writing " + uVflLriB + "...");
		PixelDataWriter azNBht9D = pdFact.newWriter(bVmtng2d.getPixelDataArray(), false, jEAesWvO, gpwih7a6,
				TIDYYrVG.getDcmDecodeParam().byteOrder, TIDYYrVG.getReadVR());
		azNBht9D.writePixelData();
		gpwih7a6.flush();
		gpwih7a6.close();
		System.out.println("done!");
	}

}