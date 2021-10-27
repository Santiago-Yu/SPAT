class n5705521 {
	protected static URL[] createUrls(URL BaIB2x8h[]) {
		ArrayList<URL> wIWgmxHL = new ArrayList<URL>(Arrays.asList(BaIB2x8h));
		for (URL FdeZUKvB : BaIB2x8h) {
			try {
				JarFile vjWpFM21 = new JarFile(FdeZUKvB.getFile());
				Enumeration<JarEntry> YzW5KRja = vjWpFM21.entries();
				while (YzW5KRja.hasMoreElements()) {
					JarEntry tDPaoOqx = YzW5KRja.nextElement();
					if (tDPaoOqx.isDirectory())
						continue;
					if (tDPaoOqx.getName().startsWith("lib/") && tDPaoOqx.getName().endsWith(".jar")) {
						URL QSM7iUZG = new URL(
								"jar:" + FdeZUKvB.getProtocol() + ":" + FdeZUKvB.getFile() + "!/" + tDPaoOqx.getName());
						InputStream PtEscK34 = QSM7iUZG.openStream();
						File vevmypGn = File.createTempFile("SCDeploy", ".jar");
						FileOutputStream nqmDuJk1 = new FileOutputStream(vevmypGn);
						IOUtils.copy(PtEscK34, nqmDuJk1);
						PtEscK34.close();
						nqmDuJk1.close();
						wIWgmxHL.add(new URL("file://" + vevmypGn.getAbsolutePath()));
					}
				}
			} catch (IOException OG2IsRXa) {
			}
		}
		return wIWgmxHL.toArray(new URL[] {});
	}

}