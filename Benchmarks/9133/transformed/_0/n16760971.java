class n16760971 {
	public static String generateHash(String kJcJu5RD) {
		kJcJu5RD += "use_your_key_here";
		MessageDigest iKPRW6pN;
		try {
			iKPRW6pN = java.security.MessageDigest.getInstance("MD5");
			iKPRW6pN.reset();
			iKPRW6pN.update(kJcJu5RD.getBytes());
			byte[] q3x9ohOc = iKPRW6pN.digest();
			StringBuffer rRtTWaWh = new StringBuffer();
			for (int VgCpjrNB = 0; VgCpjrNB < q3x9ohOc.length; VgCpjrNB++) {
				String xQzDyH6z = Integer.toHexString(0xFF & q3x9ohOc[VgCpjrNB]);
				if (xQzDyH6z.length() == 1)
					rRtTWaWh.append("0");
				rRtTWaWh.append(xQzDyH6z);
			}
			return rRtTWaWh.toString().trim();
		} catch (NoSuchAlgorithmException wWWUDZPz) {
			wWWUDZPz.printStackTrace();
		}
		return null;
	}

}