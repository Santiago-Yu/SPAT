class n130757 {
	private static void readAndRewrite(File f7aZk08k, File RG8QPBQo) throws IOException {
		ImageInputStream YE4UCKAp = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(f7aZk08k)));
		DcmParser hh42CxWb = DcmParserFactory.getInstance().newDcmParser(YE4UCKAp);
		Dataset iFAN4HUN = DcmObjectFactory.getInstance().newDataset();
		hh42CxWb.setDcmHandler(iFAN4HUN.getDcmHandler());
		hh42CxWb.parseDcmFile(null, Tags.PixelData);
		PixelDataReader zzHhuZNS = pdFact.newReader(iFAN4HUN, YE4UCKAp, hh42CxWb.getDcmDecodeParam().byteOrder,
				hh42CxWb.getReadVR());
		System.out.println("reading " + f7aZk08k + "...");
		zzHhuZNS.readPixelData(false);
		ImageOutputStream XH2HAgfO = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(RG8QPBQo)));
		DcmEncodeParam AMJZeA8q = DcmEncodeParam.IVR_LE;
		iFAN4HUN.writeDataset(XH2HAgfO, AMJZeA8q);
		iFAN4HUN.writeHeader(XH2HAgfO, AMJZeA8q, Tags.PixelData, hh42CxWb.getReadVR(), hh42CxWb.getReadLength());
		System.out.println("writing " + RG8QPBQo + "...");
		PixelDataWriter K3KETjle = pdFact.newWriter(zzHhuZNS.getPixelDataArray(), false, iFAN4HUN, XH2HAgfO,
				hh42CxWb.getDcmDecodeParam().byteOrder, hh42CxWb.getReadVR());
		K3KETjle.writePixelData();
		XH2HAgfO.flush();
		XH2HAgfO.close();
		System.out.println("done!");
	}

}