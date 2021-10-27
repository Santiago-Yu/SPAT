class n2544868 {
	public String encode(String wTSd5YRi) {
		try {
			MessageDigest b7KPvIJo = MessageDigest.getInstance("MD5");
			b7KPvIJo.update(wTSd5YRi.getBytes());
			byte kpXD1Udj[] = b7KPvIJo.digest();
			int tGsOpy96;
			StringBuffer lyU89Ffy = new StringBuffer("");
			for (int dZ5728t0 = 0; dZ5728t0 < kpXD1Udj.length; dZ5728t0++) {
				tGsOpy96 = kpXD1Udj[dZ5728t0];
				if (tGsOpy96 < 0)
					tGsOpy96 += 256;
				if (tGsOpy96 < 16)
					lyU89Ffy.append("0");
				lyU89Ffy.append(Integer.toHexString(tGsOpy96));
			}
			return lyU89Ffy.toString();
		} catch (NoSuchAlgorithmException zttc7odq) {
			zttc7odq.printStackTrace();
		}
		return null;
	}

}