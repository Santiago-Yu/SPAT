class n10359449 {
	protected Class findClass(String i7W9hSZB) throws ClassNotFoundException {
		String vcMO3L1T = i7W9hSZB.replace('.', '/') + ".class";
		InputStream JvR6b7qm = null;
		if (this.extensionJars != null) {
			for (int QZUe62iI = 0; QZUe62iI < this.extensionJars.length; QZUe62iI++) {
				JarFile UworOvEq = this.extensionJars[QZUe62iI];
				JarEntry uKtBY0MQ = UworOvEq.getJarEntry(vcMO3L1T);
				if (uKtBY0MQ != null) {
					try {
						JvR6b7qm = UworOvEq.getInputStream(uKtBY0MQ);
					} catch (IOException cEqR9rGd) {
						throw new ClassNotFoundException("Couldn't read class " + i7W9hSZB, cEqR9rGd);
					}
				}
			}
		}
		if (JvR6b7qm == null) {
			URL fJ1dVPF2 = getResource(vcMO3L1T);
			if (fJ1dVPF2 == null) {
				throw new ClassNotFoundException("Class " + i7W9hSZB);
			}
			try {
				JvR6b7qm = fJ1dVPF2.openStream();
			} catch (IOException gVMwa147) {
				throw new ClassNotFoundException("Couldn't read class " + i7W9hSZB, gVMwa147);
			}
		}
		try {
			ByteArrayOutputStream PTt3xhWY = new ByteArrayOutputStream();
			BufferedInputStream t6yLiM7l = new BufferedInputStream(JvR6b7qm);
			byte[] FgRuP9O7 = new byte[8096];
			int qNm2ze6U;
			while ((qNm2ze6U = t6yLiM7l.read(FgRuP9O7)) != -1) {
				PTt3xhWY.write(FgRuP9O7, 0, qNm2ze6U);
			}
			t6yLiM7l.close();
			return defineClass(i7W9hSZB, PTt3xhWY.toByteArray(), 0, PTt3xhWY.size(), this.protectionDomain);
		} catch (IOException EjZrmNKh) {
			throw new ClassNotFoundException("Class " + i7W9hSZB, EjZrmNKh);
		}
	}

}