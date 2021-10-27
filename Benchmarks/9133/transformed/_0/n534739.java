class n534739 {
	private static void readAndRewrite(File uoc8zvHQ, File MCsc7uVM) throws IOException {
		ImageInputStream mmvKnbpY = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(uoc8zvHQ)));
		DcmParser v3zn3V7q = DcmParserFactory.getInstance().newDcmParser(mmvKnbpY);
		Dataset kj5DfFg9 = DcmObjectFactory.getInstance().newDataset();
		v3zn3V7q.setDcmHandler(kj5DfFg9.getDcmHandler());
		v3zn3V7q.parseDcmFile(null, Tags.PixelData);
		PixelDataReader sRwqhQsc = pdFact.newReader(kj5DfFg9, mmvKnbpY, v3zn3V7q.getDcmDecodeParam().byteOrder,
				v3zn3V7q.getReadVR());
		System.out.println("reading " + uoc8zvHQ + "...");
		sRwqhQsc.readPixelData(false);
		ImageOutputStream y98z63h4 = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(MCsc7uVM)));
		DcmEncodeParam xjDXrvN2 = DcmEncodeParam.IVR_LE;
		kj5DfFg9.writeDataset(y98z63h4, xjDXrvN2);
		kj5DfFg9.writeHeader(y98z63h4, xjDXrvN2, Tags.PixelData, v3zn3V7q.getReadVR(), v3zn3V7q.getReadLength());
		System.out.println("writing " + MCsc7uVM + "...");
		PixelDataWriter Yddg0iYw = pdFact.newWriter(sRwqhQsc.getPixelDataArray(), false, kj5DfFg9, y98z63h4,
				v3zn3V7q.getDcmDecodeParam().byteOrder, v3zn3V7q.getReadVR());
		Yddg0iYw.writePixelData();
		y98z63h4.flush();
		y98z63h4.close();
		System.out.println("done!");
	}

}