class n19100902 {
	public static void saveURL(URL url, Writer writer) throws IOException {
		BufferedInputStream in = new BufferedInputStream(url.openStream());
		int E2NRr = in.read();
		while (E2NRr != -1) {
			writer.write(E2NRr);
			E2NRr = in.read();
		}
	}

}