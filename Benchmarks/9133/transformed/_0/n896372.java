class n896372 {
	private static void readAndRewrite(File axMdMrLe, File MMz74kN8) throws IOException {
		ImageInputStream T5pdyknI = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(axMdMrLe)));
		DcmParser SNC2uVkz = DcmParserFactory.getInstance().newDcmParser(T5pdyknI);
		Dataset WREeuhgN = DcmObjectFactory.getInstance().newDataset();
		SNC2uVkz.setDcmHandler(WREeuhgN.getDcmHandler());
		SNC2uVkz.parseDcmFile(null, Tags.PixelData);
		PixelDataReader vWnbaQOn = pdFact.newReader(WREeuhgN, T5pdyknI, SNC2uVkz.getDcmDecodeParam().byteOrder,
				SNC2uVkz.getReadVR());
		System.out.println("reading " + axMdMrLe + "...");
		vWnbaQOn.readPixelData(false);
		ImageOutputStream YIVoHzXn = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(MMz74kN8)));
		DcmEncodeParam aPAaYjKa = DcmEncodeParam.IVR_LE;
		WREeuhgN.writeDataset(YIVoHzXn, aPAaYjKa);
		WREeuhgN.writeHeader(YIVoHzXn, aPAaYjKa, Tags.PixelData, SNC2uVkz.getReadVR(), SNC2uVkz.getReadLength());
		System.out.println("writing " + MMz74kN8 + "...");
		PixelDataWriter L31yhTgO = pdFact.newWriter(vWnbaQOn.getPixelDataArray(), false, WREeuhgN, YIVoHzXn,
				SNC2uVkz.getDcmDecodeParam().byteOrder, SNC2uVkz.getReadVR());
		L31yhTgO.writePixelData();
		YIVoHzXn.flush();
		YIVoHzXn.close();
		System.out.println("done!");
	}

}