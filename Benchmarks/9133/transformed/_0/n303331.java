class n303331 {
	private static void readAndRewrite(File G7pz6wpI, File guF3amrE) throws IOException {
		ImageInputStream Wpmk6oUP = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(G7pz6wpI)));
		DcmParser GnvNU5Ex = DcmParserFactory.getInstance().newDcmParser(Wpmk6oUP);
		Dataset g7D8AO0Q = DcmObjectFactory.getInstance().newDataset();
		GnvNU5Ex.setDcmHandler(g7D8AO0Q.getDcmHandler());
		GnvNU5Ex.parseDcmFile(null, Tags.PixelData);
		PixelDataReader fS79KE4W = pdFact.newReader(g7D8AO0Q, Wpmk6oUP, GnvNU5Ex.getDcmDecodeParam().byteOrder,
				GnvNU5Ex.getReadVR());
		System.out.println("reading " + G7pz6wpI + "...");
		fS79KE4W.readPixelData(false);
		ImageOutputStream TvAZaxgJ = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(guF3amrE)));
		DcmEncodeParam GxyzHz3A = DcmEncodeParam.IVR_LE;
		g7D8AO0Q.writeDataset(TvAZaxgJ, GxyzHz3A);
		g7D8AO0Q.writeHeader(TvAZaxgJ, GxyzHz3A, Tags.PixelData, GnvNU5Ex.getReadVR(), GnvNU5Ex.getReadLength());
		System.out.println("writing " + guF3amrE + "...");
		PixelDataWriter qLYqeMP7 = pdFact.newWriter(fS79KE4W.getPixelDataArray(), false, g7D8AO0Q, TvAZaxgJ,
				GnvNU5Ex.getDcmDecodeParam().byteOrder, GnvNU5Ex.getReadVR());
		qLYqeMP7.writePixelData();
		TvAZaxgJ.flush();
		TvAZaxgJ.close();
		System.out.println("done!");
	}

}