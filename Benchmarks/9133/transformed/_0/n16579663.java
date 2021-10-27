class n16579663 {
	public void updateComponent(int yIFLroJ1, int CUNopr7b) throws SQLException {
		Connection AvZcS2af = null;
		PreparedStatement vHiKeUkf = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			AvZcS2af = (Connection) DriverManager.getConnection(this.jdbcURL);
			AvZcS2af.setAutoCommit(false);
			String GW7B0ZCm = "UPDATE components SET quantity=quantity+? WHERE comp_id=?";
			vHiKeUkf = AvZcS2af.prepareStatement(GW7B0ZCm);
			vHiKeUkf.setInt(1, CUNopr7b);
			vHiKeUkf.setInt(2, yIFLroJ1);
			vHiKeUkf.executeUpdate();
			AvZcS2af.commit();
		} catch (Exception dcUaPuxO) {
			AvZcS2af.rollback();
		} finally {
			try {
				AvZcS2af.close();
			} catch (Exception dLjpjsFq) {
			}
			try {
				vHiKeUkf.close();
			} catch (Exception a6M54EIr) {
			}
		}
	}

}