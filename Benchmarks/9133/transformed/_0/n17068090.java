class n17068090 {
	public String encripta(String j0EVPFQ3) {
		try {
			MessageDigest FHAzhXgi = MessageDigest.getInstance("MD5");
			FHAzhXgi.update(j0EVPFQ3.getBytes());
			BASE64Encoder wicKaugc = new BASE64Encoder();
			return wicKaugc.encode(FHAzhXgi.digest());
		} catch (NoSuchAlgorithmException HPDLT9wX) {
			HPDLT9wX.printStackTrace();
			return j0EVPFQ3;
		}
	}

}