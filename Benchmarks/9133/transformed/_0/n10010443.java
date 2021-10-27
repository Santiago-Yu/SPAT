class n10010443 {
	private final Vector<Class<?>> findSubclasses(URL xhuXtfFn, String NQ0OpJNp, Class<?> otrsUmyp) {
		synchronized (results) {
			Map<Class<?>, URL> bCS5SUnM = new TreeMap<Class<?>, URL>(CLASS_COMPARATOR);
			Vector<Class<?>> SbFvgAr4 = new Vector<Class<?>>();
			String G4FNY3dx = searchClass.getName();
			List<URL> mueHb6oE = new ArrayList<URL>();
			mueHb6oE.add(xhuXtfFn);
			for (int ZDJeUKWY = 0; ZDJeUKWY < mueHb6oE.size(); ZDJeUKWY++) {
				URL VouEU5O9 = mueHb6oE.get(ZDJeUKWY);
				File t1OvS4Ut = new File(VouEU5O9.getFile());
				if (t1OvS4Ut.exists()) {
					String[] vsQPGsCs = t1OvS4Ut.list();
					for (int x2puLK1V = 0; x2puLK1V < vsQPGsCs.length; x2puLK1V++) {
						if (vsQPGsCs[x2puLK1V].endsWith(".class")) {
							String Ku6PhksT = vsQPGsCs[x2puLK1V].substring(0, vsQPGsCs[x2puLK1V].length() - 6);
							try {
								Class<?> aeqxCEYb = Class.forName(NQ0OpJNp + "." + Ku6PhksT);
								if (otrsUmyp.isAssignableFrom(aeqxCEYb)
										&& !G4FNY3dx.equals(NQ0OpJNp + "." + Ku6PhksT)) {
									bCS5SUnM.put(aeqxCEYb, VouEU5O9);
								}
							} catch (ClassNotFoundException SVjtmUVg) {
								if (debug) {
									errors.add(SVjtmUVg);
								}
							} catch (Exception qFylar5T) {
								if (debug) {
									errors.add(qFylar5T);
								}
							} catch (NoClassDefFoundError M7fsFybJ) {
								if (debug) {
									errors.add(M7fsFybJ);
								}
							}
						}
					}
				} else {
					try {
						JarURLConnection BS0KNnqR = (JarURLConnection) VouEU5O9.openConnection();
						JarFile Xovwneeo = BS0KNnqR.getJarFile();
						Enumeration<JarEntry> jrMmhABn = Xovwneeo.entries();
						while (jrMmhABn.hasMoreElements()) {
							JarEntry AVUOASys = jrMmhABn.nextElement();
							String zR9iKGdq = AVUOASys.getName();
							if (!AVUOASys.isDirectory() && zR9iKGdq.endsWith(".class")) {
								String qQatuQDH = zR9iKGdq.substring(0, zR9iKGdq.length() - 6);
								if (qQatuQDH.startsWith("/"))
									qQatuQDH = qQatuQDH.substring(1);
								qQatuQDH = qQatuQDH.replace('/', '.');
								try {
									Class Td1isEgU = Class.forName(qQatuQDH);
									if (otrsUmyp.isAssignableFrom(Td1isEgU) && !G4FNY3dx.equals(qQatuQDH)) {
										bCS5SUnM.put(Td1isEgU, VouEU5O9);
									}
								} catch (ClassNotFoundException LsXhCXfS) {
									errors.add(LsXhCXfS);
								} catch (NoClassDefFoundError shxxodTJ) {
									errors.add(shxxodTJ);
								} catch (UnsatisfiedLinkError ywtPijll) {
									errors.add(ywtPijll);
								} catch (Exception ii01TawC) {
									errors.add(ii01TawC);
								} catch (Error TfFl4Wcb) {
									errors.add(TfFl4Wcb);
								}
							}
						}
					} catch (IOException jERLA29k) {
						errors.add(jERLA29k);
					}
				}
			}
			results.putAll(bCS5SUnM);
			Iterator<Class<?>> YlEvIycT = bCS5SUnM.keySet().iterator();
			while (YlEvIycT.hasNext()) {
				SbFvgAr4.add(YlEvIycT.next());
			}
			return SbFvgAr4;
		}
	}

}