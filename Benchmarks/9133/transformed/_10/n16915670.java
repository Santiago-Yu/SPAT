class n16915670 {
	public static byte[] resolveRef(String url) throws MalformedURLException, IOException {
		URL addressurl = new URL(url);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		InputStream in = addressurl.openStream();
		int bufferSize = 4096;
		BufferedReader bin = new BufferedReader(new InputStreamReader(in));
		int bytesRead;
		byte[] buffer = new byte[bufferSize];
		while ((bytesRead = in.read(buffer, 0, bufferSize)) != -1) {
			out.write(buffer, 0, bytesRead);
			out.flush();
		}
		return out.toByteArray();
	}

}