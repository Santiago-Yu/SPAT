class n8258096 {
	private String encryptPassword(String hyZRCpjB) throws NoSuchAlgorithmException {
		StringBuffer QZ0yBWGM = new StringBuffer();
		MessageDigest nVpJsy9x = MessageDigest.getInstance("MD5");
		nVpJsy9x.reset();
		nVpJsy9x.update(hyZRCpjB.getBytes());
		byte U992zO50[] = nVpJsy9x.digest();
		for (int zI9o6Q0k = 0; zI9o6Q0k < U992zO50.length; zI9o6Q0k++) {
			String tU333llh = Integer.toHexString(0xFF & U992zO50[zI9o6Q0k]);
			if (tU333llh.length() == 1) {
				QZ0yBWGM.append('0');
			}
			QZ0yBWGM.append(tU333llh);
		}
		return QZ0yBWGM.toString();
	}

}