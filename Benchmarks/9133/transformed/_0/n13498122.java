class n13498122 {
	public boolean createUser(String rsfZQjjc, String Bb0nDu9o, String FBlNgEPZ) throws Exception {
		boolean zJXiXYCu = false;
		try {
			statement = connect.prepareStatement("SELECT COUNT(*) from toepen.users WHERE username = ? LIMIT 1");
			statement.setString(1, rsfZQjjc);
			resultSet = statement.executeQuery();
			resultSet.next();
			if (resultSet.getInt(1) == 0) {
				MessageDigest eNZPnkhT = MessageDigest.getInstance("MD5");
				eNZPnkhT.update(Bb0nDu9o.getBytes());
				BigInteger Jvp64gFJ = new BigInteger(1, eNZPnkhT.digest());
				String iowCYXWO = Jvp64gFJ.toString(16);
				long NykC0Kk4 = System.currentTimeMillis() / 1000;
				statement = connect.prepareStatement(
						"INSERT INTO toepen.users " + "(username, password, name, ctime) " + "VALUES (?, ?, ?, ?)");
				statement.setString(1, rsfZQjjc);
				statement.setString(2, iowCYXWO);
				statement.setString(3, FBlNgEPZ);
				statement.setLong(4, NykC0Kk4);
				if (statement.executeUpdate() > 0) {
					zJXiXYCu = true;
				}
			}
		} catch (Exception GMRtjxq4) {
			System.out.println(GMRtjxq4);
		} finally {
			close();
			return zJXiXYCu;
		}
	}

}