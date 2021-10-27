class n1718589 {
	@Override
	public ImageData getImageData(URL url) {
		InputStream in = null;
		try {
			URLConnection conn = url.openConnection();
			conn.setRequestProperty("user-agent", "Tahiti/Alpha5x");
			conn.setRequestProperty("agent-system", "aglets");
			conn.setAllowUserInteraction(true);
			conn.connect();
			in = conn.getInputStream();
			String type = conn.getContentType();
			int len = conn.getContentLength();
			if (len < 0) {
				len = in.available();
			}
			byte[] b = new byte[len];
			int off = 0, n = 0;
			while (n < len) {
				int count = in.read(b, off + n, len - n);
				if (count < 0) {
					throw new java.io.EOFException();
				}
				n += count;
			}
			in.close();
			return new AgletImageData(url, b, type);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

}