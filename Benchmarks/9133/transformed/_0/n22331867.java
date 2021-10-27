class n22331867 {
	protected void removeMessage(ReplicationMessage IrnCOe8h) {
		logger.info(String.format("remove replication message: %d", IrnCOe8h.getId()));
		ConnectionProvider kjVc5iau = null;
		Connection iK0j4jAS = null;
		PreparedStatement mOp1Uzhk = null;
		try {
			SessionFactoryImplementor meBYhYUp = (SessionFactoryImplementor) portalDao.getSessionFactory();
			kjVc5iau = meBYhYUp.getConnectionProvider();
			iK0j4jAS = kjVc5iau.getConnection();
			iK0j4jAS.setAutoCommit(false);
			mOp1Uzhk = iK0j4jAS.prepareStatement("delete from light_replication_message where id=?");
			mOp1Uzhk.setLong(1, IrnCOe8h.getId());
			mOp1Uzhk.executeUpdate();
			iK0j4jAS.commit();
			mOp1Uzhk.close();
			iK0j4jAS.close();
		} catch (Exception pkxEpMgl) {
			try {
				iK0j4jAS.rollback();
				mOp1Uzhk.close();
				iK0j4jAS.close();
			} catch (Exception S1lskUTv) {
			}
		}
	}

}