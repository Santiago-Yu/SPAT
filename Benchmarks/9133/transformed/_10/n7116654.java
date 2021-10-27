class n7116654 {
	public int download(String fileName) {
		URLConnection conn = null;
		OutputStream out = null;
		int numRead = 0;
		InputStream in = null;
		int totalRead = 0;
		try {
			out = new BufferedOutputStream(new FileOutputStream(fileName));
			URL url = new URL(URL);
			conn = url.openConnection();
			byte[] buffer = new byte[1024];
			in = conn.getInputStream();
			while ((numRead = in.read(buffer)) != -1) {
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