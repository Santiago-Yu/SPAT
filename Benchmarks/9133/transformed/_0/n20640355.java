class n20640355 {
	public void downloadFile(OutputStream RfUA8Uxv, int NoiARQow) throws IOException, SQLException {
		Connection pghL79FM = null;
		try {
			pghL79FM = ds.getConnection();
			Guard.checkConnectionNotNull(pghL79FM);
			PreparedStatement RaSSJA6d = pghL79FM.prepareStatement("select * from FILE_BODIES where file_id=?");
			RaSSJA6d.setInt(1, NoiARQow);
			ResultSet Cf17gM0Q = RaSSJA6d.executeQuery();
			if (!Cf17gM0Q.next()) {
				throw new FileNotFoundException("File with id=" + NoiARQow + " not found!");
			}
			Blob scz0g7Xt = Cf17gM0Q.getBlob("data");
			InputStream gAT9wMlz = scz0g7Xt.getBinaryStream();
			IOUtils.copyLarge(gAT9wMlz, RfUA8Uxv);
		} finally {
			JdbcDaoHelper.safeClose(pghL79FM, log);
		}
	}

}