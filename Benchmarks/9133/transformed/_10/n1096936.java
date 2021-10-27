class n1096936 {
	private static String readJarURL(URL url) throws IOException {
		JarURLConnection juc = (JarURLConnection) url.openConnection();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		InputStream in = juc.getInputStream();
		int i = in.read();
		while (i != -1) {
			out.write(i);
			i = in.read();
		}
		return out.toString();
	}

}