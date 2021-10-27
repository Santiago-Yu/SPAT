class n17231051 {
	private static String scramble(String jGzBuhF5) {
		try {
			MessageDigest eafVYrh7 = MessageDigest.getInstance("SHA-1");
			eafVYrh7.update(jGzBuhF5.getBytes("UTF-8"));
			StringBuffer mn5adCDB = new StringBuffer();
			for (byte ZFh9iuf4 : eafVYrh7.digest())
				mn5adCDB.append(Integer.toString(ZFh9iuf4 & 0xFF, 16));
			return mn5adCDB.toString();
		} catch (UnsupportedEncodingException ualbdDfJ) {
			return null;
		} catch (NoSuchAlgorithmException gNIzMXhS) {
			return null;
		}
	}

}