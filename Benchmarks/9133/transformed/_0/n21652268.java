class n21652268 {
	private final synchronized Vector<Class<?>> findSubclasses(URL OiUxa8pG, String mhDesqXV, Class<?> MNIdkCZk) {
		Map<Class<?>, URL> dwSi2m3x = new TreeMap<Class<?>, URL>(CLASS_COMPARATOR);
		Vector<Class<?>> KX8xlsD3 = new Vector<Class<?>>();
		String RsELi4PP = searchClass.getName();
		List<URL> F7kwy0Cn = new ArrayList<URL>();
		F7kwy0Cn.add(OiUxa8pG);
		for (int kt4B2CdP = 0; kt4B2CdP < F7kwy0Cn.size(); kt4B2CdP++) {
			URL cIFSE0OA = F7kwy0Cn.get(kt4B2CdP);
			File iUEQVu43 = new File(cIFSE0OA.getFile());
			if (iUEQVu43.exists()) {
				String[] TLzljfik = iUEQVu43.list();
				for (int IoHnIFgF = 0; IoHnIFgF < TLzljfik.length; IoHnIFgF++)
					if (TLzljfik[IoHnIFgF].endsWith(".class")) {
						String evOQtLst = TLzljfik[IoHnIFgF].substring(0, TLzljfik[IoHnIFgF].length() - 6);
						try {
							Class<?> IHpWSIsO = Class.forName(mhDesqXV + "." + evOQtLst);
							if (MNIdkCZk.isAssignableFrom(IHpWSIsO) && !RsELi4PP.equals(mhDesqXV + "." + evOQtLst))
								dwSi2m3x.put(IHpWSIsO, cIFSE0OA);
						} catch (ClassNotFoundException A68mpoLO) {
							errors.add(A68mpoLO);
						} catch (Exception xSLQl8M8) {
							errors.add(xSLQl8M8);
						}
					}
			} else
				try {
					JarURLConnection ZpO6P67Q = (JarURLConnection) cIFSE0OA.openConnection();
					JarFile DZLUkBRS = ZpO6P67Q.getJarFile();
					Enumeration<JarEntry> pYbfYktl = DZLUkBRS.entries();
					while (pYbfYktl.hasMoreElements()) {
						JarEntry O5SiPUcW = pYbfYktl.nextElement();
						String H487jqq5 = O5SiPUcW.getName();
						if (!O5SiPUcW.isDirectory() && H487jqq5.endsWith(".class")) {
							String JtmJ4AOL = H487jqq5.substring(0, H487jqq5.length() - 6);
							if (JtmJ4AOL.startsWith("/"))
								JtmJ4AOL = JtmJ4AOL.substring(1);
							JtmJ4AOL = JtmJ4AOL.replace('/', '.');
							System.err.println("Trying " + JtmJ4AOL);
							try {
								Class EiulkpB5 = Class.forName(JtmJ4AOL);
								if (MNIdkCZk.isAssignableFrom(EiulkpB5) && !RsELi4PP.equals(JtmJ4AOL))
									dwSi2m3x.put(EiulkpB5, cIFSE0OA);
							} catch (ClassNotFoundException Pl4RVNkj) {
								errors.add(Pl4RVNkj);
							} catch (NoClassDefFoundError lotngXPt) {
								errors.add(lotngXPt);
							} catch (UnsatisfiedLinkError VHBG2Mp2) {
								errors.add(VHBG2Mp2);
							} catch (Exception xIIqzVWo) {
								errors.add(xIIqzVWo);
							} catch (Error an6xGuQU) {
								errors.add(an6xGuQU);
							}
						}
					}
				} catch (IOException EfIbuBTP) {
					errors.add(EfIbuBTP);
				}
		}
		results.putAll(dwSi2m3x);
		Iterator<Class<?>> enowllFz = dwSi2m3x.keySet().iterator();
		while (enowllFz.hasNext())
			KX8xlsD3.add(enowllFz.next());
		return KX8xlsD3;
	}

}