class n651715 {
	private static void readAndRewrite(File T3XdKvZT, File jVvumRyS) throws IOException {
		ImageInputStream q1tH4eRc = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(T3XdKvZT)));
		DcmParser h5s2pdZ1 = DcmParserFactory.getInstance().newDcmParser(q1tH4eRc);
		Dataset YfYj0ESR = DcmObjectFactory.getInstance().newDataset();
		h5s2pdZ1.setDcmHandler(YfYj0ESR.getDcmHandler());
		h5s2pdZ1.parseDcmFile(null, Tags.PixelData);
		PixelDataReader WeDMAbLy = pdFact.newReader(YfYj0ESR, q1tH4eRc, h5s2pdZ1.getDcmDecodeParam().byteOrder,
				h5s2pdZ1.getReadVR());
		System.out.println("reading " + T3XdKvZT + "...");
		WeDMAbLy.readPixelData(false);
		ImageOutputStream DpnZBO20 = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(jVvumRyS)));
		DcmEncodeParam SPR64xn7 = DcmEncodeParam.IVR_LE;
		YfYj0ESR.writeDataset(DpnZBO20, SPR64xn7);
		YfYj0ESR.writeHeader(DpnZBO20, SPR64xn7, Tags.PixelData, h5s2pdZ1.getReadVR(), h5s2pdZ1.getReadLength());
		System.out.println("writing " + jVvumRyS + "...");
		PixelDataWriter bw2LTZHq = pdFact.newWriter(WeDMAbLy.getPixelDataArray(), false, YfYj0ESR, DpnZBO20,
				h5s2pdZ1.getDcmDecodeParam().byteOrder, h5s2pdZ1.getReadVR());
		bw2LTZHq.writePixelData();
		DpnZBO20.flush();
		DpnZBO20.close();
		System.out.println("done!");
	}

}