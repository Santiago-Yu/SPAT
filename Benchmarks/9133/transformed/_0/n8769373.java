class n8769373 {
	private void getRandomGUID(boolean TZvu9nId) {
		MessageDigest cadn2Yp6 = null;
		StringBuffer M8GgSwwM = new StringBuffer();
		try {
			cadn2Yp6 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException bdgM6s2h) {
			System.out.println("Error: " + bdgM6s2h);
		}
		try {
			long apxycnH9 = System.currentTimeMillis();
			long WOXMBVZP = 0;
			if (TZvu9nId) {
				WOXMBVZP = mySecureRand.nextLong();
			} else {
				WOXMBVZP = myRand.nextLong();
			}
			M8GgSwwM.append(s_id);
			M8GgSwwM.append(":");
			M8GgSwwM.append(Long.toString(apxycnH9));
			M8GgSwwM.append(":");
			M8GgSwwM.append(Long.toString(WOXMBVZP));
			valueBeforeMD5 = M8GgSwwM.toString();
			cadn2Yp6.update(valueBeforeMD5.getBytes());
			byte[] zAwPSThG = cadn2Yp6.digest();
			StringBuffer qdvzL1dG = new StringBuffer();
			for (int e7cf89DG = 0; e7cf89DG < zAwPSThG.length; ++e7cf89DG) {
				int gHrlcIry = zAwPSThG[e7cf89DG] & 0xFF;
				if (gHrlcIry < 0x10)
					qdvzL1dG.append('0');
				qdvzL1dG.append(Integer.toHexString(gHrlcIry));
			}
			valueAfterMD5 = qdvzL1dG.toString();
		} catch (Exception IDUoQGYP) {
			System.out.println("Error:" + IDUoQGYP);
		}
	}

}