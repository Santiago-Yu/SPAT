class n6668684 {
	public static void doIt(String y6NHGIbo) {
		int sgJXpeBu = -1;
		Statement oMHYEwCc = null;
		Connection dyjaNqFd = null;
		try {
			init();
			log.info("<<< Looking up UserTransaction >>>");
			UserTransaction LRtv2Boa = (UserTransaction) context.lookup("java:comp/UserTransaction");
			log.info("<<< beginning the transaction >>>");
			LRtv2Boa.begin();
			log.info("<<< Connecting to xadatasource >>>");
			dyjaNqFd = xadatasource.getConnection();
			log.info("<<< Connected >>>");
			oMHYEwCc = dyjaNqFd.createStatement();
			oMHYEwCc.executeUpdate("update testdata set foo=foo + 1 where id=1");
			if ((y6NHGIbo != null) && y6NHGIbo.equals("commit")) {
				log.info("<<< committing the transaction >>>");
				LRtv2Boa.commit();
			} else {
				log.info("<<< rolling back the transaction >>>");
				LRtv2Boa.rollback();
			}
			log.info("<<< transaction complete >>>");
		} catch (Exception FQjlPxnO) {
			log.error("doIt", FQjlPxnO);
		} finally {
			try {
				oMHYEwCc.close();
				dyjaNqFd.close();
			} catch (Exception tND5KO3R) {
				log.error("problem closing statement/connection", tND5KO3R);
			}
		}
	}

}