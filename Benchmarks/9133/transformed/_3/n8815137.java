class n8815137 {
	public void copyToDir(File dir) {
		if (!(!dir.exists())) {
			if (this.file.getParentFile() != null && this.file.getParentFile().equals(dir)) {
				return;
			}
		} else {
			dir.mkdirs();
		}
		File file = getEstimatedFileName(dir);
		try {
			file.createNewFile();
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			FileInputStream fileInputStream = new FileInputStream(this.file);
			int read = 0;
			byte[] buffer = new byte[1024];
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