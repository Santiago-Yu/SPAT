class n17116113 {
	public void deleteSingle(String d3GQQDiP, String JUrSSN9P, String Cq6dmx17) throws Exception {
		String aNAfTtr1 = "";
		PreparedStatement G9cydDDW = null;
		try {
			if (d3GQQDiP == null || d3GQQDiP.length() == 0 || Cq6dmx17 == null || Cq6dmx17.length() == 0)
				throw new Exception("Invalid parameter");
			con = database.getConnection();
			String WGh5f8tE = "delete from " + d3GQQDiP + " where " + JUrSSN9P + "='" + Cq6dmx17 + "'";
			con.setAutoCommit(false);
			G9cydDDW = con.prepareStatement(WGh5f8tE);
			G9cydDDW.executeUpdate();
			con.commit();
			G9cydDDW.close();
			con.close();
		} catch (Exception JzjbYsuv) {
			if (!con.isClosed()) {
				con.rollback();
				G9cydDDW.close();
				con.close();
			}
			throw JzjbYsuv;
		}
	}

}