class n850680 {
	private static void readAndRewrite(File lbbCsJCc, File CJovQ0Z1) throws IOException {
		ImageInputStream x6zvZ6jv = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(lbbCsJCc)));
		DcmParser ysWII5WO = DcmParserFactory.getInstance().newDcmParser(x6zvZ6jv);
		Dataset AKYaJbE6 = DcmObjectFactory.getInstance().newDataset();
		ysWII5WO.setDcmHandler(AKYaJbE6.getDcmHandler());
		ysWII5WO.parseDcmFile(null, Tags.PixelData);
		PixelDataReader kCFaWMat = pdFact.newReader(AKYaJbE6, x6zvZ6jv, ysWII5WO.getDcmDecodeParam().byteOrder,
				ysWII5WO.getReadVR());
		System.out.println("reading " + lbbCsJCc + "...");
		kCFaWMat.readPixelData(false);
		ImageOutputStream qGKigBha = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(CJovQ0Z1)));
		DcmEncodeParam Ct9vompF = DcmEncodeParam.IVR_LE;
		AKYaJbE6.writeDataset(qGKigBha, Ct9vompF);
		AKYaJbE6.writeHeader(qGKigBha, Ct9vompF, Tags.PixelData, ysWII5WO.getReadVR(), ysWII5WO.getReadLength());
		System.out.println("writing " + CJovQ0Z1 + "...");
		PixelDataWriter KL5qCAkG = pdFact.newWriter(kCFaWMat.getPixelDataArray(), false, AKYaJbE6, qGKigBha,
				ysWII5WO.getDcmDecodeParam().byteOrder, ysWII5WO.getReadVR());
		KL5qCAkG.writePixelData();
		qGKigBha.flush();
		qGKigBha.close();
		System.out.println("done!");
	}

}