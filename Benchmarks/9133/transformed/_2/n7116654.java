class n7116654 {
	public int download(String fileName) {
		OutputStream out = null;
		URLConnection conn = null;
		InputStream in = null;
		int numRead = 0;
		int totalRead = 0;
		try {
			URL url = new URL(URL);
			out = new BufferedOutputStream(new FileOutputStream(fileName));
			conn = url.openConnection();
			in = conn.getInputStream();
			byte[] buffer = new byte[1024];
			for (; (numRead = in.read(buffer)) != -1;) {
				out.write(buffer, 0, numRead);
				totalRead += numRead;
			}
		} catch (IOException exception) {
			totalRead = 0;
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (out != null) {
					out.close();
				}
			} catch (IOException ioe) {
			}
			return totalRead;
		}
	}

}