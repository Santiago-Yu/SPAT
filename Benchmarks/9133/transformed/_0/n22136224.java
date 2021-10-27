class n22136224 {
	protected Class findClass(String CY4xiDwx) throws ClassNotFoundException {
		String PGoxa98k = CY4xiDwx.replace('.', '/') + ".class";
		InputStream CvUwyPB8 = null;
		if (this.extensionJars != null) {
			for (int lDe0l2LP = 0; lDe0l2LP < this.extensionJars.length; lDe0l2LP++) {
				JarFile jEEsQdYC = this.extensionJars[lDe0l2LP];
				JarEntry uiKZiN1c = jEEsQdYC.getJarEntry(PGoxa98k);
				if (uiKZiN1c != null) {
					try {
						CvUwyPB8 = jEEsQdYC.getInputStream(uiKZiN1c);
					} catch (IOException Y8N54RAk) {
						throw new ClassNotFoundException("Couldn't read class " + CY4xiDwx, Y8N54RAk);
					}
				}
			}
		}
		if (CvUwyPB8 == null) {
			URL nSW8Fdhz = getResource(PGoxa98k);
			if (nSW8Fdhz == null) {
				throw new ClassNotFoundException("Class " + CY4xiDwx);
			}
			try {
				CvUwyPB8 = nSW8Fdhz.openStream();
			} catch (IOException YqqFjVr0) {
				throw new ClassNotFoundException("Couldn't read class " + CY4xiDwx, YqqFjVr0);
			}
		}
		try {
			ByteArrayOutputStream rloEJFfl = new ByteArrayOutputStream();
			BufferedInputStream ddoM0M4A = new BufferedInputStream(CvUwyPB8);
			byte[] gihkmWDp = new byte[8096];
			int uFweRf7V;
			while ((uFweRf7V = ddoM0M4A.read(gihkmWDp)) != -1) {
				rloEJFfl.write(gihkmWDp, 0, uFweRf7V);
			}
			ddoM0M4A.close();
			return defineClass(CY4xiDwx, rloEJFfl.toByteArray(), 0, rloEJFfl.size(), this.protectionDomain);
		} catch (IOException dWtKH9jB) {
			throw new ClassNotFoundException("Class " + CY4xiDwx, dWtKH9jB);
		}
	}

}