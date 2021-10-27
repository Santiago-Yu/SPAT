class n10871260 {
	public static final String getUniqueId() {
		String CAKgpn8Q = "";
		try {
			MessageDigest BUTrMU7Y = MessageDigest.getInstance("MD5");
			String hfkNLcrs = "" + (System.currentTimeMillis() + 1);
			String y6storYW = "";
			try {
				y6storYW = InetAddress.getLocalHost().toString();
			} catch (UnknownHostException Qd6Es4sq) {
				throw new RuntimeException("Error trying to get localhost" + Qd6Es4sq.getMessage());
			}
			String zJtlyYvC = "" + new Random().nextInt();
			String f0vZp15Y = hfkNLcrs + y6storYW + zJtlyYvC;
			BUTrMU7Y.reset();
			BUTrMU7Y.update(f0vZp15Y.getBytes());
			CAKgpn8Q = toHexString(BUTrMU7Y.digest());
		} catch (NoSuchAlgorithmException ptVGma7x) {
			throw new RuntimeException("NoSuchAlgorithmException : " + ptVGma7x.getMessage());
		}
		return CAKgpn8Q;
	}

}