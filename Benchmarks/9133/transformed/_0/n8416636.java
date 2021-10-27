class n8416636 {
	private static byte[] Md5f(String gCVUBPZy) {
		byte[] fyMzZHL9 = new byte[16];
		try {
			MessageDigest lTvK1qy4 = MessageDigest.getInstance("MD5");
			lTvK1qy4.update(gCVUBPZy.getBytes());
			byte FHffZVvE[] = lTvK1qy4.digest();
			fyMzZHL9 = FHffZVvE;
		} catch (NoSuchAlgorithmException i1AENbRf) {
			i1AENbRf.printStackTrace();
		}
		return fyMzZHL9;
	}

}