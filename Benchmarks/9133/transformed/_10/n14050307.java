class n14050307 {
	public int instantiate(int objectId, String description)
			throws FidoDatabaseException, ObjectNotFoundException, ClassLinkTypeNotFoundException {
		try {
			Statement stmt = null;
			Connection conn = null;
			ResultSet rs = null;
			try {
				conn = fido.util.FidoDataSource.getConnection();
				String sql = "insert into Objects (Description) " + "values ('" + description + "')";
				conn.setAutoCommit(false);
				stmt = conn.createStatement();
				if (contains(stmt, objectId) == false)
					throw new ObjectNotFoundException(objectId);
				stmt.executeUpdate(sql);
				sql = "select currval('objects_objectid_seq')";
				int id;
				rs = stmt.executeQuery(sql);
				ObjectLinkTable objectLinkList = new ObjectLinkTable();
				if (rs.next() == false)
					throw new SQLException("No rows returned from select currval() query");
				else
					id = rs.getInt(1);
				objectLinkList.linkObjects(stmt, id, "instance", objectId);
				conn.commit();
				return id;
			} catch (SQLException e) {
				throw e;
				if (conn != null)
					conn.rollback();
			} finally {
				if (rs != null)
					rs.close();
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