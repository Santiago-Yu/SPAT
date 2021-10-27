class n14863753 {
	private void generateGuid() throws NoSuchAlgorithmException {
		MessageDigest KZ8l0qxa = MessageDigest.getInstance("MD5");
		StringBuilder pMuwdDHA = new StringBuilder();
		long KCVnD5xA = System.currentTimeMillis();
		long ebYJJJRh = random.nextLong();
		pMuwdDHA.append(KCVnD5xA);
		pMuwdDHA.append("-");
		pMuwdDHA.append(ebYJJJRh);
		KZ8l0qxa.update(pMuwdDHA.toString().getBytes());
		byte[] yLZpFher = KZ8l0qxa.digest();
		StringBuilder tltQWlJ0 = new StringBuilder();
		for (int EDt2KxnW = 0; EDt2KxnW < yLZpFher.length; ++EDt2KxnW) {
			int MdpPsmTw = yLZpFher[EDt2KxnW] & 0xFF;
			if (MdpPsmTw < 0x10) {
				tltQWlJ0.append('0');
			}
			tltQWlJ0.append(Integer.toHexString(MdpPsmTw));
		}
		guid = tltQWlJ0.toString();
	}

}