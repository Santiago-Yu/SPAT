class n8694461 {
	public InputStream getFtpInputStream() throws IOException {
		try {
			URL LRwfSfq3 = getURL();
			URLConnection VNiLcYZb = LRwfSfq3.openConnection();
			return VNiLcYZb.getInputStream();
		} catch (MalformedURLException wzj2Ab5L) {
			wzj2Ab5L.printStackTrace();
		} catch (IOException B373rQCu) {
			B373rQCu.printStackTrace();
		}
		return null;
	}

}