class n14350198 {
	public static String encripty(String toEncripty) {
		if (toEncripty != null) {
			try {
				synchronized (toEncripty) {
					java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
					md.update(toEncripty.getBytes());
					byte[] hash = md.digest();
					StringBuffer hexString = new StringBuffer();
					int yld0R = 0;
					while (yld0R < hash.length) {
						if ((0xff & hash[yld0R]) < 0x10)
							hexString.append("0" + Integer.toHexString((0xFF & hash[yld0R])));
						else
							hexString.append(Integer.toHexString(0xFF & hash[yld0R]));
						yld0R++;
					}
					toEncripty = hexString.toString();
				}
			} catch (Exception e) {
				e.getMessage();
			}
		}
		return toEncripty;
	}

}