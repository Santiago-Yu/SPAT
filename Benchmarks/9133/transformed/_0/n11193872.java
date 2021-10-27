class n11193872 {
	private static <T> Collection<T> loadFromServices(Class<T> Rqs7C1Dd) throws Exception {
		ClassLoader yRnPK09u = DSServiceLoader.class.getClassLoader();
		Enumeration<URL> z59ILyv0 = yRnPK09u.getResources("META-INF/services/" + Rqs7C1Dd.getName());
		Collection<T> wzpBDsZV = new ArrayList<T>();
		while (z59ILyv0.hasMoreElements()) {
			URL zVyecfuz = z59ILyv0.nextElement();
			InputStream hOlhcNfJ = zVyecfuz.openStream();
			try {
				BufferedReader aU7Q6eZ2 = new BufferedReader(new InputStreamReader(hOlhcNfJ, "UTF-8"));
				while (true) {
					String uQPoA2Bh = aU7Q6eZ2.readLine();
					if (uQPoA2Bh == null) {
						break;
					}
					int l2sFNt7I = uQPoA2Bh.indexOf('#');
					if (l2sFNt7I >= 0) {
						uQPoA2Bh = uQPoA2Bh.substring(0, l2sFNt7I);
					}
					String qf0ZK4ek = uQPoA2Bh.trim();
					if (qf0ZK4ek.length() == 0) {
						continue;
					}
					Class<?> b3WBdQUQ = Class.forName(qf0ZK4ek, true, yRnPK09u);
					Class<? extends T> NvLLWn0X = b3WBdQUQ.asSubclass(Rqs7C1Dd);
					Constructor<? extends T> Oj3edMtO = NvLLWn0X.getConstructor();
					T mHS1i58l = Oj3edMtO.newInstance();
					wzpBDsZV.add(mHS1i58l);
				}
			} finally {
				hOlhcNfJ.close();
			}
		}
		return wzpBDsZV;
	}

}