class n792644 {
	private static void readAndRewrite(File eiX4YJd9, File uoPmaEfO) throws IOException {
		ImageInputStream ClF6By0F = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(eiX4YJd9)));
		DcmParser NKRf7dgw = DcmParserFactory.getInstance().newDcmParser(ClF6By0F);
		Dataset x6TcF2XM = DcmObjectFactory.getInstance().newDataset();
		NKRf7dgw.setDcmHandler(x6TcF2XM.getDcmHandler());
		NKRf7dgw.parseDcmFile(null, Tags.PixelData);
		PixelDataReader u6GLPsMZ = pdFact.newReader(x6TcF2XM, ClF6By0F, NKRf7dgw.getDcmDecodeParam().byteOrder,
				NKRf7dgw.getReadVR());
		System.out.println("reading " + eiX4YJd9 + "...");
		u6GLPsMZ.readPixelData(false);
		ImageOutputStream sYs5N94F = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(uoPmaEfO)));
		DcmEncodeParam nXz6eTmz = DcmEncodeParam.IVR_LE;
		x6TcF2XM.writeDataset(sYs5N94F, nXz6eTmz);
		x6TcF2XM.writeHeader(sYs5N94F, nXz6eTmz, Tags.PixelData, NKRf7dgw.getReadVR(), NKRf7dgw.getReadLength());
		System.out.println("writing " + uoPmaEfO + "...");
		PixelDataWriter zgF8TCD3 = pdFact.newWriter(u6GLPsMZ.getPixelDataArray(), false, x6TcF2XM, sYs5N94F,
				NKRf7dgw.getDcmDecodeParam().byteOrder, NKRf7dgw.getReadVR());
		zgF8TCD3.writePixelData();
		sYs5N94F.flush();
		sYs5N94F.close();
		System.out.println("done!");
	}

}