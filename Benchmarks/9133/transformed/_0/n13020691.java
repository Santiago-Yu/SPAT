class n13020691 {
	private void getRandomGUID(boolean Yq3BhNlz) {
		MessageDigest v6SoI39Q = null;
		StringBuffer KLm7LPLX = new StringBuffer();
		try {
			v6SoI39Q = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException eSkN40ov) {
		}
		try {
			long jqqeyevl = System.currentTimeMillis();
			long t9lUqeph = 0;
			if (Yq3BhNlz) {
				t9lUqeph = mySecureRand.nextLong();
			} else {
				t9lUqeph = myRand.nextLong();
			}
			KLm7LPLX.append(s_id);
			KLm7LPLX.append(":");
			KLm7LPLX.append(Long.toString(jqqeyevl));
			KLm7LPLX.append(":");
			KLm7LPLX.append(Long.toString(t9lUqeph));
			valueBeforeMD5 = KLm7LPLX.toString();
			v6SoI39Q.update(valueBeforeMD5.getBytes());
			byte[] zCZpRlYy = v6SoI39Q.digest();
			StringBuffer jWEZFD1I = new StringBuffer();
			for (int mLzr4KA7 = 0; mLzr4KA7 < zCZpRlYy.length; ++mLzr4KA7) {
				int cQDPIoOX = zCZpRlYy[mLzr4KA7] & 0xFF;
				if (cQDPIoOX < 0x10)
					jWEZFD1I.append('0');
				jWEZFD1I.append(Integer.toHexString(cQDPIoOX));
			}
			valueAfterMD5 = jWEZFD1I.toString();
		} catch (Exception SgXUvz58) {
			System.out.println("Error:" + SgXUvz58);
		}
	}

}