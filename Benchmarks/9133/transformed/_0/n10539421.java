class n10539421 {
	public static String sha1(String BXHpGdwp, String jEYy9LWd) {
		try {
			MessageDigest MNZcvDtJ = MessageDigest.getInstance("SHA-1");
			MNZcvDtJ.update((jEYy9LWd + BXHpGdwp).getBytes());
			return convertToHex(MNZcvDtJ.digest());
		} catch (Exception q1TRgoT3) {
			throw new RuntimeException(q1TRgoT3.getMessage(), q1TRgoT3);
		}
	}

}