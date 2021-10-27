class n22328849 {
	protected void doRestoreOrganize() throws Exception {
		Connection fF00ZFdM = null;
		PreparedStatement Pc6DjEdp = null;
		ResultSet X86tzQN9 = null;
		String hkxMeQJb = "DELETE FROM " + Common.ORGANIZE_TABLE;
		String EfqhxPr5 = "SELECT organize_id,organize_type_id,organize_name,organize_manager,"
				+ "organize_describe,work_type,show_order,position_x,position_y " + "FROM " + Common.ORGANIZE_B_TABLE
				+ " " + "WHERE version_no = ?";
		String EftZuV3c = "INSERT INTO " + Common.ORGANIZE_TABLE + " "
				+ "(organize_id,organize_type_id,organize_name,organize_manager,"
				+ "organize_describe,work_type,show_order,position_x,position_y) " + "VALUES (?,?,?,?,?,?,?,?,?)";
		DBOperation PYLfuHZe = factory.createDBOperation(POOL_NAME);
		try {
			try {
				fF00ZFdM = PYLfuHZe.getConnection();
				fF00ZFdM.setAutoCommit(false);
				Pc6DjEdp = fF00ZFdM.prepareStatement(hkxMeQJb);
				Pc6DjEdp.executeUpdate();
				Pc6DjEdp = fF00ZFdM.prepareStatement(EfqhxPr5);
				Pc6DjEdp.setInt(1, this.versionNO);
				X86tzQN9 = Pc6DjEdp.executeQuery();
				Pc6DjEdp = fF00ZFdM.prepareStatement(EftZuV3c);
				while (X86tzQN9.next()) {
					Pc6DjEdp.setString(1, X86tzQN9.getString("organize_id"));
					Pc6DjEdp.setString(2, X86tzQN9.getString("organize_type_id"));
					Pc6DjEdp.setString(3, X86tzQN9.getString("organize_name"));
					Pc6DjEdp.setString(4, X86tzQN9.getString("organize_manager"));
					Pc6DjEdp.setString(5, X86tzQN9.getString("organize_describe"));
					Pc6DjEdp.setString(6, X86tzQN9.getString("work_type"));
					Pc6DjEdp.setInt(7, X86tzQN9.getInt("show_order"));
					Pc6DjEdp.setInt(8, X86tzQN9.getInt("position_x"));
					Pc6DjEdp.setInt(9, X86tzQN9.getInt("position_y"));
					int jxIFok1Y = Pc6DjEdp.executeUpdate();
					if (jxIFok1Y != 1) {
						fF00ZFdM.rollback();
						throw new CesSystemException("Organize_backup.doRestoreOrganize(): ERROR Inserting data "
								+ "in T_SYS_ORGANIZE INSERT !! resultCount = " + jxIFok1Y);
					}
				}
				fF00ZFdM.commit();
			} catch (SQLException EdUKchK7) {
				fF00ZFdM.rollback();
				throw new CesSystemException("Organize_backup.doRestoreOrganize(): SQLException:  " + EdUKchK7);
			} finally {
				fF00ZFdM.setAutoCommit(true);
				close(PYLfuHZe, Pc6DjEdp, X86tzQN9);
			}
		} catch (SQLException Vu2hi5Gv) {
			throw new CesSystemException(
					"Organize_backup.doRestoreOrganize(): SQLException while committing or rollback");
		}
	}

}