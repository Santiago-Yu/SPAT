class n332635 {
	private static void readAndRewrite(File faLcDzi7, File ieQi0Ev4) throws IOException {
		ImageInputStream ayirpHLW = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(faLcDzi7)));
		DcmParser Wrh6eLRy = DcmParserFactory.getInstance().newDcmParser(ayirpHLW);
		Dataset BMij1zDl = DcmObjectFactory.getInstance().newDataset();
		Wrh6eLRy.setDcmHandler(BMij1zDl.getDcmHandler());
		Wrh6eLRy.parseDcmFile(null, Tags.PixelData);
		PixelDataReader j54sS8Dr = pdFact.newReader(BMij1zDl, ayirpHLW, Wrh6eLRy.getDcmDecodeParam().byteOrder,
				Wrh6eLRy.getReadVR());
		System.out.println("reading " + faLcDzi7 + "...");
		j54sS8Dr.readPixelData(false);
		ImageOutputStream LpuxTvig = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(ieQi0Ev4)));
		DcmEncodeParam ei6Dxbrj = DcmEncodeParam.IVR_LE;
		BMij1zDl.writeDataset(LpuxTvig, ei6Dxbrj);
		BMij1zDl.writeHeader(LpuxTvig, ei6Dxbrj, Tags.PixelData, Wrh6eLRy.getReadVR(), Wrh6eLRy.getReadLength());
		System.out.println("writing " + ieQi0Ev4 + "...");
		PixelDataWriter KmoN29sY = pdFact.newWriter(j54sS8Dr.getPixelDataArray(), false, BMij1zDl, LpuxTvig,
				Wrh6eLRy.getDcmDecodeParam().byteOrder, Wrh6eLRy.getReadVR());
		KmoN29sY.writePixelData();
		LpuxTvig.flush();
		LpuxTvig.close();
		System.out.println("done!");
	}

}