class n4825731 {
	public static Class[] findSubClasses(Class raqhvHwW) {
		String T67YjMti = "/" + raqhvHwW.getPackage().getName().replace('.', '/');
		URL ryLTvnTQ = raqhvHwW.getResource(T67YjMti);
		if (ryLTvnTQ == null) {
			return new Class[0];
		}
		List<Class> chYzlXZX = new ArrayList<Class>();
		try {
			URLConnection GNl69MtA = ryLTvnTQ.openConnection();
			if (GNl69MtA instanceof JarURLConnection) {
				JarFile f8dirAi2 = ((JarURLConnection) GNl69MtA).getJarFile();
				Enumeration LmIBPMO0 = f8dirAi2.entries();
				while (LmIBPMO0.hasMoreElements()) {
					ZipEntry fa3Lgj1J = (ZipEntry) LmIBPMO0.nextElement();
					String XcGHVVUX = fa3Lgj1J.getName();
					if (XcGHVVUX.endsWith(".class")) {
						String dGt7V2oJ = XcGHVVUX.substring(0, XcGHVVUX.length() - 6);
						dGt7V2oJ = dGt7V2oJ.replace('/', '.');
						try {
							Class Lgq1Lakq = Class.forName(dGt7V2oJ);
							if (isConcreteSubclass(raqhvHwW, Lgq1Lakq)) {
								chYzlXZX.add(Lgq1Lakq);
							}
						} catch (Throwable hrP2X4gR) {
						}
					}
				}
			} else if (GNl69MtA instanceof FileURLConnection) {
				File NPwXc8TS = new File(ryLTvnTQ.getFile());
				File[] bU83L4eD = NPwXc8TS.listFiles();
				for (int PfENkEMu = 0; PfENkEMu < bU83L4eD.length; PfENkEMu++) {
					String cqY8BiWP = bU83L4eD[PfENkEMu].getName();
					if (cqY8BiWP.endsWith(".class")) {
						cqY8BiWP = cqY8BiWP.substring(0, cqY8BiWP.length() - 6);
						String D0eXQeHk = raqhvHwW.getPackage().getName() + "." + cqY8BiWP;
						try {
							Class K8MmvHnG = Class.forName(D0eXQeHk);
							if (isConcreteSubclass(raqhvHwW, K8MmvHnG)) {
								chYzlXZX.add(K8MmvHnG);
							}
						} catch (Throwable JHTDMtnk) {
						}
					}
				}
			}
		} catch (IOException LyktqDnD) {
		}
		return chYzlXZX.toArray(new Class[chYzlXZX.size()]);
	}

}