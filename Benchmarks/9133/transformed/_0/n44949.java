class n44949 {
	private static void readAndRewrite(File cn6v5RBM, File wg9JR7Br) throws IOException {
		ImageInputStream C9YOusNf = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(cn6v5RBM)));
		DcmParser s4Y1ofkG = DcmParserFactory.getInstance().newDcmParser(C9YOusNf);
		Dataset dGbIfTTu = DcmObjectFactory.getInstance().newDataset();
		s4Y1ofkG.setDcmHandler(dGbIfTTu.getDcmHandler());
		s4Y1ofkG.parseDcmFile(null, Tags.PixelData);
		PixelDataReader OdMVHXFa = pdFact.newReader(dGbIfTTu, C9YOusNf, s4Y1ofkG.getDcmDecodeParam().byteOrder,
				s4Y1ofkG.getReadVR());
		System.out.println("reading " + cn6v5RBM + "...");
		OdMVHXFa.readPixelData(false);
		ImageOutputStream r9YIxZXT = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(wg9JR7Br)));
		DcmEncodeParam rQXvZ0bd = DcmEncodeParam.IVR_LE;
		dGbIfTTu.writeDataset(r9YIxZXT, rQXvZ0bd);
		dGbIfTTu.writeHeader(r9YIxZXT, rQXvZ0bd, Tags.PixelData, s4Y1ofkG.getReadVR(), s4Y1ofkG.getReadLength());
		System.out.println("writing " + wg9JR7Br + "...");
		PixelDataWriter bW4qHF7I = pdFact.newWriter(OdMVHXFa.getPixelDataArray(), false, dGbIfTTu, r9YIxZXT,
				s4Y1ofkG.getDcmDecodeParam().byteOrder, s4Y1ofkG.getReadVR());
		bW4qHF7I.writePixelData();
		r9YIxZXT.flush();
		r9YIxZXT.close();
		System.out.println("done!");
	}

}