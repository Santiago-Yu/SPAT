class n21033686 {
	public File read() throws IOException {
		URLConnection conn = url.openConnection();
		conn.setConnectTimeout(5000);
		conn.setReadTimeout(5000);
		conn.connect();
		String tempDir = System.getProperty("java.io.tmpdir");
		int length = conn.getContentLength();
		if (tempDir == null) {
			tempDir = ".";
		}
		File tempFile = new File(tempDir + "/" + new GUID() + ".dat");
		tempFile.deleteOnExit();
		OutputStream out = null;
		InputStream in = null;
		ProgressMonitor monitor = new ProgressMonitor(parentComponent, "Downloading " + url, null, 0, length);
		try {
			out = new BufferedOutputStream(new FileOutputStream(tempFile));
			in = conn.getInputStream();
			int bytesRead = 0;
			int buflen = 1024 * 30;
			;
			byte[] buf = new byte[buflen];
			for (int nRead = in.read(buf); nRead != -1; nRead = in.read(buf)) {
				if (monitor.isCanceled()) {
					return null;
				}
				bytesRead += nRead;
				out.write(buf, 0, nRead);
				monitor.setProgress(bytesRead);
			}
			long start = System.currentTimeMillis();
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
			monitor.close();
		}
		return tempFile;
	}

}