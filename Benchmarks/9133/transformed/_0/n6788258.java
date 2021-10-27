class n6788258 {
	private void getRandomGUID(boolean Glm4lecD) {
		MessageDigest RSCxissM = null;
		StringBuffer jxvEfH7M = new StringBuffer();
		try {
			RSCxissM = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException NjfFcvlV) {
			System.out.println("Error: " + NjfFcvlV);
		}
		try {
			long ZMs4poNk = System.currentTimeMillis();
			long Rgs9qjTp = 0;
			if (Glm4lecD) {
				Rgs9qjTp = mySecureRand.nextLong();
			} else {
				Rgs9qjTp = myRand.nextLong();
			}
			jxvEfH7M.append(s_id);
			jxvEfH7M.append(":");
			jxvEfH7M.append(Long.toString(ZMs4poNk));
			jxvEfH7M.append(":");
			jxvEfH7M.append(Long.toString(Rgs9qjTp));
			valueBeforeMD5 = jxvEfH7M.toString();
			RSCxissM.update(valueBeforeMD5.getBytes());
			byte[] Amkjh4um = RSCxissM.digest();
			StringBuffer OnNFU1ou = new StringBuffer();
			for (int ifEhCrhO = 0; ifEhCrhO < Amkjh4um.length; ++ifEhCrhO) {
				int O1WcT2Wg = Amkjh4um[ifEhCrhO] & 0xFF;
				if (O1WcT2Wg < 0x10)
					OnNFU1ou.append('0');
				OnNFU1ou.append(Integer.toHexString(O1WcT2Wg));
			}
			valueAfterMD5 = OnNFU1ou.toString();
		} catch (Exception CmtMuJS2) {
			System.out.println("Error:" + CmtMuJS2);
		}
	}

}