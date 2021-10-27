class n153462 {
	private static File copyFileTo(File file, File directory) throws IOException {
		FileInputStream fis = null;
		File newFile = new File(directory, file.getName());
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(newFile);
			fis = new FileInputStream(file);
			int val;
			byte buff[] = new byte[1024];
			while ((val = fis.read(buff)) > 0)
				fos.write(buff, 0, val);
		} finally {
			if (fis != null)
				fis.close();
			if (fos != null)
				fos.close();
		}
		return newFile;
	}

}