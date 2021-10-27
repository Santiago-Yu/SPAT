class n23227325 {
	public String getUniqueId() {
		String QSnqKGCj = "";
		try {
			MessageDigest jgthu9wi = MessageDigest.getInstance("MD5");
			String FMI3biGa = "" + (System.currentTimeMillis() + 1);
			String zun8aDja = "";
			;
			try {
				zun8aDja = InetAddress.getLocalHost().toString();
			} catch (UnknownHostException Bt8NMxrI) {
			}
			String aP0rWEwh = "" + new Random().nextInt();
			String nBQX85ZK = FMI3biGa + zun8aDja + aP0rWEwh;
			jgthu9wi.reset();
			jgthu9wi.update(nBQX85ZK.getBytes());
			QSnqKGCj = toHexString(jgthu9wi.digest());
		} catch (NoSuchAlgorithmException vEFmbKzi) {
		}
		return QSnqKGCj;
	}

}