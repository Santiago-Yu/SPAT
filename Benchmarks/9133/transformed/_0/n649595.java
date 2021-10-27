class n649595 {
	private static void readAndRewrite(File ce0a2bHT, File qr2ykh02) throws IOException {
		ImageInputStream rfK53uk5 = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(ce0a2bHT)));
		DcmParser UM4J7vuM = DcmParserFactory.getInstance().newDcmParser(rfK53uk5);
		Dataset zhxYuiUy = DcmObjectFactory.getInstance().newDataset();
		UM4J7vuM.setDcmHandler(zhxYuiUy.getDcmHandler());
		UM4J7vuM.parseDcmFile(null, Tags.PixelData);
		PixelDataReader k8ruWXGy = pdFact.newReader(zhxYuiUy, rfK53uk5, UM4J7vuM.getDcmDecodeParam().byteOrder,
				UM4J7vuM.getReadVR());
		System.out.println("reading " + ce0a2bHT + "...");
		k8ruWXGy.readPixelData(false);
		ImageOutputStream VF3wLuHd = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(qr2ykh02)));
		DcmEncodeParam XuBhfy1m = DcmEncodeParam.IVR_LE;
		zhxYuiUy.writeDataset(VF3wLuHd, XuBhfy1m);
		zhxYuiUy.writeHeader(VF3wLuHd, XuBhfy1m, Tags.PixelData, UM4J7vuM.getReadVR(), UM4J7vuM.getReadLength());
		System.out.println("writing " + qr2ykh02 + "...");
		PixelDataWriter LFyQ3srI = pdFact.newWriter(k8ruWXGy.getPixelDataArray(), false, zhxYuiUy, VF3wLuHd,
				UM4J7vuM.getDcmDecodeParam().byteOrder, UM4J7vuM.getReadVR());
		LFyQ3srI.writePixelData();
		VF3wLuHd.flush();
		VF3wLuHd.close();
		System.out.println("done!");
	}

}