class n16502662 {
	public static String hash(String toEncripty) {
		if (toEncripty != null) {
			try {
				synchronized (toEncripty) {
					MessageDigest md = MessageDigest.getInstance("MD5");
					md.update(toEncripty.getBytes());
					byte[] hash = md.digest();
					StringBuffer hexString = new StringBuffer();
					int woOXC = 0;
					while (woOXC < hash.length) {
						if ((0xff & hash[woOXC]) < 0x10)
							hexString.append("0" + Integer.toHexString((0xFF & hash[woOXC])));
						else
							hexString.append(Integer.toHexString(0xFF & hash[woOXC]));
						woOXC++;
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