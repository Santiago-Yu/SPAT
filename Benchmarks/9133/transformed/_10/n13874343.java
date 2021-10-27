class n13874343 {
	private static boolean execute(String query) throws SQLException {
		boolean success = true;
		try {
			PreparedStatement stm = con.prepareStatement(query);
			stm.executeUpdate();
			stm.close();
			con.commit();
		} catch (SQLException e) {
			success = false;
			try {
				con.rollback();
			} catch (Exception rbex) {
				rbex.printStackTrace();
			}
			throw e;
		}
		return success;
	}

}