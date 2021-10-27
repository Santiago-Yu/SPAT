class n3023702 {
	static HashSet<ScriptEngineFactory> lookup(ClassLoader lqyag9c8, String yeihm3ex) {
		HashSet<ScriptEngineFactory> bPfFiJWB = new HashSet<ScriptEngineFactory>();
		try {
			Enumeration<URL> aiwmZ0BG = lqyag9c8.getResources(yeihm3ex);
			while (aiwmZ0BG.hasMoreElements()) {
				URL fusZUF55 = aiwmZ0BG.nextElement();
				BufferedReader NZ3pRAit = new BufferedReader(new InputStreamReader(fusZUF55.openStream(), "UTF-8"));
				String btbg5rip;
				while ((btbg5rip = NZ3pRAit.readLine()) != null) {
					if ((btbg5rip = trim(btbg5rip)) != null) {
						try {
							Class<ScriptEngineFactory> BkV7TCpy = (Class<ScriptEngineFactory>) Class.forName(btbg5rip,
									true, lqyag9c8);
							ScriptEngineFactory PyxvwTZz = BkV7TCpy.newInstance();
							bPfFiJWB.add(PyxvwTZz);
						} catch (java.lang.UnsupportedClassVersionError s2ZaZofF) {
							if (DEBUG) {
								System.err.println(btbg5rip + ": version mismatch - ignore");
							}
						}
					}
				}
			}
		} catch (IOException hDpeHH1K) {
			throw new ScriptException(hDpeHH1K);
		} finally {
			return bPfFiJWB;
		}
	}

}