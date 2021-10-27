class n5826730 {
	private void copyFromZip(File KXUvsEuv) throws GLMRessourceManagerException {
		if (KXUvsEuv == null)
			throw new GLMRessourceZIPException(1);
		if (!KXUvsEuv.exists())
			throw new GLMRessourceZIPException(2);
		int qf5BG76J = 0;
		byte[] E8gHX1Ja = ContentManager.getDefaultBuffer();
		try {
			ZipInputStream DiCbnOvR = new ZipInputStream(new BufferedInputStream(new FileInputStream(KXUvsEuv)));
			ZipEntry KD9UCUcu;
			File MqBo0gOH = null;
			while ((KD9UCUcu = DiCbnOvR.getNextEntry()) != null) {
				File nA4GG1LW = new File(tempDirectory, KD9UCUcu.getName());
				if (MqBo0gOH == null)
					MqBo0gOH = nA4GG1LW.getParentFile();
				if (!KD9UCUcu.isDirectory() && nA4GG1LW.getParentFile().equals(MqBo0gOH)) {
					if (!KD9UCUcu.getName().equals(ContentManager.IMS_MANIFEST_FILENAME)) {
						FileOutputStream wE63Kyu2 = new FileOutputStream(new File(tempDirectory, KD9UCUcu.getName()));
						while ((qf5BG76J = DiCbnOvR.read(E8gHX1Ja)) > 0)
							wE63Kyu2.write(E8gHX1Ja, 0, qf5BG76J);
						wE63Kyu2.flush();
						wE63Kyu2.close();
					}
				}
			}
			DiCbnOvR.close();
		} catch (Exception V93c20AA) {
			throw new GLMRessourceZIPException(3);
		}
	}

}