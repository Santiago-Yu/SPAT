class n6926155 {
	public boolean download(String address, String localFileName) {
		URLConnection conn = null;
		OutputStream out = null;
		InputStream in = null;
		try {
			out = new BufferedOutputStream(new FileOutputStream(localFileName));
			URL url = new URL(address);
			conn = url.openConnection();
			byte[] buffer = new byte[1024];
			in = conn.getInputStream();
			long numWritten = 0;
			int numRead;
			while ((numRead = in.read(buffer)) != -1) {
				out.write(buffer, 0, numRead);
				numWritten += numRead;
			}
			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
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
		}
		return false;
	}

}