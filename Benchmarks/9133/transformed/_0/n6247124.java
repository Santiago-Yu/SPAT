class n6247124 {
	public static long getFileTimeStamp(String P3etwoep, String DgX3Nh9L) throws Exception {
		if (P3etwoep == null)
			return 0;
		if (P3etwoep.startsWith("/")) {
			P3etwoep = P3etwoep.substring(1, P3etwoep.length());
		} else if (DgX3Nh9L != null && P3etwoep.startsWith(DgX3Nh9L)) {
			P3etwoep = P3etwoep.substring(DgX3Nh9L.length());
		}
		URL CiFuX2hJ = Thread.currentThread().getContextClassLoader().getResource(P3etwoep);
		URLConnection xOmLErUK = null;
		try {
			if (CiFuX2hJ == null) {
				return 0;
			}
			xOmLErUK = CiFuX2hJ.openConnection();
			return xOmLErUK.getLastModified();
		} finally {
			if (xOmLErUK != null && xOmLErUK.getInputStream() != null)
				xOmLErUK.getInputStream().close();
		}
	}

}