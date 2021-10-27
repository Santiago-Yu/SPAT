class n5135686 {
	private boolean loadNodeData(NodeInfo info) {
		boolean rCode = false;
		String query = mServer + "load.php" + ("?id=" + info.getId()) + ("&mask=" + NodePropertyFlag.Data);
		try {
			URL url = new URL(query);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setAllowUserInteraction(false);
			conn.setRequestMethod("GET");
			setCredentials(conn);
			conn.connect();
			if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
				byte[] data = new byte[0], temp = new byte[1024];
				InputStream stream = conn.getInputStream();
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