class n530882 {
	private static void readAndRewrite(File ieu3tpwI, File ySRUOGjs) throws IOException {
		ImageInputStream eXVLKYmf = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(ieu3tpwI)));
		DcmParser nYC6mUME = DcmParserFactory.getInstance().newDcmParser(eXVLKYmf);
		Dataset StLDEPPw = DcmObjectFactory.getInstance().newDataset();
		nYC6mUME.setDcmHandler(StLDEPPw.getDcmHandler());
		nYC6mUME.parseDcmFile(null, Tags.PixelData);
		PixelDataReader MKDHyfJU = pdFact.newReader(StLDEPPw, eXVLKYmf, nYC6mUME.getDcmDecodeParam().byteOrder,
				nYC6mUME.getReadVR());
		System.out.println("reading " + ieu3tpwI + "...");
		MKDHyfJU.readPixelData(false);
		ImageOutputStream lhb5TSod = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(ySRUOGjs)));
		DcmEncodeParam iDEIG30h = DcmEncodeParam.IVR_LE;
		StLDEPPw.writeDataset(lhb5TSod, iDEIG30h);
		StLDEPPw.writeHeader(lhb5TSod, iDEIG30h, Tags.PixelData, nYC6mUME.getReadVR(), nYC6mUME.getReadLength());
		System.out.println("writing " + ySRUOGjs + "...");
		PixelDataWriter NuQPglTm = pdFact.newWriter(MKDHyfJU.getPixelDataArray(), false, StLDEPPw, lhb5TSod,
				nYC6mUME.getDcmDecodeParam().byteOrder, nYC6mUME.getReadVR());
		NuQPglTm.writePixelData();
		lhb5TSod.flush();
		lhb5TSod.close();
		System.out.println("done!");
	}

}