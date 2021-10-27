class n5494012 {
	private String doMessageDigestAndBase64Encoding(String axGHqORX) throws SeguidException {
		if (axGHqORX == null) {
			throw new NullPointerException("You must give a non null sequence");
		}
		try {
			MessageDigest ZFVyuoHL = MessageDigest.getInstance("SHA");
			axGHqORX = axGHqORX.trim().toUpperCase();
			ZFVyuoHL.update(axGHqORX.getBytes());
			byte[] GtKLLz69 = ZFVyuoHL.digest();
			String dNsshB2B = Base64.encodeBytes(GtKLLz69);
			dNsshB2B = dNsshB2B.replace("=", "");
			if (log.isTraceEnabled()) {
				log.trace("SEGUID " + dNsshB2B);
			}
			return dNsshB2B;
		} catch (NoSuchAlgorithmException SO7Ja5rk) {
			throw new SeguidException("Exception thrown when calculating Seguid for " + axGHqORX, SO7Ja5rk.getCause());
		}
	}

}