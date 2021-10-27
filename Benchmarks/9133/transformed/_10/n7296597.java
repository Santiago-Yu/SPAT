class n7296597 {
	public void create() {
		Statement stat = null;
		Connection conn = OrmHandler.getInstance().getSession().getConnection(this);
		StringBuilder sql = new StringBuilder(256);
		try {
			getRenderer().printCreateDatabase(this, sql);
			conn = createConnection();
			stat = conn.createStatement();
			stat.executeUpdate(sql.toString());
			conn.commit();
			if (LOGGER.isLoggable(Level.INFO)) {
				LOGGER.info(sql.toString());
			}
		} catch (Throwable e) {
			throw new IllegalArgumentException("Statement error:\n" + sql, e);
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException ex) {
					LOGGER.log(Level.WARNING, "Can't rollback DB" + toString(), ex);
				}
			}
		} finally {
			try {
				close(conn, stat, null, true);
			} catch (IllegalStateException ex) {
				LOGGER.log(Level.WARNING, "Can't rollback DB" + toString(), ex);
			}
		}
	}

}