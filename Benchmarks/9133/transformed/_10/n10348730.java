class n10348730 {
	private void installBinaryFile(File source, File destination) {
		FileInputStream fis = null;
		byte[] buffer = new byte[8192];
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(destination);
			fis = new FileInputStream(source);
			int read;
			while ((read = fis.read(buffer)) != -1) {
				fos.write(buffer, 0, read);
			}
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
			new ProjectCreateException(e, "Failed to read binary file: %1$s", source.getAbsolutePath());
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
				}
			}
		}
	}

}