class n811157 {
	private static void readAndRewrite(File pvGpoGWr, File B39QCpu2) throws IOException {
		ImageInputStream Q2Pu2oDE = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(pvGpoGWr)));
		DcmParser dTrA8Lvg = DcmParserFactory.getInstance().newDcmParser(Q2Pu2oDE);
		Dataset ySK3P5B9 = DcmObjectFactory.getInstance().newDataset();
		dTrA8Lvg.setDcmHandler(ySK3P5B9.getDcmHandler());
		dTrA8Lvg.parseDcmFile(null, Tags.PixelData);
		PixelDataReader ScQd50rB = pdFact.newReader(ySK3P5B9, Q2Pu2oDE, dTrA8Lvg.getDcmDecodeParam().byteOrder,
				dTrA8Lvg.getReadVR());
		System.out.println("reading " + pvGpoGWr + "...");
		ScQd50rB.readPixelData(false);
		ImageOutputStream iMvTCXVp = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(B39QCpu2)));
		DcmEncodeParam U6cr61z1 = DcmEncodeParam.IVR_LE;
		ySK3P5B9.writeDataset(iMvTCXVp, U6cr61z1);
		ySK3P5B9.writeHeader(iMvTCXVp, U6cr61z1, Tags.PixelData, dTrA8Lvg.getReadVR(), dTrA8Lvg.getReadLength());
		System.out.println("writing " + B39QCpu2 + "...");
		PixelDataWriter IfyHBy6Y = pdFact.newWriter(ScQd50rB.getPixelDataArray(), false, ySK3P5B9, iMvTCXVp,
				dTrA8Lvg.getDcmDecodeParam().byteOrder, dTrA8Lvg.getReadVR());
		IfyHBy6Y.writePixelData();
		iMvTCXVp.flush();
		iMvTCXVp.close();
		System.out.println("done!");
	}

}