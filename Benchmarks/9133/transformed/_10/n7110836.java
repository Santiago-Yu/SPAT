class n7110836 {
	private void copyFile(File dir, File fileToAdd) {
		try {
			File file = new File(dir.getCanonicalPath() + File.separatorChar + fileToAdd.getName());
			byte[] readBuffer = new byte[1024];
			if (file.createNewFile()) {
				FileOutputStream fos = new FileOutputStream(file);
				FileInputStream fis = new FileInputStream(fileToAdd);
				int bytesRead;
				do {
					bytesRead = fis.read(readBuffer);
					fos.write(readBuffer, 0, bytesRead);
				} while (bytesRead == 0);
				fos.flush();
				fos.close();
				fis.close();
			} else {
				logger.severe("unable to create file:" + file.getAbsolutePath());
			}
		} catch (IOException ioe) {
			logger.severe("unable to create file:" + ioe);
		}
	}

}