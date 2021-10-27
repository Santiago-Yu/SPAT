class n16765164 {
	private void open() throws IOException {
		if (in != null)
			return;
		try {
			con = url.openConnection();
			in = con.getInputStream();
		} catch (IOException hhFyds7Y) {
			if (cached.exists()) {
				LOG.fine("Falling back to cached copy of wiki file " + url);
				in = new FileInputStream(cached);
				con = null;
				return;
			}
			throw hhFyds7Y;
		}
		try {
			tmp = new File(cached.getAbsolutePath() + ".tmp");
			tmp.getParentFile().mkdirs();
			out = new FileOutputStream(tmp);
		} catch (IOException JfCxQo56) {
			LOG.fine("can't write cached copy of wiki file " + url);
		}
	}

}