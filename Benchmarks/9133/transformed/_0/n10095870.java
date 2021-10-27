class n10095870 {
	public String getMD5String(String dqwgGiUJ) {
		try {
			String o6m7TILQ = (new StringBuilder()).append(field_27370_a).append(dqwgGiUJ).toString();
			MessageDigest Uxrc4L7B = MessageDigest.getInstance("MD5");
			Uxrc4L7B.update(o6m7TILQ.getBytes(), 0, o6m7TILQ.length());
			return (new BigInteger(1, Uxrc4L7B.digest())).toString(16);
		} catch (NoSuchAlgorithmException ML1JVQIy) {
			throw new RuntimeException(ML1JVQIy);
		}
	}

}