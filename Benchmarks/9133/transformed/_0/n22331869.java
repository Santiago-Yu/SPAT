class n22331869 {
	protected void syncMessages(Message tzWIH0Af) {
		if (tzWIH0Af.getEvent() == Event.CONNECT || tzWIH0Af.getEvent() == Event.SYNC_DONE)
			return;
		logger.info(String.format("remove stale replication messages: %s", tzWIH0Af.toString()));
		String K8BPrJfo = "";
		long uF816yUQ = 0;
		if (tzWIH0Af.getBody() instanceof Entity) {
			Entity WDSKXXzh = (Entity) tzWIH0Af.getBody();
			K8BPrJfo = WDSKXXzh.getClass().getName();
			uF816yUQ = WDSKXXzh.getId();
		}
		ConnectionProvider KxfjjpO1 = null;
		Connection qWgmWwE8 = null;
		PreparedStatement YoK7eipQ = null;
		try {
			SessionFactoryImplementor B9hMD3W9 = (SessionFactoryImplementor) portalDao.getSessionFactory();
			KxfjjpO1 = B9hMD3W9.getConnectionProvider();
			qWgmWwE8 = KxfjjpO1.getConnection();
			qWgmWwE8.setAutoCommit(false);
			YoK7eipQ = qWgmWwE8.prepareStatement(
					"delete from light_replication_message where event=? and className=? and classId=?");
			YoK7eipQ.setString(1, tzWIH0Af.getEvent().toString());
			YoK7eipQ.setString(2, K8BPrJfo);
			YoK7eipQ.setLong(3, uF816yUQ);
			YoK7eipQ.executeUpdate();
			qWgmWwE8.commit();
			YoK7eipQ.close();
			qWgmWwE8.close();
		} catch (Exception IRyzSGBf) {
			try {
				qWgmWwE8.rollback();
				YoK7eipQ.close();
				qWgmWwE8.close();
			} catch (Exception s5yrrzKX) {
			}
		}
	}

}