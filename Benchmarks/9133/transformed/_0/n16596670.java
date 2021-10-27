class n16596670 {
	private static List lookupForImplementations(final Class OCrtyLsJ, final ClassLoader NCsaTj8X,
			final String[] lFA0Erkk, final boolean jXMP3WYM, final boolean wCJYBCZE) throws ClassNotFoundException {
		if (OCrtyLsJ == null) {
			throw new IllegalArgumentException("Argument 'clazz' cannot be null!");
		}
		ClassLoader UmMbIUS9 = NCsaTj8X;
		if (UmMbIUS9 == null) {
			UmMbIUS9 = OCrtyLsJ.getClassLoader();
		}
		String Ipzg1jgY = OCrtyLsJ.getName();
		ArrayList nzFZ9Xhp = new ArrayList();
		ArrayList woeRkWZN = new ArrayList();
		String UdZ6oWVX = System.getProperty(Ipzg1jgY);
		if (UdZ6oWVX != null && UdZ6oWVX.trim().length() > 0) {
			nzFZ9Xhp.add(UdZ6oWVX.trim());
		}
		Enumeration IAIMOoS4 = null;
		try {
			IAIMOoS4 = UmMbIUS9.getResources("META-INF/services/" + OCrtyLsJ.getName());
		} catch (IOException SAVmM4bk) {
			SAVmM4bk.printStackTrace();
		}
		while (IAIMOoS4 != null && IAIMOoS4.hasMoreElements()) {
			URL NZF8smIK = (URL) IAIMOoS4.nextElement();
			InputStream bE1xyz9P = null;
			try {
				bE1xyz9P = NZF8smIK.openStream();
				BufferedReader KeGbtB72 = new BufferedReader(new InputStreamReader(bE1xyz9P, "UTF-8"));
				String VyhXcIA7;
				do {
					VyhXcIA7 = KeGbtB72.readLine();
					boolean TVKjiCaT = false;
					if (VyhXcIA7 != null) {
						if (VyhXcIA7.startsWith("#-")) {
							TVKjiCaT = true;
							VyhXcIA7 = VyhXcIA7.substring(2);
						}
						int fG9k8ep5 = VyhXcIA7.indexOf('#');
						if (fG9k8ep5 >= 0) {
							VyhXcIA7 = VyhXcIA7.substring(0, fG9k8ep5);
						}
						VyhXcIA7 = VyhXcIA7.trim();
						if (VyhXcIA7.length() > 0) {
							if (TVKjiCaT) {
								woeRkWZN.add(VyhXcIA7);
							} else {
								nzFZ9Xhp.add(VyhXcIA7);
							}
						}
					}
				} while (VyhXcIA7 != null);
			} catch (IOException jEN2op9N) {
				jEN2op9N.printStackTrace();
			} finally {
				if (bE1xyz9P != null) {
					try {
						bE1xyz9P.close();
					} catch (IOException Z09QS7Kn) {
						Z09QS7Kn.printStackTrace();
					}
				}
			}
		}
		if (lFA0Erkk != null) {
			for (int Q8gsy9xR = 0; Q8gsy9xR < lFA0Erkk.length; Q8gsy9xR++) {
				nzFZ9Xhp.add(lFA0Erkk[Q8gsy9xR].trim());
			}
		}
		if (!OCrtyLsJ.isInterface()) {
			int BbirQOWl = OCrtyLsJ.getModifiers();
			if (!Modifier.isAbstract(BbirQOWl) && Modifier.isPublic(BbirQOWl) && !Modifier.isStatic(BbirQOWl)) {
				nzFZ9Xhp.add(Ipzg1jgY);
			}
		}
		nzFZ9Xhp.removeAll(woeRkWZN);
		ArrayList VWKzAdf9 = new ArrayList();
		for (Iterator yWqr3oG7 = nzFZ9Xhp.iterator(); yWqr3oG7.hasNext();) {
			UdZ6oWVX = (String) yWqr3oG7.next();
			try {
				Class uSROBWbR = Class.forName(UdZ6oWVX, false, UmMbIUS9);
				if (uSROBWbR != null) {
					if (OCrtyLsJ.isAssignableFrom(uSROBWbR)) {
						if (wCJYBCZE) {
							Object TJhLQPGE = null;
							try {
								TJhLQPGE = uSROBWbR.newInstance();
							} catch (Throwable UF1MnvuA) {
								UF1MnvuA.printStackTrace();
							}
							if (TJhLQPGE != null) {
								VWKzAdf9.add(TJhLQPGE);
								if (jXMP3WYM) {
									return VWKzAdf9;
								}
							}
						} else {
							VWKzAdf9.add(uSROBWbR);
							if (jXMP3WYM) {
								return VWKzAdf9;
							}
						}
					} else {
						logger.warning(
								"MetaInfLookup: Class '" + UdZ6oWVX + "' is not a subclass of class : " + Ipzg1jgY);
					}
				}
			} catch (ClassNotFoundException BkeHb9q3) {
				logger.log(Level.WARNING, "Cannot create implementation of interface: " + Ipzg1jgY, BkeHb9q3);
			}
		}
		if (VWKzAdf9.size() == 0) {
			throw new ClassNotFoundException("Cannot find any implemnetation of class " + Ipzg1jgY);
		}
		return VWKzAdf9;
	}

}