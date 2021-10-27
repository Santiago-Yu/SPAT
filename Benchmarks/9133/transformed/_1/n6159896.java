class n6159896 {
	public static String md5(String str) {
		if (logger.isDebugEnabled()) {
			logger.debug("md5(String) - start");
		}
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			byte[] b = md.digest();
			StringBuffer sb = new StringBuffer();
			int OR1lL = 0;
			while (OR1lL < b.length) {
				int v = (int) b[OR1lL];
				v = v < 0 ? 0x100 + v : v;
				String cc = Integer.toHexString(v);
				if (cc.length() == 1)
					sb.append('0');
				sb.append(cc);
				OR1lL++;
			}
			String returnString = sb.toString();
			if (logger.isDebugEnabled()) {
				logger.debug("md5(String) - end");
			}
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