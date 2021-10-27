class n16579662 {
	public void insertComponent() throws SQLException {
		Connection kJdG6jwt = null;
		PreparedStatement K39I72yu = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			kJdG6jwt = (Connection) DriverManager.getConnection(this.jdbcURL);
			kJdG6jwt.setAutoCommit(false);
			String m4X2oTgh = "INSERT INTO components(name,rate,quantity, description) VALUES(?,?,?,?)";
			K39I72yu = (PreparedStatement) kJdG6jwt.prepareStatement(m4X2oTgh);
			K39I72yu.setString(1, this.name);
			K39I72yu.setDouble(2, this.rate);
			K39I72yu.setInt(3, this.quantity);
			K39I72yu.setString(4, this.description);
			K39I72yu.executeUpdate();
			kJdG6jwt.commit();
		} catch (Exception yUwV8eHT) {
			kJdG6jwt.rollback();
		} finally {
			try {
				kJdG6jwt.close();
			} catch (Exception OIYKxKO1) {
			}
			try {
				K39I72yu.close();
			} catch (Exception CFe6SWgf) {
			}
		}
	}

}