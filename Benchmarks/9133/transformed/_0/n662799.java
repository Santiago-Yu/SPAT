class n662799 {
	private static void readAndRewrite(File oax5yHzs, File fiies1Jh) throws IOException {
		ImageInputStream E7HjcbJt = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(oax5yHzs)));
		DcmParser PbFXQKvD = DcmParserFactory.getInstance().newDcmParser(E7HjcbJt);
		Dataset CywDl6wS = DcmObjectFactory.getInstance().newDataset();
		PbFXQKvD.setDcmHandler(CywDl6wS.getDcmHandler());
		PbFXQKvD.parseDcmFile(null, Tags.PixelData);
		PixelDataReader YqFubL4m = pdFact.newReader(CywDl6wS, E7HjcbJt, PbFXQKvD.getDcmDecodeParam().byteOrder,
				PbFXQKvD.getReadVR());
		System.out.println("reading " + oax5yHzs + "...");
		YqFubL4m.readPixelData(false);
		ImageOutputStream k0i2J3v7 = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(fiies1Jh)));
		DcmEncodeParam qJicCsMy = DcmEncodeParam.IVR_LE;
		CywDl6wS.writeDataset(k0i2J3v7, qJicCsMy);
		CywDl6wS.writeHeader(k0i2J3v7, qJicCsMy, Tags.PixelData, PbFXQKvD.getReadVR(), PbFXQKvD.getReadLength());
		System.out.println("writing " + fiies1Jh + "...");
		PixelDataWriter kPS15om6 = pdFact.newWriter(YqFubL4m.getPixelDataArray(), false, CywDl6wS, k0i2J3v7,
				PbFXQKvD.getDcmDecodeParam().byteOrder, PbFXQKvD.getReadVR());
		kPS15om6.writePixelData();
		k0i2J3v7.flush();
		k0i2J3v7.close();
		System.out.println("done!");
	}

}