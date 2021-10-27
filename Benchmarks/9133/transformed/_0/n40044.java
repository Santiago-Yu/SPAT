class n40044 {
	private static void readAndRewrite(File HcwXhb58, File ev69FqRc) throws IOException {
		ImageInputStream O888YW4o = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(HcwXhb58)));
		DcmParser KBHD3IIq = DcmParserFactory.getInstance().newDcmParser(O888YW4o);
		Dataset xJNbb9fv = DcmObjectFactory.getInstance().newDataset();
		KBHD3IIq.setDcmHandler(xJNbb9fv.getDcmHandler());
		KBHD3IIq.parseDcmFile(null, Tags.PixelData);
		PixelDataReader Rz8OsMie = pdFact.newReader(xJNbb9fv, O888YW4o, KBHD3IIq.getDcmDecodeParam().byteOrder,
				KBHD3IIq.getReadVR());
		System.out.println("reading " + HcwXhb58 + "...");
		Rz8OsMie.readPixelData(false);
		ImageOutputStream x47Mc98g = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(ev69FqRc)));
		DcmEncodeParam KIG0QEFM = DcmEncodeParam.IVR_LE;
		xJNbb9fv.writeDataset(x47Mc98g, KIG0QEFM);
		xJNbb9fv.writeHeader(x47Mc98g, KIG0QEFM, Tags.PixelData, KBHD3IIq.getReadVR(), KBHD3IIq.getReadLength());
		System.out.println("writing " + ev69FqRc + "...");
		PixelDataWriter HFMAVuZJ = pdFact.newWriter(Rz8OsMie.getPixelDataArray(), false, xJNbb9fv, x47Mc98g,
				KBHD3IIq.getDcmDecodeParam().byteOrder, KBHD3IIq.getReadVR());
		HFMAVuZJ.writePixelData();
		x47Mc98g.flush();
		x47Mc98g.close();
		System.out.println("done!");
	}

}