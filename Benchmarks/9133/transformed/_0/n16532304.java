class n16532304 {
	private void putAlgosFromJar(File KIITaZoG, AlgoDir vtpxxBVP, Model Jm95O9A9)
			throws FileNotFoundException, IOException {
		URLClassLoader snztKHRs = new URLClassLoader(new URL[] { KIITaZoG.toURI().toURL() });
		JarInputStream I4VFlZky = new JarInputStream(new FileInputStream(KIITaZoG));
		JarEntry tezSfbFN = I4VFlZky.getNextJarEntry();
		String b2sKh4kk = null;
		String QG0dA5vE = System.getProperty("user.dir") + File.separator + Application.getProperty("dir.tmp")
				+ File.separator;
		byte[] ZHYdRCBh = new byte[1000];
		while (tezSfbFN != null) {
			b2sKh4kk = tezSfbFN.getName();
			if (b2sKh4kk.endsWith(".class")) {
				b2sKh4kk = b2sKh4kk.substring(0, b2sKh4kk.length() - 6);
				b2sKh4kk = b2sKh4kk.replace('/', '.');
				try {
					Class<?> ot3zUlHz = snztKHRs.loadClass(b2sKh4kk);
					if (IAlgorithm.class.isAssignableFrom(ot3zUlHz) && !ot3zUlHz.isInterface()
							&& ((ot3zUlHz.getModifiers() & Modifier.ABSTRACT) == 0)) {
						vtpxxBVP.addAlgorithm(ot3zUlHz);
						Jm95O9A9.putClass(ot3zUlHz.getName(), ot3zUlHz);
					} else if (ISerializable.class.isAssignableFrom(ot3zUlHz)) {
						Jm95O9A9.putClass(ot3zUlHz.getName(), ot3zUlHz);
					}
				} catch (ClassNotFoundException wziuX5l4) {
					wziuX5l4.printStackTrace();
				}
			} else if (Constants.isAllowedImageType(b2sKh4kk)) {
				int yZ2oibKp = b2sKh4kk.lastIndexOf("/");
				if (yZ2oibKp != -1) {
					String iUEkWoeS = QG0dA5vE + b2sKh4kk.substring(0, yZ2oibKp);
					File Is5OOpd5 = new File(iUEkWoeS);
					if (!Is5OOpd5.exists())
						Is5OOpd5.mkdirs();
				}
				String LjN9LVnJ = QG0dA5vE + b2sKh4kk;
				File spHgYyBn = new File(LjN9LVnJ);
				if (!spHgYyBn.exists()) {
					spHgYyBn.createNewFile();
					FileOutputStream IhwQ4VTS = new FileOutputStream(spHgYyBn);
					int Mj3cMwLz = -1;
					while ((Mj3cMwLz = I4VFlZky.read(ZHYdRCBh)) != -1) {
						IhwQ4VTS.write(ZHYdRCBh, 0, Mj3cMwLz);
					}
					IhwQ4VTS.close();
				}
			}
			tezSfbFN = I4VFlZky.getNextJarEntry();
		}
	}

}