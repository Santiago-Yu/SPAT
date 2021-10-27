class n22328845 {
	protected void doBackupOrganizeRelation() throws Exception {
		Connection OBmVGqH9 = null;
		PreparedStatement cayHd72h = null;
		ResultSet PuYMSQfX = null;
		String AS4w2WsJ = "SELECT organize_id,organize_type_id,child_id,child_type_id,remark " + "FROM "
				+ Common.ORGANIZE_RELATION_TABLE;
		String pQl3Lxqh = "INSERT INTO " + Common.ORGANIZE_RELATION_B_TABLE + " "
				+ "(version_no,organize_id,organize_type,child_id,child_type,remark) " + "VALUES (?,?,?,?,?,?)";
		DBOperation VSDEYZ20 = factory.createDBOperation(POOL_NAME);
		try {
			try {
				OBmVGqH9 = VSDEYZ20.getConnection();
				OBmVGqH9.setAutoCommit(false);
				cayHd72h = OBmVGqH9.prepareStatement(AS4w2WsJ);
				PuYMSQfX = cayHd72h.executeQuery();
				cayHd72h = OBmVGqH9.prepareStatement(pQl3Lxqh);
				while (PuYMSQfX.next()) {
					cayHd72h.setInt(1, this.versionNO);
					cayHd72h.setString(2, PuYMSQfX.getString("organize_id"));
					cayHd72h.setString(3, PuYMSQfX.getString("organize_type_id"));
					cayHd72h.setString(4, PuYMSQfX.getString("child_id"));
					cayHd72h.setString(5, PuYMSQfX.getString("child_type_id"));
					cayHd72h.setString(6, PuYMSQfX.getString("remark"));
					int ypRqMMy6 = cayHd72h.executeUpdate();
					if (ypRqMMy6 != 1) {
						OBmVGqH9.rollback();
						throw new CesSystemException("Organize_backup.doBackupOrganizeRelation(): ERROR Inserting data "
								+ "in T_SYS_ORGANIZE_RELATION_B INSERT !! resultCount = " + ypRqMMy6);
					}
				}
				OBmVGqH9.commit();
			} catch (SQLException mEUCaNeD) {
				OBmVGqH9.rollback();
				throw new CesSystemException("Organize_backup.doBackupOrganizeRelation(): SQLException:  " + mEUCaNeD);
			} finally {
				OBmVGqH9.setAutoCommit(true);
				close(VSDEYZ20, cayHd72h, PuYMSQfX);
			}
		} catch (SQLException Hkt7YvhJ) {
			throw new CesSystemException(
					"Organize_backup.doBackupOrganizeRelation(): SQLException while committing or rollback");
		}
	}

}