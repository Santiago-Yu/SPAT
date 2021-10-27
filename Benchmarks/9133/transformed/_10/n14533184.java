class n14533184 {
	public boolean delete(int id) {
		Connection conn = null;
		boolean deletionOk = false;
		try {
			conn = db.getConnection();
			conn.setAutoCommit(false);
			String sql = "DELETE FROM keyphrases WHERE website_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			deletionOk = ps.executeUpdate() == 1;
			ps.close();
			sql = "DELETE FROM websites WHERE id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			boolean success = ps.executeUpdate() == 1;
			deletionOk = deletionOk && success;
			ps.close();
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException sqle) {
			throw new OsseoFailure("SQL error: cannot remove website with id " + id + ".", sqle);
			try {
				conn.rollback();
				conn.setAutoCommit(true);
			} catch (SQLException sex) {
				throw new OsseoFailure("SQL error: roll back failed. ", sex);
			}
		} finally {
			db.putConnection(conn);
		}
		return deletionOk;
	}

}