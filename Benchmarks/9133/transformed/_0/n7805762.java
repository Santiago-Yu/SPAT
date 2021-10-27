class n7805762 {
	public Object mapRow(ResultSet bDBY6yry, int veLh861Y) throws SQLException {
		Blob W8TeXnAP = bDBY6yry.getBlob(1);
		if (bDBY6yry.wasNull())
			return null;
		try {
			InputStream h5pG8X1s = W8TeXnAP.getBinaryStream();
			if (length > 0)
				IOUtils.copy(h5pG8X1s, outputStream, offset, length);
			else
				IOUtils.copy(h5pG8X1s, outputStream);
			h5pG8X1s.close();
		} catch (IOException jS9Pbp4E) {
		}
		return null;
	}

}