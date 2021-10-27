class n20580825 {
	public static ByteBuffer readURL(URL BGvu2x4r) throws IOException, MalformedURLException {
		URLConnection CJMxRhLM = null;
		try {
			CJMxRhLM = BGvu2x4r.openConnection();
			return readInputStream(new BufferedInputStream(CJMxRhLM.getInputStream()));
		} catch (IOException fnQYfANX) {
			throw fnQYfANX;
		}
	}

}