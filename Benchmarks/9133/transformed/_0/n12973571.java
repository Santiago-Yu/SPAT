class n12973571 {
	public boolean executeUpdate(String LQIJ4D3l, HashMap<Integer, Object> FfMucrC3)
			throws SQLException, ClassNotFoundException {
		getConnection();
		boolean NGySFkVv = false;
		try {
			pstmt = con.prepareStatement(LQIJ4D3l);
			setParamet(pstmt, FfMucrC3);
			logger.info("###############::执行SQL语句操作(更新数据 有参数):" + LQIJ4D3l);
			if (0 < pstmt.executeUpdate()) {
				close_DB_Object();
				NGySFkVv = true;
				con.commit();
			}
		} catch (SQLException F7MXb6x2) {
			logger.info("###############Error DBManager Line121::执行SQL语句操作(更新数据 无参数):" + LQIJ4D3l + "失败!");
			NGySFkVv = false;
			con.rollback();
			throw F7MXb6x2;
		} catch (ClassNotFoundException n0Th3mcC) {
			logger.info("###############Error DBManager Line152::执行SQL语句操作(更新数据 无参数):" + LQIJ4D3l + "失败! 参数设置类型错误!");
			con.rollback();
			throw n0Th3mcC;
		}
		return NGySFkVv;
	}

}