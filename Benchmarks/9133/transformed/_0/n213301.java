class n213301 {
	private static void readAndRewrite(File QNct1oaK, File MpQcqKX9) throws IOException {
		ImageInputStream e0QvQ4XL = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(QNct1oaK)));
		DcmParser vffrsODl = DcmParserFactory.getInstance().newDcmParser(e0QvQ4XL);
		Dataset H1bhYJ6T = DcmObjectFactory.getInstance().newDataset();
		vffrsODl.setDcmHandler(H1bhYJ6T.getDcmHandler());
		vffrsODl.parseDcmFile(null, Tags.PixelData);
		PixelDataReader igP4mPtj = pdFact.newReader(H1bhYJ6T, e0QvQ4XL, vffrsODl.getDcmDecodeParam().byteOrder,
				vffrsODl.getReadVR());
		System.out.println("reading " + QNct1oaK + "...");
		igP4mPtj.readPixelData(false);
		ImageOutputStream LlZfmQRi = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(MpQcqKX9)));
		DcmEncodeParam XETF0iEc = DcmEncodeParam.IVR_LE;
		H1bhYJ6T.writeDataset(LlZfmQRi, XETF0iEc);
		H1bhYJ6T.writeHeader(LlZfmQRi, XETF0iEc, Tags.PixelData, vffrsODl.getReadVR(), vffrsODl.getReadLength());
		System.out.println("writing " + MpQcqKX9 + "...");
		PixelDataWriter REx8AbA1 = pdFact.newWriter(igP4mPtj.getPixelDataArray(), false, H1bhYJ6T, LlZfmQRi,
				vffrsODl.getDcmDecodeParam().byteOrder, vffrsODl.getReadVR());
		REx8AbA1.writePixelData();
		LlZfmQRi.flush();
		LlZfmQRi.close();
		System.out.println("done!");
	}

}