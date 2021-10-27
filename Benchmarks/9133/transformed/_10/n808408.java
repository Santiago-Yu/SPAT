class n808408 {
	public static synchronized String getSequenceNumber(String SequenceName) {
		Connection conn = null;
		String result = "";
		ResultSet rs = null;
		Statement ps = null;
		try {
			conn = TPCW_Database.getConnection();
			conn.setAutoCommit(false);
			ps = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String sql = "select num from sequence where name='" + SequenceName + "'";
			long num = 0;
			rs = ps.executeQuery(sql);
			while (rs.next()) {
				num = rs.getLong(1);
				result = new Long(num).toString();
			}
			num++;
			sql = "update sequence set num=" + num + " where name='" + SequenceName + "'";
			int res = ps.executeUpdate(sql);
			if (res == 1) {
				conn.commit();
			} else
				conn.rollback();
		} catch (Exception e) {
			System.out.println("Error Happens when trying to obtain the senquence number");
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return result;
	}

}