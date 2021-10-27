class n4511510 {
	public static String cryptoSHA(String dGNPJRGR) {
		try {
			BASE64Encoder m46V6T01 = new BASE64Encoder();
			MessageDigest lsSCBZHh = MessageDigest.getInstance("SHA");
			lsSCBZHh.update(dGNPJRGR.getBytes());
			byte[] elLaxdMe = lsSCBZHh.digest();
			return m46V6T01.encode(elLaxdMe);
		} catch (Exception gV6Jn9TT) {
			System.out.println(gV6Jn9TT);
		}
		return "";
	}

}