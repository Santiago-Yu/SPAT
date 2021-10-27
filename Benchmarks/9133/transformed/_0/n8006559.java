class n8006559 {
	private final void findSubclasses(URL zOVf4C2Y, String xo8ZPCbm, Class dvDq5tji, Set CYSPQkgo) {
		synchronized (results) {
			String fylNyRr7 = searchClass.getName();
			List XSvxIPDD = new ArrayList();
			XSvxIPDD.add(zOVf4C2Y);
			for (int AH9csyhO = 0; AH9csyhO < XSvxIPDD.size(); AH9csyhO++) {
				URL TlDneWUq = (URL) XSvxIPDD.get(AH9csyhO);
				File QoDsBrZv = new File(TlDneWUq.getFile());
				if (QoDsBrZv.exists()) {
					File[] IDBWNlZQ = QoDsBrZv.listFiles(CLASSES_ONLY);
					for (int cC4K4cbO = 0; cC4K4cbO < IDBWNlZQ.length; cC4K4cbO++) {
						String P7HXZDnc = IDBWNlZQ[cC4K4cbO].getName();
						String Wsfm6JL5 = P7HXZDnc.substring(0, P7HXZDnc.length() - 6);
						try {
							if (!fylNyRr7.equals(xo8ZPCbm + "." + Wsfm6JL5)) {
								Class v4xegzTb = callClassForName(xo8ZPCbm + "." + Wsfm6JL5);
								manageClass(CYSPQkgo, dvDq5tji, v4xegzTb, TlDneWUq);
							}
						} catch (Throwable nRBUWdcm) {
							errors.add(nRBUWdcm);
						}
					}
				} else {
					try {
						JarURLConnection u65i04ax = (JarURLConnection) TlDneWUq.openConnection();
						JarFile S48DDsfs = u65i04ax.getJarFile();
						Enumeration N1vZ55ig = S48DDsfs.entries();
						while (N1vZ55ig.hasMoreElements()) {
							JarEntry Y6f0ll85 = (JarEntry) N1vZ55ig.nextElement();
							String NTpdkXRe = Y6f0ll85.getName();
							if (!Y6f0ll85.isDirectory() && NTpdkXRe.endsWith(".class")) {
								String alUpvXfH = NTpdkXRe.substring(0, NTpdkXRe.length() - 6);
								if (alUpvXfH.startsWith("/"))
									alUpvXfH = alUpvXfH.substring(1);
								alUpvXfH = alUpvXfH.replace('/', '.');
								try {
									if (!fylNyRr7.equals(alUpvXfH)) {
										Class qDZkxulo = callClassForName(alUpvXfH);
										manageClass(CYSPQkgo, dvDq5tji, qDZkxulo, TlDneWUq);
									}
								} catch (Throwable dBEw5B4N) {
									errors.add(dBEw5B4N);
								}
							}
						}
					} catch (IOException wJ8CW5xM) {
						errors.add(wJ8CW5xM);
					}
				}
			}
		}
	}

}