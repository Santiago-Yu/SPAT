class n804637 {
	private static void readAndRewrite(File aoqtBnsO, File VGJPL1lj) throws IOException {
		ImageInputStream d6tLpm6u = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(aoqtBnsO)));
		DcmParser dyeo4vWv = DcmParserFactory.getInstance().newDcmParser(d6tLpm6u);
		Dataset kFIsV0h2 = DcmObjectFactory.getInstance().newDataset();
		dyeo4vWv.setDcmHandler(kFIsV0h2.getDcmHandler());
		dyeo4vWv.parseDcmFile(null, Tags.PixelData);
		PixelDataReader ILRFh0G0 = pdFact.newReader(kFIsV0h2, d6tLpm6u, dyeo4vWv.getDcmDecodeParam().byteOrder,
				dyeo4vWv.getReadVR());
		System.out.println("reading " + aoqtBnsO + "...");
		ILRFh0G0.readPixelData(false);
		ImageOutputStream D1PD9um8 = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(VGJPL1lj)));
		DcmEncodeParam pb5y3DpM = DcmEncodeParam.IVR_LE;
		kFIsV0h2.writeDataset(D1PD9um8, pb5y3DpM);
		kFIsV0h2.writeHeader(D1PD9um8, pb5y3DpM, Tags.PixelData, dyeo4vWv.getReadVR(), dyeo4vWv.getReadLength());
		System.out.println("writing " + VGJPL1lj + "...");
		PixelDataWriter YZpGpeub = pdFact.newWriter(ILRFh0G0.getPixelDataArray(), false, kFIsV0h2, D1PD9um8,
				dyeo4vWv.getDcmDecodeParam().byteOrder, dyeo4vWv.getReadVR());
		YZpGpeub.writePixelData();
		D1PD9um8.flush();
		D1PD9um8.close();
		System.out.println("done!");
	}

}