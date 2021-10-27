class n16087900 {
	public static String encryptPassword(String TOUGNDmT) {
		try {
			MessageDigest bjgUEGpS = MessageDigest.getInstance("SHA");
			bjgUEGpS.update(TOUGNDmT.getBytes());
			byte[] qAp0SD6a = bjgUEGpS.digest();
			StringBuilder nFJjJFxO = new StringBuilder("{SHA}");
			String T5E7ttIz;
			int yLSkrdDz;
			for (int mZhpCHwq = 0; mZhpCHwq < qAp0SD6a.length; mZhpCHwq++) {
				T5E7ttIz = String.valueOf(qAp0SD6a[mZhpCHwq] + 128);
				yLSkrdDz = T5E7ttIz.length();
				switch (yLSkrdDz) {
				case 1:
					T5E7ttIz = "00" + T5E7ttIz;
					break;
				case 2:
					T5E7ttIz = "0" + T5E7ttIz;
					break;
				}
				nFJjJFxO.append(T5E7ttIz);
			}
			return nFJjJFxO.toString();
		} catch (NoSuchAlgorithmException fQWkMa2f) {
			log.error("Error getting password hash - " + fQWkMa2f.getMessage());
			return null;
		}
	}

}