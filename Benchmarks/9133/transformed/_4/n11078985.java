class n11078985 {
	public void run() {
		OutputStream out = null;
		InputStream in = null;
		boolean success = false;
		String absoluteFileName = "";
		try {
			String fileName = getFileName(softwareLocation);
			File downloadFolder = new File(Properties.downloadFolder);
			if (downloadFolder.exists()) {
				fileName = (downloadFolder.isDirectory()) ? downloadFolder.getPath() + File.separator + fileName
						: fileName;
			} else {
				downloadFolder.mkdir();
				fileName = downloadFolder.getPath() + File.separator + fileName;
			}
			File softwareFile = new File(fileName);
			absoluteFileName = softwareFile.getAbsolutePath();
			if (softwareFile.exists() && softwareFile.length() == softwareSize) {
				XohmLogger.debugPrintln("Software file already exists. Exiting...");
				listener.downloadComplete(true, softwareName, absoluteFileName);
				return;
			} else {
				try {
					File[] oldFiles = downloadFolder.listFiles();
					for (int i = 0; i < oldFiles.length; i++) {
						oldFiles[i].delete();
					}
				} catch (Exception ex) {
				}
			}
			File softwareTempFile = File.createTempFile("XOHMCM", null);
			URL url = new URL(softwareLocation);
			out = new BufferedOutputStream(new FileOutputStream(softwareTempFile));
			URLConnection connection = url.openConnection();
			in = connection.getInputStream();
			listener.downloadStarted(softwareName);
			byte[] buffer = new byte[1024];
			int numRead;
			long numWritten = 0;
			while ((numRead = in.read(buffer)) != -1) {
				out.write(buffer, 0, numRead);
				numWritten += numRead;
				listener.downloadProgressNotification(softwareName, numWritten, softwareSize);
			}
			out.flush();
			out.close();
			in.close();
			if (copyFile(softwareTempFile, softwareFile)) {
				XohmLogger.debugPrintln("Download complete: " + absoluteFileName + "\t" + numWritten);
				success = true;
				softwareTempFile.delete();
			}
		} catch (Exception ex) {
			XohmLogger.warningPrintln("Software Update download failed - " + ex.getMessage(), null, null);
			ex.printStackTrace();
		}
		listener.downloadComplete(success, softwareName, absoluteFileName);
	}

}