class n460972 {
	public static void main(String[] args) throws MalformedURLException, IOException {
		URL url = new URL("https://imo.im/");
		URLConnection con = url.openConnection();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		InputStream is = con.getInputStream();
		int len;
		byte[] buffer = new byte[1024];
		while (((len = is.read(buffer)) >= 0)) {
			out.write(buffer, 0, len);
		}
		out.flush();
		System.out.println(out.toString());
	}

}