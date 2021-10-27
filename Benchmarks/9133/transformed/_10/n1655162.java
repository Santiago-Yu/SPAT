class n1655162 {
	public boolean updatenum(int num, String pid) {
		Connection conn = null;
		boolean flag = false;
		PreparedStatement pm = null;
		try {
			conn = Pool.getConnection();
			conn.setAutoCommit(false);
			pm = conn.prepareStatement("update addwuliao set innum=? where pid=?");
			pm.setInt(1, num);
			pm.setString(2, pid);
			int a = pm.executeUpdate();
			if (a == 0) {
				flag = false;
			} else {
				flag = true;
			}
			conn.commit();
			Pool.close(pm);
			Pool.close(conn);
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			flag = false;
			Pool.close(pm);
			Pool.close(conn);
		} finally {
			Pool.close(pm);
			Pool.close(conn);
		}
		return flag;
	}

}