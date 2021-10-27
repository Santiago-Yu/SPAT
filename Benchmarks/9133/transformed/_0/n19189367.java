class n19189367 {
	public void insert() throws Exception {
		Connection vOjluBtb = DbUtil.connectToDb();
		PreparedStatement VjvVwL50 = null;
		try {
			VjvVwL50 = vOjluBtb.prepareStatement(
					"INSERT INTO " + Constants.TABLENAME + " (name,phone,address)" + " values(?,?,?)");
			vOjluBtb.setAutoCommit(false);
			VjvVwL50.setString(1, name);
			VjvVwL50.setString(2, phone);
			VjvVwL50.setString(3, address);
			int MCJgeqip = VjvVwL50.executeUpdate();
			vOjluBtb.commit();
		} catch (Exception F5CKsc8a) {
			try {
				vOjluBtb.rollback();
			} catch (SQLException MKOov4Jd) {
				MKOov4Jd.printStackTrace(System.out);
			}
			throw F5CKsc8a;
		} finally {
			try {
				VjvVwL50.close();
				vOjluBtb.close();
			} catch (Exception Vw67FnwC) {
				Vw67FnwC.printStackTrace();
			}
		}
	}

}