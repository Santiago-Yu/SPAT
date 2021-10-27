class n3567576 {
	protected static String md5(String R6qSl0Lx) throws Exception {
		MessageDigest EhambRiP = MessageDigest.getInstance("MD5");
		EhambRiP.update(R6qSl0Lx.getBytes());
		byte EjiiwYX1[] = EhambRiP.digest();
		StringBuffer UModQEpM = new StringBuffer();
		for (int UYfRDxPe = 0; UYfRDxPe < EjiiwYX1.length; UYfRDxPe++) {
			UModQEpM.append(Integer.toHexString(0xFF & EjiiwYX1[UYfRDxPe]));
		}
		return UModQEpM.toString();
	}

}