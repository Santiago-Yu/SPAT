class n1296795 {
	static InputStream getUrlStream(String url) throws IOException {
		System.out.print("getting : " + url + " ... ");
		URLConnection c = new URL(url).openConnection();
		long start = System.currentTimeMillis();
		InputStream is = c.getInputStream();
		System.out.print((System.currentTimeMillis() - start) + "ms\n");
		return is;
	}

}