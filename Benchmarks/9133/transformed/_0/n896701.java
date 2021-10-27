class n896701 {
	private static void readAndRewrite(File W7NhgPMr, File YsF8aXrm) throws IOException {
		ImageInputStream VZTbVLDk = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(W7NhgPMr)));
		DcmParser iIoZ5G6d = DcmParserFactory.getInstance().newDcmParser(VZTbVLDk);
		Dataset dWjGB18z = DcmObjectFactory.getInstance().newDataset();
		iIoZ5G6d.setDcmHandler(dWjGB18z.getDcmHandler());
		iIoZ5G6d.parseDcmFile(null, Tags.PixelData);
		PixelDataReader SKf6T4KH = pdFact.newReader(dWjGB18z, VZTbVLDk, iIoZ5G6d.getDcmDecodeParam().byteOrder,
				iIoZ5G6d.getReadVR());
		System.out.println("reading " + W7NhgPMr + "...");
		SKf6T4KH.readPixelData(false);
		ImageOutputStream UrR04RBE = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(YsF8aXrm)));
		DcmEncodeParam KpYvy5mR = DcmEncodeParam.IVR_LE;
		dWjGB18z.writeDataset(UrR04RBE, KpYvy5mR);
		dWjGB18z.writeHeader(UrR04RBE, KpYvy5mR, Tags.PixelData, iIoZ5G6d.getReadVR(), iIoZ5G6d.getReadLength());
		System.out.println("writing " + YsF8aXrm + "...");
		PixelDataWriter rwWEdXvi = pdFact.newWriter(SKf6T4KH.getPixelDataArray(), false, dWjGB18z, UrR04RBE,
				iIoZ5G6d.getDcmDecodeParam().byteOrder, iIoZ5G6d.getReadVR());
		rwWEdXvi.writePixelData();
		UrR04RBE.flush();
		UrR04RBE.close();
		System.out.println("done!");
	}

}