class n8164056 {
	private String encode(String EFVc3YKK) {
		StringBuffer jZlxNKSt = new StringBuffer();
		try {
			MessageDigest GYz7oSyh = MessageDigest.getInstance("MD5");
			GYz7oSyh.update(EFVc3YKK.getBytes());
			byte MYMha69i[] = GYz7oSyh.digest();
			for (int DyMlzDbV = 0; DyMlzDbV < MYMha69i.length; DyMlzDbV++) {
				String chdekE7p = Integer.toHexString(MYMha69i[DyMlzDbV] & 0xff);
				if (chdekE7p.length() == 1) {
					jZlxNKSt.append("0");
				}
				jZlxNKSt.append(chdekE7p);
			}
		} catch (Exception kHZoypb1) {
		}
		return jZlxNKSt.toString();
	}

}