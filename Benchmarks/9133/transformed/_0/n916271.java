class n916271 {
	private static void readAndRewrite(File DqeJ5jYx, File bqGU0DRE) throws IOException {
		ImageInputStream Jsh7BjRL = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(DqeJ5jYx)));
		DcmParser cIbOT0Uq = DcmParserFactory.getInstance().newDcmParser(Jsh7BjRL);
		Dataset m2gW8kjW = DcmObjectFactory.getInstance().newDataset();
		cIbOT0Uq.setDcmHandler(m2gW8kjW.getDcmHandler());
		cIbOT0Uq.parseDcmFile(null, Tags.PixelData);
		PixelDataReader To8T8SR1 = pdFact.newReader(m2gW8kjW, Jsh7BjRL, cIbOT0Uq.getDcmDecodeParam().byteOrder,
				cIbOT0Uq.getReadVR());
		System.out.println("reading " + DqeJ5jYx + "...");
		To8T8SR1.readPixelData(false);
		ImageOutputStream SSKiNoBJ = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(bqGU0DRE)));
		DcmEncodeParam bdBKVoH8 = DcmEncodeParam.IVR_LE;
		m2gW8kjW.writeDataset(SSKiNoBJ, bdBKVoH8);
		m2gW8kjW.writeHeader(SSKiNoBJ, bdBKVoH8, Tags.PixelData, cIbOT0Uq.getReadVR(), cIbOT0Uq.getReadLength());
		System.out.println("writing " + bqGU0DRE + "...");
		PixelDataWriter Kw3TA2Oo = pdFact.newWriter(To8T8SR1.getPixelDataArray(), false, m2gW8kjW, SSKiNoBJ,
				cIbOT0Uq.getDcmDecodeParam().byteOrder, cIbOT0Uq.getReadVR());
		Kw3TA2Oo.writePixelData();
		SSKiNoBJ.flush();
		SSKiNoBJ.close();
		System.out.println("done!");
	}

}