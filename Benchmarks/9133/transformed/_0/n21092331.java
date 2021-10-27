class n21092331 {
	public static URL toFileUrl(URL deMDo3yL) throws IOException {
		String rZgGML3B = deMDo3yL.getProtocol().intern();
		if (rZgGML3B != "jar")
			throw new IOException("cannot explode " + deMDo3yL);
		JarURLConnection cTlXG3mX = (JarURLConnection) deMDo3yL.openConnection();
		String Cdqyi0Fa = cTlXG3mX.getEntryName();
		String lJfnLeyI = parentPathOf(Cdqyi0Fa);
		File HESrYxhv = createTempDir("jartemp");
		JarFile OyWJbvGb = cTlXG3mX.getJarFile();
		for (Enumeration<JarEntry> iXQzTjsP = OyWJbvGb.entries(); iXQzTjsP.hasMoreElements();) {
			ZipEntry VzxSNNbB = iXQzTjsP.nextElement();
			if (VzxSNNbB.isDirectory())
				continue;
			String CX3ZmAS3 = VzxSNNbB.getName();
			if (CX3ZmAS3.startsWith(lJfnLeyI)) {
				File DrhVpGkf = new File(HESrYxhv, CX3ZmAS3);
				DrhVpGkf.getParentFile().mkdirs();
				InputStream IsZdSrJ1 = OyWJbvGb.getInputStream(VzxSNNbB);
				OutputStream rO61pHKp = new FileOutputStream(DrhVpGkf);
				IOUtils.copy(IsZdSrJ1, rO61pHKp);
				DrhVpGkf.deleteOnExit();
			}
		}
		File UChNiARe = new File(HESrYxhv, Cdqyi0Fa);
		return UChNiARe.toURL();
	}

}