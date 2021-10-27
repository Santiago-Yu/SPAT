class n88047 {
	private static void readAndRewrite(File QApTI9xw, File n8kqDwSr) throws IOException {
		ImageInputStream U0uP3IHJ = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(QApTI9xw)));
		DcmParser hgidpRFP = DcmParserFactory.getInstance().newDcmParser(U0uP3IHJ);
		Dataset pCnB5ZaD = DcmObjectFactory.getInstance().newDataset();
		hgidpRFP.setDcmHandler(pCnB5ZaD.getDcmHandler());
		hgidpRFP.parseDcmFile(null, Tags.PixelData);
		PixelDataReader CCdMddiy = pdFact.newReader(pCnB5ZaD, U0uP3IHJ, hgidpRFP.getDcmDecodeParam().byteOrder,
				hgidpRFP.getReadVR());
		System.out.println("reading " + QApTI9xw + "...");
		CCdMddiy.readPixelData(false);
		ImageOutputStream donJlGpp = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(n8kqDwSr)));
		DcmEncodeParam XLRN4w2V = DcmEncodeParam.IVR_LE;
		pCnB5ZaD.writeDataset(donJlGpp, XLRN4w2V);
		pCnB5ZaD.writeHeader(donJlGpp, XLRN4w2V, Tags.PixelData, hgidpRFP.getReadVR(), hgidpRFP.getReadLength());
		System.out.println("writing " + n8kqDwSr + "...");
		PixelDataWriter ARuh897C = pdFact.newWriter(CCdMddiy.getPixelDataArray(), false, pCnB5ZaD, donJlGpp,
				hgidpRFP.getDcmDecodeParam().byteOrder, hgidpRFP.getReadVR());
		ARuh897C.writePixelData();
		donJlGpp.flush();
		donJlGpp.close();
		System.out.println("done!");
	}

}