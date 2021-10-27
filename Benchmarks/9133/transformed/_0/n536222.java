class n536222 {
	private static void readAndRewrite(File fvp29qMw, File qGzRkwv0) throws IOException {
		ImageInputStream HaWoRaeN = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(fvp29qMw)));
		DcmParser dnQ3c4Ni = DcmParserFactory.getInstance().newDcmParser(HaWoRaeN);
		Dataset pn2Ljohh = DcmObjectFactory.getInstance().newDataset();
		dnQ3c4Ni.setDcmHandler(pn2Ljohh.getDcmHandler());
		dnQ3c4Ni.parseDcmFile(null, Tags.PixelData);
		PixelDataReader NTdJHhY7 = pdFact.newReader(pn2Ljohh, HaWoRaeN, dnQ3c4Ni.getDcmDecodeParam().byteOrder,
				dnQ3c4Ni.getReadVR());
		System.out.println("reading " + fvp29qMw + "...");
		NTdJHhY7.readPixelData(false);
		ImageOutputStream yc0Qjuof = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(qGzRkwv0)));
		DcmEncodeParam Q14sK9xo = DcmEncodeParam.IVR_LE;
		pn2Ljohh.writeDataset(yc0Qjuof, Q14sK9xo);
		pn2Ljohh.writeHeader(yc0Qjuof, Q14sK9xo, Tags.PixelData, dnQ3c4Ni.getReadVR(), dnQ3c4Ni.getReadLength());
		System.out.println("writing " + qGzRkwv0 + "...");
		PixelDataWriter SFHTuG7g = pdFact.newWriter(NTdJHhY7.getPixelDataArray(), false, pn2Ljohh, yc0Qjuof,
				dnQ3c4Ni.getDcmDecodeParam().byteOrder, dnQ3c4Ni.getReadVR());
		SFHTuG7g.writePixelData();
		yc0Qjuof.flush();
		yc0Qjuof.close();
		System.out.println("done!");
	}

}