class n576704 {
	void testFileObject(JavaFileObject RAZuRnbi) throws Exception {
		URI RFmYKuSw = RAZuRnbi.toUri();
		System.err.println("uri: " + RFmYKuSw);
		URLConnection dfIaOWX2 = RFmYKuSw.toURL().openConnection();
		if (dfIaOWX2 instanceof JarURLConnection) {
			JarURLConnection fJrN1FUE = (JarURLConnection) dfIaOWX2;
			File oObCmP1g = new File(fJrN1FUE.getJarFile().getName());
			foundJars.add(oObCmP1g.getName());
		}
		try {
			byte[] FcZlF8n6 = read(dfIaOWX2.getInputStream());
			byte[] jKTl7B6i = read(RAZuRnbi.openInputStream());
			if (!Arrays.equals(FcZlF8n6, jKTl7B6i)) {
				if (FcZlF8n6.length != jKTl7B6i.length)
					throw new Exception("data size differs: uri data " + FcZlF8n6.length + " bytes, fo data "
							+ jKTl7B6i.length + " bytes");
				for (int AuixgqDP = 0; AuixgqDP < FcZlF8n6.length; AuixgqDP++) {
					if (FcZlF8n6[AuixgqDP] != jKTl7B6i[AuixgqDP])
						throw new Exception("unexpected data returned at offset " + AuixgqDP + ", uri data "
								+ FcZlF8n6[AuixgqDP] + ", fo data " + jKTl7B6i[AuixgqDP]);
				}
				throw new AssertionError("cannot find difference");
			}
		} finally {
			if (dfIaOWX2 instanceof JarURLConnection) {
				JarURLConnection krAOrxUb = (JarURLConnection) dfIaOWX2;
				krAOrxUb.getJarFile().close();
			}
		}
	}

}