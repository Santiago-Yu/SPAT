class n22328843 {
	protected void doBackupOrganizeTypeRelation() throws Exception {
		Connection w3WN520w = null;
		PreparedStatement B8MQqztK = null;
		ResultSet YrwM6DaX = null;
		String JXeiJVhN = "SELECT parent_organize_type,child_organize_type " + "FROM "
				+ Common.ORGANIZE_TYPE_RELATION_TABLE;
		String mwtuBx1M = "INSERT INTO " + Common.ORGANIZE_TYPE_RELATION_B_TABLE + " "
				+ "(version_no,parent_organize_type,child_organize_type) " + "VALUES (?,?,?)";
		DBOperation t0FdD5YF = factory.createDBOperation(POOL_NAME);
		try {
			try {
				w3WN520w = t0FdD5YF.getConnection();
				w3WN520w.setAutoCommit(false);
				B8MQqztK = w3WN520w.prepareStatement(JXeiJVhN);
				YrwM6DaX = B8MQqztK.executeQuery();
				B8MQqztK = w3WN520w.prepareStatement(mwtuBx1M);
				while (YrwM6DaX.next()) {
					B8MQqztK.setInt(1, this.versionNO);
					B8MQqztK.setString(2, YrwM6DaX.getString("parent_organize_type"));
					B8MQqztK.setString(3, YrwM6DaX.getString("child_organize_type"));
					int x2PaRLTF = B8MQqztK.executeUpdate();
					if (x2PaRLTF != 1) {
						w3WN520w.rollback();
						throw new CesSystemException(
								"Organize_backup.doBackupOrganizeTypeRelation(): ERROR Inserting data "
										+ "in T_SYS_ORGANIZE_TYPE_RELATION_B INSERT !! resultCount = " + x2PaRLTF);
					}
				}
				w3WN520w.commit();
			} catch (SQLException g3pXkw6c) {
				w3WN520w.rollback();
				throw new CesSystemException(
						"Organize_backup.doBackupOrganizeTypeRelation(): SQLException:  " + g3pXkw6c);
			} finally {
				w3WN520w.setAutoCommit(true);
				close(t0FdD5YF, B8MQqztK, YrwM6DaX);
			}
		} catch (SQLException aoy1RpMr) {
			throw new CesSystemException(
					"Organize_backup.doBackupOrganizeTypeRelation(): SQLException while committing or rollback");
		}
	}

}