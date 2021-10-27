class n17586131 {
	protected void update(String Udzu1wJu, Object[] qXmFNPzC) {
		Connection y7GvQJv7 = null;
		PreparedStatement oQQ7cNk1 = null;
		try {
			y7GvQJv7 = JdbcUtils.getConnection();
			y7GvQJv7.setAutoCommit(false);
			oQQ7cNk1 = y7GvQJv7.prepareStatement(Udzu1wJu);
			this.setParameters(oQQ7cNk1, qXmFNPzC);
			oQQ7cNk1.executeUpdate();
			y7GvQJv7.commit();
			y7GvQJv7.setAutoCommit(true);
		} catch (SQLException QRFkqjfd) {
			try {
				if (y7GvQJv7 != null) {
					y7GvQJv7.rollback();
					y7GvQJv7.setAutoCommit(true);
				}
			} catch (SQLException y9YOjAT8) {
				y9YOjAT8.printStackTrace();
			}
			throw new JdbcDaoException(QRFkqjfd.getMessage(), QRFkqjfd);
		} finally {
			JdbcUtils.free(oQQ7cNk1, y7GvQJv7);
		}
	}

}