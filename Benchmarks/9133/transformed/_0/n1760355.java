class n1760355 {
	public static int deleteHedgeCustTrade() {
		Connection Kb0NTsKw = null;
		PreparedStatement BNByH0Aj = null;
		StringBuffer Nh5vKjnL = new StringBuffer(200);
		int JzQe7p9y = 0;
		Nh5vKjnL.append(" DELETE FROM JHF_HEDGE_CUSTTRADE ");
		try {
			Kb0NTsKw = JdbcConnectionPool.mainConnection();
			Kb0NTsKw.setAutoCommit(false);
			Kb0NTsKw.setReadOnly(false);
			BNByH0Aj = Kb0NTsKw.prepareStatement(Nh5vKjnL.toString());
			JzQe7p9y = BNByH0Aj.executeUpdate();
			Kb0NTsKw.commit();
		} catch (SQLException fZRBACUw) {
			if (null != Kb0NTsKw) {
				try {
					Kb0NTsKw.rollback();
				} catch (SQLException v9tpsdBs) {
					System.out.println(" error when roll back !");
				}
			}
		} finally {
			try {
				if (null != BNByH0Aj) {
					BNByH0Aj.close();
					BNByH0Aj = null;
				}
				if (null != Kb0NTsKw) {
					Kb0NTsKw.close();
					Kb0NTsKw = null;
				}
			} catch (SQLException emNtGdit) {
				System.out.println(" error  when psmt close or conn close .");
			}
		}
		return JzQe7p9y;
	}

}