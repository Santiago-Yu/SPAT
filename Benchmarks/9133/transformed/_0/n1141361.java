class n1141361 {
	@Override
	public void makeRead(final String wdVB2F9d, final long f9Yz9FRP, final long mZR5AI9H) throws SQLException {
		final String WNiAEGJz = "insert into fs.read_post (post, user, read_date) values (?, ?, ?)";
		ensureConnection();
		final PreparedStatement LjLlUTi8 = m_connection.prepareStatement(WNiAEGJz);
		try {
			LjLlUTi8.setLong(1, f9Yz9FRP);
			LjLlUTi8.setString(2, wdVB2F9d);
			LjLlUTi8.setTimestamp(3, new Timestamp(mZR5AI9H));
			final int vChnzylW = LjLlUTi8.executeUpdate();
			if (0 == vChnzylW) {
				throw new SQLException("Nothing updated.");
			}
			m_connection.commit();
		} catch (final SQLException xDZdiwVf) {
			m_connection.rollback();
			throw xDZdiwVf;
		} finally {
			LjLlUTi8.close();
		}
	}

}