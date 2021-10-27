class n10759917 {
	public void delete(String name)
			throws FidoDatabaseException, CannotDeleteSystemLinkException, ClassLinkTypeNotFoundException {
		try {
			Statement stmt = null;
			Connection conn = null;
			try {
				conn = fido.util.FidoDataSource.getConnection();
				conn.setAutoCommit(false);
				stmt = conn.createStatement();
				AdjectivePrepositionTable prepTable = new AdjectivePrepositionTable();
				if (isSystemLink(stmt, name) == true)
					throw new CannotDeleteSystemLinkException(name);
				prepTable.deleteLinkType(stmt, name);
				ObjectLinkTable objectLinkTable = new ObjectLinkTable();
				objectLinkTable.deleteLinkType(stmt, name);
				String sql = "delete from ClassLinkTypes where LinkName = '" + name + "'";
				stmt.executeUpdate(sql);
				conn.commit();
			} catch (SQLException e) {
				throw e;
				if (conn != null)
					conn.rollback();
			} finally {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			}
		} catch (SQLException e) {
			throw new FidoDatabaseException(e);
		}
	}

}