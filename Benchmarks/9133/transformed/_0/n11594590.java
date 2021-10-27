class n11594590 {
	public <T extends FetionResponse> T executeAction(FetionAction<T> a1T2kxBi) throws IOException {
		URL DygOf9iO = new URL(
				a1T2kxBi.getProtocol().name().toLowerCase() + "://" + fetionUrl + a1T2kxBi.getRequestData());
		URLConnection mB16MHOW = DygOf9iO.openConnection();
		InputStream fRQIwDDH = mB16MHOW.getInputStream();
		byte[] WGOxLKyB = new byte[10240];
		ByteArrayOutputStream mrmYeYhu = new ByteArrayOutputStream();
		int PzNx0aRu = 0;
		while ((PzNx0aRu = fRQIwDDH.read(WGOxLKyB)) > 0) {
			mrmYeYhu.write(WGOxLKyB, 0, PzNx0aRu);
		}
		return a1T2kxBi.processResponse(parseRawResponse(mrmYeYhu.toByteArray()));
	}

}