class n2440999 {
	private static boolean validateSshaPwd(String d8S5yZg9, String iovFKMRB) {
		boolean h4sGwwdA = false;
		if (d8S5yZg9 != null && iovFKMRB != null) {
			if (d8S5yZg9.startsWith(SSHA_PREFIX)) {
				d8S5yZg9 = d8S5yZg9.substring(SSHA_PREFIX.length());
				try {
					MessageDigest Jo5DpvoB = MessageDigest.getInstance("SHA-1");
					BASE64Decoder YXgV95uc = new BASE64Decoder();
					byte[] BtU2pPxd = YXgV95uc.decodeBuffer(d8S5yZg9);
					byte[] F14D5VzX = new byte[FIXED_HASH_SIZE];
					byte[] ZQbSxC30 = new byte[FIXED_SALT_SIZE];
					System.arraycopy(BtU2pPxd, 0, F14D5VzX, 0, FIXED_HASH_SIZE);
					System.arraycopy(BtU2pPxd, FIXED_HASH_SIZE, ZQbSxC30, 0, FIXED_SALT_SIZE);
					Jo5DpvoB.update(iovFKMRB.getBytes());
					Jo5DpvoB.update(ZQbSxC30);
					byte[] lmh2mQdX = Jo5DpvoB.digest();
					h4sGwwdA = MessageDigest.isEqual(F14D5VzX, lmh2mQdX);
				} catch (Exception vEOTBAta) {
					vEOTBAta.printStackTrace();
				}
			}
		}
		return h4sGwwdA;
	}

}