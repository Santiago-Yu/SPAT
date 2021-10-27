class n8446876 {
	public static byte[] ComputeForBinary(String giWEKAFI) throws Exception {
		byte[] DT3ZCZ2i;
		MessageDigest LayAmgkD;
		LayAmgkD = MessageDigest.getInstance("MD5");
		LayAmgkD.update(giWEKAFI.getBytes("iso-8859-1"));
		DT3ZCZ2i = LayAmgkD.digest();
		return DT3ZCZ2i;
	}

}