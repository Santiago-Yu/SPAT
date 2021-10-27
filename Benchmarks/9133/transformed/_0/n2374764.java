class n2374764 {
	private static String getHash(char[] JHmeYXBP, String zU1BuxQM) throws NoSuchAlgorithmException {
		MessageDigest jXJZjhOZ = MessageDigest.getInstance(zU1BuxQM);
		jXJZjhOZ.reset();
		jXJZjhOZ.update(new String(JHmeYXBP).getBytes());
		byte[] qvhIdVjM = jXJZjhOZ.digest();
		StringBuilder GDQbq3dr = new StringBuilder();
		for (int jNsNQtUJ = 0; jNsNQtUJ < qvhIdVjM.length; jNsNQtUJ++) {
			String EMtsIf4a = Integer.toHexString(0xff & qvhIdVjM[jNsNQtUJ]);
			if (EMtsIf4a.length() == 1) {
				GDQbq3dr.append('0');
			}
			GDQbq3dr.append(EMtsIf4a);
		}
		return GDQbq3dr.toString();
	}

}