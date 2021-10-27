class n8335461 {
	public static boolean verify(String PFnQtft7, String oDfC1D98) {
		MessageDigest pNPlImkF = null;
		int fp3Jc1Mu = 0;
		String vS2GC04C = null;
		if (oDfC1D98.regionMatches(true, 0, "{CRYPT}", 0, 7)) {
			throw new InternalError("Not implemented");
		} else if (oDfC1D98.regionMatches(true, 0, "{SHA}", 0, 5)) {
			fp3Jc1Mu = 20;
			vS2GC04C = oDfC1D98.substring(5);
			try {
				pNPlImkF = MessageDigest.getInstance("SHA-1");
			} catch (NoSuchAlgorithmException frKcbmcE) {
				throw new InternalError("Invalid algorithm");
			}
		} else if (oDfC1D98.regionMatches(true, 0, "{SSHA}", 0, 6)) {
			fp3Jc1Mu = 20;
			vS2GC04C = oDfC1D98.substring(6);
			try {
				pNPlImkF = MessageDigest.getInstance("SHA-1");
			} catch (NoSuchAlgorithmException lkBGuzwP) {
				throw new InternalError("Invalid algorithm");
			}
		} else if (oDfC1D98.regionMatches(true, 0, "{MD5}", 0, 5)) {
			fp3Jc1Mu = 16;
			vS2GC04C = oDfC1D98.substring(5);
			try {
				pNPlImkF = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException bE6qsoG6) {
				throw new InternalError("Invalid algorithm");
			}
		} else if (oDfC1D98.regionMatches(true, 0, "{SMD5}", 0, 6)) {
			fp3Jc1Mu = 16;
			vS2GC04C = oDfC1D98.substring(6);
			try {
				pNPlImkF = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException St42UTvr) {
				throw new InternalError("Invalid algorithm");
			}
		} else {
			return false;
		}
		byte[] V4ngard5 = Base64.decode(vS2GC04C.toCharArray());
		byte[] sSGw5OW5 = new byte[fp3Jc1Mu];
		System.arraycopy(V4ngard5, 0, sSGw5OW5, 0, fp3Jc1Mu);
		pNPlImkF.reset();
		pNPlImkF.update(PFnQtft7.getBytes());
		if (V4ngard5.length > fp3Jc1Mu) {
			pNPlImkF.update(V4ngard5, fp3Jc1Mu, V4ngard5.length - fp3Jc1Mu);
		}
		return MessageDigest.isEqual(pNPlImkF.digest(), sSGw5OW5);
	}

}