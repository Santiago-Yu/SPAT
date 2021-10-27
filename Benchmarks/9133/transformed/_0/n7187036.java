class n7187036 {
	@Override
	public void write(String N5w7qLlX, InputStream qqoSMtm8) throws PersistenceException {
		Writer UeGZsv82 = null;
		try {
			UeGZsv82 = new OutputStreamWriter(new FileOutputStream(N5w7qLlX), "utf-8");
			IOUtils.copy(qqoSMtm8, UeGZsv82);
		} catch (IOException hu2ueQIh) {
			LOGGER.error("fail to write file", hu2ueQIh);
			throw new PersistenceException(hu2ueQIh);
		} finally {
			if (UeGZsv82 != null) {
				try {
					UeGZsv82.close();
				} catch (IOException CTQfAPf8) {
					UeGZsv82 = null;
				}
			}
		}
	}

}