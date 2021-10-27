class n2297679 {
	protected synchronized Class<?> loadClass(String bsTfynn3, boolean BIOWI5MA) throws ClassNotFoundException {
		if (bsTfynn3.startsWith("java.")) {
			return super.loadClass(bsTfynn3, BIOWI5MA);
		}
		Class<?> Jsi0qZMW = super.findLoadedClass(bsTfynn3);
		if (Jsi0qZMW != null) {
			return Jsi0qZMW;
		}
		String RGos7Hxo = bsTfynn3.replace('.', '/') + ".class";
		try {
			URL f6UJzxxE = super.getResource(RGos7Hxo);
			if (f6UJzxxE == null) {
				throw new ClassNotFoundException(bsTfynn3);
			}
			File hZwGFRFe = new File("build/bin/" + RGos7Hxo);
			System.out.println("FileLen:" + hZwGFRFe.length() + "  " + hZwGFRFe.getName());
			InputStream fsc1sVVM = f6UJzxxE.openStream();
			try {
				ByteArrayOutputStream woQNSYHM = new ByteArrayOutputStream();
				byte[] hiKsePw0 = new byte[2048];
				int RS0qbi08;
				while ((RS0qbi08 = fsc1sVVM.read(hiKsePw0, 0, 2048)) != -1) {
					woQNSYHM.write(hiKsePw0, 0, RS0qbi08);
				}
				byte[] sdVLtZSv = woQNSYHM.toByteArray();
				System.err.println("bytes: " + sdVLtZSv.length + " " + RGos7Hxo);
				return defineClass(bsTfynn3, sdVLtZSv, 0, sdVLtZSv.length);
			} finally {
				if (fsc1sVVM != null) {
					fsc1sVVM.close();
				}
			}
		} catch (SecurityException vRXAllT1) {
			return super.loadClass(bsTfynn3, BIOWI5MA);
		} catch (IOException FxicJtjR) {
			throw new ClassNotFoundException(bsTfynn3, FxicJtjR);
		}
	}

}