class n23574720 {
	public void insertProfile() throws ClassNotFoundException, SQLException {
		Connection ydcWg0nK = null;
		PreparedStatement erRZro1M = null;
		PreparedStatement OFLipOiq = null;
		PreparedStatement tj6J2G63 = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			ydcWg0nK = DriverManager.getConnection(this.url);
			ydcWg0nK.setAutoCommit(false);
			String HrHMaMp2 = "INSERT INTO customers(name,password) VALUES(?,?)";
			erRZro1M = ydcWg0nK.prepareStatement(HrHMaMp2);
			erRZro1M.setString(1, this.name);
			erRZro1M.setString(2, this.password);
			String zSG9aDTH = "INSERT INTO customer_roles(name,role_name) VALUES(?,?)";
			OFLipOiq = ydcWg0nK.prepareStatement(zSG9aDTH);
			OFLipOiq.setString(1, this.name);
			OFLipOiq.setString(2, "user");
			String svuy7DSy = "INSERT INTO customers_profile(name,first_name,middle_name,last_name,address1,address2,city,post_box,email,country)"
					+ "VALUES(?,?,?,?,?,?,?,?,?,?)";
			tj6J2G63 = ydcWg0nK.prepareStatement(svuy7DSy);
			tj6J2G63.setString(1, this.name);
			tj6J2G63.setString(2, this.firstName);
			tj6J2G63.setString(3, this.middleName);
			tj6J2G63.setString(4, this.lastName);
			tj6J2G63.setString(5, this.address1);
			tj6J2G63.setString(6, this.address2);
			tj6J2G63.setString(7, this.city);
			tj6J2G63.setString(8, this.postBox);
			tj6J2G63.setString(9, this.email);
			tj6J2G63.setString(10, this.country);
			erRZro1M.executeUpdate();
			OFLipOiq.executeUpdate();
			tj6J2G63.executeUpdate();
			ydcWg0nK.commit();
		} catch (Exception w5A5vzA8) {
			ydcWg0nK.rollback();
		} finally {
			try {
				this.connection.close();
			} catch (Exception Nlx3g6el) {
			}
			try {
				erRZro1M.close();
			} catch (Exception fehJYYPw) {
			}
			try {
				OFLipOiq.close();
			} catch (Exception MXbbSkIv) {
			}
			try {
				tj6J2G63.close();
			} catch (Exception QhtW8HQn) {
			}
		}
	}

}