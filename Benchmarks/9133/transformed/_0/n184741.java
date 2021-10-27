class n184741 {
	private static void readAndRewrite(File XUMjQ1Za, File FzQDy44r) throws IOException {
		ImageInputStream I4NjOqQE = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(XUMjQ1Za)));
		DcmParser D9J33Lx5 = DcmParserFactory.getInstance().newDcmParser(I4NjOqQE);
		Dataset H8gcCazV = DcmObjectFactory.getInstance().newDataset();
		D9J33Lx5.setDcmHandler(H8gcCazV.getDcmHandler());
		D9J33Lx5.parseDcmFile(null, Tags.PixelData);
		PixelDataReader clKf7uWt = pdFact.newReader(H8gcCazV, I4NjOqQE, D9J33Lx5.getDcmDecodeParam().byteOrder,
				D9J33Lx5.getReadVR());
		System.out.println("reading " + XUMjQ1Za + "...");
		clKf7uWt.readPixelData(false);
		ImageOutputStream wBQRM6UB = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(FzQDy44r)));
		DcmEncodeParam QqC8lVM3 = DcmEncodeParam.IVR_LE;
		H8gcCazV.writeDataset(wBQRM6UB, QqC8lVM3);
		H8gcCazV.writeHeader(wBQRM6UB, QqC8lVM3, Tags.PixelData, D9J33Lx5.getReadVR(), D9J33Lx5.getReadLength());
		System.out.println("writing " + FzQDy44r + "...");
		PixelDataWriter EmWEJZRM = pdFact.newWriter(clKf7uWt.getPixelDataArray(), false, H8gcCazV, wBQRM6UB,
				D9J33Lx5.getDcmDecodeParam().byteOrder, D9J33Lx5.getReadVR());
		EmWEJZRM.writePixelData();
		wBQRM6UB.flush();
		wBQRM6UB.close();
		System.out.println("done!");
	}

}