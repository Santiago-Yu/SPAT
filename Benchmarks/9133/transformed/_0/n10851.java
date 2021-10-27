class n10851 {
	private static void readAndRewrite(File tYfSUsVc, File tyoHRllI) throws IOException {
		ImageInputStream szYmooJk = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(tYfSUsVc)));
		DcmParser zPmlAUdR = DcmParserFactory.getInstance().newDcmParser(szYmooJk);
		Dataset XLOEWXqP = DcmObjectFactory.getInstance().newDataset();
		zPmlAUdR.setDcmHandler(XLOEWXqP.getDcmHandler());
		zPmlAUdR.parseDcmFile(null, Tags.PixelData);
		PixelDataReader hJ1OnfgW = pdFact.newReader(XLOEWXqP, szYmooJk, zPmlAUdR.getDcmDecodeParam().byteOrder,
				zPmlAUdR.getReadVR());
		System.out.println("reading " + tYfSUsVc + "...");
		hJ1OnfgW.readPixelData(false);
		ImageOutputStream YaAWBeGq = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(tyoHRllI)));
		DcmEncodeParam KnpBW4fA = DcmEncodeParam.IVR_LE;
		XLOEWXqP.writeDataset(YaAWBeGq, KnpBW4fA);
		XLOEWXqP.writeHeader(YaAWBeGq, KnpBW4fA, Tags.PixelData, zPmlAUdR.getReadVR(), zPmlAUdR.getReadLength());
		System.out.println("writing " + tyoHRllI + "...");
		PixelDataWriter tJeDLlF1 = pdFact.newWriter(hJ1OnfgW.getPixelDataArray(), false, XLOEWXqP, YaAWBeGq,
				zPmlAUdR.getDcmDecodeParam().byteOrder, zPmlAUdR.getReadVR());
		tJeDLlF1.writePixelData();
		YaAWBeGq.flush();
		YaAWBeGq.close();
		System.out.println("done!");
	}

}