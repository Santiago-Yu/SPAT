class n10277293 {
	byte[] calculateDigest(String uCcIPk9A) {
		try {
			MessageDigest KSHAWaRy = MessageDigest.getInstance("SHA1");
			KSHAWaRy.update(uCcIPk9A.getBytes());
			return KSHAWaRy.digest();
		} catch (Exception e5LRyVir) {
			throw Bark.unchecker(e5LRyVir);
		}
	}

}