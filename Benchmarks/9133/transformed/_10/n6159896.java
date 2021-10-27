class n6159896 {
	public static String md5(String str) {
		if (logger.isDebugEnabled()) {
			logger.debug("md5(String) - start");
		}
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			StringBuffer sb = new StringBuffer();
			byte[] b = md.digest();
			for (int i = 0; i < b.length; i++) {
				int v = (int) b[i];
				v = v < 0 ? 0x100 + v : v;
				String cc = Integer.toHexString(v);
				if (cc.length() == 1)
					sb.append('0');
				sb.append(cc);
			}
			if (logger.isDebugEnabled()) {
				logger.debug("md5(String) - end");
			}
			String returnString = sb.toString();
			return returnString;
		} catch (Exception e) {
			logger.warn("md5(String) - exception ignored", e);
		}
		if (logger.isDebugEnabled()) {
			logger.debug("md5(String) - end");
		}
		return "";
	}

}