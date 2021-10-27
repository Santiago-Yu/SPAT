class n21139907 {
	public void fetchPublicContent(int id) throws IOException {
		String fileName = FILE_NAME_PREFIX + id + ".xml";
		File file = new File(fileName);
		if (file.exists()) {
			System.out.println("user: " + id + " not fetched because it already exists");
			return;
		}
		URL url = new URL("http://twitter.com/statuses/followers.xml?id=" + id);
		OutputStream out = new FileOutputStream(file, false);
		URLConnection conn = url.openConnection();
		int i = 0;
		InputStream in = conn.getInputStream();
		while ((i = in.read()) != -1) {
			out.write(i);
		}
		in.close();
		out.close();
	}

}