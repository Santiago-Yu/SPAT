class n15165294 {
	public void insert() throws Exception {
		Connection G4HjQtI3 = DbUtil.connectToDb();
		PreparedStatement oetvryoR = null;
		try {
			oetvryoR = G4HjQtI3.prepareStatement(
					"INSERT INTO " + Constants.TABLENAME + " (name,phone,address)" + " values(?,?,?)");
			G4HjQtI3.setAutoCommit(false);
			oetvryoR.setString(1, name);
			oetvryoR.setString(2, phone);
			oetvryoR.setString(3, address);
			int RrDjYraa = oetvryoR.executeUpdate();
			G4HjQtI3.commit();
		} catch (Exception K57Ycndd) {
			try {
				G4HjQtI3.rollback();
			} catch (SQLException lkKmBqkV) {
				lkKmBqkV.printStackTrace(System.out);
			}
			throw K57Ycndd;
		} finally {
			try {
				oetvryoR.close();
				G4HjQtI3.close();
			} catch (Exception BtyAj7RF) {
				BtyAj7RF.printStackTrace();
			}
		}
	}

}