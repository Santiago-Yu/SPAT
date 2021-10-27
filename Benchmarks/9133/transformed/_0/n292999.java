class n292999 {
	private static void readAndRewrite(File uIjZWItY, File Nq4NrmWg) throws IOException {
		ImageInputStream zIH9n55N = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(uIjZWItY)));
		DcmParser IO6d7AdM = DcmParserFactory.getInstance().newDcmParser(zIH9n55N);
		Dataset DXgUuHub = DcmObjectFactory.getInstance().newDataset();
		IO6d7AdM.setDcmHandler(DXgUuHub.getDcmHandler());
		IO6d7AdM.parseDcmFile(null, Tags.PixelData);
		PixelDataReader bnQvwBum = pdFact.newReader(DXgUuHub, zIH9n55N, IO6d7AdM.getDcmDecodeParam().byteOrder,
				IO6d7AdM.getReadVR());
		System.out.println("reading " + uIjZWItY + "...");
		bnQvwBum.readPixelData(false);
		ImageOutputStream Af4Megzx = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(Nq4NrmWg)));
		DcmEncodeParam jYcUxpn5 = DcmEncodeParam.IVR_LE;
		DXgUuHub.writeDataset(Af4Megzx, jYcUxpn5);
		DXgUuHub.writeHeader(Af4Megzx, jYcUxpn5, Tags.PixelData, IO6d7AdM.getReadVR(), IO6d7AdM.getReadLength());
		System.out.println("writing " + Nq4NrmWg + "...");
		PixelDataWriter I3H1z8fC = pdFact.newWriter(bnQvwBum.getPixelDataArray(), false, DXgUuHub, Af4Megzx,
				IO6d7AdM.getDcmDecodeParam().byteOrder, IO6d7AdM.getReadVR());
		I3H1z8fC.writePixelData();
		Af4Megzx.flush();
		Af4Megzx.close();
		System.out.println("done!");
	}

}