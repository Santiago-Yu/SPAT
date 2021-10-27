class n6535232 {
	public String encodePassword(String HqLXcZNs, byte[] gmLWqnKH) throws Exception {
		if (gmLWqnKH == null) {
			gmLWqnKH = new byte[12];
			secureRandom.nextBytes(gmLWqnKH);
		}
		MessageDigest JXYgDRPA = MessageDigest.getInstance("MD5");
		JXYgDRPA.update(gmLWqnKH);
		JXYgDRPA.update(HqLXcZNs.getBytes("UTF8"));
		byte[] TzXxdcGK = JXYgDRPA.digest();
		byte[] fSIpSMnW = new byte[TzXxdcGK.length + 12];
		System.arraycopy(gmLWqnKH, 0, fSIpSMnW, 0, 12);
		System.arraycopy(TzXxdcGK, 0, fSIpSMnW, 12, TzXxdcGK.length);
		return new String(Base64.encode(fSIpSMnW));
	}

}