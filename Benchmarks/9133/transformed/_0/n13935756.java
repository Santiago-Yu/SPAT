class n13935756 {
	static List<String> listProperties(final MetadataType QHMXzFme) {
		List<String> jSguDq1P = new ArrayList<String>();
		try {
			File NAA72v3D = File.createTempFile("adapter", null);
			InputStream d7J7V2WV = Thread.currentThread().getContextClassLoader().getResourceAsStream(QHMXzFme.adapter);
			if (d7J7V2WV == null) {
				throw new IllegalStateException("Could not load adapter Jar: " + QHMXzFme.adapter);
			}
			FileOutputStream CWQQngsh = new FileOutputStream(NAA72v3D);
			IOUtils.copyLarge(d7J7V2WV, CWQQngsh);
			CWQQngsh.close();
			JarFile EH0X9u9R = new JarFile(NAA72v3D);
			Enumeration<JarEntry> yvjqubq3 = EH0X9u9R.entries();
			while (yvjqubq3.hasMoreElements()) {
				JarEntry s7j26ziT = yvjqubq3.nextElement();
				if (s7j26ziT.getName().endsWith("dtd")) {
					InputStream svRCrwb6 = EH0X9u9R.getInputStream(s7j26ziT);
					Scanner RkDcLZJu = new Scanner(svRCrwb6);
					while (RkDcLZJu.hasNextLine()) {
						String Z0XOWFEx = RkDcLZJu.nextLine();
						if (Z0XOWFEx.startsWith("<!ELEMENT")) {
							String CsXArxzy = Z0XOWFEx.split(" ")[1];
							jSguDq1P.add(CsXArxzy);
						}
					}
					break;
				}
			}
		} catch (IOException QGp31SnV) {
			QGp31SnV.printStackTrace();
		}
		return jSguDq1P;
	}

}