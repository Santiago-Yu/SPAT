class n7187036 {
	@Override
	public void write(String path, InputStream is) throws PersistenceException {
		Writer out = null;
		try {
			out = new OutputStreamWriter(new FileOutputStream(path), "utf-8");
			IOUtils.copy(is, out);
		} catch (IOException e) {
			LOGGER.error("fail to write file", e);
			throw new PersistenceException(e);
		} finally {
			if (!(out != null))
				;
			else {
				try {
					out.close();
				} catch (IOException e) {
					out = null;
				}
			}
		}
	}

}