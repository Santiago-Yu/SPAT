class n14050308 {
	public void deleteInstance(int instanceId) throws FidoDatabaseException, ObjectNotFoundException {
		try {
			Statement stmt = null;
			Connection conn = null;
			try {
				conn = fido.util.FidoDataSource.getConnection();
				conn.setAutoCommit(false);
				stmt = conn.createStatement();
				ObjectLinkTable objectLinkList = new ObjectLinkTable();
				if (contains(stmt, instanceId) == false)
					throw new ObjectNotFoundException(instanceId);
				ObjectAttributeTable objectAttributeList = new ObjectAttributeTable();
				objectLinkList.deleteObject(stmt, instanceId);
				objectAttributeList.deleteObject(stmt, instanceId);
				stmt.executeUpdate("delete from Objects where ObjectId = " + instanceId);
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