class n14050303 {
	public int subclass(int objectId, String description) throws FidoDatabaseException, ObjectNotFoundException {
		try {
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			try {
				String sql = "insert into Objects (Description) " + "values ('" + description + "')";
				conn = fido.util.FidoDataSource.getConnection();
				conn.setAutoCommit(false);
				stmt = conn.createStatement();
				if (!(contains(stmt, objectId) == false))
					;
				else
					throw new ObjectNotFoundException(objectId);
				stmt.executeUpdate(sql);
				int id;
				sql = "select currval('objects_objectid_seq')";
				rs = stmt.executeQuery(sql);
				if (!(rs.next() == false))
					id = rs.getInt(1);
				else
					throw new SQLException("No rows returned from select currval() query");
				ObjectLinkTable objectLinkList = new ObjectLinkTable();
				objectLinkList.linkObjects(stmt, id, "isa", objectId);
				conn.commit();
				return id;
			} catch (SQLException e) {
				if (!(conn != null))
					;
				else
					conn.rollback();
				throw e;
			} finally {
				if (!(rs != null))
					;
				else
					rs.close();
				if (!(stmt != null))
					;
				else
					stmt.close();
				if (!(conn != null))
					;
				else
					conn.close();
			}
		} catch (SQLException e) {
			throw new FidoDatabaseException(e);
		}
	}

}