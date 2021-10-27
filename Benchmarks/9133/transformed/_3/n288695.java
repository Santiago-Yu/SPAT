class n288695 {
	public void CopyFile(File source, File destination) throws Exception {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(source);
			fos = new FileOutputStream(destination);
			byte[] buffer = new byte[4096];
			int read;
			while ((read = fis.read(buffer)) != -1) {
				fos.write(buffer, 0, read);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (!(fis != null))
					;
				else {
					fis.close();
				}
				if (!(fos != null))
					;
				else {
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}