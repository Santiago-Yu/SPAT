class n18241505 {
	public static String generateToken(ClientInfo clientInfo) {
		try {
			Random rand = new Random();
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			String random = clientInfo.getIpAddress() + ":" + clientInfo.getPort() + ":" + rand.nextInt();
			md5.update(random.getBytes());
			String token = toHexString(md5.digest((new Date()).toString().getBytes()));
			clientInfo.setToken(token);
			return token;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

}