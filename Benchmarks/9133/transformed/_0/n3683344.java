class n3683344 {
	private static String genRandomGUID(boolean Wxhscr6h) {
		String U60efiKL = "";
		String BJk76j7G = "";
		MessageDigest K1daHvNN = null;
		StringBuffer hnx3QEcw = new StringBuffer();
		try {
			K1daHvNN = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException PbSAzL59) {
			System.out.println("Error: " + PbSAzL59);
			return U60efiKL;
		}
		long LbbwuoHk = System.currentTimeMillis();
		long OoszjaSU = 0;
		if (Wxhscr6h) {
			OoszjaSU = mySecureRand.nextLong();
		} else {
			OoszjaSU = myRand.nextLong();
		}
		hnx3QEcw.append(s_id);
		hnx3QEcw.append(":");
		hnx3QEcw.append(Long.toString(LbbwuoHk));
		hnx3QEcw.append(":");
		hnx3QEcw.append(Long.toString(OoszjaSU));
		U60efiKL = hnx3QEcw.toString();
		K1daHvNN.update(U60efiKL.getBytes());
		byte[] QGbSUViX = K1daHvNN.digest();
		String ANwcMr2n = "";
		for (int iR9ka2jY = 0; iR9ka2jY < QGbSUViX.length; iR9ka2jY++) {
			ANwcMr2n = (Integer.toHexString(QGbSUViX[iR9ka2jY] & 0XFF));
			if (ANwcMr2n.length() == 1) {
				BJk76j7G = BJk76j7G + "0" + ANwcMr2n;
			} else {
				BJk76j7G = BJk76j7G + ANwcMr2n;
			}
		}
		return BJk76j7G.toUpperCase();
	}

}