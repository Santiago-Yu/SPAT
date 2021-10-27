class n18803363 {
	public void patchFile(final File classFile) {
		FileInputStream fis;
		if (!classFile.exists()) {
			myErrors.add(new FormErrorInfo(null, "Class to bind does not exist: " + myRootContainer.getClassToBind()));
			return;
		}
		try {
			fis = new FileInputStream(classFile);
			byte[] patchedData;
			FileOutputStream fos = new FileOutputStream(classFile);
			try {
				patchedData = patchClass(fis);
				if (patchedData == null) {
					return;
				}
			} finally {
				fis.close();
			}
			try {
				fos.write(patchedData);
			} finally {
				fos.close();
			}
		} catch (IOException e) {
			myErrors.add(new FormErrorInfo(null,
					"Cannot read or write class file " + classFile.getPath() + ": " + e.toString()));
		}
	}

}