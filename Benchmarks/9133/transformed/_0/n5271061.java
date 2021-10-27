class n5271061 {
	private void createJarArchive(File jpEDLp34, List<File> B6VDx1Wv, File pt91TQ6b) throws Exception {
		FileOutputStream bSSSI9JI = new FileOutputStream(jpEDLp34);
		JarOutputStream aeg07jPf = new JarOutputStream(bSSSI9JI);
		for (File TpgyqtPy : B6VDx1Wv) {
			if (TpgyqtPy == null || !TpgyqtPy.exists() || TpgyqtPy.isDirectory())
				continue;
			String VSUHb0vO = TpgyqtPy.getAbsolutePath().substring(pt91TQ6b.getAbsolutePath().length() + 1)
					.replace("\\", "/");
			JarEntry iPYB2qwX = new JarEntry(VSUHb0vO);
			iPYB2qwX.setTime(TpgyqtPy.lastModified());
			aeg07jPf.putNextEntry(iPYB2qwX);
			FileInputStream jTklm3un = new FileInputStream(TpgyqtPy);
			IOUtils.copy(jTklm3un, aeg07jPf);
			IOUtils.closeQuietly(jTklm3un);
			aeg07jPf.closeEntry();
		}
		aeg07jPf.close();
		bSSSI9JI.close();
		System.out.println("Generated file: " + jpEDLp34);
	}

}