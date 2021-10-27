class n13999345 {
	private void writeFile(String name, URL url) throws IOException {
		Location location = resourcesHome.resolve(name);
		InputStream input = url.openStream();
		OutputStream output = location.getOutputStream();
		try {
			byte buf[] = new byte[1024];
			int read;
			while (true) {
				read = input.read(buf);
				if (-1 == read)
					break;
				output.write(buf, 0, read);
			}
		} finally {
			try {
				input.close();
			} finally {
				output.close();
			}
		}
	}

}