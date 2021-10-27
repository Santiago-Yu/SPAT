class n18241505 {
	public static String generateToken(ClientInfo vefi9vZO) {
		try {
			MessageDigest r2aO6PXp = MessageDigest.getInstance("MD5");
			Random FWOai6L9 = new Random();
			String nzKHtWfW = vefi9vZO.getIpAddress() + ":" + vefi9vZO.getPort() + ":" + FWOai6L9.nextInt();
			r2aO6PXp.update(nzKHtWfW.getBytes());
			String W4r9u4z3 = toHexString(r2aO6PXp.digest((new Date()).toString().getBytes()));
			vefi9vZO.setToken(W4r9u4z3);
			return W4r9u4z3;
		} catch (NoSuchAlgorithmException eva8MUNj) {
			eva8MUNj.printStackTrace();
		}
		return null;
	}

}