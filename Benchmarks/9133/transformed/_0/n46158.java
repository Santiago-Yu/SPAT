class n46158 {
	private static void readAndRewrite(File PmfpKC13, File l1bd3GSC) throws IOException {
		ImageInputStream n8Ueidrs = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(PmfpKC13)));
		DcmParser xxAv3DL8 = DcmParserFactory.getInstance().newDcmParser(n8Ueidrs);
		Dataset qYnDtP0x = DcmObjectFactory.getInstance().newDataset();
		xxAv3DL8.setDcmHandler(qYnDtP0x.getDcmHandler());
		xxAv3DL8.parseDcmFile(null, Tags.PixelData);
		PixelDataReader iQEousJB = pdFact.newReader(qYnDtP0x, n8Ueidrs, xxAv3DL8.getDcmDecodeParam().byteOrder,
				xxAv3DL8.getReadVR());
		System.out.println("reading " + PmfpKC13 + "...");
		iQEousJB.readPixelData(false);
		ImageOutputStream po3xQEPo = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(l1bd3GSC)));
		DcmEncodeParam HdRGxn0Z = DcmEncodeParam.IVR_LE;
		qYnDtP0x.writeDataset(po3xQEPo, HdRGxn0Z);
		qYnDtP0x.writeHeader(po3xQEPo, HdRGxn0Z, Tags.PixelData, xxAv3DL8.getReadVR(), xxAv3DL8.getReadLength());
		System.out.println("writing " + l1bd3GSC + "...");
		PixelDataWriter wRTEdEIH = pdFact.newWriter(iQEousJB.getPixelDataArray(), false, qYnDtP0x, po3xQEPo,
				xxAv3DL8.getDcmDecodeParam().byteOrder, xxAv3DL8.getReadVR());
		wRTEdEIH.writePixelData();
		po3xQEPo.flush();
		po3xQEPo.close();
		System.out.println("done!");
	}

}