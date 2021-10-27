class n3193200 {
	private final Vector<Class<?>> findSubclasses(URL erkQg9TI, String wNUcV7jX, Class<?> mugm3v9D) {
		synchronized (results) {
			Map<Class<?>, URL> z9e6ZGbS = new TreeMap<Class<?>, URL>(CLASS_COMPARATOR);
			Vector<Class<?>> ZvJ1EjCJ = new Vector<Class<?>>();
			String gC0hLWEa = searchClass.getName();
			List<URL> OMhEKUxZ = new ArrayList<URL>();
			OMhEKUxZ.add(erkQg9TI);
			for (int EzhFioCD = 0; EzhFioCD < OMhEKUxZ.size(); EzhFioCD++) {
				URL mfh7ckFv = OMhEKUxZ.get(EzhFioCD);
				File EVWu6X4q = new File(mfh7ckFv.getFile());
				if (EVWu6X4q.exists()) {
					String[] QMVx23Bj = EVWu6X4q.list();
					for (int jwYBXsAr = 0; jwYBXsAr < QMVx23Bj.length; jwYBXsAr++) {
						if (QMVx23Bj[jwYBXsAr].endsWith(".class")) {
							String HIIggOtK = QMVx23Bj[jwYBXsAr].substring(0, QMVx23Bj[jwYBXsAr].length() - 6);
							try {
								Class<?> qDrtQHQR = Class.forName(wNUcV7jX + "." + HIIggOtK);
								if (mugm3v9D.isAssignableFrom(qDrtQHQR)
										&& !gC0hLWEa.equals(wNUcV7jX + "." + HIIggOtK)) {
									z9e6ZGbS.put(qDrtQHQR, mfh7ckFv);
								}
							} catch (ClassNotFoundException LNgjk9da) {
								errors.add(LNgjk9da);
							} catch (Exception rercAtbK) {
								errors.add(rercAtbK);
							}
						}
					}
				} else {
					try {
						JarURLConnection McGzZ8cY = (JarURLConnection) mfh7ckFv.openConnection();
						JarFile SoiYV0Go = McGzZ8cY.getJarFile();
						Enumeration<JarEntry> e0SdNXKW = SoiYV0Go.entries();
						while (e0SdNXKW.hasMoreElements()) {
							JarEntry DYenfyR2 = e0SdNXKW.nextElement();
							String pJwYPBSP = DYenfyR2.getName();
							if (!DYenfyR2.isDirectory() && pJwYPBSP.endsWith(".class")) {
								String DMD0MKzG = pJwYPBSP.substring(0, pJwYPBSP.length() - 6);
								if (DMD0MKzG.startsWith("/"))
									DMD0MKzG = DMD0MKzG.substring(1);
								DMD0MKzG = DMD0MKzG.replace('/', '.');
								try {
									Class DQU0oiL2 = Class.forName(DMD0MKzG);
									if (mugm3v9D.isAssignableFrom(DQU0oiL2) && !gC0hLWEa.equals(DMD0MKzG)) {
										z9e6ZGbS.put(DQU0oiL2, mfh7ckFv);
									}
								} catch (ClassNotFoundException y1NOlxFZ) {
									errors.add(y1NOlxFZ);
								} catch (NoClassDefFoundError PQBH09JW) {
									errors.add(PQBH09JW);
								} catch (UnsatisfiedLinkError BQrOTqI9) {
									errors.add(BQrOTqI9);
								} catch (Exception gCeJIUem) {
									errors.add(gCeJIUem);
								} catch (Error A4AE9gTK) {
									errors.add(A4AE9gTK);
								}
							}
						}
					} catch (IOException J22J9HNB) {
						errors.add(J22J9HNB);
					}
				}
			}
			results.putAll(z9e6ZGbS);
			Iterator<Class<?>> QIZXd0g0 = z9e6ZGbS.keySet().iterator();
			while (QIZXd0g0.hasNext()) {
				ZvJ1EjCJ.add(QIZXd0g0.next());
			}
			return ZvJ1EjCJ;
		}
	}

}