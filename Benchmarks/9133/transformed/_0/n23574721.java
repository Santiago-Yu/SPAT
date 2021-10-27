class n23574721 {
	public void updateProfile() throws ClassNotFoundException, SQLException {
		Connection uNISjIbR = null;
		PreparedStatement wuxCIEUM = null;
		PreparedStatement E4B28BZS = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			uNISjIbR = DriverManager.getConnection(this.url);
			uNISjIbR.setAutoCommit(false);
			String SRaLRp28 = "UPDATE customers SET password=? WHERE name=?";
			String ovqqZ18B = "UPDATE customers_profile " + "SET first_name=?,middle_name=?,last_name=?,address1=?"
					+ ",address2=?,city=?,post_box=?,email=?,country=? WHERE name=?";
			wuxCIEUM = uNISjIbR.prepareStatement(ovqqZ18B);
			E4B28BZS = uNISjIbR.prepareStatement(SRaLRp28);
			wuxCIEUM.setString(1, this.firstName);
			wuxCIEUM.setString(2, this.middleName);
			wuxCIEUM.setString(3, this.lastName);
			wuxCIEUM.setString(4, this.address1);
			wuxCIEUM.setString(5, this.address2);
			wuxCIEUM.setString(6, this.city);
			wuxCIEUM.setString(7, this.postBox);
			wuxCIEUM.setString(8, this.email);
			wuxCIEUM.setString(9, this.country);
			wuxCIEUM.setString(10, this.name);
			E4B28BZS.setString(1, this.password);
			E4B28BZS.setString(2, this.name);
			wuxCIEUM.executeUpdate();
			E4B28BZS.executeUpdate();
		} catch (Exception fKFwz7e6) {
			uNISjIbR.rollback();
		} finally {
			try {
				this.connection.close();
			} catch (Exception nU9dTq0T) {
			}
			try {
				wuxCIEUM.close();
			} catch (Exception p603qLqe) {
			}
			try {
				E4B28BZS.close();
			} catch (Exception FsJ6pA2I) {
			}
		}
	}

}