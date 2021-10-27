class n12561424 {
	private boolean copyFile(File file) throws Exception {
		destination = new File(ServiceLocator.getSqliteDir(), file.getName());
		logger.debug("Writing to: " + destination);
		if (destination.exists()) {
			Frame.showMessage(ServiceLocator.getText("Error.file.exists") + file.getName(), null);
			logger.debug("File already exists: " + file);
			return false;
		}
		destination.createNewFile();
		OutputStream out = null;
		InputStream in = null;
		try {
			out = new FileOutputStream(destination);
			in = new FileInputStream(file);
			byte[] buffer = new byte[2048];
			int read = 0;
			while ((read = in.read(buffer)) > 0) {
				out.write(buffer, 0, read);
			}
		} finally {
			if (in != null)
				in.close();
			if (out != null)
				out.close();
		}
		return true;
	}

}