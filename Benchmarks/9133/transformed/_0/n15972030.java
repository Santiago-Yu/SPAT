class n15972030 {
	private void getGUID(boolean TdtkXuw8) {
		MessageDigest NHFrZ4dU = null;
		StringBuffer niYn9rYZ = new StringBuffer();
		try {
			NHFrZ4dU = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException BpnjSV8v) {
			System.out.println("Error: " + BpnjSV8v);
		}
		try {
			long QK0XjkTu = System.currentTimeMillis();
			long YV4epAWG = 0;
			if (TdtkXuw8) {
				YV4epAWG = mySecureRand.nextLong();
			} else {
				YV4epAWG = myRand.nextLong();
			}
			niYn9rYZ.append(s_id);
			niYn9rYZ.append(":");
			niYn9rYZ.append(Long.toString(QK0XjkTu));
			niYn9rYZ.append(":");
			niYn9rYZ.append(Long.toString(YV4epAWG));
			valueBeforeMD5 = niYn9rYZ.toString();
			NHFrZ4dU.update(valueBeforeMD5.getBytes());
			byte[] s6UJcWMf = NHFrZ4dU.digest();
			StringBuffer zUl8ZRNw = new StringBuffer();
			for (int oYM4qDQK = 0; oYM4qDQK < s6UJcWMf.length; ++oYM4qDQK) {
				int yCSb915y = s6UJcWMf[oYM4qDQK] & 0xFF;
				if (yCSb915y < 0x10)
					zUl8ZRNw.append('0');
				zUl8ZRNw.append(Integer.toHexString(yCSb915y));
			}
			valueAfterMD5 = zUl8ZRNw.toString();
		} catch (Exception oUhgZYJK) {
			System.out.println("Error:" + oUhgZYJK);
		}
	}

}