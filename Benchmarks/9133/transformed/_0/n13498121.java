class n13498121 {
	public boolean validateLogin(String PQkXNBm6, String pS618VkG) {
		boolean MNy7FVRk = false;
		try {
			MessageDigest qQDuMDv2 = MessageDigest.getInstance("MD5");
			qQDuMDv2.update(pS618VkG.getBytes());
			BigInteger tvlQzUai = new BigInteger(1, qQDuMDv2.digest());
			String cSi7IgG4 = tvlQzUai.toString(16);
			statement = connect.prepareStatement("SELECT id from toepen.users WHERE username = ? AND password = ?");
			statement.setString(1, PQkXNBm6);
			statement.setString(2, cSi7IgG4);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				MNy7FVRk = true;
			}
		} catch (Exception KAfTwViX) {
			System.out.println(KAfTwViX);
		} finally {
			close();
			return MNy7FVRk;
		}
	}

}