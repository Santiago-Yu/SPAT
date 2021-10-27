class n22328842 {
	protected void doBackupOrganizeType() throws Exception {
		Connection cZpEH7F5 = null;
		PreparedStatement fODtNTQa = null;
		ResultSet KZfGlZ0G = null;
		String CW9OEueQ = "SELECT organize_type_id,organize_type_name,width " + "FROM " + Common.ORGANIZE_TYPE_TABLE;
		String TrO9dUTU = "INSERT INTO " + Common.ORGANIZE_TYPE_B_TABLE + " "
				+ "(version_no,organize_type_id,organize_type_name,width) " + "VALUES (?,?,?,?)";
		DBOperation HaNPUEkU = factory.createDBOperation(POOL_NAME);
		try {
			try {
				cZpEH7F5 = HaNPUEkU.getConnection();
				cZpEH7F5.setAutoCommit(false);
				fODtNTQa = cZpEH7F5.prepareStatement(CW9OEueQ);
				KZfGlZ0G = fODtNTQa.executeQuery();
				fODtNTQa = cZpEH7F5.prepareStatement(TrO9dUTU);
				while (KZfGlZ0G.next()) {
					fODtNTQa.setInt(1, this.versionNO);
					fODtNTQa.setString(2, KZfGlZ0G.getString("organize_type_id"));
					fODtNTQa.setString(3, KZfGlZ0G.getString("organize_type_name"));
					fODtNTQa.setInt(4, KZfGlZ0G.getInt("width"));
					int HxCZVb0D = fODtNTQa.executeUpdate();
					if (HxCZVb0D != 1) {
						cZpEH7F5.rollback();
						throw new CesSystemException("Organize_backup.doBackupOrganizeType(): ERROR Inserting data "
								+ "in T_SYS_ORGANIZE_B_TYPE INSERT !! resultCount = " + HxCZVb0D);
					}
				}
				cZpEH7F5.commit();
			} catch (SQLException AwuM13ns) {
				cZpEH7F5.rollback();
				throw new CesSystemException("Organize_backup.doBackupOrganizeType(): SQLException:  " + AwuM13ns);
			} finally {
				cZpEH7F5.setAutoCommit(true);
				close(HaNPUEkU, fODtNTQa, KZfGlZ0G);
			}
		} catch (SQLException ebSu0wV5) {
			throw new CesSystemException(
					"Organize_backup.doBackupOrganizeType(): SQLException while committing or rollback");
		}
	}

}