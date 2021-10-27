class n1729635 {
	protected StringBuffer readURL(java.net.URL url) throws IOException {
		InputStreamReader reader = new InputStreamReader(url.openStream());
		StringBuffer result = new StringBuffer(4096);
		for (;;) {
			char portion[] = new char[4096];
			int numRead = reader.read(portion, 0, portion.length);
			if (numRead < 0)
				break;
			result.append(portion, 0, numRead);
		}
		dout("Read " + result.length() + " bytes.");
		return result;
	}

}