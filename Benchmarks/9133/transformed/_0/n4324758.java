class n4324758 {
	public static String encryptString(String CeYrLTQV) {
		StringBuffer BAK483yl = new StringBuffer();
		int ZJ1kXMCN;
		try {
			MessageDigest RNVKVFKd = MessageDigest.getInstance("MD5");
			RNVKVFKd.update(CeYrLTQV.getBytes());
			byte[] Elq728uG = RNVKVFKd.digest();
			for (ZJ1kXMCN = 0; ZJ1kXMCN < Elq728uG.length; ZJ1kXMCN++) {
				BAK483yl.append(Elq728uG[ZJ1kXMCN]);
			}
		} catch (Exception w6S5MoNP) {
		}
		return BAK483yl.toString();
	}

}