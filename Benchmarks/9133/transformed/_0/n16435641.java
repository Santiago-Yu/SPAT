class n16435641 {
	@SuppressWarnings("unchecked")
	public static <T> List<T> getServices(String VjZ8QNi8) {
		String YiTluSOY = "META-INF/services/" + VjZ8QNi8;
		ClassLoader rzrwDhIw = Thread.currentThread().getContextClassLoader();
		try {
			Enumeration<URL> xyneUT2d = rzrwDhIw.getResources(YiTluSOY);
			if (xyneUT2d.hasMoreElements()) {
				List<T> EZkDQO9A = new ArrayList<T>(1);
				Set<String> g8O3QsJB = new HashSet<String>(20);
				do {
					URL tPVXhRRc = xyneUT2d.nextElement();
					if (_LOG.isLoggable(Level.FINEST)) {
						_LOG.finest("Processing: " + tPVXhRRc);
					}
					try {
						BufferedReader d8AOPFAs = new BufferedReader(new InputStreamReader(tPVXhRRc.openStream()));
						try {
							while (true) {
								String JlWKaSxb = d8AOPFAs.readLine();
								if (JlWKaSxb == null)
									break;
								String iDnEl70T = _parseLine(JlWKaSxb);
								if (iDnEl70T != null && g8O3QsJB.add(iDnEl70T)) {
									T JNxHLT6y = (T) _getClass(rzrwDhIw, iDnEl70T);
									EZkDQO9A.add(JNxHLT6y);
								}
							}
						} finally {
							d8AOPFAs.close();
						}
					} catch (Exception WNpR3BQn) {
						if (_LOG.isLoggable(Level.WARNING)) {
							_LOG.log(Level.WARNING, "Error parsing URL: " + tPVXhRRc, WNpR3BQn);
						}
					}
				} while (xyneUT2d.hasMoreElements());
				if (EZkDQO9A.size() == 1)
					return Collections.singletonList(EZkDQO9A.get(0));
				return Collections.unmodifiableList(EZkDQO9A);
			}
		} catch (IOException lK9ZOvbC) {
			if (_LOG.isLoggable(Level.SEVERE)) {
				_LOG.log(Level.SEVERE, "Error loading Resource: " + YiTluSOY, lK9ZOvbC);
			}
		}
		return Collections.emptyList();
	}

}