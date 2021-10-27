class n708766 {
	private static void readAndRewrite(File cj1L71Ai, File ZZ5XlI6G) throws IOException {
		ImageInputStream lC7mJJbP = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(cj1L71Ai)));
		DcmParser tuoL5VRG = DcmParserFactory.getInstance().newDcmParser(lC7mJJbP);
		Dataset tLHWFQor = DcmObjectFactory.getInstance().newDataset();
		tuoL5VRG.setDcmHandler(tLHWFQor.getDcmHandler());
		tuoL5VRG.parseDcmFile(null, Tags.PixelData);
		PixelDataReader rqhuluLF = pdFact.newReader(tLHWFQor, lC7mJJbP, tuoL5VRG.getDcmDecodeParam().byteOrder,
				tuoL5VRG.getReadVR());
		System.out.println("reading " + cj1L71Ai + "...");
		rqhuluLF.readPixelData(false);
		ImageOutputStream YQVcLmvT = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(ZZ5XlI6G)));
		DcmEncodeParam xosDURTw = DcmEncodeParam.IVR_LE;
		tLHWFQor.writeDataset(YQVcLmvT, xosDURTw);
		tLHWFQor.writeHeader(YQVcLmvT, xosDURTw, Tags.PixelData, tuoL5VRG.getReadVR(), tuoL5VRG.getReadLength());
		System.out.println("writing " + ZZ5XlI6G + "...");
		PixelDataWriter s1eNpQbu = pdFact.newWriter(rqhuluLF.getPixelDataArray(), false, tLHWFQor, YQVcLmvT,
				tuoL5VRG.getDcmDecodeParam().byteOrder, tuoL5VRG.getReadVR());
		s1eNpQbu.writePixelData();
		YQVcLmvT.flush();
		YQVcLmvT.close();
		System.out.println("done!");
	}

}