class n801395 {
	private static void readAndRewrite(File Td6Kq5Jw, File vPcWul8N) throws IOException {
		ImageInputStream Y4S5FNeX = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(Td6Kq5Jw)));
		DcmParser fPpo2qxf = DcmParserFactory.getInstance().newDcmParser(Y4S5FNeX);
		Dataset DmCU8rAI = DcmObjectFactory.getInstance().newDataset();
		fPpo2qxf.setDcmHandler(DmCU8rAI.getDcmHandler());
		fPpo2qxf.parseDcmFile(null, Tags.PixelData);
		PixelDataReader W8sfEpyk = pdFact.newReader(DmCU8rAI, Y4S5FNeX, fPpo2qxf.getDcmDecodeParam().byteOrder,
				fPpo2qxf.getReadVR());
		System.out.println("reading " + Td6Kq5Jw + "...");
		W8sfEpyk.readPixelData(false);
		ImageOutputStream YqUMJYFI = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(vPcWul8N)));
		DcmEncodeParam IJmMBhOr = DcmEncodeParam.IVR_LE;
		DmCU8rAI.writeDataset(YqUMJYFI, IJmMBhOr);
		DmCU8rAI.writeHeader(YqUMJYFI, IJmMBhOr, Tags.PixelData, fPpo2qxf.getReadVR(), fPpo2qxf.getReadLength());
		System.out.println("writing " + vPcWul8N + "...");
		PixelDataWriter wA5u84To = pdFact.newWriter(W8sfEpyk.getPixelDataArray(), false, DmCU8rAI, YqUMJYFI,
				fPpo2qxf.getDcmDecodeParam().byteOrder, fPpo2qxf.getReadVR());
		wA5u84To.writePixelData();
		YqUMJYFI.flush();
		YqUMJYFI.close();
		System.out.println("done!");
	}

}