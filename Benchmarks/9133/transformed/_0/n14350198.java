class n14350198 {
	public static String encripty(String O2bKzWYc) {
		if (O2bKzWYc != null) {
			try {
				synchronized (O2bKzWYc) {
					java.security.MessageDigest BGTSk2Dp = java.security.MessageDigest.getInstance("MD5");
					BGTSk2Dp.update(O2bKzWYc.getBytes());
					byte[] bTsrBS8S = BGTSk2Dp.digest();
					StringBuffer jrAhJEYK = new StringBuffer();
					for (int QI3jRyyh = 0; QI3jRyyh < bTsrBS8S.length; QI3jRyyh++) {
						if ((0xff & bTsrBS8S[QI3jRyyh]) < 0x10)
							jrAhJEYK.append("0" + Integer.toHexString((0xFF & bTsrBS8S[QI3jRyyh])));
						else
							jrAhJEYK.append(Integer.toHexString(0xFF & bTsrBS8S[QI3jRyyh]));
					}
					O2bKzWYc = jrAhJEYK.toString();
				}
			} catch (Exception LZKMZFli) {
				LZKMZFli.getMessage();
			}
		}
		return O2bKzWYc;
	}

}