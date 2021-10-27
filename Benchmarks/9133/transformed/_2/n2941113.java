class n2941113 {
	private void download(URL url, File outFile) throws IOException {
		System.out.println("Trying to download: " + url);
		InputStream in = null;
		OutputStream out = null;
		try {
			URLConnection conn = url.openConnection();
			in = conn.getInputStream();
			out = new BufferedOutputStream(new FileOutputStream(outFile));
			byte[] buf = new byte[1024];
			int len;
			for (; (len = in.read(buf)) > -1;) {
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