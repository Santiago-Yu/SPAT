class n22331867 {
	protected void removeMessage(ReplicationMessage message) {
		logger.info(String.format("remove replication message: %d", message.getId()));
		Connection conn = null;
		ConnectionProvider cp = null;
		PreparedStatement ps = null;
		try {
			SessionFactoryImplementor impl = (SessionFactoryImplementor) portalDao.getSessionFactory();
			cp = impl.getConnectionProvider();
			conn = cp.getConnection();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement("delete from light_replication_message where id=?");
			ps.setLong(1, message.getId());
			ps.executeUpdate();
			conn.commit();
			ps.close();
			conn.close();
		} catch (Exception e) {
			try {
				conn.rollback();
				ps.close();
				conn.close();
			} catch (Exception se) {
			}
		}
	}

}