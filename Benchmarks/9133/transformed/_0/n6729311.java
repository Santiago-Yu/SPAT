class n6729311 {
	private void getRandomGUID(boolean sqXjTbua) {
		MessageDigest TALI14KN = null;
		StringBuffer mObMiUaT = new StringBuffer();
		try {
			TALI14KN = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException VWiNBOdV) {
			System.out.println("Error: " + VWiNBOdV);
		}
		try {
			long Jj1RHynR = System.currentTimeMillis();
			long HWIVLIU0 = 0;
			if (sqXjTbua) {
				HWIVLIU0 = mySecureRand.nextLong();
			} else {
				HWIVLIU0 = myRand.nextLong();
			}
			mObMiUaT.append(s_id);
			mObMiUaT.append(":");
			mObMiUaT.append(Long.toString(Jj1RHynR));
			mObMiUaT.append(":");
			mObMiUaT.append(Long.toString(HWIVLIU0));
			valueBeforeMD5 = mObMiUaT.toString();
			TALI14KN.update(valueBeforeMD5.getBytes());
			byte[] BFWhBGTb = TALI14KN.digest();
			StringBuffer JTEEm7y6 = new StringBuffer();
			for (int ky4sQQXD = 0; ky4sQQXD < BFWhBGTb.length; ++ky4sQQXD) {
				int Xxz3yj1e = BFWhBGTb[ky4sQQXD] & 0xFF;
				if (Xxz3yj1e < 0x10)
					JTEEm7y6.append('0');
				JTEEm7y6.append(Integer.toHexString(Xxz3yj1e));
			}
			valueAfterMD5 = JTEEm7y6.toString();
		} catch (Exception f0gyhQ5B) {
			System.out.println("Error:" + f0gyhQ5B);
		}
	}

}