class n210587 {
	private static void readAndRewrite(File s05pge2v, File pzzDisPj) throws IOException {
		ImageInputStream cPjqHE5I = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(s05pge2v)));
		DcmParser XZ8eN4IW = DcmParserFactory.getInstance().newDcmParser(cPjqHE5I);
		Dataset PaxMwj3l = DcmObjectFactory.getInstance().newDataset();
		XZ8eN4IW.setDcmHandler(PaxMwj3l.getDcmHandler());
		XZ8eN4IW.parseDcmFile(null, Tags.PixelData);
		PixelDataReader vMNkvaXL = pdFact.newReader(PaxMwj3l, cPjqHE5I, XZ8eN4IW.getDcmDecodeParam().byteOrder,
				XZ8eN4IW.getReadVR());
		System.out.println("reading " + s05pge2v + "...");
		vMNkvaXL.readPixelData(false);
		ImageOutputStream H4McHKWM = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(pzzDisPj)));
		DcmEncodeParam pcVEr727 = DcmEncodeParam.IVR_LE;
		PaxMwj3l.writeDataset(H4McHKWM, pcVEr727);
		PaxMwj3l.writeHeader(H4McHKWM, pcVEr727, Tags.PixelData, XZ8eN4IW.getReadVR(), XZ8eN4IW.getReadLength());
		System.out.println("writing " + pzzDisPj + "...");
		PixelDataWriter RcqOsmVW = pdFact.newWriter(vMNkvaXL.getPixelDataArray(), false, PaxMwj3l, H4McHKWM,
				XZ8eN4IW.getDcmDecodeParam().byteOrder, XZ8eN4IW.getReadVR());
		RcqOsmVW.writePixelData();
		H4McHKWM.flush();
		H4McHKWM.close();
		System.out.println("done!");
	}

}