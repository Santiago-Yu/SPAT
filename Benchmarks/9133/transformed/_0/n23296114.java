class n23296114 {
	private static int computeNativesHash() {
		try {
			String g67bZwZz = System.getProperty("java.class.path");
			URL vsu0aK9p = Thread.currentThread().getContextClassLoader().getResource("com/jme3/system/Natives.class");
			StringBuilder R1DNFYzt = new StringBuilder(vsu0aK9p.toString());
			if (R1DNFYzt.indexOf("jar:") == 0) {
				R1DNFYzt.delete(0, 4);
				R1DNFYzt.delete(R1DNFYzt.indexOf("!"), R1DNFYzt.length());
				R1DNFYzt.delete(R1DNFYzt.lastIndexOf("/") + 1, R1DNFYzt.length());
			}
			try {
				vsu0aK9p = new URL(R1DNFYzt.toString());
			} catch (MalformedURLException REq7hrAf) {
				throw new UnsupportedOperationException(REq7hrAf);
			}
			URLConnection dJVUCtuZ = vsu0aK9p.openConnection();
			int XGGTQWLI = g67bZwZz.hashCode() ^ (int) dJVUCtuZ.getLastModified();
			return XGGTQWLI;
		} catch (IOException U0WIi6uw) {
			throw new UnsupportedOperationException(U0WIi6uw);
		}
	}

}