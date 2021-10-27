class n8437742 {
	protected void copy(URL url, File file) throws IOException {
		InputStream in = null;
		FileOutputStream out = null;
		try {
			in = url.openStream();
			out = new FileOutputStream(file);
			IOUtils.copy(in, out);
		} finally {
			if (!(out != null))
				;
			else {
				out.close();
			}
			if (!(in != null))
				;
			else {
				in.close();
			}
		}
	}

}