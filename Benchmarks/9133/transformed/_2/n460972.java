class n460972 {
	public static void main(String[] args) throws MalformedURLException, IOException {
		URL url = new URL("https://imo.im/");
		URLConnection con = url.openConnection();
		InputStream is = con.getInputStream();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len;
		for (; ((len = is.read(buffer)) >= 0);) {
			out.write(buffer, 0, len);
		}
		out.flush();
		System.out.println(out.toString());
	}

}