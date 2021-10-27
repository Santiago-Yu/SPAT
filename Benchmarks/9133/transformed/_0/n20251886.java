class n20251886 {
	private void initJarURL() {
		try {
			URL KstbLwYk = getKwantuJarURLInMavenRepo(artifactId, version);
			File Bk2JKZ4I = File.createTempFile(artifactId + "-" + version, ".jar");
			OutputStream yobTYZBj = new FileOutputStream(Bk2JKZ4I);
			InputStream bOnNvdnl = KstbLwYk.openStream();
			int MWqsF9aY = 0;
			byte[] U7Uayugp = new byte[2048];
			while ((MWqsF9aY = bOnNvdnl.read(U7Uayugp)) > 0) {
				yobTYZBj.write(U7Uayugp, 0, MWqsF9aY);
			}
			bOnNvdnl.close();
			yobTYZBj.close();
			jarURL = Bk2JKZ4I.toURI().toURL();
		} catch (IOException j0nmlQ7a) {
			throw new KwantuFaultException(j0nmlQ7a);
		}
	}

}