class n576161 {
	public boolean download(URL url, File file) {
		URLConnection conn = null;
		OutputStream out = null;
		InputStream in = null;
		try {
			conn = url.openConnection();
			out = new BufferedOutputStream(new FileOutputStream(file));
			byte[] buffer = new byte[4096];
			in = conn.getInputStream();
			long numWritten = 0;
			int numRead;
			while ((numRead = in.read(buffer)) != -1) {
				out.write(buffer, 0, numRead);
				numWritten += numRead;
			}
		} catch (Exception e) {
			System.out.println(e);
			return false;
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (out != null) {
					out.close();
				}
			} catch (IOException ioe) {
				return false;
			}
		}
		return true;
	}

}