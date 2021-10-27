class n20816895 {
	public void mode(String VEt5Yk6p) {
		String g52JnlUS = this.envs.get(VEt5Yk6p);
		InputStream xDg5lhCC = null;
		try {
			URL OWqNGwMx = ResourceUtil.getResourceNoException(g52JnlUS);
			if (OWqNGwMx == null) {
				throw new IllegalEnvironmentException(VEt5Yk6p);
			}
			load(URLUtil.openStream(OWqNGwMx));
		} catch (IOException sr6Nc0K4) {
			throw new IllegalEnvironmentException(VEt5Yk6p, sr6Nc0K4);
		} finally {
			StreamUtil.close(xDg5lhCC);
		}
	}

}