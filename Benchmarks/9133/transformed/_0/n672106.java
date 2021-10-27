class n672106 {
	private static void readAndRewrite(File tyiwmXR0, File Ei7ZE8Pe) throws IOException {
		ImageInputStream nqmPyxTW = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(tyiwmXR0)));
		DcmParser NmZ2GGlH = DcmParserFactory.getInstance().newDcmParser(nqmPyxTW);
		Dataset xvO5TbBE = DcmObjectFactory.getInstance().newDataset();
		NmZ2GGlH.setDcmHandler(xvO5TbBE.getDcmHandler());
		NmZ2GGlH.parseDcmFile(null, Tags.PixelData);
		PixelDataReader MkUQRee5 = pdFact.newReader(xvO5TbBE, nqmPyxTW, NmZ2GGlH.getDcmDecodeParam().byteOrder,
				NmZ2GGlH.getReadVR());
		System.out.println("reading " + tyiwmXR0 + "...");
		MkUQRee5.readPixelData(false);
		ImageOutputStream gGU2O7xg = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(Ei7ZE8Pe)));
		DcmEncodeParam d2HWq3ar = DcmEncodeParam.IVR_LE;
		xvO5TbBE.writeDataset(gGU2O7xg, d2HWq3ar);
		xvO5TbBE.writeHeader(gGU2O7xg, d2HWq3ar, Tags.PixelData, NmZ2GGlH.getReadVR(), NmZ2GGlH.getReadLength());
		System.out.println("writing " + Ei7ZE8Pe + "...");
		PixelDataWriter nwSrNZqR = pdFact.newWriter(MkUQRee5.getPixelDataArray(), false, xvO5TbBE, gGU2O7xg,
				NmZ2GGlH.getDcmDecodeParam().byteOrder, NmZ2GGlH.getReadVR());
		nwSrNZqR.writePixelData();
		gGU2O7xg.flush();
		gGU2O7xg.close();
		System.out.println("done!");
	}

}