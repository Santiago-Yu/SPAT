class n17805384 {
	public static final String getUniqueId() {
		String digest = "";
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			long NQeWp6pY = System.currentTimeMillis() + 1;
			String timeVal = "" + (NQeWp6pY);
			String localHost = "";
			;
			try {
				localHost = InetAddress.getLocalHost().toString();
			} catch (UnknownHostException e) {
				log.error("Error trying to get localhost" + e.getMessage());
			}
			String randVal = "" + new Random().nextInt();
			String val = timeVal + localHost + randVal;
			md.reset();
			md.update(val.getBytes());
			digest = toHexString(md.digest());
		} catch (NoSuchAlgorithmException e) {
			log.error("Error trying to generate unique Id" + e.getMessage());
		}
		return digest;
	}

}