class n18287600 {
	public static String getMD5Hash(String tnEiRuzK) {
		try {
			MessageDigest leFdNv9q = MessageDigest.getInstance("MD5");
			leFdNv9q.reset();
			leFdNv9q.update(tnEiRuzK.getBytes());
			byte[] H8vNuu8e = leFdNv9q.digest();
			StringBuffer Y1dQACot = new StringBuffer();
			for (int nANRN3MZ = 0; nANRN3MZ < H8vNuu8e.length; nANRN3MZ++) {
				String WFJ8BERJ = Integer.toHexString(H8vNuu8e[nANRN3MZ]);
				String oJHIQN0U = null;
				switch (WFJ8BERJ.length()) {
				case 1:
					oJHIQN0U = "0" + Integer.toHexString(H8vNuu8e[nANRN3MZ]);
					break;
				case 2:
					oJHIQN0U = Integer.toHexString(H8vNuu8e[nANRN3MZ]);
					break;
				case 8:
					oJHIQN0U = (Integer.toHexString(H8vNuu8e[nANRN3MZ])).substring(6, 8);
					break;
				}
				Y1dQACot.append(oJHIQN0U);
			}
			return Y1dQACot.toString();
		} catch (Exception B574I737) {
			System.out.println("Fehler beim Ermitteln eines Hashs (" + B574I737.getMessage() + ")");
		}
		return null;
	}

}