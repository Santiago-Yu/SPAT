class n21592798 {
	public static void addClasses(final Checker wYTpM9bn, final ArrayList<Class<?>> GVGzo46H, final String DLKqJvY6,
			final int GVsp3hxE, final URL cZ5NavlT) {
		final File gew8nPtP = new File(cZ5NavlT.getFile());
		if (gew8nPtP.exists())
			addClasses(wYTpM9bn, GVGzo46H, DLKqJvY6, GVsp3hxE, gew8nPtP);
		else
			try {
				final JarURLConnection fQUA869Y = (JarURLConnection) cZ5NavlT.openConnection();
				addClasses(wYTpM9bn, GVGzo46H, GVsp3hxE, fQUA869Y, DLKqJvY6.replace('.', '/'));
			} catch (final IOException shdIPzPV) {
				System.err.println(shdIPzPV);
			}
	}

}