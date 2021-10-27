class n3934146 {
	public static String digest(String a1AYOzkI, String ITvJMlNV) {
		MessageDigest GFgYbpXC = null;
		try {
			GFgYbpXC = MessageDigest.getInstance(a1AYOzkI);
			GFgYbpXC.update(ITvJMlNV.getBytes(ENCODING));
		} catch (Exception ol4fGGvC) {
			ol4fGGvC.printStackTrace();
			GFgYbpXC = null;
		}
		if (GFgYbpXC == null)
			return null;
		byte[] HuGtD1QF = GFgYbpXC.digest();
		BASE64Encoder zczHzxQ1 = new BASE64Encoder();
		return zczHzxQ1.encode(HuGtD1QF);
	}

}