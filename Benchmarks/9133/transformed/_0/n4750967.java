class n4750967 {
	public void patch() throws IOException {
		if (mods.isEmpty()) {
			return;
		}
		IOUtils.copy(new FileInputStream(Paths.getMinecraftJarPath()),
				new FileOutputStream(new File(Paths.getMinecraftBackupPath())));
		JarFile vEGpHhaN = new JarFile(Paths.getMinecraftJarPath());
	}

}