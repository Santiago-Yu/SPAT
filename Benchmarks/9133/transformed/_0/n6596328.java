class n6596328 {
	public static String getSHA1Hash(String CxzhHLxH) throws NoSuchAlgorithmException {
		MessageDigest Be4scYrP = MessageDigest.getInstance("SHA1");
		Be4scYrP.update(CxzhHLxH.getBytes());
		byte[] vSnQPOzw = Be4scYrP.digest();
		StringBuffer DZZMknKq = new StringBuffer();
		for (int YPmJfx4Y = 0; YPmJfx4Y < vSnQPOzw.length; YPmJfx4Y++) {
			String eo3UA90Z = Integer.toHexString(0xFF & vSnQPOzw[YPmJfx4Y]);
			if (eo3UA90Z.length() == 1)
				DZZMknKq.append('0');
			DZZMknKq.append(eo3UA90Z);
		}
		return DZZMknKq.toString().toUpperCase();
	}

}