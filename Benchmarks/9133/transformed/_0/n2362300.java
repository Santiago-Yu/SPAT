class n2362300 {
	static void test() throws SQLException {
		Connection zFiJyruZ = null;
		Statement wYCumHj0 = null;
		ResultSet TSvRTVqG = null;
		try {
			zFiJyruZ = JdbcUtils.getConnection();
			zFiJyruZ.setAutoCommit(false);
			wYCumHj0 = zFiJyruZ.createStatement();
			String UJ15rz52 = "update user set money=money-10 where id=15";
			wYCumHj0.executeUpdate(UJ15rz52);
			UJ15rz52 = "select money from user where id=13";
			TSvRTVqG = wYCumHj0.executeQuery(UJ15rz52);
			float YqPWRHnt = 0.0f;
			while (TSvRTVqG.next()) {
				YqPWRHnt = TSvRTVqG.getFloat("money");
			}
			if (YqPWRHnt > 1000)
				throw new RuntimeException("?????????????");
			UJ15rz52 = "update user set money=money+10 where id=13";
			wYCumHj0.executeUpdate(UJ15rz52);
			zFiJyruZ.commit();
		} catch (SQLException OMzv5YuI) {
			if (zFiJyruZ != null)
				zFiJyruZ.rollback();
			throw OMzv5YuI;
		} finally {
			JdbcUtils.free(TSvRTVqG, wYCumHj0, zFiJyruZ);
		}
	}

}