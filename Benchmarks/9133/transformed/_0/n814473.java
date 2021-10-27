class n814473 {
	private static void readAndRewrite(File PawfPGvH, File wqACU5NG) throws IOException {
		ImageInputStream hD4m8bgh = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(PawfPGvH)));
		DcmParser Lq0vYUek = DcmParserFactory.getInstance().newDcmParser(hD4m8bgh);
		Dataset dTplnBXy = DcmObjectFactory.getInstance().newDataset();
		Lq0vYUek.setDcmHandler(dTplnBXy.getDcmHandler());
		Lq0vYUek.parseDcmFile(null, Tags.PixelData);
		PixelDataReader jzeCrkJK = pdFact.newReader(dTplnBXy, hD4m8bgh, Lq0vYUek.getDcmDecodeParam().byteOrder,
				Lq0vYUek.getReadVR());
		System.out.println("reading " + PawfPGvH + "...");
		jzeCrkJK.readPixelData(false);
		ImageOutputStream zsMSM9JB = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(wqACU5NG)));
		DcmEncodeParam P7gTPLWq = DcmEncodeParam.IVR_LE;
		dTplnBXy.writeDataset(zsMSM9JB, P7gTPLWq);
		dTplnBXy.writeHeader(zsMSM9JB, P7gTPLWq, Tags.PixelData, Lq0vYUek.getReadVR(), Lq0vYUek.getReadLength());
		System.out.println("writing " + wqACU5NG + "...");
		PixelDataWriter iWtZgapY = pdFact.newWriter(jzeCrkJK.getPixelDataArray(), false, dTplnBXy, zsMSM9JB,
				Lq0vYUek.getDcmDecodeParam().byteOrder, Lq0vYUek.getReadVR());
		iWtZgapY.writePixelData();
		zsMSM9JB.flush();
		zsMSM9JB.close();
		System.out.println("done!");
	}

}