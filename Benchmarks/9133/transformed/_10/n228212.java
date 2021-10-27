class n228212 {
	public void CopyFile(File source, File destination) throws Exception {
		FileOutputStream fos = null;
		FileInputStream fis = null;
		try {
			fos = new FileOutputStream(destination);
			fis = new FileInputStream(source);
			int read;
			byte[] buffer = new byte[4096];
			while ((read = fis.read(buffer)) != -1) {
				fos.write(buffer, 0, read);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}