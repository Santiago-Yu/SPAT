class n854262 {
	private static void readAndRewrite(File svriuFIE, File KSZxoMXs) throws IOException {
		ImageInputStream xnyq0lfj = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(svriuFIE)));
		DcmParser u9pSNkpm = DcmParserFactory.getInstance().newDcmParser(xnyq0lfj);
		Dataset YIp2WL3X = DcmObjectFactory.getInstance().newDataset();
		u9pSNkpm.setDcmHandler(YIp2WL3X.getDcmHandler());
		u9pSNkpm.parseDcmFile(null, Tags.PixelData);
		PixelDataReader QoJWFp8W = pdFact.newReader(YIp2WL3X, xnyq0lfj, u9pSNkpm.getDcmDecodeParam().byteOrder,
				u9pSNkpm.getReadVR());
		System.out.println("reading " + svriuFIE + "...");
		QoJWFp8W.readPixelData(false);
		ImageOutputStream aktzNlEp = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(KSZxoMXs)));
		DcmEncodeParam MkJLrG5T = DcmEncodeParam.IVR_LE;
		YIp2WL3X.writeDataset(aktzNlEp, MkJLrG5T);
		YIp2WL3X.writeHeader(aktzNlEp, MkJLrG5T, Tags.PixelData, u9pSNkpm.getReadVR(), u9pSNkpm.getReadLength());
		System.out.println("writing " + KSZxoMXs + "...");
		PixelDataWriter EuWL2G0j = pdFact.newWriter(QoJWFp8W.getPixelDataArray(), false, YIp2WL3X, aktzNlEp,
				u9pSNkpm.getDcmDecodeParam().byteOrder, u9pSNkpm.getReadVR());
		EuWL2G0j.writePixelData();
		aktzNlEp.flush();
		aktzNlEp.close();
		System.out.println("done!");
	}

}