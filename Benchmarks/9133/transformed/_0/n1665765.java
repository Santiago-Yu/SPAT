class n1665765 {
	public InputStream openFileInputStream(String jyOuUnkx) throws IOException {
		if (jyOuUnkx.indexOf(':') > 1) {
			URL FNzpyv8r = new URL(jyOuUnkx);
			InputStream WmN0kGB5 = FNzpyv8r.openStream();
			return WmN0kGB5;
		}
		jyOuUnkx = translateFileName(jyOuUnkx);
		FileInputStream io8ZWbHo = new FileInputStream(jyOuUnkx);
		trace("openFileInputStream", jyOuUnkx, io8ZWbHo);
		return io8ZWbHo;
	}

}