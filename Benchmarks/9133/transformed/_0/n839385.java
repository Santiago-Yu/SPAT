class n839385 {
	private static void readAndRewrite(File qWxAkjHH, File CHc8U9K2) throws IOException {
		ImageInputStream AbwDJrkA = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(qWxAkjHH)));
		DcmParser Fd8pUmPc = DcmParserFactory.getInstance().newDcmParser(AbwDJrkA);
		Dataset fQCbVNPj = DcmObjectFactory.getInstance().newDataset();
		Fd8pUmPc.setDcmHandler(fQCbVNPj.getDcmHandler());
		Fd8pUmPc.parseDcmFile(null, Tags.PixelData);
		PixelDataReader ZjQ2Q4ps = pdFact.newReader(fQCbVNPj, AbwDJrkA, Fd8pUmPc.getDcmDecodeParam().byteOrder,
				Fd8pUmPc.getReadVR());
		System.out.println("reading " + qWxAkjHH + "...");
		ZjQ2Q4ps.readPixelData(false);
		ImageOutputStream iHbEAVSC = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(CHc8U9K2)));
		DcmEncodeParam MzMRLFTS = DcmEncodeParam.IVR_LE;
		fQCbVNPj.writeDataset(iHbEAVSC, MzMRLFTS);
		fQCbVNPj.writeHeader(iHbEAVSC, MzMRLFTS, Tags.PixelData, Fd8pUmPc.getReadVR(), Fd8pUmPc.getReadLength());
		System.out.println("writing " + CHc8U9K2 + "...");
		PixelDataWriter HHgNgo2x = pdFact.newWriter(ZjQ2Q4ps.getPixelDataArray(), false, fQCbVNPj, iHbEAVSC,
				Fd8pUmPc.getDcmDecodeParam().byteOrder, Fd8pUmPc.getReadVR());
		HHgNgo2x.writePixelData();
		iHbEAVSC.flush();
		iHbEAVSC.close();
		System.out.println("done!");
	}

}