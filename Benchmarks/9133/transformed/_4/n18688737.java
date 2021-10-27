class n18688737 {
	private void loadMascotLibrary() {
		if (isMascotLibraryLoaded)
			return;
		try {
			boolean isLinux = false;
			boolean isAMD64 = false;
			String mascotLibraryFile;
			isLinux = (Configurator.getOSName().toLowerCase().contains("linux")) ? true : isLinux;
			isAMD64 = (Configurator.getOSArch().toLowerCase().contains("amd64")) ? true : isAMD64;
			if (isLinux) {
				mascotLibraryFile = (isAMD64) ? "libmsparserj-64.so" : "libmsparserj-32.so";
			} else {
				mascotLibraryFile = (isAMD64) ? "msparserj-64.dll" : "msparserj-32.dll";
			}
			logger.warn("Using: " + mascotLibraryFile);
			URL mascot_lib = MascotDAO.class.getClassLoader().getResource(mascotLibraryFile);
			if (mascot_lib != null) {
				logger.debug("Mascot library URL: " + mascot_lib);
				tmpMascotLibraryFile = File.createTempFile("libmascot.so.", ".tmp",
						new File(System.getProperty("java.io.tmpdir")));
				InputStream in = mascot_lib.openStream();
				OutputStream out = new FileOutputStream(tmpMascotLibraryFile);
				IOUtils.copy(in, out);
				in.close();
				out.close();
				System.load(tmpMascotLibraryFile.getAbsolutePath());
				isMascotLibraryLoaded = true;
			} else {
				throw new ConverterException("Could not load Mascot Library for system: " + Configurator.getOSName()
						+ Configurator.getOSArch());
			}
		} catch (IOException e) {
			throw new ConverterException("Error loading Mascot library: " + e.getMessage(), e);
		}
	}

}