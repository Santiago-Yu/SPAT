class n5735102 {
	private static PointGeomReader[] loadResourceList(final String VzgWwfVR, ClassLoader V9YvlL25) {
		if (V9YvlL25 == null)
			V9YvlL25 = ClassLoader.getSystemClassLoader();
		final FastSet<PointGeomReader> AAoG8UuF = FastSet.newInstance();
		try {
			final Enumeration<URL> Jm9t27wT = V9YvlL25.getResources(VzgWwfVR);
			if (Jm9t27wT != null) {
				while (Jm9t27wT.hasMoreElements()) {
					final URL ePbNKQXR = Jm9t27wT.nextElement();
					final Properties FxNFAe5Q;
					InputStream lGoboUQ9 = null;
					try {
						lGoboUQ9 = ePbNKQXR.openStream();
						FxNFAe5Q = new Properties();
						FxNFAe5Q.load(lGoboUQ9);
					} catch (IOException uOwsDz3B) {
						continue;
					} finally {
						if (lGoboUQ9 != null)
							try {
								lGoboUQ9.close();
							} catch (Exception asdr39cf) {
							}
					}
					for (Enumeration bQ4ezNI4 = FxNFAe5Q.propertyNames(); bQ4ezNI4.hasMoreElements();) {
						final String UTUPhFRW = (String) bQ4ezNI4.nextElement();
						final String ToPmE1E2 = FxNFAe5Q.getProperty(UTUPhFRW);
						AAoG8UuF.add(loadResource(ToPmE1E2, V9YvlL25));
					}
				}
			}
		} catch (IOException xDP2lj27) {
		}
		PointGeomReader[] gQljfOjp = AAoG8UuF.toArray(new PointGeomReader[AAoG8UuF.size()]);
		Arrays.sort(gQljfOjp, FastComparator.DEFAULT);
		FastSet.recycle(AAoG8UuF);
		return gQljfOjp;
	}

}