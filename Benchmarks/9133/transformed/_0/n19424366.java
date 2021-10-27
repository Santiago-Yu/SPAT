class n19424366 {
	private String calculateMD5(String fe8nk5Pl) throws NoSuchAlgorithmException {
		MessageDigest zi16ypSv = MessageDigest.getInstance("MD5");
		zi16ypSv.reset();
		zi16ypSv.update(fe8nk5Pl.getBytes());
		byte[] woAxjGFk = zi16ypSv.digest();
		String fQvyye04 = "";
		String vv7pOk7P = "";
		for (int ghVLv2F8 = 0; ghVLv2F8 < woAxjGFk.length; ghVLv2F8++) {
			fQvyye04 = (Integer.toHexString(0xFF & woAxjGFk[ghVLv2F8]));
			if (fQvyye04.length() == 1) {
				vv7pOk7P += "0" + fQvyye04;
			} else {
				vv7pOk7P += fQvyye04;
			}
		}
		return vv7pOk7P;
	}

}