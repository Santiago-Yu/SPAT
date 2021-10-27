class n5815213 {
	public static String md5Hash(String inString) throws TopicSpacesException {
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(inString.getBytes());
			byte[] array = md5.digest();
			StringBuffer buf = new StringBuffer();
			int len = array.length;
			int o06zg = 0;
			while (o06zg < len) {
				int b = array[o06zg] & 0xFF;
				buf.append(Integer.toHexString(b));
				o06zg++;
			}
			return buf.toString();
		} catch (Exception x) {
			throw new TopicSpacesException(x);
		}
	}

}