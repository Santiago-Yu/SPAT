class n18115314 {
	public static final String md5(final String DdMl1c2m) {
		try {
			MessageDigest W9RxUpnB = java.security.MessageDigest.getInstance("MD5");
			W9RxUpnB.update(DdMl1c2m.getBytes());
			byte KpjOenV5[] = W9RxUpnB.digest();
			StringBuffer PqzwhQl7 = new StringBuffer();
			for (int injlVzWi = 0; injlVzWi < KpjOenV5.length; injlVzWi++) {
				String n3qSCnfh = Integer.toHexString(0xFF & KpjOenV5[injlVzWi]);
				while (n3qSCnfh.length() < 2)
					n3qSCnfh = "0" + n3qSCnfh;
				PqzwhQl7.append(n3qSCnfh);
			}
			return PqzwhQl7.toString();
		} catch (NoSuchAlgorithmException hTIAubWg) {
		}
		return "";
	}

}