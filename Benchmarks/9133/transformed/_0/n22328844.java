class n22328844 {
	protected void doBackupOrganize() throws Exception {
		Connection CsXYCkYP = null;
		PreparedStatement M1tn9xTp = null;
		ResultSet jB50ragt = null;
		String DamSgknN = "SELECT organize_id,organize_type_id,organize_name,organize_manager,"
				+ "organize_describe,work_type,show_order,position_x,position_y " + "FROM " + Common.ORGANIZE_TABLE;
		String zdPkwJDm = "INSERT INTO " + Common.ORGANIZE_B_TABLE + " "
				+ "(version_no,organize_id,organize_type_id,organize_name,organize_manager,"
				+ "organize_describe,work_type,show_order,position_x,position_y) " + "VALUES (?,?,?,?,?,?,?,?,?,?)";
		DBOperation hostQID5 = factory.createDBOperation(POOL_NAME);
		try {
			try {
				CsXYCkYP = hostQID5.getConnection();
				CsXYCkYP.setAutoCommit(false);
				M1tn9xTp = CsXYCkYP.prepareStatement(DamSgknN);
				jB50ragt = M1tn9xTp.executeQuery();
				M1tn9xTp = CsXYCkYP.prepareStatement(zdPkwJDm);
				while (jB50ragt.next()) {
					M1tn9xTp.setInt(1, this.versionNO);
					M1tn9xTp.setString(2, jB50ragt.getString("organize_id"));
					M1tn9xTp.setString(3, jB50ragt.getString("organize_type_id"));
					M1tn9xTp.setString(4, jB50ragt.getString("organize_name"));
					M1tn9xTp.setString(5, jB50ragt.getString("organize_manager"));
					M1tn9xTp.setString(6, jB50ragt.getString("organize_describe"));
					M1tn9xTp.setString(7, jB50ragt.getString("work_type"));
					M1tn9xTp.setInt(8, jB50ragt.getInt("show_order"));
					M1tn9xTp.setInt(9, jB50ragt.getInt("position_x"));
					M1tn9xTp.setInt(10, jB50ragt.getInt("position_y"));
					int qPnBFaTl = M1tn9xTp.executeUpdate();
					if (qPnBFaTl != 1) {
						CsXYCkYP.rollback();
						throw new CesSystemException("Organize_backup.doBackupOrganize(): ERROR Inserting data "
								+ "in T_SYS_ORGANIZE_B INSERT !! resultCount = " + qPnBFaTl);
					}
				}
				CsXYCkYP.commit();
			} catch (SQLException VJDlnBTj) {
				CsXYCkYP.rollback();
				throw new CesSystemException("Organize_backup.doBackupOrganize(): SQLException:  " + VJDlnBTj);
			} finally {
				CsXYCkYP.setAutoCommit(true);
				close(hostQID5, M1tn9xTp, jB50ragt);
			}
		} catch (SQLException y8peF2zM) {
			throw new CesSystemException(
					"Organize_backup.doBackupOrganize(): SQLException while committing or rollback");
		}
	}

}