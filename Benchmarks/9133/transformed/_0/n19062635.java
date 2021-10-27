class n19062635 {
	public Constructor run() throws Exception {
		String lu5x3nGs = "META-INF/services/" + ComponentApplicationContext.class.getName();
		ClassLoader TPtFaqvr = Thread.currentThread().getContextClassLoader();
		final Enumeration<URL> NxGW61gV;
		if (TPtFaqvr == null) {
			NxGW61gV = ComponentApplicationContext.class.getClassLoader().getResources(lu5x3nGs);
		} else {
			NxGW61gV = TPtFaqvr.getResources(lu5x3nGs);
		}
		while (NxGW61gV.hasMoreElements()) {
			URL o6OT7lC4 = NxGW61gV.nextElement();
			BufferedReader NBrBb0JD = new BufferedReader(new InputStreamReader(o6OT7lC4.openStream()));
			try {
				String zRR5KLNe = null;
				while ((zRR5KLNe = NBrBb0JD.readLine()) != null) {
					final String p8WOs6d8 = zRR5KLNe.trim();
					if (!p8WOs6d8.startsWith("#") && !p8WOs6d8.startsWith(";") && !p8WOs6d8.startsWith("//")) {
						final Class<?> k3FXrGjX;
						if (TPtFaqvr == null) {
							k3FXrGjX = Class.forName(p8WOs6d8);
						} else {
							k3FXrGjX = Class.forName(p8WOs6d8, true, TPtFaqvr);
						}
						int LYjEXZdi = k3FXrGjX.getModifiers();
						if (ComponentApplicationContext.class.isAssignableFrom(k3FXrGjX)
								&& !Modifier.isAbstract(LYjEXZdi) && !Modifier.isInterface(LYjEXZdi)) {
							Constructor HZRVyaKQ = k3FXrGjX.getDeclaredConstructor();
							if (!Modifier.isPublic(HZRVyaKQ.getModifiers())) {
								HZRVyaKQ.setAccessible(true);
							}
							return HZRVyaKQ;
						} else {
							throw new ClassCastException(k3FXrGjX.getName());
						}
					}
				}
			} finally {
				NBrBb0JD.close();
			}
		}
		throw new ComponentApplicationException("No " + "ComponentApplicationContext implementation " + "found.");
	}

}