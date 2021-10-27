class n624490 {
	private static void readAndRewrite(File CLpNGZQb, File hcZQFYOo) throws IOException {
		ImageInputStream WE4EjOWh = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(CLpNGZQb)));
		DcmParser OketJw3M = DcmParserFactory.getInstance().newDcmParser(WE4EjOWh);
		Dataset fwY0TIGs = DcmObjectFactory.getInstance().newDataset();
		OketJw3M.setDcmHandler(fwY0TIGs.getDcmHandler());
		OketJw3M.parseDcmFile(null, Tags.PixelData);
		PixelDataReader OOSdEvEx = pdFact.newReader(fwY0TIGs, WE4EjOWh, OketJw3M.getDcmDecodeParam().byteOrder,
				OketJw3M.getReadVR());
		System.out.println("reading " + CLpNGZQb + "...");
		OOSdEvEx.readPixelData(false);
		ImageOutputStream KVTDfL65 = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(hcZQFYOo)));
		DcmEncodeParam MKQmXVkx = DcmEncodeParam.IVR_LE;
		fwY0TIGs.writeDataset(KVTDfL65, MKQmXVkx);
		fwY0TIGs.writeHeader(KVTDfL65, MKQmXVkx, Tags.PixelData, OketJw3M.getReadVR(), OketJw3M.getReadLength());
		System.out.println("writing " + hcZQFYOo + "...");
		PixelDataWriter j2xpbdq6 = pdFact.newWriter(OOSdEvEx.getPixelDataArray(), false, fwY0TIGs, KVTDfL65,
				OketJw3M.getDcmDecodeParam().byteOrder, OketJw3M.getReadVR());
		j2xpbdq6.writePixelData();
		KVTDfL65.flush();
		KVTDfL65.close();
		System.out.println("done!");
	}

}