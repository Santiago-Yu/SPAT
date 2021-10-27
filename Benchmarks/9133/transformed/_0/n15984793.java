class n15984793 {
	public InputStream getPage(String WtPEh5sR) throws IOException {
		URL ModlAsVs = new URL(hattrickServerURL + "/Common/" + WtPEh5sR);
		HttpURLConnection aLAputkR = (HttpURLConnection) ModlAsVs.openConnection();
		aLAputkR.setRequestProperty("Cookie", sessionCookie);
		return aLAputkR.getInputStream();
	}

}