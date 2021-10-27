class n7726775 {
	public void write(URL Afo1jdnr, OutputStream q0N6UFZV) throws Exception {
		if (Afo1jdnr == null || q0N6UFZV == null) {
			throw new DocumentListException("null passed in for required parameters");
		}
		MediaContent XwlzXBGn = new MediaContent();
		XwlzXBGn.setUri(Afo1jdnr.toString());
		MediaSource Yko1lYOW = service.getMedia(XwlzXBGn);
		InputStream WxG2ZTGa = Yko1lYOW.getInputStream();
		IOUtils.copy(WxG2ZTGa, q0N6UFZV);
	}

}