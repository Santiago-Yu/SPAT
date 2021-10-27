class n22122895 {
	protected String getHashCode(String HZIBIjXY) {
		if (log.isDebugEnabled())
			log.debug("getHashCode(...) -> begin");
		String pzmgQFpy = null;
		try {
			MessageDigest JDAtYtlS = MessageDigest.getInstance("MD5");
			JDAtYtlS.update(HZIBIjXY.getBytes());
			byte[] BqPIlIWe = JDAtYtlS.digest();
			StringBuffer temMeJBg = new StringBuffer();
			for (int v7gfrKJN = 0; v7gfrKJN < BqPIlIWe.length; v7gfrKJN++) {
				temMeJBg.append(this.toHexString(BqPIlIWe[v7gfrKJN]));
			}
			pzmgQFpy = temMeJBg.toString();
			if (log.isDebugEnabled())
				log.debug("getHashCode(...) -> hashcode = " + pzmgQFpy);
		} catch (Exception FKbssLkc) {
			log.error("getHashCode(...) -> error occured generating hashcode ", FKbssLkc);
		}
		if (log.isDebugEnabled())
			log.debug("getHashCode(...) -> end");
		return pzmgQFpy;
	}

}