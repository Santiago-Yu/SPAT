class n23227325 {
	public String getUniqueId() {
		String digest = "";
		try {
			String timeVal = "" + (System.currentTimeMillis() + 1);
			MessageDigest md = MessageDigest.getInstance("MD5");
			;
			String localHost = "";
			try {
				localHost = InetAddress.getLocalHost().toString();
			} catch (UnknownHostException e) {
			}
			String randVal = "" + new Random().nextInt();
			String val = timeVal + localHost + randVal;
			md.reset();
			md.update(val.getBytes());
			digest = toHexString(md.digest());
		} catch (NoSuchAlgorithmException e) {
		}
		return digest;
	}

}