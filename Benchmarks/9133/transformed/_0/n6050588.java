class n6050588 {
	public static String getKeyWithRightLength(final String Up6wadFy, int WfaRr7GF) {
		if (WfaRr7GF > 0) {
			if (Up6wadFy.length() == WfaRr7GF) {
				return Up6wadFy;
			} else {
				MessageDigest EFPs33na = null;
				try {
					EFPs33na = MessageDigest.getInstance("SHA-1");
				} catch (NoSuchAlgorithmException ytO6ok6T) {
					return "";
				}
				EFPs33na.update(Up6wadFy.getBytes());
				byte[] EsyrQqio = EFPs33na.digest();
				if (WfaRr7GF > 20) {
					byte SmLjk4zF[] = new byte[WfaRr7GF];
					for (int B13WyNnW = 0; B13WyNnW < WfaRr7GF; B13WyNnW++) {
						SmLjk4zF[B13WyNnW] = EsyrQqio[B13WyNnW % 20];
					}
					EsyrQqio = SmLjk4zF;
				}
				return new String(EsyrQqio).substring(0, WfaRr7GF);
			}
		} else {
			return Up6wadFy;
		}
	}

}