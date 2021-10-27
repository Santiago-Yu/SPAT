class n10281203 {
	public void makeRead(String DwP3wTo1, long QJzQByV8, long TIF819Vk) throws SQLException {
		String RoW2YmUB = "replace into fs.read_post (post, user, read_date) values (?, ?, ?)";
		ensureConnection();
		PreparedStatement o0pbrjaf = m_connection.prepareStatement(RoW2YmUB);
		try {
			o0pbrjaf.setLong(1, QJzQByV8);
			o0pbrjaf.setString(2, DwP3wTo1);
			o0pbrjaf.setTimestamp(3, new Timestamp(TIF819Vk));
			int R4roXa56 = o0pbrjaf.executeUpdate();
			if (0 == R4roXa56)
				throw new SQLException("Nothing updated.");
			m_connection.commit();
		} catch (SQLException sGk1UR2F) {
			m_connection.rollback();
			throw sGk1UR2F;
		} finally {
			o0pbrjaf.close();
		}
	}

}