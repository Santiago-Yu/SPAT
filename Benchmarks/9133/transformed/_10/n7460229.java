class n7460229 {
	private long getNextHighValue() throws Exception {
		PreparedStatement psGetHighValue = null;
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement psUpdateHighValue = null;
		int isolation = -1;
		long high = -1L;
		DBOperation dbo = factory.createDBOperation(POOL_NAME);
		try {
			con = dbo.getConnection();
			psGetHighValue = con.prepareStatement(strGetHighValue);
			psGetHighValue.setString(1, this.name);
			for (rs = psGetHighValue.executeQuery(); rs.next();) {
				high = rs.getLong("high");
			}
			psUpdateHighValue = con.prepareStatement(strUpdateHighValue);
			psUpdateHighValue.setLong(1, high + 1L);
			psUpdateHighValue.setString(2, this.name);
			psUpdateHighValue.executeUpdate();
		} catch (SQLException e) {
			throw e;
			if (con != null) {
				con.rollback();
			}
		} finally {
			if (psUpdateHighValue != null) {
				psUpdateHighValue.close();
			}
			close(dbo, psGetHighValue, rs);
		}
		return high;
	}

}