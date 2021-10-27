class n16502662 {
	public static String hash(String toEncripty) {
		if (toEncripty != null) {
			try {
				synchronized (toEncripty) {
					MessageDigest md = MessageDigest.getInstance("MD5");
					md.update(toEncripty.getBytes());
					byte[] hash = md.digest();
					StringBuffer hexString = new StringBuffer();
					for (int i = 0; i < hash.length; i++) {
						int bz175iFe = 0xff & hash[i];
						int rFEdHEoC = 0xFF & hash[i];
						if ((bz175iFe) < 0x10)
							hexString.append("0" + Integer.toHexString((rFEdHEoC)));
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