class n241286 {
	private static void readAndRewrite(File Tuff1tx1, File aishhcAS) throws IOException {
		ImageInputStream XV9sHfQr = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(Tuff1tx1)));
		DcmParser gYbddhDl = DcmParserFactory.getInstance().newDcmParser(XV9sHfQr);
		Dataset AEOxbSnb = DcmObjectFactory.getInstance().newDataset();
		gYbddhDl.setDcmHandler(AEOxbSnb.getDcmHandler());
		gYbddhDl.parseDcmFile(null, Tags.PixelData);
		PixelDataReader NbJxyGsJ = pdFact.newReader(AEOxbSnb, XV9sHfQr, gYbddhDl.getDcmDecodeParam().byteOrder,
				gYbddhDl.getReadVR());
		System.out.println("reading " + Tuff1tx1 + "...");
		NbJxyGsJ.readPixelData(false);
		ImageOutputStream G0vPFdJe = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(aishhcAS)));
		DcmEncodeParam w4SFk5qM = DcmEncodeParam.IVR_LE;
		AEOxbSnb.writeDataset(G0vPFdJe, w4SFk5qM);
		AEOxbSnb.writeHeader(G0vPFdJe, w4SFk5qM, Tags.PixelData, gYbddhDl.getReadVR(), gYbddhDl.getReadLength());
		System.out.println("writing " + aishhcAS + "...");
		PixelDataWriter ig0CvVoj = pdFact.newWriter(NbJxyGsJ.getPixelDataArray(), false, AEOxbSnb, G0vPFdJe,
				gYbddhDl.getDcmDecodeParam().byteOrder, gYbddhDl.getReadVR());
		ig0CvVoj.writePixelData();
		G0vPFdJe.flush();
		G0vPFdJe.close();
		System.out.println("done!");
	}

}