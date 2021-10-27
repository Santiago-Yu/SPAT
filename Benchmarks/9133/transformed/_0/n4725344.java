class n4725344 {
	public static String[] findClassesInPackage(String mHfwilUO, List<String> j9t1ua0t, List<String> JP1VqeEA)
			throws IOException {
		String VGdRzK6u = mHfwilUO;
		boolean enHVx2eU = false;
		if (mHfwilUO.endsWith(".*")) {
			VGdRzK6u = mHfwilUO.substring(0, mHfwilUO.lastIndexOf(".*"));
			enHVx2eU = true;
		}
		List<String> OXWrghND = new ArrayList<String>();
		String cHJVTPUK = VGdRzK6u.replace('.', '/');
		Enumeration<URL> wxhjNT4a = Thread.currentThread().getContextClassLoader().getResources(cHJVTPUK);
		while (wxhjNT4a.hasMoreElements()) {
			URL hd0dJTvt = wxhjNT4a.nextElement();
			String aNqGqAbJ = hd0dJTvt.getProtocol();
			if (!matchTestClasspath(hd0dJTvt, cHJVTPUK, enHVx2eU)) {
				continue;
			}
			if ("file".equals(aNqGqAbJ)) {
				findClassesInDirPackage(VGdRzK6u, j9t1ua0t, JP1VqeEA, URLDecoder.decode(hd0dJTvt.getFile(), "UTF-8"),
						enHVx2eU, OXWrghND);
			} else if ("jar".equals(aNqGqAbJ)) {
				JarFile m71IdP07 = ((JarURLConnection) hd0dJTvt.openConnection()).getJarFile();
				Enumeration<JarEntry> G4RWyTlf = m71IdP07.entries();
				while (G4RWyTlf.hasMoreElements()) {
					JarEntry IqPYYPXN = G4RWyTlf.nextElement();
					String RlT2rhTo = IqPYYPXN.getName();
					if (RlT2rhTo.charAt(0) == '/') {
						RlT2rhTo = RlT2rhTo.substring(1);
					}
					if (RlT2rhTo.startsWith(cHJVTPUK)) {
						int V898Stp3 = RlT2rhTo.lastIndexOf('/');
						if (V898Stp3 != -1) {
							mHfwilUO = RlT2rhTo.substring(0, V898Stp3).replace('/', '.');
						}
						Utils.log("PackageUtils", 4, "Package name is " + mHfwilUO);
						if ((V898Stp3 != -1) || enHVx2eU) {
							if (RlT2rhTo.endsWith(".class") && !IqPYYPXN.isDirectory()) {
								String R9ZmEp33 = RlT2rhTo.substring(mHfwilUO.length() + 1, RlT2rhTo.length() - 6);
								Utils.log("PackageUtils", 4,
										"Found class " + R9ZmEp33 + ", seeing it if it's included or excluded");
								includeOrExcludeClass(mHfwilUO, R9ZmEp33, j9t1ua0t, JP1VqeEA, OXWrghND);
							}
						}
					}
				}
			}
		}
		String[] s8Wd38ml = OXWrghND.toArray(new String[OXWrghND.size()]);
		return s8Wd38ml;
	}

}