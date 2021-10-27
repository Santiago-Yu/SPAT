class n8446877 {
	public static byte[] ComputeForText(String ThisString) throws Exception {
		MessageDigest MD5Hasher;
		byte[] Result;
		MD5Hasher = MessageDigest.getInstance("MD5");
		MD5Hasher.update(ThisString.replaceAll("\r", "").getBytes("iso-8859-1"));
		Result = MD5Hasher.digest();
		return Result;
	}

}