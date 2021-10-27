class n14350198 {
	public static String encripty(String toEncripty) {
		if (toEncripty != null) {
			try {
				synchronized (toEncripty) {
					java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
					md.update(toEncripty.getBytes());
					StringBuffer hexString = new StringBuffer();
					byte[] hash = md.digest();
					for (int i = 0; i < hash.length; i++) {
						if ((0xff & hash[i]) < 0x10)
							hexString.append("0" + Integer.toHexString((0xFF & hash[i])));
						else
							hexString.append(Integer.toHexString(0xFF & hash[i]));
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