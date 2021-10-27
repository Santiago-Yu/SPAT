class n9568958 {
	private void getRandomGuid(boolean YhJM6ZkF) {
		MessageDigest qxxY0Q4D = null;
		StringBuffer ewRvPWcH = new StringBuffer();
		try {
			qxxY0Q4D = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException VjpsxbMD) {
			System.out.println("Error: " + VjpsxbMD);
		}
		try {
			long dLig2u3t = System.currentTimeMillis();
			long shixAuC5 = 0;
			if (YhJM6ZkF) {
				shixAuC5 = secureRandom.nextLong();
			} else {
				shixAuC5 = random.nextLong();
			}
			ewRvPWcH.append(id);
			ewRvPWcH.append(":");
			ewRvPWcH.append(Long.toString(dLig2u3t));
			ewRvPWcH.append(":");
			ewRvPWcH.append(Long.toString(shixAuC5));
			valueBeforeMD5 = ewRvPWcH.toString();
			qxxY0Q4D.update(valueBeforeMD5.getBytes());
			byte[] q9f9R6Zm = qxxY0Q4D.digest();
			StringBuffer lEb0cRwF = new StringBuffer();
			for (int nW38A2Bm = 0; nW38A2Bm < q9f9R6Zm.length; ++nW38A2Bm) {
				int SLcRc2tN = q9f9R6Zm[nW38A2Bm] & 0xFF;
				if (SLcRc2tN < 0x10)
					lEb0cRwF.append('0');
				lEb0cRwF.append(Integer.toHexString(SLcRc2tN));
			}
			valueAfterMD5 = lEb0cRwF.toString();
		} catch (Exception QANmKm0f) {
			System.out.println("Error:" + QANmKm0f);
		}
	}

}