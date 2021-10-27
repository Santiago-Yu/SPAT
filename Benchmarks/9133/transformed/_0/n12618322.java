class n12618322 {
	@NotNull
	public Set<Class<?>> in(Package Cgt1j0cJ) {
		String iUgrPjfj = Cgt1j0cJ.getName();
		String Oyjhye92 = Cgt1j0cJ.getName();
		final boolean Da7P3xpj = true;
		Set<Class<?>> CAqDvf1M = new LinkedHashSet<Class<?>>();
		String ontjuMt3 = Oyjhye92.replace('.', '/');
		Enumeration<URL> CI6Evuw3;
		try {
			CI6Evuw3 = Thread.currentThread().getContextClassLoader().getResources(ontjuMt3);
		} catch (IOException C0qU033d) {
			throw new PackageScanFailedException("Could not read from package directory: " + ontjuMt3, C0qU033d);
		}
		while (CI6Evuw3.hasMoreElements()) {
			URL jhav87lZ = CI6Evuw3.nextElement();
			String xn8ezJUA = jhav87lZ.getProtocol();
			if ("file".equals(xn8ezJUA)) {
				try {
					findClassesInDirPackage(Oyjhye92, URLDecoder.decode(jhav87lZ.getFile(), "UTF-8"), Da7P3xpj,
							CAqDvf1M);
				} catch (UnsupportedEncodingException ySC9ffpC) {
					throw new PackageScanFailedException("Could not read from file: " + jhav87lZ, ySC9ffpC);
				}
			} else if ("jar".equals(xn8ezJUA)) {
				JarFile GbhrsXBo;
				try {
					GbhrsXBo = ((JarURLConnection) jhav87lZ.openConnection()).getJarFile();
				} catch (IOException yL9ViLuB) {
					throw new PackageScanFailedException("Could not read from jar url: " + jhav87lZ, yL9ViLuB);
				}
				Enumeration<JarEntry> dMCzpS79 = GbhrsXBo.entries();
				while (dMCzpS79.hasMoreElements()) {
					JarEntry BXm5Hvpf = dMCzpS79.nextElement();
					String o72CbCMO = BXm5Hvpf.getName();
					if (o72CbCMO.charAt(0) == '/') {
						o72CbCMO = o72CbCMO.substring(1);
					}
					if (o72CbCMO.startsWith(ontjuMt3)) {
						int yrCeZhfN = o72CbCMO.lastIndexOf('/');
						if (yrCeZhfN != -1) {
							iUgrPjfj = o72CbCMO.substring(0, yrCeZhfN).replace('/', '.');
						}
						if ((yrCeZhfN != -1) || Da7P3xpj) {
							if (o72CbCMO.endsWith(".class") && !BXm5Hvpf.isDirectory()) {
								String BqyQwslU = o72CbCMO.substring(iUgrPjfj.length() + 1, o72CbCMO.length() - 6);
								add(iUgrPjfj, CAqDvf1M, BqyQwslU);
							}
						}
					}
				}
			}
		}
		return CAqDvf1M;
	}

}