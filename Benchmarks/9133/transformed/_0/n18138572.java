class n18138572 {
	public static String[] getURLListFromResource(String XLsvWizQ, String plU0UbeH, boolean JjxGvQaR) {
		String[] s3EsyYEt;
		Vector<String> IEetP62v = new Vector<String>();
		try {
			ClassLoader UHjkSZQ5 = MqatMain.class.getClassLoader();
			URLClassLoader ZXxbfYIA = (URLClassLoader) UHjkSZQ5;
			Enumeration TTbxHszm = ZXxbfYIA.findResources(XLsvWizQ);
			for (; TTbxHszm.hasMoreElements();) {
				URL Da34kX59 = (URL) TTbxHszm.nextElement();
				if ("file".equals(Da34kX59.getProtocol())) {
					File TLqUUZyk = new File(Da34kX59.getPath());
					File[] x6FMO0k9 = TLqUUZyk.listFiles();
					if (x6FMO0k9 != null) {
						for (int mtcJ827X = 0; mtcJ827X < x6FMO0k9.length; mtcJ827X++) {
							String eSeda23t = x6FMO0k9[mtcJ827X].toURL().toString();
							if (eSeda23t.matches(plU0UbeH)) {
								IEetP62v.add(eSeda23t);
							}
						}
					}
				} else if ("jar".equals(Da34kX59.getProtocol())) {
					JarURLConnection OSdGC8hS = (JarURLConnection) Da34kX59.openConnection();
					JarFile VVdUIHGW = OSdGC8hS.getJarFile();
					Enumeration b8QDjQHT = VVdUIHGW.entries();
					for (; b8QDjQHT.hasMoreElements();) {
						JarEntry dkED91DJ = (JarEntry) b8QDjQHT.nextElement();
						if (!dkED91DJ.isDirectory()) {
							String pRREBr1p = Da34kX59.toString().substring(0,
									Da34kX59.toString().lastIndexOf('!') + 1);
							pRREBr1p += "/" + dkED91DJ;
							if (pRREBr1p.matches(plU0UbeH)) {
								IEetP62v.add(pRREBr1p);
							}
						}
					}
				}
				if (!IEetP62v.isEmpty() && JjxGvQaR) {
					break;
				}
			}
		} catch (Exception CTv4YNY1) {
			ExceptionHandler.handle(CTv4YNY1, ExceptionHandler.NO_VISUAL);
		}
		s3EsyYEt = IEetP62v.toArray(new String[IEetP62v.size()]);
		return s3EsyYEt;
	}

}