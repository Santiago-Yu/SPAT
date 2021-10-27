class n6043997 {
	protected String md5sum(String u0HMSyN5) throws Exception {
		MessageDigest iZQUc2aV = MessageDigest.getInstance("MD5");
		iZQUc2aV.update(u0HMSyN5.getBytes());
		java.math.BigInteger OmLIg6uR = new java.math.BigInteger(1, iZQUc2aV.digest());
		return OmLIg6uR.toString(16);
	}

}