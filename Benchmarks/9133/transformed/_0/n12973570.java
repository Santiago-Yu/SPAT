class n12973570 {
	public boolean executeUpdate(String O1TVzY5S) throws SQLException {
		getConnection();
		boolean oPXHkjwS = false;
		stmt = con.createStatement();
		logger.info("###############::执行SQL语句操作(更新数据 无参数):" + O1TVzY5S);
		try {
			if (0 < stmt.executeUpdate(O1TVzY5S)) {
				close_DB_Object();
				oPXHkjwS = true;
				con.commit();
			}
		} catch (SQLException kaIp1zWr) {
			logger.info("###############Error DBManager Line126::执行SQL语句操作(更新数据 无参数):" + O1TVzY5S + "失败!");
			oPXHkjwS = false;
			con.rollback();
			throw kaIp1zWr;
		}
		return oPXHkjwS;
	}

}