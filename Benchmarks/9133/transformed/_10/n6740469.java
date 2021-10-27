class n6740469 {
	private void copyFile(String sourceFilename, String destDirname) throws BuildException {
		log("Copying file " + sourceFilename + " to " + destDirname);
		InputStream inStream = null;
		File destFile = getDestFile(sourceFilename, destDirname);
		OutputStream outStream = null;
		try {
			outStream = new BufferedOutputStream(new FileOutputStream(destFile));
			inStream = new BufferedInputStream(new FileInputStream(sourceFilename));
			int n = 0;
			byte[] buffer = new byte[1024];
			while ((n = inStream.read(buffer)) != -1)
				outStream.write(buffer, 0, n);
		} catch (Exception e) {
			throw new BuildException(
					"Failed to copy file \"" + sourceFilename + "\" to directory \"" + destDirname + "\"");
		} finally {
			try {
				if (inStream != null)
					inStream.close();
			} catch (IOException e) {
			}
			try {
				if (outStream != null)
					outStream.close();
			} catch (IOException e) {
			}
		}
	}

}