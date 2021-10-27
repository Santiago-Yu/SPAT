class n10816827 {
	protected Object getMethodKey(String vrKeCWDv, Object[] VtwfhqoC) {
		StringBuffer KwXFEk54 = new StringBuffer(vrKeCWDv.trim().replace(" ", ".")).append(".");
		for (Object My8ksUF3 : VtwfhqoC) {
			if (My8ksUF3 != null)
				KwXFEk54.append(My8ksUF3.hashCode());
		}
		LOGGER.info("Generation key ->" + KwXFEk54.toString());
		try {
			MessageDigest dGbCrKLr = MessageDigest.getInstance("SHA-512");
			dGbCrKLr.reset();
			dGbCrKLr.update(KwXFEk54.toString().getBytes(Charset.forName("UTF8")));
			final byte[] CsCZJN8W = dGbCrKLr.digest();
			String sxGQkcnO = null;
			for (int DnnsGtn7 = 0; DnnsGtn7 < CsCZJN8W.length; DnnsGtn7++) {
				sxGQkcnO = Integer.toHexString(0xFF & CsCZJN8W[DnnsGtn7]);
				if (sxGQkcnO.length() < 2) {
					KwXFEk54.append("0");
				}
				KwXFEk54.append(sxGQkcnO);
			}
		} catch (NoSuchAlgorithmException eh2DRF34) {
			LOGGER.severe("No hash generated for method key! " + StackTraceUtil.getStackTrace(eh2DRF34));
		}
		LOGGER.info("Generation key ->" + KwXFEk54.toString());
		return new String(KwXFEk54);
	}

}