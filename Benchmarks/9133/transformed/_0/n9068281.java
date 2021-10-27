class n9068281 {
	@Override
	protected Class<?> findClass(String TorbZTSe) throws ClassNotFoundException {
		String LIkUkPWD = TorbZTSe.replace('.', '/') + ".class";
		InputStream i6kNNjKK = null;
		for (JarFile SLdJlKOb : this.java3DJars) {
			JarEntry a6w4KtiO = SLdJlKOb.getJarEntry(LIkUkPWD);
			if (a6w4KtiO != null) {
				try {
					i6kNNjKK = SLdJlKOb.getInputStream(a6w4KtiO);
				} catch (IOException lDPbMpNo) {
					throw new ClassNotFoundException("Couldn't read class " + TorbZTSe, lDPbMpNo);
				}
			}
		}
		if (i6kNNjKK == null) {
			URL VMmXTqIG = getResource(LIkUkPWD);
			if (VMmXTqIG == null) {
				throw new ClassNotFoundException("Class " + TorbZTSe);
			}
			try {
				i6kNNjKK = VMmXTqIG.openStream();
			} catch (IOException iQDpeRIp) {
				throw new ClassNotFoundException("Couldn't read class " + TorbZTSe, iQDpeRIp);
			}
		}
		try {
			ByteArrayOutputStream cn9eRFSJ = new ByteArrayOutputStream();
			BufferedInputStream fJHglCFJ = new BufferedInputStream(i6kNNjKK);
			byte[] R5f7WxRQ = new byte[8096];
			int j4tUlmB4;
			while ((j4tUlmB4 = fJHglCFJ.read(R5f7WxRQ)) != -1) {
				cn9eRFSJ.write(R5f7WxRQ, 0, j4tUlmB4);
			}
			fJHglCFJ.close();
			return defineClass(TorbZTSe, cn9eRFSJ.toByteArray(), 0, cn9eRFSJ.size(), this.protectionDomain);
		} catch (IOException s4wtlUMM) {
			throw new ClassNotFoundException("Class " + TorbZTSe, s4wtlUMM);
		}
	}

}