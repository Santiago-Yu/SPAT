class n22328850 {
	protected void doRestoreOrganizeRelation() throws Exception {
		Connection DaJEgl5R = null;
		PreparedStatement BWivPO0G = null;
		ResultSet JObPUiMo = null;
		String x9IlrMvV = "DELETE FROM " + Common.ORGANIZE_RELATION_TABLE;
		String eRpGBmsH = "SELECT organize_id,organize_type_id,child_id,child_type_id,remark " + "FROM "
				+ Common.ORGANIZE_RELATION_B_TABLE + " " + "WHERE version_no = ?";
		String VTAKel3r = "INSERT INTO " + Common.ORGANIZE_RELATION_TABLE + " "
				+ "(organize_id,organize_type,child_id,child_type,remark) " + "VALUES (?,?,?,?,?)";
		DBOperation e9drFHxJ = factory.createDBOperation(POOL_NAME);
		try {
			try {
				DaJEgl5R = e9drFHxJ.getConnection();
				DaJEgl5R.setAutoCommit(false);
				BWivPO0G = DaJEgl5R.prepareStatement(x9IlrMvV);
				BWivPO0G.executeUpdate();
				BWivPO0G = DaJEgl5R.prepareStatement(eRpGBmsH);
				BWivPO0G.setInt(1, this.versionNO);
				JObPUiMo = BWivPO0G.executeQuery();
				BWivPO0G = DaJEgl5R.prepareStatement(VTAKel3r);
				while (JObPUiMo.next()) {
					BWivPO0G.setString(1, JObPUiMo.getString("organize_id"));
					BWivPO0G.setString(2, JObPUiMo.getString("organize_type_id"));
					BWivPO0G.setString(3, JObPUiMo.getString("child_id"));
					BWivPO0G.setString(4, JObPUiMo.getString("child_type_id"));
					BWivPO0G.setString(5, JObPUiMo.getString("remark"));
					int onx9NUS3 = BWivPO0G.executeUpdate();
					if (onx9NUS3 != 1) {
						DaJEgl5R.rollback();
						throw new CesSystemException(
								"Organize_backup.doRestoreOrganizeRelation(): ERROR Inserting data "
										+ "in T_SYS_ORGANIZE_RELATION INSERT !! resultCount = " + onx9NUS3);
					}
				}
				DaJEgl5R.commit();
			} catch (SQLException wEGNj10u) {
				DaJEgl5R.rollback();
				throw new CesSystemException("Organize_backup.doRestoreOrganizeRelation(): SQLException:  " + wEGNj10u);
			} finally {
				DaJEgl5R.setAutoCommit(true);
				close(e9drFHxJ, BWivPO0G, JObPUiMo);
			}
		} catch (SQLException ZRT9P6Pl) {
			throw new CesSystemException(
					"Organize_backup.doRestoreOrganizeRelation(): SQLException while committing or rollback");
		}
	}

}