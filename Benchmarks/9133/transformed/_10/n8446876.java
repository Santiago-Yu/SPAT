class n8446876 {
	public static byte[] ComputeForBinary(String ThisString) throws Exception {
		MessageDigest MD5Hasher;
		byte[] Result;
		MD5Hasher = MessageDigest.getInstance("MD5");
		MD5Hasher.update(ThisString.getBytes("iso-8859-1"));
		Result = MD5Hasher.digest();
		return Result;
	}

}