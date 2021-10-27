class n14484136 {
	public void copyJarContent(File gAll5dPG, File RxDE0sVK) throws IOException {
		log.info("Copying natives from " + gAll5dPG.getName());
		JarFile fphqOfTs = new JarFile(gAll5dPG);
		Enumeration<JarEntry> alHcml1K = fphqOfTs.entries();
		while (alHcml1K.hasMoreElements()) {
			JarEntry IzZTlKPi = alHcml1K.nextElement();
			File QqC5tT4Y = new File(RxDE0sVK, IzZTlKPi.getName());
			log.info("Copying native - " + IzZTlKPi.getName());
			File RhrGMQSl = QqC5tT4Y.getParentFile();
			RhrGMQSl.mkdirs();
			if (IzZTlKPi.isDirectory()) {
				QqC5tT4Y.mkdir();
				continue;
			}
			InputStream iaeRVeCS = null;
			FileOutputStream ih1a783Q = null;
			try {
				iaeRVeCS = fphqOfTs.getInputStream(IzZTlKPi);
				ih1a783Q = new FileOutputStream(QqC5tT4Y);
				IOUtils.copy(iaeRVeCS, ih1a783Q);
			} finally {
				if (ih1a783Q != null)
					ih1a783Q.close();
				if (iaeRVeCS != null)
					iaeRVeCS.close();
			}
		}
	}

}