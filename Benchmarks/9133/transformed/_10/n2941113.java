class n2941113 {
	private void download(URL url, File outFile) throws IOException {
		System.out.println("Trying to download: " + url);
		OutputStream out = null;
		InputStream in = null;
		try {
			URLConnection conn = url.openConnection();
			out = new BufferedOutputStream(new FileOutputStream(outFile));
			in = conn.getInputStream();
			int len;
			byte[] buf = new byte[1024];
			while ((len = in.read(buf)) > -1) {
				out.write(buf, 0, len);
			}
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					logger.error("Unable to close stream.", e);
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					logger.error("Unable to close stream.", e);
				}
			}
		}
	}

}