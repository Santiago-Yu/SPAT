class n19578818 {
	public String calculateDigest(String skIRGmt3) {
		StringBuffer b5w95LRj = new StringBuffer();
		try {
			MessageDigest zvEH0Tei = MessageDigest.getInstance("SHA-1");
			zvEH0Tei.update(skIRGmt3.getBytes());
			byte[] Pryhmz3e = zvEH0Tei.digest();
			for (byte iSbPucHC : Pryhmz3e) {
				b5w95LRj.append(Integer.toHexString((int) (iSbPucHC & 0xff)));
			}
		} catch (NoSuchAlgorithmException H6LvfDe1) {
			H6LvfDe1.printStackTrace();
		}
		return b5w95LRj.toString();
	}

}