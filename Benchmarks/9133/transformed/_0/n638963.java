class n638963 {
	private static void readAndRewrite(File ZJcM6xKh, File DHl0HZYE) throws IOException {
		ImageInputStream hu2blfRz = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(ZJcM6xKh)));
		DcmParser qXIXlUWH = DcmParserFactory.getInstance().newDcmParser(hu2blfRz);
		Dataset K3exTXrp = DcmObjectFactory.getInstance().newDataset();
		qXIXlUWH.setDcmHandler(K3exTXrp.getDcmHandler());
		qXIXlUWH.parseDcmFile(null, Tags.PixelData);
		PixelDataReader S5YcdfJJ = pdFact.newReader(K3exTXrp, hu2blfRz, qXIXlUWH.getDcmDecodeParam().byteOrder,
				qXIXlUWH.getReadVR());
		System.out.println("reading " + ZJcM6xKh + "...");
		S5YcdfJJ.readPixelData(false);
		ImageOutputStream NdWl2mwS = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(DHl0HZYE)));
		DcmEncodeParam fiaj3O7R = DcmEncodeParam.IVR_LE;
		K3exTXrp.writeDataset(NdWl2mwS, fiaj3O7R);
		K3exTXrp.writeHeader(NdWl2mwS, fiaj3O7R, Tags.PixelData, qXIXlUWH.getReadVR(), qXIXlUWH.getReadLength());
		System.out.println("writing " + DHl0HZYE + "...");
		PixelDataWriter SlsJfjPK = pdFact.newWriter(S5YcdfJJ.getPixelDataArray(), false, K3exTXrp, NdWl2mwS,
				qXIXlUWH.getDcmDecodeParam().byteOrder, qXIXlUWH.getReadVR());
		SlsJfjPK.writePixelData();
		NdWl2mwS.flush();
		NdWl2mwS.close();
		System.out.println("done!");
	}

}