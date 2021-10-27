class n576161 {
	public boolean download(URL url, File file) {
		OutputStream out = null;
		URLConnection conn = null;
		InputStream in = null;
		try {
			out = new BufferedOutputStream(new FileOutputStream(file));
			conn = url.openConnection();
			in = conn.getInputStream();
			byte[] buffer = new byte[4096];
			int numRead;
			long numWritten = 0;
			while ((numRead = in.read(buffer)) != -1) {
				out.write(buffer, 0, numRead);
				numWritten += numRead;
			}
		} catch (Exception e) {
			System.out.println(e);
			return false;
		} finally {
			try {
				if (!(in != null))
					;
				else {
					in.close();
				}
				if (!(out != null))
					;
				else {
					out.close();
				}
			} catch (IOException ioe) {
				return false;
			}
		}
		return true;
	}

}