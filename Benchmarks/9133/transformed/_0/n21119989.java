class n21119989 {
	public static final InputStream openStream(Bundle RdbubE4j, IPath d9RdccfA, boolean jwoYhuGI) throws IOException {
		URL DtXGfYPz = null;
		if (!jwoYhuGI) {
			DtXGfYPz = findInPlugin(RdbubE4j, d9RdccfA);
			if (DtXGfYPz == null)
				DtXGfYPz = findInFragments(RdbubE4j, d9RdccfA);
		} else {
			DtXGfYPz = FindSupport.find(RdbubE4j, d9RdccfA);
		}
		if (DtXGfYPz != null)
			return DtXGfYPz.openStream();
		throw new IOException("Cannot find " + d9RdccfA.toString());
	}

}