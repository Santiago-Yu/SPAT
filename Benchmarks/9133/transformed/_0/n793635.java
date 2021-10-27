class n793635 {
	private static void readAndRewrite(File BVWKE3sG, File HGofy4Mu) throws IOException {
		ImageInputStream Pc7XQVs4 = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(BVWKE3sG)));
		DcmParser JlFpIEiL = DcmParserFactory.getInstance().newDcmParser(Pc7XQVs4);
		Dataset lElbCVk9 = DcmObjectFactory.getInstance().newDataset();
		JlFpIEiL.setDcmHandler(lElbCVk9.getDcmHandler());
		JlFpIEiL.parseDcmFile(null, Tags.PixelData);
		PixelDataReader lim6pnwx = pdFact.newReader(lElbCVk9, Pc7XQVs4, JlFpIEiL.getDcmDecodeParam().byteOrder,
				JlFpIEiL.getReadVR());
		System.out.println("reading " + BVWKE3sG + "...");
		lim6pnwx.readPixelData(false);
		ImageOutputStream nKEch2ys = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(HGofy4Mu)));
		DcmEncodeParam YNnX1EeH = DcmEncodeParam.IVR_LE;
		lElbCVk9.writeDataset(nKEch2ys, YNnX1EeH);
		lElbCVk9.writeHeader(nKEch2ys, YNnX1EeH, Tags.PixelData, JlFpIEiL.getReadVR(), JlFpIEiL.getReadLength());
		System.out.println("writing " + HGofy4Mu + "...");
		PixelDataWriter ugXHMSxZ = pdFact.newWriter(lim6pnwx.getPixelDataArray(), false, lElbCVk9, nKEch2ys,
				JlFpIEiL.getDcmDecodeParam().byteOrder, JlFpIEiL.getReadVR());
		ugXHMSxZ.writePixelData();
		nKEch2ys.flush();
		nKEch2ys.close();
		System.out.println("done!");
	}

}