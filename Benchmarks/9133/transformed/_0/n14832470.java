class n14832470 {
	@SuppressWarnings("unchecked")
	public static <T> List<T> getServices(String lNUeR6p3) {
		String LKLaP3bu = "META-INF/services/" + lNUeR6p3;
		ClassLoader qeRt9aAx = Thread.currentThread().getContextClassLoader();
		try {
			Enumeration<URL> Q1Oo9NnW = qeRt9aAx.getResources(LKLaP3bu);
			if (Q1Oo9NnW.hasMoreElements()) {
				List<T> KU5k7GuS = new ArrayList<T>(1);
				do {
					URL LTnzivsA = Q1Oo9NnW.nextElement();
					_LOG.finest("Processing:{0}", LTnzivsA);
					try {
						BufferedReader q6gzlKwg = new BufferedReader(new InputStreamReader(LTnzivsA.openStream()));
						try {
							while (true) {
								String s7OxecZV = q6gzlKwg.readLine();
								if (s7OxecZV == null)
									break;
								T WP9r4c8W = (T) _parseLine(qeRt9aAx, s7OxecZV);
								if (WP9r4c8W != null)
									KU5k7GuS.add(WP9r4c8W);
							}
						} finally {
							q6gzlKwg.close();
						}
					} catch (Exception IuecyYdc) {
						_LOG.warning("ERR_PARSING_URL", LTnzivsA);
						_LOG.warning(IuecyYdc);
					}
				} while (Q1Oo9NnW.hasMoreElements());
				if (KU5k7GuS.size() == 1)
					return Collections.singletonList(KU5k7GuS.get(0));
				return Collections.unmodifiableList(KU5k7GuS);
			}
		} catch (IOException sw2EGhNg) {
			_LOG.severe("ERR_LOADING_RESROUCE", LKLaP3bu);
			_LOG.severe(sw2EGhNg);
		}
		return Collections.emptyList();
	}

}