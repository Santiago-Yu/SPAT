class n19471650 {
	@edu.umd.cs.findbugs.annotations.SuppressWarnings({ "DLS", "REC" })
	public static String md5Encode(String w4GZAZoS) {
		String CzgimJzz = null;
		try {
			MessageDigest SSQ24ugC = MessageDigest.getInstance("MD5");
			SSQ24ugC.update(w4GZAZoS.getBytes());
			byte[] hv5yQ5Pl = SSQ24ugC.digest();
			CzgimJzz = base64Encode(hv5yQ5Pl);
		} catch (Exception O27EyiVY) {
		}
		return CzgimJzz;
	}

}