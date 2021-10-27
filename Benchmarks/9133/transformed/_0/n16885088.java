class n16885088 {
	private static void getClasses(Collection<Class<?>> v7fVbIs4, String... OgIcyeh7) throws ClassNotFoundException {
		boolean aDcCRxMs = true;
		for (String UsVxCa4w : OgIcyeh7) {
			if (StringUtil.isEmpty(UsVxCa4w))
				continue;
			String SHFO38pp = UsVxCa4w.replace('.', '/');
			Enumeration<URL> WioGL9S9 = null;
			try {
				WioGL9S9 = Thread.currentThread().getContextClassLoader().getResources(SHFO38pp);
				while (WioGL9S9.hasMoreElements()) {
					URL zHLouAIs = WioGL9S9.nextElement();
					String azsSAJen = zHLouAIs.getProtocol();
					if ("file".equals(azsSAJen)) {
						String exyUDVSC = URLDecoder.decode(zHLouAIs.getFile(), DECODING);
						getClassesByPackageFile(UsVxCa4w, exyUDVSC, aDcCRxMs, v7fVbIs4);
					} else if ("jar".equals(azsSAJen)) {
						JarFile FsIdfhcX = null;
						try {
							FsIdfhcX = ((JarURLConnection) zHLouAIs.openConnection()).getJarFile();
							Enumeration<JarEntry> ElmMEQwe = FsIdfhcX.entries();
							while (ElmMEQwe.hasMoreElements()) {
								JarEntry EMBZoCaz = ElmMEQwe.nextElement();
								String YK42J7fm = EMBZoCaz.getName();
								if (YK42J7fm.charAt(0) == '/') {
									YK42J7fm = YK42J7fm.substring(1);
								}
								if (YK42J7fm.startsWith(SHFO38pp)) {
									int wJK0Rh3f = YK42J7fm.lastIndexOf('/');
									if (wJK0Rh3f != -1) {
										UsVxCa4w = YK42J7fm.substring(0, wJK0Rh3f).replace('/', '.');
									}
									if ((wJK0Rh3f != -1) || aDcCRxMs) {
										if (YK42J7fm.endsWith(JAVA_CLASS_SUFFIX) && !EMBZoCaz.isDirectory()) {
											String ybSkFfVH = YK42J7fm.substring(UsVxCa4w.length() + 1,
													YK42J7fm.length() - 6);
											v7fVbIs4.add(loadClass(UsVxCa4w + '.' + ybSkFfVH));
										}
									}
								}
							}
						} catch (IOException Afdg9e63) {
							LOG.error("IOException when loading files from : " + zHLouAIs, Afdg9e63);
						}
					}
				}
			} catch (IOException C9QpXN19) {
				LOG.error("IOException when get classes from : " + UsVxCa4w, C9QpXN19);
			}
		}
	}

}