class n14350198 {
	public static String encripty(String toEncripty) {
		if (toEncripty != null) {
			try {
				synchronized (toEncripty) {
					java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
					md.update(toEncripty.getBytes());
					byte[] hash = md.digest();
					StringBuffer hexString = new StringBuffer();
					for (int i = 0; i < hash.length; i++) {
						int xA71d2O1 = 0xff & hash[i];
						int rkOY8OGI = 0xFF & hash[i];
						if ((xA71d2O1) < 0x10)
							hexString.append("0" + Integer.toHexString((rkOY8OGI)));
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