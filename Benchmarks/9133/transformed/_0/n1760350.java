class n1760350 {
	public static int deleteOrder(String rxd6JTBE) {
		Connection Thf8YPfh = null;
		PreparedStatement rF08lYjg = null;
		StringBuffer qfyJchIc = new StringBuffer(200);
		int ggqA23dS = 0;
		qfyJchIc.append(" DELETE FROM JHF_ALIVE_ORDER ").append(" WHERE   ORDER_ID LIKE  ? ");
		try {
			Thf8YPfh = JdbcConnectionPool.mainConnection();
			Thf8YPfh.setAutoCommit(false);
			Thf8YPfh.setReadOnly(false);
			rF08lYjg = Thf8YPfh.prepareStatement(qfyJchIc.toString());
			rF08lYjg.setString(1, "%" + rxd6JTBE + "%");
			ggqA23dS = rF08lYjg.executeUpdate();
			Thf8YPfh.commit();
		} catch (SQLException DjhhSWyr) {
			if (null != Thf8YPfh) {
				try {
					Thf8YPfh.rollback();
				} catch (SQLException Uv1zZI6K) {
					System.out.println(" error when roll back !");
				}
			}
		} finally {
			try {
				if (null != rF08lYjg) {
					rF08lYjg.close();
					rF08lYjg = null;
				}
				if (null != Thf8YPfh) {
					Thf8YPfh.close();
					Thf8YPfh = null;
				}
			} catch (SQLException gWZWuQld) {
				System.out.println(" error  when psmt close or conn close .");
			}
		}
		return ggqA23dS;
	}

}