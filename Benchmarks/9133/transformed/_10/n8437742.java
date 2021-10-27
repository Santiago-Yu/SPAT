class n8437742 {
	protected void copy(URL url, File file) throws IOException {
		FileOutputStream out = null;
		InputStream in = null;
		try {
			out = new FileOutputStream(file);
			in = url.openStream();
			IOUtils.copy(in, out);
		} finally {
			if (out != null) {
				out.close();
			}
			if (in != null) {
				in.close();
			}
		}
	}

}