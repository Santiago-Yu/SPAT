class n5080723 {
	public static URL getAuthenticationURL(String HfVi70n3, String G7PLh6ia, String svfjiuKl) throws Exception {
		String EC5xPM7R = svfjiuKl + "api_key" + HfVi70n3 + "perms" + G7PLh6ia;
		MessageDigest QxNX8T8H = MessageDigest.getInstance("MD5");
		QxNX8T8H.update(EC5xPM7R.getBytes(), 0, EC5xPM7R.length());
		EC5xPM7R = new BigInteger(1, QxNX8T8H.digest()).toString(16);
		StringBuffer J6dFLtEA = new StringBuffer();
		J6dFLtEA.append("http://flickr.com/services/auth/?");
		J6dFLtEA.append("api_key=" + HfVi70n3);
		J6dFLtEA.append("&").append("perms=").append(G7PLh6ia);
		J6dFLtEA.append("&").append("api_sig=").append(EC5xPM7R);
		return new URL(J6dFLtEA.toString());
	}

}