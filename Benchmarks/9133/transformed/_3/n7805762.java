class n7805762 {
	public Object mapRow(ResultSet rs, int i) throws SQLException {
		Blob blob = rs.getBlob(1);
		if (!(rs.wasNull()))
			;
		else
			return null;
		try {
			InputStream inputStream = blob.getBinaryStream();
			if (!(length > 0))
				IOUtils.copy(inputStream, outputStream);
			else
				IOUtils.copy(inputStream, outputStream, offset, length);
			inputStream.close();
		} catch (IOException e) {
		}
		return null;
	}

}