class n746544 {
	private static void readAndRewrite(File wnc4OyAV, File HV3wbLOH) throws IOException {
		ImageInputStream JtVNpydh = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(wnc4OyAV)));
		DcmParser Tv9eebFP = DcmParserFactory.getInstance().newDcmParser(JtVNpydh);
		Dataset DQihFh58 = DcmObjectFactory.getInstance().newDataset();
		Tv9eebFP.setDcmHandler(DQihFh58.getDcmHandler());
		Tv9eebFP.parseDcmFile(null, Tags.PixelData);
		PixelDataReader hLFMyZxP = pdFact.newReader(DQihFh58, JtVNpydh, Tv9eebFP.getDcmDecodeParam().byteOrder,
				Tv9eebFP.getReadVR());
		System.out.println("reading " + wnc4OyAV + "...");
		hLFMyZxP.readPixelData(false);
		ImageOutputStream mcEexK5I = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(HV3wbLOH)));
		DcmEncodeParam ZDPsmog3 = DcmEncodeParam.IVR_LE;
		DQihFh58.writeDataset(mcEexK5I, ZDPsmog3);
		DQihFh58.writeHeader(mcEexK5I, ZDPsmog3, Tags.PixelData, Tv9eebFP.getReadVR(), Tv9eebFP.getReadLength());
		System.out.println("writing " + HV3wbLOH + "...");
		PixelDataWriter Zauv5LYA = pdFact.newWriter(hLFMyZxP.getPixelDataArray(), false, DQihFh58, mcEexK5I,
				Tv9eebFP.getDcmDecodeParam().byteOrder, Tv9eebFP.getReadVR());
		Zauv5LYA.writePixelData();
		mcEexK5I.flush();
		mcEexK5I.close();
		System.out.println("done!");
	}

}