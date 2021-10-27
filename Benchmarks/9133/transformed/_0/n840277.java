class n840277 {
	private static void readAndRewrite(File zWVRDC8V, File uIgV4iw3) throws IOException {
		ImageInputStream VmI86lI9 = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(zWVRDC8V)));
		DcmParser SMkKpZCR = DcmParserFactory.getInstance().newDcmParser(VmI86lI9);
		Dataset eQMrGshX = DcmObjectFactory.getInstance().newDataset();
		SMkKpZCR.setDcmHandler(eQMrGshX.getDcmHandler());
		SMkKpZCR.parseDcmFile(null, Tags.PixelData);
		PixelDataReader D9AGSkwg = pdFact.newReader(eQMrGshX, VmI86lI9, SMkKpZCR.getDcmDecodeParam().byteOrder,
				SMkKpZCR.getReadVR());
		System.out.println("reading " + zWVRDC8V + "...");
		D9AGSkwg.readPixelData(false);
		ImageOutputStream SP6DgBbF = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(uIgV4iw3)));
		DcmEncodeParam AcmWkU4u = DcmEncodeParam.IVR_LE;
		eQMrGshX.writeDataset(SP6DgBbF, AcmWkU4u);
		eQMrGshX.writeHeader(SP6DgBbF, AcmWkU4u, Tags.PixelData, SMkKpZCR.getReadVR(), SMkKpZCR.getReadLength());
		System.out.println("writing " + uIgV4iw3 + "...");
		PixelDataWriter niImQVvN = pdFact.newWriter(D9AGSkwg.getPixelDataArray(), false, eQMrGshX, SP6DgBbF,
				SMkKpZCR.getDcmDecodeParam().byteOrder, SMkKpZCR.getReadVR());
		niImQVvN.writePixelData();
		SP6DgBbF.flush();
		SP6DgBbF.close();
		System.out.println("done!");
	}

}