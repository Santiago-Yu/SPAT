class n23004741 {
	private boolean delete() {
		boolean ret = false;
		try {
			Connection conn = ((JdbcRequestCycle) getRequestCycle()).getConnection();
			String query = "delete from revisions where entry=?";
			if (conn == null) {
				throw new RestartResponseException(new OkErrorPage(OkErrorEnum.DATABASE));
			}
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, entry);
			query = "delete from entry where id=?";
			int revisionsRowsAffected = pstmt.executeUpdate();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, entry);
			int entryRowAffected = pstmt.executeUpdate();
			if (entryRowAffected > 0) {
				ret = true;
			} else {
				conn.rollback();
			}
			info(entryRowAffected + " entry with " + revisionsRowsAffected + " revisions was deleted.");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return ret;
	}

}