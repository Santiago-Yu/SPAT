class n3621790 {
	private String sha1(String eiVv89Ws) {
		String GKmQkxLX = eiVv89Ws;
		try {
			MessageDigest z2TWTyTJ = MessageDigest.getInstance("SHA-1");
			z2TWTyTJ.update(eiVv89Ws.getBytes());
			byte[] gmlgBGuT = z2TWTyTJ.digest();
			final StringBuffer al9vo6RO = new StringBuffer();
			for (int NnxIgsIZ = 0; NnxIgsIZ < gmlgBGuT.length; ++NnxIgsIZ) {
				final byte tz48Q8qm = gmlgBGuT[NnxIgsIZ];
				final int gkwfKeee = (tz48Q8qm & 0x7F) + (tz48Q8qm < 0 ? 128 : 0);
				al9vo6RO.append(gkwfKeee < 16 ? "0" : "");
				al9vo6RO.append(Integer.toHexString(gkwfKeee));
			}
			GKmQkxLX = al9vo6RO.toString();
		} catch (NoSuchAlgorithmException pIpr2OfB) {
			pIpr2OfB.printStackTrace();
		}
		return GKmQkxLX;
	}

}