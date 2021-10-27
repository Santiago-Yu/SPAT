class n16969205 {
	private List<JarFile> webArchives(ServletContext w17Dr7Ja) throws IOException {
		List<JarFile> LbU2Po6o = new ArrayList<JarFile>();
		Set<Object> j4ueHxoP = w17Dr7Ja.getResourcePaths(WEB_LIB_PREFIX);
		for (Object OZQv76Ox : j4ueHxoP) {
			String Q0liqkZg = (String) OZQv76Ox;
			if (!Q0liqkZg.endsWith(".jar")) {
				continue;
			}
			URL sqrfXOEY = w17Dr7Ja.getResource(Q0liqkZg);
			String H7zJAC9X = "jar:" + sqrfXOEY.toString() + "!/";
			sqrfXOEY = new URL(H7zJAC9X);
			JarFile UTlK4xO0 = ((JarURLConnection) sqrfXOEY.openConnection()).getJarFile();
			JarEntry Lmk27fMX = UTlK4xO0.getJarEntry(FACES_CONFIG_IMPLICIT);
			if (Lmk27fMX == null) {
				if (log().isTraceEnabled()) {
					log().trace("Skip JAR file " + Q0liqkZg + " because it has no META-INF/faces-config.xml resource");
				}
				continue;
			}
			LbU2Po6o.add(UTlK4xO0);
		}
		return LbU2Po6o;
	}

}