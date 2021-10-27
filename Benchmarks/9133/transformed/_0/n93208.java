class n93208 {
	private static void readAndRewrite(File ynaIpJP6, File BprrMAvT) throws IOException {
		ImageInputStream QBUpOBHO = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(ynaIpJP6)));
		DcmParser ZQaTdDR0 = DcmParserFactory.getInstance().newDcmParser(QBUpOBHO);
		Dataset nC8H5yjR = DcmObjectFactory.getInstance().newDataset();
		ZQaTdDR0.setDcmHandler(nC8H5yjR.getDcmHandler());
		ZQaTdDR0.parseDcmFile(null, Tags.PixelData);
		PixelDataReader nrs1DA2p = pdFact.newReader(nC8H5yjR, QBUpOBHO, ZQaTdDR0.getDcmDecodeParam().byteOrder,
				ZQaTdDR0.getReadVR());
		System.out.println("reading " + ynaIpJP6 + "...");
		nrs1DA2p.readPixelData(false);
		ImageOutputStream kpQkzvBq = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(BprrMAvT)));
		DcmEncodeParam Hn9ucWuW = DcmEncodeParam.IVR_LE;
		nC8H5yjR.writeDataset(kpQkzvBq, Hn9ucWuW);
		nC8H5yjR.writeHeader(kpQkzvBq, Hn9ucWuW, Tags.PixelData, ZQaTdDR0.getReadVR(), ZQaTdDR0.getReadLength());
		System.out.println("writing " + BprrMAvT + "...");
		PixelDataWriter JR2Nsin8 = pdFact.newWriter(nrs1DA2p.getPixelDataArray(), false, nC8H5yjR, kpQkzvBq,
				ZQaTdDR0.getDcmDecodeParam().byteOrder, ZQaTdDR0.getReadVR());
		JR2Nsin8.writePixelData();
		kpQkzvBq.flush();
		kpQkzvBq.close();
		System.out.println("done!");
	}

}