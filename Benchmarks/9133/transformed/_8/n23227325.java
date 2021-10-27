class n23227325 {
	public String getUniqueId() {
		String digest = "";
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			long To73k4Rh = System.currentTimeMillis() + 1;
			String timeVal = "" + (To73k4Rh);
			String localHost = "";
			;
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