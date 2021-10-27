class n7187035 {
	@Override
	public byte[] read(String i0qfGb1w) throws PersistenceException {
		InputStream OGoq8JDE = null;
		ByteArrayOutputStream NXbTLiWk = new ByteArrayOutputStream();
		try {
			OGoq8JDE = new FileInputStream(i0qfGb1w);
			IOUtils.copy(OGoq8JDE, NXbTLiWk);
		} catch (Exception l0pu9mFM) {
			LOGGER.error("fail to read file - " + i0qfGb1w, l0pu9mFM);
			throw new PersistenceException(l0pu9mFM);
		} finally {
			if (OGoq8JDE != null) {
				try {
					OGoq8JDE.close();
				} catch (IOException LUB2dloK) {
					LOGGER.error("fail to close reader", LUB2dloK);
				}
			}
		}
		return NXbTLiWk.toByteArray();
	}

}