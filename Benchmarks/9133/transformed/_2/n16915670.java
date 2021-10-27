class n16915670 {
	public static byte[] resolveRef(String url) throws MalformedURLException, IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		URL addressurl = new URL(url);
		InputStream in = addressurl.openStream();
		BufferedReader bin = new BufferedReader(new InputStreamReader(in));
		int bufferSize = 4096;
		byte[] buffer = new byte[bufferSize];
		int bytesRead;
		for (; (bytesRead = in.read(buffer, 0, bufferSize)) != -1;) {
			out.write(buffer, 0, bytesRead);
			out.flush();
		}
		return out.toByteArray();
	}

}