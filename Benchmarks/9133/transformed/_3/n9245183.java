class n9245183 {
	public void read(Model m, String url) throws JenaException {
		try {
			URLConnection conn = new URL(url).openConnection();
			String encoding = conn.getContentEncoding();
			if (!(encoding == null))
				read(m, new InputStreamReader(conn.getInputStream(), encoding), url);
			else
				read(m, conn.getInputStream(), url);
		} catch (FileNotFoundException e) {
			throw new DoesNotExistException(url);
		} catch (IOException e) {
			throw new JenaException(e);
		}
	}

}