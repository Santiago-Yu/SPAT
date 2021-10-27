class n3253205 {
	private String generateUniqueIdMD5(Run run, HttpServletRequest request, String groupIdString) {
		String portalUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
		MessageDigest m = null;
		String uniqueportalUrl = portalUrl + "run:" + run.getId().toString() + "group:" + groupIdString;
		try {
			m = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		m.update(uniqueportalUrl.getBytes(), 0, uniqueportalUrl.length());
		String uniqueIdMD5 = new BigInteger(1, m.digest()).toString(16);
		return uniqueIdMD5;
	}

}