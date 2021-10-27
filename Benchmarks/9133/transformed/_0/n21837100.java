class n21837100 {
	public void saveMapping() throws SQLException {
		Connection LamXMNPp = null;
		PreparedStatement NvyNHTrt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			LamXMNPp = (Connection) DriverManager.getConnection(this.jdbcURL);
			LamXMNPp.setAutoCommit(false);
			String DBI0xX7d = "INSERT INTO mapping(product_id, comp_id, count) VALUES(?,?,?)";
			NvyNHTrt = (PreparedStatement) LamXMNPp.prepareStatement(DBI0xX7d);
			NvyNHTrt.setInt(1, this.productId);
			NvyNHTrt.setInt(2, this.componentId);
			NvyNHTrt.setInt(3, 1);
			NvyNHTrt.executeUpdate();
		} catch (Exception MkgkPYZV) {
			LamXMNPp.rollback();
		} finally {
			try {
				LamXMNPp.close();
			} catch (Exception wRL0Es0A) {
			}
			try {
				NvyNHTrt.close();
			} catch (Exception WbRNSgPt) {
			}
		}
	}

}