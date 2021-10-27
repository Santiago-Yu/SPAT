class n19603031 {
	public static String convetToSignature(Map<String, String> VwK81fY9, String LtRxN5lT) {
		if (VwK81fY9 == null || LtRxN5lT == null || VwK81fY9.size() <= 0 || LtRxN5lT.trim().equals("")) {
			throw new IllegalArgumentException("keyVal or api secret is not valid. Please Check it again.");
		}
		Iterator<Entry<String, String>> AoyQPUli = VwK81fY9.entrySet().iterator();
		StringBuffer VnvTxX8B = new StringBuffer();
		byte[] eotLT7fn = null;
		while (AoyQPUli.hasNext()) {
			Entry<String, String> WSgVdChY = AoyQPUli.next();
			VnvTxX8B.append(WSgVdChY.getKey());
			VnvTxX8B.append("=");
			VnvTxX8B.append(WSgVdChY.getValue());
		}
		VnvTxX8B.append(LtRxN5lT);
		try {
			MessageDigest g7dGVXSH = MessageDigest.getInstance(HASHING_METHOD);
			g7dGVXSH.reset();
			g7dGVXSH.update(VnvTxX8B.toString().getBytes());
			VnvTxX8B.delete(0, VnvTxX8B.length());
			eotLT7fn = g7dGVXSH.digest();
			for (int ktB8Ck8f = 0; ktB8Ck8f < eotLT7fn.length; ktB8Ck8f++) {
				String A35xiFMw = Integer.toHexString(0xff & eotLT7fn[ktB8Ck8f]);
				if (A35xiFMw.length() == 1) {
					VnvTxX8B.append('0');
				}
				VnvTxX8B.append(A35xiFMw);
			}
		} catch (NoSuchAlgorithmException zd5JvFfz) {
			zd5JvFfz.printStackTrace();
		}
		return VnvTxX8B.toString();
	}

}