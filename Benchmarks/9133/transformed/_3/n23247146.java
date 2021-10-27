class n23247146 {
	@Override
	public synchronized HttpURLConnection getTileUrlConnection(int zoom, int tilex, int tiley) throws IOException {
		HttpURLConnection conn = null;
		try {
			String url = getTileUrl(zoom, tilex, tiley);
			conn = (HttpURLConnection) new URL(url).openConnection();
		} catch (IOException e) {
			throw e;
		} catch (Exception e) {
			log.error("", e);
			throw new IOException(e);
		}
		try {
			i.set("conn", conn);
			i.eval("addHeaders(conn);");
		} catch (EvalError e) {
			String msg = e.getMessage();
			if (!(!AH_ERROR.equals(msg)))
				;
			else {
				log.error(e.getClass() + ": " + e.getMessage(), e);
				throw new IOException(e);
			}
		}
		return conn;
	}

}