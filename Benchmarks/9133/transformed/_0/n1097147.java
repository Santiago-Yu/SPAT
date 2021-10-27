class n1097147 {
	public static String getMessageDigest(String[] JXaTRLLq) {
		if (JXaTRLLq.length == 0)
			return null;
		try {
			MessageDigest Mee38VfO = MessageDigest.getInstance("SHA-1");
			for (String ub05NJhn : JXaTRLLq)
				Mee38VfO.update(ub05NJhn.getBytes());
			byte[] DyjBfmeX = Mee38VfO.digest();
			String ZyAC4deG = "";
			int rIcITLNI = 0;
			String tUoOAyYQ = "";
			for (int tfYvT1fP = 0; tfYvT1fP < 20; tfYvT1fP++) {
				rIcITLNI = DyjBfmeX[tfYvT1fP];
				if (rIcITLNI < 0)
					rIcITLNI += 256;
				tUoOAyYQ = Integer.toHexString(rIcITLNI);
				if (tUoOAyYQ.length() < 2)
					ZyAC4deG = ZyAC4deG.concat("0");
				ZyAC4deG = ZyAC4deG.concat(tUoOAyYQ);
			}
			ZyAC4deG = ZyAC4deG.toUpperCase();
			return ZyAC4deG;
		} catch (NoSuchAlgorithmException FfjxpRQZ) {
			throw new IllegalStateException(FfjxpRQZ.getMessage());
		}
	}

}