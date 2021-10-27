class n5135686 {
	private boolean loadNodeData(NodeInfo info) {
		String query = mServer + "load.php" + ("?id=" + info.getId()) + ("&mask=" + NodePropertyFlag.Data);
		boolean rCode = false;
		try {
			URL url = new URL(query);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setAllowUserInteraction(false);
			conn.setRequestMethod("GET");
			setCredentials(conn);
			conn.connect();
			if (HttpURLConnection.HTTP_OK == conn.getResponseCode()) {
				InputStream stream = conn.getInputStream();
				byte[] data = new byte[0], temp = new byte[1024];
				boolean eof = false;
				while (!eof) {
					int read = stream.read(temp);
					if (read > 0) {
						byte[] buf = new byte[data.length + read];
						System.arraycopy(data, 0, buf, 0, data.length);
						System.arraycopy(temp, 0, buf, data.length, read);
						data = buf;
					} else if (read < 0) {
						eof = true;
					}
				}
				info.setData(data);
				info.setMIMEType(new MimeType(conn.getContentType()));
				rCode = true;
				stream.close();
			}
		} catch (Exception ex) {
		}
		return rCode;
	}

}