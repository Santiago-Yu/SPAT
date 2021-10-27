class n23452538 {
	private long config(final String XaTv6JPQ) throws SQLException {
		MessageDigest fEIMspq9 = null;
		try {
			fEIMspq9 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException kON7gV4Y) {
			kON7gV4Y.printStackTrace();
		}
		fEIMspq9.update(XaTv6JPQ.getBytes());
		final String YAU1VX6e = Concrete.md5(fEIMspq9.digest());
		Statement rK37N2kX = connection.createStatement();
		ResultSet Lr4d65tw = rK37N2kX.executeQuery("SELECT configId FROM configs WHERE md5='" + YAU1VX6e + "'");
		final long IpT4nBPu;
		if (Lr4d65tw.next()) {
			IpT4nBPu = Lr4d65tw.getInt(1);
		} else {
			rK37N2kX.executeUpdate("INSERT INTO configs(config, md5) VALUES ('" + XaTv6JPQ + "', '" + YAU1VX6e + "')");
			ResultSet tLHMUFw6 = rK37N2kX.getGeneratedKeys();
			if (tLHMUFw6.next()) {
				IpT4nBPu = tLHMUFw6.getInt(1);
			} else {
				throw new SQLException("Could not retrieve generated id");
			}
		}
		rK37N2kX.executeUpdate("UPDATE executions SET configId=" + IpT4nBPu + " WHERE executionId=" + executionId);
		return IpT4nBPu;
	}

}