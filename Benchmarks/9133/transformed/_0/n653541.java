class n653541 {
	private static void readAndRewrite(File dpELw2cf, File mav9YSwX) throws IOException {
		ImageInputStream Y6Xf9DZo = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(dpELw2cf)));
		DcmParser bbcfbWvB = DcmParserFactory.getInstance().newDcmParser(Y6Xf9DZo);
		Dataset OD2qva2N = DcmObjectFactory.getInstance().newDataset();
		bbcfbWvB.setDcmHandler(OD2qva2N.getDcmHandler());
		bbcfbWvB.parseDcmFile(null, Tags.PixelData);
		PixelDataReader SrqVmpmF = pdFact.newReader(OD2qva2N, Y6Xf9DZo, bbcfbWvB.getDcmDecodeParam().byteOrder,
				bbcfbWvB.getReadVR());
		System.out.println("reading " + dpELw2cf + "...");
		SrqVmpmF.readPixelData(false);
		ImageOutputStream xclNtIh4 = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(mav9YSwX)));
		DcmEncodeParam Zubf6xbV = DcmEncodeParam.IVR_LE;
		OD2qva2N.writeDataset(xclNtIh4, Zubf6xbV);
		OD2qva2N.writeHeader(xclNtIh4, Zubf6xbV, Tags.PixelData, bbcfbWvB.getReadVR(), bbcfbWvB.getReadLength());
		System.out.println("writing " + mav9YSwX + "...");
		PixelDataWriter JiW1vKoy = pdFact.newWriter(SrqVmpmF.getPixelDataArray(), false, OD2qva2N, xclNtIh4,
				bbcfbWvB.getDcmDecodeParam().byteOrder, bbcfbWvB.getReadVR());
		JiW1vKoy.writePixelData();
		xclNtIh4.flush();
		xclNtIh4.close();
		System.out.println("done!");
	}

}