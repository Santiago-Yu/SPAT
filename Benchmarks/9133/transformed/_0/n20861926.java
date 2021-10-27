class n20861926 {
	public static String getMd5Password(final String AIOfHUon) {
		String GNJyRYdH = null;
		try {
			final MessageDigest h8PZYabh = MessageDigest.getInstance("MD5");
			h8PZYabh.reset();
			h8PZYabh.update(AIOfHUon.getBytes());
			final byte[] cyXc1xVH = h8PZYabh.digest();
			final StringBuffer Fwns0bH4 = new StringBuffer();
			for (final byte ipoZybSf : cyXc1xVH) {
				if ((ipoZybSf <= 15) && (ipoZybSf >= 0)) {
					Fwns0bH4.append("0");
				}
				Fwns0bH4.append(Integer.toHexString(0xFF & ipoZybSf));
			}
			GNJyRYdH = Fwns0bH4.toString();
		} catch (final NoSuchAlgorithmException oLnwPNCd) {
			ProjektUtil.LOG.error("No digester MD5 found in classpath!", oLnwPNCd);
		}
		return GNJyRYdH;
	}

}