class n8969949 {
	public static String getHash(String VP9jq9wq) throws NoSuchAlgorithmException {
		MessageDigest Q3KFHGPx = MessageDigest.getInstance("MD5");
		Q3KFHGPx.update(VP9jq9wq.getBytes());
		byte Eu45yvb9[] = Q3KFHGPx.digest();
		StringBuffer BVxSJY6v = new StringBuffer();
		for (int Pu4iWJ5I = 0; Pu4iWJ5I < Eu45yvb9.length; Pu4iWJ5I++) {
			BVxSJY6v.append(Integer.toHexString(0xFF & Eu45yvb9[Pu4iWJ5I]));
		}
		return BVxSJY6v.toString();
	}

}