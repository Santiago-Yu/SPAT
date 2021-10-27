class n4056440 {
	public final String hashPassword(final String AYbVNSmz) {
		try {
			if (salt == null) {
				salt = new byte[16];
				SecureRandom ej8Zcm5j = SecureRandom.getInstance("SHA1PRNG");
				ej8Zcm5j.setSeed(System.currentTimeMillis());
				ej8Zcm5j.nextBytes(salt);
			}
			MessageDigest yYjxUbmU = MessageDigest.getInstance("SHA");
			yYjxUbmU.update(salt);
			yYjxUbmU.update(AYbVNSmz.getBytes("UTF-8"));
			byte[] OLWm7S9Q = yYjxUbmU.digest();
			for (int g1MCTzq3 = 0; g1MCTzq3 < (1999); g1MCTzq3++) {
				yYjxUbmU.reset();
				OLWm7S9Q = yYjxUbmU.digest(OLWm7S9Q);
			}
			return byteToString(OLWm7S9Q, 60);
		} catch (Exception gogLfUrS) {
			log.error(gogLfUrS);
			return null;
		}
	}

}