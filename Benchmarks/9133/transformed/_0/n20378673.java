class n20378673 {
	private void getRandomGUID(boolean ysLMuR8B) {
		MessageDigest JKjF01po = null;
		StringBuffer b418LnvH = new StringBuffer();
		try {
			JKjF01po = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException vb39O6qo) {
			System.out.println("Error: " + vb39O6qo);
		}
		try {
			long w5RttRFm = System.currentTimeMillis();
			long x4YpUyKg = 0;
			if (ysLMuR8B) {
				x4YpUyKg = mySecureRand.nextLong();
			} else {
				x4YpUyKg = myRand.nextLong();
			}
			b418LnvH.append(s_id);
			b418LnvH.append(":");
			b418LnvH.append(Long.toString(w5RttRFm));
			b418LnvH.append(":");
			b418LnvH.append(Long.toString(x4YpUyKg));
			valueBeforeMD5 = b418LnvH.toString();
			JKjF01po.update(valueBeforeMD5.getBytes());
			byte[] tYR9R1Q4 = JKjF01po.digest();
			StringBuffer IAIJIA4l = new StringBuffer();
			for (int RGtiJkvu = 0; RGtiJkvu < tYR9R1Q4.length; ++RGtiJkvu) {
				int F7X1NaT3 = tYR9R1Q4[RGtiJkvu] & 0xFF;
				if (F7X1NaT3 < 0x10)
					IAIJIA4l.append('0');
				IAIJIA4l.append(Integer.toHexString(F7X1NaT3));
			}
			valueAfterMD5 = IAIJIA4l.toString();
		} catch (Exception XE032y5L) {
			System.out.println("Error:" + XE032y5L);
		}
	}

}