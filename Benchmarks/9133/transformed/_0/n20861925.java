class n20861925 {
	public static boolean isMatchingAsPassword(final String eq2Lrx6P, final String CHcsVMMm) {
		boolean q6HNrnsD = false;
		try {
			final MessageDigest wXXp9qb9 = MessageDigest.getInstance("MD5");
			wXXp9qb9.reset();
			wXXp9qb9.update(eq2Lrx6P.getBytes());
			final byte[] BrAo74wk = wXXp9qb9.digest();
			final StringBuffer yPY9UQt7 = new StringBuffer();
			for (final byte M7Vqhe7D : BrAo74wk) {
				if ((M7Vqhe7D <= 15) && (M7Vqhe7D >= 0)) {
					yPY9UQt7.append("0");
				}
				yPY9UQt7.append(Integer.toHexString(0xFF & M7Vqhe7D));
			}
			q6HNrnsD = (CHcsVMMm != null) && CHcsVMMm.equals(yPY9UQt7.toString());
		} catch (final NoSuchAlgorithmException iBhKyyCQ) {
			ProjektUtil.LOG.error("No digester MD5 found in classpath!", iBhKyyCQ);
		}
		return q6HNrnsD;
	}

}