class n1655163 {
	public boolean delwuliao(String pid) {
		Connection conn = null;
		boolean flag = false;
		PreparedStatement pm = null;
		try {
			conn = Pool.getConnection();
			conn.setAutoCommit(false);
			pm = conn.prepareStatement("delete from addwuliao where pid=?");
			pm.setString(1, pid);
			int x = pm.executeUpdate();
			if (x == 0) {
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