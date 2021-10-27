class n22328847 {
	protected void doRestoreOrganizeType() throws Exception {
		Connection G7fUcZkI = null;
		PreparedStatement GeKj4nej = null;
		ResultSet crbmB1H9 = null;
		String kL9kwfrR = "DELETE FROM " + Common.ORGANIZE_TYPE_TABLE;
		String HQa1dDUj = "SELECT organize_type_id,organize_type_name,width " + "FROM " + Common.ORGANIZE_TYPE_B_TABLE
				+ " " + "WHERE version_no = ?";
		String GxnZDOcN = "INSERT INTO " + Common.ORGANIZE_TYPE_TABLE + " "
				+ "(organize_type_id,organize_type_name,width) " + "VALUES (?,?,?)";
		DBOperation jvB4fZa3 = factory.createDBOperation(POOL_NAME);
		try {
			try {
				G7fUcZkI = jvB4fZa3.getConnection();
				G7fUcZkI.setAutoCommit(false);
				GeKj4nej = G7fUcZkI.prepareStatement(kL9kwfrR);
				GeKj4nej.executeUpdate();
				GeKj4nej = G7fUcZkI.prepareStatement(HQa1dDUj);
				GeKj4nej.setInt(1, this.versionNO);
				crbmB1H9 = GeKj4nej.executeQuery();
				GeKj4nej = G7fUcZkI.prepareStatement(GxnZDOcN);
				while (crbmB1H9.next()) {
					GeKj4nej.setString(1, crbmB1H9.getString("organize_type_id"));
					GeKj4nej.setString(2, crbmB1H9.getString("organize_type_name"));
					GeKj4nej.setInt(3, crbmB1H9.getInt("width"));
					int ewO6C40w = GeKj4nej.executeUpdate();
					if (ewO6C40w != 1) {
						G7fUcZkI.rollback();
						throw new CesSystemException("Organize_backup.doRestoreOrganizeType(): ERROR Inserting data "
								+ "in T_SYS_ORGANIZE_TYPE INSERT !! resultCount = " + ewO6C40w);
					}
				}
				G7fUcZkI.commit();
			} catch (SQLException lNszOOzk) {
				G7fUcZkI.rollback();
				throw new CesSystemException("Organize_backup.doRestoreOrganizeType(): SQLException:  " + lNszOOzk);
			} finally {
				G7fUcZkI.setAutoCommit(true);
				close(jvB4fZa3, GeKj4nej, crbmB1H9);
			}
		} catch (SQLException KvVTGitS) {
			throw new CesSystemException(
					"Organize_backup.doRestoreOrganizeType(): SQLException while committing or rollback");
		}
	}

}