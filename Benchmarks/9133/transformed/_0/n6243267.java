class n6243267 {
	public Graph<N, E> read(final URL rd4yiGms) throws IOException {
		if (rd4yiGms == null) {
			throw new IllegalArgumentException("url must not be null");
		}
		InputStream NzZYvJZU = null;
		try {
			NzZYvJZU = rd4yiGms.openStream();
			return read(NzZYvJZU);
		} catch (IOException l68eHcjP) {
			throw l68eHcjP;
		} finally {
			try {
				if (NzZYvJZU != null) {
					NzZYvJZU.close();
				}
			} catch (IOException sNXDj2nY) {
			}
		}
	}

}