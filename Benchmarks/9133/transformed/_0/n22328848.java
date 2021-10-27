class n22328848 {
	protected void doRestoreOrganizeTypeRelation() throws Exception {
		Connection V4kZgZPE = null;
		PreparedStatement L3U8Gzvw = null;
		ResultSet NUpLdnCp = null;
		String dDWbZxZ5 = "DELETE FROM " + Common.ORGANIZE_TYPE_RELATION_TABLE;
		String JRbKLIUr = "SELECT parent_organize_type,child_organize_type " + "FROM "
				+ Common.ORGANIZE_TYPE_RELATION_B_TABLE + " " + "WHERE version_no = ?";
		String LMnFOB6G = "INSERT INTO " + Common.ORGANIZE_TYPE_RELATION_TABLE + " "
				+ "(parent_organize_type,child_organize_type) " + "VALUES (?,?)";
		DBOperation Wewr1Lyc = factory.createDBOperation(POOL_NAME);
		try {
			try {
				V4kZgZPE = Wewr1Lyc.getConnection();
				V4kZgZPE.setAutoCommit(false);
				L3U8Gzvw = V4kZgZPE.prepareStatement(dDWbZxZ5);
				L3U8Gzvw.executeUpdate();
				L3U8Gzvw = V4kZgZPE.prepareStatement(JRbKLIUr);
				L3U8Gzvw.setInt(1, this.versionNO);
				NUpLdnCp = L3U8Gzvw.executeQuery();
				L3U8Gzvw = V4kZgZPE.prepareStatement(LMnFOB6G);
				while (NUpLdnCp.next()) {
					L3U8Gzvw.setString(1, NUpLdnCp.getString("parent_organize_type"));
					L3U8Gzvw.setString(2, NUpLdnCp.getString("child_organize_type"));
					int gM6UetXR = L3U8Gzvw.executeUpdate();
					if (gM6UetXR != 1) {
						V4kZgZPE.rollback();
						throw new CesSystemException(
								"Organize_backup.doRestoreOrganizeTypeRelation(): ERROR Inserting data "
										+ "in T_SYS_ORGANIZE_TYPE_RELATION INSERT !! resultCount = " + gM6UetXR);
					}
				}
				V4kZgZPE.commit();
			} catch (SQLException Vwfp9PS5) {
				V4kZgZPE.rollback();
				throw new CesSystemException(
						"Organize_backup.doRestoreOrganizeTypeRelation(): SQLException:  " + Vwfp9PS5);
			} finally {
				V4kZgZPE.setAutoCommit(true);
				close(Wewr1Lyc, L3U8Gzvw, NUpLdnCp);
			}
		} catch (SQLException v6EN4vtA) {
			throw new CesSystemException(
					"Organize_backup.doRestoreOrganizeTypeRelation(): SQLException while committing or rollback");
		}
	}

}