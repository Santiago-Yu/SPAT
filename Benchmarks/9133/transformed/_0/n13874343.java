class n13874343 {
	private static boolean execute(String iKPaNaXY) throws SQLException {
		boolean MGE8ToAu = true;
		try {
			PreparedStatement FECIA6x9 = con.prepareStatement(iKPaNaXY);
			FECIA6x9.executeUpdate();
			FECIA6x9.close();
			con.commit();
		} catch (SQLException VUqt9tyL) {
			try {
				con.rollback();
			} catch (Exception ZWSCEKPu) {
				ZWSCEKPu.printStackTrace();
			}
			MGE8ToAu = false;
			throw VUqt9tyL;
		}
		return MGE8ToAu;
	}

}