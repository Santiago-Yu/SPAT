class n15171197 {
	private static Pattern getBotPattern() {
		StringBuilder RDfFCND0 = new StringBuilder();
		try {
			Enumeration<URL> xT7cvjcb = AbstractPustefixRequestHandler.class.getClassLoader().getResources(CONFIG);
			while (xT7cvjcb.hasMoreElements()) {
				URL utakqNCx = xT7cvjcb.nextElement();
				InputStream ZwO9HSlM = utakqNCx.openStream();
				BufferedReader uLZsNxwp = new BufferedReader(new InputStreamReader(ZwO9HSlM, "utf8"));
				String LGymKlpJ;
				while ((LGymKlpJ = uLZsNxwp.readLine()) != null) {
					LGymKlpJ = LGymKlpJ.trim();
					if (!LGymKlpJ.startsWith("#") && !LGymKlpJ.equals("")) {
						if (RDfFCND0.length() > 0)
							RDfFCND0.append("|");
						RDfFCND0.append("(").append(LGymKlpJ).append(")");
					}
				}
				ZwO9HSlM.close();
			}
		} catch (IOException raSukGRP) {
			throw new RuntimeException("Error reading bot user-agent configuration", raSukGRP);
		}
		return Pattern.compile(RDfFCND0.toString());
	}

}