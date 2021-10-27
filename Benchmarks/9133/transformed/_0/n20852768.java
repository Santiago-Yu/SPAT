class n20852768 {
	private final Vector<Class<?>> findSubclasses(URL sdozgkYe, String wYihNehU, Class<?> uQc8sffQ) {
		synchronized (results) {
			Map<Class<?>, URL> V8WsvI4h = new TreeMap<Class<?>, URL>(CLASS_COMPARATOR);
			Vector<Class<?>> SFk3jEHR = new Vector<Class<?>>();
			String MUQnvevc = searchClass.getName();
			List<URL> lSKJ6Qpm = new ArrayList<URL>();
			lSKJ6Qpm.add(sdozgkYe);
			for (int SpNM3XOb = 0; SpNM3XOb < lSKJ6Qpm.size(); SpNM3XOb++) {
				URL VcuSU1Si = lSKJ6Qpm.get(SpNM3XOb);
				File ZkkgaYlK = new File(VcuSU1Si.getFile());
				if (ZkkgaYlK.exists()) {
					String[] ggjamkUQ = ZkkgaYlK.list();
					for (int SPOPHk7V = 0; SPOPHk7V < ggjamkUQ.length; SPOPHk7V++) {
						if (ggjamkUQ[SPOPHk7V].endsWith(".class")) {
							String vzD1Pgjd = ggjamkUQ[SPOPHk7V].substring(0, ggjamkUQ[SPOPHk7V].length() - 6);
							try {
								Class<?> VDOMl4yC = Class.forName(wYihNehU + "." + vzD1Pgjd);
								if (uQc8sffQ.isAssignableFrom(VDOMl4yC)
										&& !MUQnvevc.equals(wYihNehU + "." + vzD1Pgjd)) {
									V8WsvI4h.put(VDOMl4yC, VcuSU1Si);
								}
							} catch (ClassNotFoundException wouLEPGT) {
								errors.add(wouLEPGT);
							} catch (Exception oCCDeqry) {
								errors.add(oCCDeqry);
							}
						}
					}
				} else {
					try {
						JarURLConnection uM0JkmdK = (JarURLConnection) VcuSU1Si.openConnection();
						JarFile bAtFW3R1 = uM0JkmdK.getJarFile();
						Enumeration<JarEntry> RJHqvbzA = bAtFW3R1.entries();
						while (RJHqvbzA.hasMoreElements()) {
							JarEntry gXWkY6Za = RJHqvbzA.nextElement();
							String xDXwnMv6 = gXWkY6Za.getName();
							if (!gXWkY6Za.isDirectory() && xDXwnMv6.endsWith(".class")) {
								String tVC9bFZn = xDXwnMv6.substring(0, xDXwnMv6.length() - 6);
								if (tVC9bFZn.startsWith("/"))
									tVC9bFZn = tVC9bFZn.substring(1);
								tVC9bFZn = tVC9bFZn.replace('/', '.');
								try {
									Class BP5neY1q = Class.forName(tVC9bFZn);
									if (uQc8sffQ.isAssignableFrom(BP5neY1q) && !MUQnvevc.equals(tVC9bFZn)) {
										V8WsvI4h.put(BP5neY1q, VcuSU1Si);
									}
								} catch (ClassNotFoundException nYwh25dW) {
									errors.add(nYwh25dW);
								} catch (NoClassDefFoundError bXXaEgDL) {
									errors.add(bXXaEgDL);
								} catch (UnsatisfiedLinkError Gcvvwcj5) {
									errors.add(Gcvvwcj5);
								} catch (Exception ZRnMPL00) {
									errors.add(ZRnMPL00);
								} catch (Error bC4Awzvc) {
									errors.add(bC4Awzvc);
								}
							}
						}
					} catch (IOException wEcWaZ6U) {
						errors.add(wEcWaZ6U);
					}
				}
			}
			results.putAll(V8WsvI4h);
			Iterator<Class<?>> i7vbiWoB = V8WsvI4h.keySet().iterator();
			while (i7vbiWoB.hasNext()) {
				SFk3jEHR.add(i7vbiWoB.next());
			}
			return SFk3jEHR;
		}
	}

}