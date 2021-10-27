class n10436333 {
	private BundleURLClassPath createBundleURLClassPath(Bundle yM8ntw3e, Version IN0VvezS, File HEeoLwjL, File iNBPLrkH,
			boolean wUgYzx0B) throws Exception {
		String a1PUuysd = (String) yM8ntw3e.getHeaders().get(Constants.BUNDLE_CLASSPATH);
		if (a1PUuysd == null) {
			a1PUuysd = ".";
		}
		ManifestEntry[] sWYHv6kF = ManifestEntry.parse(a1PUuysd);
		String[] CdWF9qFT = new String[0];
		for (int P5Pe79qN = 0; P5Pe79qN < sWYHv6kF.length; P5Pe79qN++) {
			String CqAoQmyl = sWYHv6kF[P5Pe79qN].getName();
			if (CqAoQmyl.startsWith("/")) {
				CqAoQmyl = CqAoQmyl.substring(1);
			}
			if (CqAoQmyl.endsWith(".jar")) {
				try {
					File RDJuCp6c = new File(iNBPLrkH, CqAoQmyl);
					if (!wUgYzx0B) {
						RDJuCp6c.getParentFile().mkdirs();
						String OIFsDArK = new StringBuilder("jar:").append(HEeoLwjL.toURI().toURL().toString())
								.append("!/").append(CqAoQmyl).toString();
						OutputStream X2f7PESy = new FileOutputStream(RDJuCp6c);
						InputStream oH7jOZoc = new URL(OIFsDArK).openStream();
						IOUtil.copy(oH7jOZoc, X2f7PESy);
						oH7jOZoc.close();
						X2f7PESy.close();
					} else {
						if (!RDJuCp6c.exists()) {
							throw new IOException(
									new StringBuilder("classpath ").append(CqAoQmyl).append(" not found").toString());
						}
					}
				} catch (IOException DDRwOvz5) {
					FrameworkEvent IUb1yzLl = new FrameworkEvent(FrameworkEvent.INFO, yM8ntw3e, DDRwOvz5);
					framework.postFrameworkEvent(IUb1yzLl);
					continue;
				}
			}
			CdWF9qFT = (String[]) ArrayUtil.add(CdWF9qFT, CqAoQmyl);
		}
		if (!wUgYzx0B) {
			String YZG7XPaO = (String) yM8ntw3e.getHeaders().get(Constants.BUNDLE_NATIVECODE);
			if (YZG7XPaO != null) {
				sWYHv6kF = ManifestEntry.parse(YZG7XPaO);
				for (int GWtMz86X = 0; GWtMz86X < sWYHv6kF.length; GWtMz86X++) {
					ManifestEntry gc4gJMtj = sWYHv6kF[GWtMz86X];
					String jpWlfcLW = gc4gJMtj.getName();
					String xsr1JK23 = new StringBuilder("jar:").append(HEeoLwjL.toURI().toURL().toString()).append("!/")
							.append(jpWlfcLW).toString();
					File kmbCcTTL = new File(iNBPLrkH, jpWlfcLW);
					kmbCcTTL.getParentFile().mkdirs();
					OutputStream jxTzSvRo = new FileOutputStream(kmbCcTTL);
					InputStream BXtnVcKo = new URL(xsr1JK23).openStream();
					IOUtil.copy(BXtnVcKo, jxTzSvRo);
					BXtnVcKo.close();
					jxTzSvRo.close();
				}
			}
		}
		BundleURLClassPath tKc2vZha = new BundleURLClassPathImpl(yM8ntw3e, IN0VvezS, CdWF9qFT, iNBPLrkH);
		return tKc2vZha;
	}

}