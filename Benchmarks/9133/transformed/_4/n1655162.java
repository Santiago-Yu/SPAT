class n1655162 {
	public boolean updatenum(int num, String pid) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pm = null;
		try {
			conn = Pool.getConnection();
			conn.setAutoCommit(false);
			pm = conn.prepareStatement("update addwuliao set innum=? where pid=?");
			pm.setInt(1, num);
			pm.setString(2, pid);
			int a = pm.executeUpdate();
			flag = (a == 0) ? false : true;
			conn.commit();
			Pool.close(pm);
			Pool.close(conn);
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			Pool.close(pm);
			Pool.close(conn);
		} finally {
			Pool.close(pm);
			Pool.close(conn);
		}
		return flag;
	}

}