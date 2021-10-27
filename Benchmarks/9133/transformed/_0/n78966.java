class n78966 {
	private static void readAndRewrite(File Edfmhv33, File A4YrprCj) throws IOException {
		ImageInputStream k9kid5uu = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(Edfmhv33)));
		DcmParser W82BQwce = DcmParserFactory.getInstance().newDcmParser(k9kid5uu);
		Dataset TekTnd81 = DcmObjectFactory.getInstance().newDataset();
		W82BQwce.setDcmHandler(TekTnd81.getDcmHandler());
		W82BQwce.parseDcmFile(null, Tags.PixelData);
		PixelDataReader TtbNmSR5 = pdFact.newReader(TekTnd81, k9kid5uu, W82BQwce.getDcmDecodeParam().byteOrder,
				W82BQwce.getReadVR());
		System.out.println("reading " + Edfmhv33 + "...");
		TtbNmSR5.readPixelData(false);
		ImageOutputStream HuhsjxH2 = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(A4YrprCj)));
		DcmEncodeParam RiCznxGA = DcmEncodeParam.IVR_LE;
		TekTnd81.writeDataset(HuhsjxH2, RiCznxGA);
		TekTnd81.writeHeader(HuhsjxH2, RiCznxGA, Tags.PixelData, W82BQwce.getReadVR(), W82BQwce.getReadLength());
		System.out.println("writing " + A4YrprCj + "...");
		PixelDataWriter yq9bUS51 = pdFact.newWriter(TtbNmSR5.getPixelDataArray(), false, TekTnd81, HuhsjxH2,
				W82BQwce.getDcmDecodeParam().byteOrder, W82BQwce.getReadVR());
		yq9bUS51.writePixelData();
		HuhsjxH2.flush();
		HuhsjxH2.close();
		System.out.println("done!");
	}

}