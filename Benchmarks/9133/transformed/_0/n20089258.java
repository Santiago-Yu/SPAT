class n20089258 {
	private void copyEntries() {
		if (zipFile != null) {
			Enumeration<? extends ZipEntry> LHW50M5M = zipFile.entries();
			while (LHW50M5M.hasMoreElements()) {
				ZipEntry eae1pjrR = LHW50M5M.nextElement();
				if (!eae1pjrR.isDirectory() && !toIgnore.contains(normalizePath(eae1pjrR.getName()))) {
					ZipEntry YKDIKSGJ = new ZipEntry(eae1pjrR.getName());
					try {
						zipOutput.putNextEntry(YKDIKSGJ);
						IOUtils.copy(getInputStream(eae1pjrR.getName()), zipOutput);
						zipOutput.closeEntry();
					} catch (IOException Ndm5Yn7v) {
						Ndm5Yn7v.printStackTrace();
					}
				}
			}
		}
	}

}