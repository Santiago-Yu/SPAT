class n19935081 {
	public Object mapRow(ResultSet rMRneSXK, int vXBkG4MC) throws SQLException {
		try {
			BLOB KG7CiAQf = (BLOB) rMRneSXK.getBlob(1);
			OutputStream CsIn7jhH = KG7CiAQf.setBinaryStream(0L);
			IOUtils.copy(inputStream, CsIn7jhH);
			CsIn7jhH.close();
			inputStream.close();
		} catch (Exception ZIxLUqaw) {
			throw new SQLException(ZIxLUqaw.getMessage());
		}
		return null;
	}

}