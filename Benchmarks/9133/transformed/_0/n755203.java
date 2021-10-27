class n755203 {
	private static void readAndRewrite(File SAH2hW0W, File hSJrcaTQ) throws IOException {
		ImageInputStream cjVjTtZ3 = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(SAH2hW0W)));
		DcmParser wPq3cRpP = DcmParserFactory.getInstance().newDcmParser(cjVjTtZ3);
		Dataset kANy4D00 = DcmObjectFactory.getInstance().newDataset();
		wPq3cRpP.setDcmHandler(kANy4D00.getDcmHandler());
		wPq3cRpP.parseDcmFile(null, Tags.PixelData);
		PixelDataReader iqEe8LIZ = pdFact.newReader(kANy4D00, cjVjTtZ3, wPq3cRpP.getDcmDecodeParam().byteOrder,
				wPq3cRpP.getReadVR());
		System.out.println("reading " + SAH2hW0W + "...");
		iqEe8LIZ.readPixelData(false);
		ImageOutputStream VC7r8zU2 = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(hSJrcaTQ)));
		DcmEncodeParam qnZbj6Pp = DcmEncodeParam.IVR_LE;
		kANy4D00.writeDataset(VC7r8zU2, qnZbj6Pp);
		kANy4D00.writeHeader(VC7r8zU2, qnZbj6Pp, Tags.PixelData, wPq3cRpP.getReadVR(), wPq3cRpP.getReadLength());
		System.out.println("writing " + hSJrcaTQ + "...");
		PixelDataWriter F8iFUeXE = pdFact.newWriter(iqEe8LIZ.getPixelDataArray(), false, kANy4D00, VC7r8zU2,
				wPq3cRpP.getDcmDecodeParam().byteOrder, wPq3cRpP.getReadVR());
		F8iFUeXE.writePixelData();
		VC7r8zU2.flush();
		VC7r8zU2.close();
		System.out.println("done!");
	}

}