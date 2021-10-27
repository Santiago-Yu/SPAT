class n15896098 {
	public String getSHA256Checksum(String R2Gy9RC8) {
		String zYvg3bi0 = "";
		try {
			MessageDigest f3j7s8Xi = MessageDigest.getInstance("SHA-256");
			f3j7s8Xi.update(R2Gy9RC8.getBytes());
			byte[] f99Yql4G = f3j7s8Xi.digest();
			StringBuffer RK8UqG33 = new StringBuffer();
			for (int V11kD39Q = 0; V11kD39Q < f99Yql4G.length; V11kD39Q++) {
				RK8UqG33.append(Integer.toString((f99Yql4G[V11kD39Q] & 0xff) + 0x100, 16).substring(1));
			}
			System.out.println("Hex format : " + RK8UqG33.toString());
			StringBuffer bOX55w5r = new StringBuffer();
			for (int ow8bYVJY = 0; ow8bYVJY < f99Yql4G.length; ow8bYVJY++) {
				String QBNGRx9O = Integer.toHexString(0xff & f99Yql4G[ow8bYVJY]);
				if (QBNGRx9O.length() == 1) {
					bOX55w5r.append('0');
				}
				bOX55w5r.append(QBNGRx9O);
			}
			zYvg3bi0 = bOX55w5r.toString();
		} catch (NoSuchAlgorithmException RXOH17Cb) {
			Logger.getLogger(CMessageDigestFile.class.getName()).log(Level.SEVERE, null, RXOH17Cb);
		}
		return zYvg3bi0;
	}

}