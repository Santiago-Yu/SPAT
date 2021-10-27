class n597134 {
	private static void readAndRewrite(File APs6nSvJ, File ItrswkhH) throws IOException {
		ImageInputStream UMMo5pa1 = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(APs6nSvJ)));
		DcmParser RnYaIPF7 = DcmParserFactory.getInstance().newDcmParser(UMMo5pa1);
		Dataset MtPj7RjU = DcmObjectFactory.getInstance().newDataset();
		RnYaIPF7.setDcmHandler(MtPj7RjU.getDcmHandler());
		RnYaIPF7.parseDcmFile(null, Tags.PixelData);
		PixelDataReader dRagkX8D = pdFact.newReader(MtPj7RjU, UMMo5pa1, RnYaIPF7.getDcmDecodeParam().byteOrder,
				RnYaIPF7.getReadVR());
		System.out.println("reading " + APs6nSvJ + "...");
		dRagkX8D.readPixelData(false);
		ImageOutputStream SGxK6p9J = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(ItrswkhH)));
		DcmEncodeParam eT9MfBLc = DcmEncodeParam.IVR_LE;
		MtPj7RjU.writeDataset(SGxK6p9J, eT9MfBLc);
		MtPj7RjU.writeHeader(SGxK6p9J, eT9MfBLc, Tags.PixelData, RnYaIPF7.getReadVR(), RnYaIPF7.getReadLength());
		System.out.println("writing " + ItrswkhH + "...");
		PixelDataWriter du6Y4wby = pdFact.newWriter(dRagkX8D.getPixelDataArray(), false, MtPj7RjU, SGxK6p9J,
				RnYaIPF7.getDcmDecodeParam().byteOrder, RnYaIPF7.getReadVR());
		du6Y4wby.writePixelData();
		SGxK6p9J.flush();
		SGxK6p9J.close();
		System.out.println("done!");
	}

}