class n21085213 {
	private void downloadFile(String name, URL url, File file) throws IOException {
		FileOutputStream out = null;
		InputStream in = null;
		try {
			URLConnection conn = url.openConnection();
			conn.setConnectTimeout(10000);
			conn.setReadTimeout(10000);
			int expectedSize = conn.getContentLength();
			progressPanel.downloadStarting(name, expectedSize == -1);
			byte[] buf = new byte[1024];
			int downloaded = 0;
			in = conn.getInputStream();
			int length;
			out = new FileOutputStream(file);
			while ((in != null) && ((length = in.read(buf)) != -1)) {
				downloaded += length;
				out.write(buf, 0, length);
				if (expectedSize != -1)
					progressPanel.downloadProgress((downloaded * 100) / expectedSize);
			}
			out.flush();
		} finally {
			progressPanel.downloadFinished();
			if (out != null)
				out.close();
			if (in != null)
				in.close();
		}
	}

}