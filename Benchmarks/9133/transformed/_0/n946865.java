class n946865 {
	private static void readAndRewrite(File zcmB87CA, File WrTimyR1) throws IOException {
		ImageInputStream xNM2pDuy = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(zcmB87CA)));
		DcmParser BBSpZuoa = DcmParserFactory.getInstance().newDcmParser(xNM2pDuy);
		Dataset jnIg2zz7 = DcmObjectFactory.getInstance().newDataset();
		BBSpZuoa.setDcmHandler(jnIg2zz7.getDcmHandler());
		BBSpZuoa.parseDcmFile(null, Tags.PixelData);
		PixelDataReader kyks5zxy = pdFact.newReader(jnIg2zz7, xNM2pDuy, BBSpZuoa.getDcmDecodeParam().byteOrder,
				BBSpZuoa.getReadVR());
		System.out.println("reading " + zcmB87CA + "...");
		kyks5zxy.readPixelData(false);
		ImageOutputStream RWdn7irt = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(WrTimyR1)));
		DcmEncodeParam Ak5cm1FO = DcmEncodeParam.IVR_LE;
		jnIg2zz7.writeDataset(RWdn7irt, Ak5cm1FO);
		jnIg2zz7.writeHeader(RWdn7irt, Ak5cm1FO, Tags.PixelData, BBSpZuoa.getReadVR(), BBSpZuoa.getReadLength());
		System.out.println("writing " + WrTimyR1 + "...");
		PixelDataWriter D0uVOqrG = pdFact.newWriter(kyks5zxy.getPixelDataArray(), false, jnIg2zz7, RWdn7irt,
				BBSpZuoa.getDcmDecodeParam().byteOrder, BBSpZuoa.getReadVR());
		D0uVOqrG.writePixelData();
		RWdn7irt.flush();
		RWdn7irt.close();
		System.out.println("done!");
	}

}