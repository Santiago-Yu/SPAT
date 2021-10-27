class n908793 {
	private static void readAndRewrite(File pUa5cCyH, File K2yCxU1w) throws IOException {
		ImageInputStream GjtAGY5V = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(pUa5cCyH)));
		DcmParser fP92CEEJ = DcmParserFactory.getInstance().newDcmParser(GjtAGY5V);
		Dataset iJU7BiWq = DcmObjectFactory.getInstance().newDataset();
		fP92CEEJ.setDcmHandler(iJU7BiWq.getDcmHandler());
		fP92CEEJ.parseDcmFile(null, Tags.PixelData);
		PixelDataReader r4zC0o6d = pdFact.newReader(iJU7BiWq, GjtAGY5V, fP92CEEJ.getDcmDecodeParam().byteOrder,
				fP92CEEJ.getReadVR());
		System.out.println("reading " + pUa5cCyH + "...");
		r4zC0o6d.readPixelData(false);
		ImageOutputStream cpCE23Nm = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(K2yCxU1w)));
		DcmEncodeParam uJ7W0Lte = DcmEncodeParam.IVR_LE;
		iJU7BiWq.writeDataset(cpCE23Nm, uJ7W0Lte);
		iJU7BiWq.writeHeader(cpCE23Nm, uJ7W0Lte, Tags.PixelData, fP92CEEJ.getReadVR(), fP92CEEJ.getReadLength());
		System.out.println("writing " + K2yCxU1w + "...");
		PixelDataWriter wmmWT7y5 = pdFact.newWriter(r4zC0o6d.getPixelDataArray(), false, iJU7BiWq, cpCE23Nm,
				fP92CEEJ.getDcmDecodeParam().byteOrder, fP92CEEJ.getReadVR());
		wmmWT7y5.writePixelData();
		cpCE23Nm.flush();
		cpCE23Nm.close();
		System.out.println("done!");
	}

}