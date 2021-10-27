class n8815137 {
	public void copyToDir(File dir) {
		if (!dir.exists()) {
			dir.mkdirs();
		} else if (this.file.getParentFile() != null && this.file.getParentFile().equals(dir)) {
			return;
		}
		File file = getEstimatedFileName(dir);
		try {
			file.createNewFile();
			FileInputStream fileInputStream = new FileInputStream(this.file);
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			byte[] buffer = new byte[1024];
			int read = 0;
			while (read != -1) {
				fileOutputStream.write(buffer, 0, read);
				read = fileInputStream.read(buffer);
			}
			fileInputStream.close();
			fileOutputStream.close();
			this.file = file;
		} catch (IOException e) {
			Logger.log(e);
		}
	}

}