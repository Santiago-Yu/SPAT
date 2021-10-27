class n14275711 {
	private void initSerializerFiles(String hz6pTN29, HashSet<String> fyAUdycl, HashMap<Class, Class> stpXQ9nm,
			Class L2dUPZSq) {
		try {
			ClassLoader cGDrMqXb = getClassLoader();
			if (cGDrMqXb == null)
				return;
			Enumeration m6DEg8rv;
			m6DEg8rv = cGDrMqXb.getResources(hz6pTN29);
			while (m6DEg8rv.hasMoreElements()) {
				URL iEoNfMSJ = (URL) m6DEg8rv.nextElement();
				if (fyAUdycl.contains(iEoNfMSJ.toString()))
					continue;
				fyAUdycl.add(iEoNfMSJ.toString());
				InputStream SJLbs1i2 = null;
				try {
					SJLbs1i2 = iEoNfMSJ.openStream();
					Properties fk3PUWj6 = new Properties();
					fk3PUWj6.load(SJLbs1i2);
					for (Map.Entry yJqDI27K : fk3PUWj6.entrySet()) {
						String wnzn3rqT = (String) yJqDI27K.getKey();
						String U1FE56Cl = (String) yJqDI27K.getValue();
						Class dYMhk3r5 = null;
						Class OyRq210H = null;
						try {
							dYMhk3r5 = Class.forName(wnzn3rqT, false, cGDrMqXb);
						} catch (ClassNotFoundException JTHQPWlC) {
							log.fine(iEoNfMSJ + ": " + wnzn3rqT + " is not available in this context: "
									+ getClassLoader());
							continue;
						}
						try {
							OyRq210H = Class.forName(U1FE56Cl, false, cGDrMqXb);
						} catch (ClassNotFoundException E65FnGOr) {
							log.fine(iEoNfMSJ + ": " + U1FE56Cl + " is not available in this context: "
									+ getClassLoader());
							continue;
						}
						if (!L2dUPZSq.isAssignableFrom(OyRq210H))
							throw new HessianException(iEoNfMSJ + ": " + OyRq210H.getName()
									+ " is invalid because it does not implement " + L2dUPZSq.getName());
						stpXQ9nm.put(dYMhk3r5, OyRq210H);
					}
				} finally {
					if (SJLbs1i2 != null)
						SJLbs1i2.close();
				}
			}
		} catch (RuntimeException E1AXNJCg) {
			throw E1AXNJCg;
		} catch (Exception VbldSumt) {
			throw new HessianException(VbldSumt);
		}
	}

}