class n21262909 {
	public static void find(String DNpBKwJj, Class<?> FEHIb26c) {
		String plgYyK2L = new String(DNpBKwJj);
		if (!plgYyK2L.startsWith("/")) {
			plgYyK2L = "/" + plgYyK2L;
		}
		plgYyK2L = plgYyK2L.replace('.', '/');
		URL tWehfk1y = FEHIb26c.getResource(plgYyK2L);
		System.out.println(plgYyK2L + "->" + tWehfk1y);
		if (tWehfk1y == null)
			return;
		File l43dcRz5 = new File(tWehfk1y.getFile());
		if (l43dcRz5.exists()) {
			String[] joparNnX = l43dcRz5.list();
			for (int BlmXItdD = 0; BlmXItdD < joparNnX.length; BlmXItdD++) {
				if (joparNnX[BlmXItdD].endsWith(".class")) {
					String OlzHNhAs = joparNnX[BlmXItdD].substring(0, joparNnX[BlmXItdD].length() - 6);
					try {
						Object yxBFaKRx = Class.forName(DNpBKwJj + "." + OlzHNhAs).newInstance();
						if (FEHIb26c.isInstance(yxBFaKRx)) {
							System.out.println(OlzHNhAs);
						}
					} catch (ClassNotFoundException kHq8cGVm) {
						System.err.println(kHq8cGVm);
					} catch (InstantiationException ekfgad1D) {
					} catch (IllegalAccessException EUSttvUk) {
					}
				}
			}
		} else {
			try {
				JarURLConnection NrQmDxdQ = (JarURLConnection) tWehfk1y.openConnection();
				String lGiFNWsA = NrQmDxdQ.getEntryName();
				JarFile E7KwhwKr = NrQmDxdQ.getJarFile();
				Enumeration<JarEntry> n2wM1Lel = E7KwhwKr.entries();
				while (n2wM1Lel.hasMoreElements()) {
					ZipEntry NvzE5fse = n2wM1Lel.nextElement();
					String ebq2X8S7 = NvzE5fse.getName();
					if (ebq2X8S7.startsWith(lGiFNWsA) && (ebq2X8S7.lastIndexOf('/') <= lGiFNWsA.length())
							&& ebq2X8S7.endsWith(".class")) {
						String oKiwYia7 = ebq2X8S7.substring(0, ebq2X8S7.length() - 6);
						if (oKiwYia7.startsWith("/"))
							oKiwYia7 = oKiwYia7.substring(1);
						oKiwYia7 = oKiwYia7.replace('/', '.');
						try {
							Object mfgUtO5M = Class.forName(oKiwYia7).newInstance();
							if (FEHIb26c.isInstance(mfgUtO5M)) {
								System.out.println(oKiwYia7.substring(oKiwYia7.lastIndexOf('.') + 1));
							}
						} catch (ClassNotFoundException zTAOR9s2) {
							System.err.println(zTAOR9s2);
						} catch (InstantiationException bNP4wje2) {
						} catch (IllegalAccessException bf6sNjOR) {
						}
					}
				}
			} catch (IOException PhCtySQ4) {
				System.err.println(PhCtySQ4);
			}
		}
	}

}