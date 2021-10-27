class n150478 {
	private static void readAndRewrite(File ETiduItr, File UvmCCP61) throws IOException {
		ImageInputStream drzl9JkY = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(ETiduItr)));
		DcmParser b9Gpz74W = DcmParserFactory.getInstance().newDcmParser(drzl9JkY);
		Dataset qthWYkdz = DcmObjectFactory.getInstance().newDataset();
		b9Gpz74W.setDcmHandler(qthWYkdz.getDcmHandler());
		b9Gpz74W.parseDcmFile(null, Tags.PixelData);
		PixelDataReader CsV1VAcJ = pdFact.newReader(qthWYkdz, drzl9JkY, b9Gpz74W.getDcmDecodeParam().byteOrder,
				b9Gpz74W.getReadVR());
		System.out.println("reading " + ETiduItr + "...");
		CsV1VAcJ.readPixelData(false);
		ImageOutputStream HeYMID84 = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(UvmCCP61)));
		DcmEncodeParam GDbBArP3 = DcmEncodeParam.IVR_LE;
		qthWYkdz.writeDataset(HeYMID84, GDbBArP3);
		qthWYkdz.writeHeader(HeYMID84, GDbBArP3, Tags.PixelData, b9Gpz74W.getReadVR(), b9Gpz74W.getReadLength());
		System.out.println("writing " + UvmCCP61 + "...");
		PixelDataWriter OnUYMhEa = pdFact.newWriter(CsV1VAcJ.getPixelDataArray(), false, qthWYkdz, HeYMID84,
				b9Gpz74W.getDcmDecodeParam().byteOrder, b9Gpz74W.getReadVR());
		OnUYMhEa.writePixelData();
		HeYMID84.flush();
		HeYMID84.close();
		System.out.println("done!");
	}

}