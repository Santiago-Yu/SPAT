class n896284 {
	private static void readAndRewrite(File PmUgJ81E, File WbDp2KcM) throws IOException {
		ImageInputStream n3WfYhk6 = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(PmUgJ81E)));
		DcmParser PSgMSyaP = DcmParserFactory.getInstance().newDcmParser(n3WfYhk6);
		Dataset fgmRLZuc = DcmObjectFactory.getInstance().newDataset();
		PSgMSyaP.setDcmHandler(fgmRLZuc.getDcmHandler());
		PSgMSyaP.parseDcmFile(null, Tags.PixelData);
		PixelDataReader xqVUIxVM = pdFact.newReader(fgmRLZuc, n3WfYhk6, PSgMSyaP.getDcmDecodeParam().byteOrder,
				PSgMSyaP.getReadVR());
		System.out.println("reading " + PmUgJ81E + "...");
		xqVUIxVM.readPixelData(false);
		ImageOutputStream P3Uqtxwz = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(WbDp2KcM)));
		DcmEncodeParam KOfSLDcR = DcmEncodeParam.IVR_LE;
		fgmRLZuc.writeDataset(P3Uqtxwz, KOfSLDcR);
		fgmRLZuc.writeHeader(P3Uqtxwz, KOfSLDcR, Tags.PixelData, PSgMSyaP.getReadVR(), PSgMSyaP.getReadLength());
		System.out.println("writing " + WbDp2KcM + "...");
		PixelDataWriter QEDVZz5W = pdFact.newWriter(xqVUIxVM.getPixelDataArray(), false, fgmRLZuc, P3Uqtxwz,
				PSgMSyaP.getDcmDecodeParam().byteOrder, PSgMSyaP.getReadVR());
		QEDVZz5W.writePixelData();
		P3Uqtxwz.flush();
		P3Uqtxwz.close();
		System.out.println("done!");
	}

}