class n9720547 {
	private void refreshJOGL(final File installDir) {
		try {
			Class subAppletClass = Class.forName(subAppletClassName);
		} catch (ClassNotFoundException cnfe) {
			displayError("Start failed : class not found : " + subAppletClassName);
		}
		if (!installDir.exists()) {
			installDir.mkdirs();
		}
		String libURLName = nativeLibsJarNames[osType];
		URL nativeLibURL;
		URLConnection urlConnection;
		String path = getCodeBase().toExternalForm() + libURLName;
		try {
			nativeLibURL = new URL(path);
			urlConnection = nativeLibURL.openConnection();
		} catch (Exception e) {
			e.printStackTrace();
			displayError("Couldn't access the native lib URL : " + path);
			return;
		}
		long lastModified = urlConnection.getLastModified();
		File localNativeFile = new File(installDir, nativeLibsFileNames[osType]);
		boolean needsRefresh = (!localNativeFile.exists()) || localNativeFile.lastModified() != lastModified;
		if (needsRefresh) {
			displayMessage("Updating local version of the native libraries");
			File localJarFile = new File(installDir, nativeLibsJarNames[osType]);
			try {
				saveNativesJarLocally(localJarFile, urlConnection);
			} catch (IOException ioe) {
				ioe.printStackTrace();
				displayError("Unable to install the native file locally");
				return;
			}
			InputStream is = null;
			BufferedOutputStream out = null;
			try {
				JarFile jf = new JarFile(localJarFile);
				JarEntry nativeLibEntry = findNativeEntry(jf);
				if (nativeLibEntry == null) {
					displayError("native library not found in jar file");
				} else {
					is = jf.getInputStream(nativeLibEntry);
					int totalLength = (int) nativeLibEntry.getSize();
					try {
						out = new BufferedOutputStream(new FileOutputStream(localNativeFile));
					} catch (FileNotFoundException ex) {
						ex.printStackTrace();
						return;
					}
					byte[] buffer = new byte[1024];
					int sum = 0, len;
					try {
						while ((len = is.read(buffer)) > 0) {
							out.write(buffer, 0, len);
							sum += len;
							int percent = (100 * sum / totalLength);
							displayMessage("Installing native files");
							progressBar.setValue(percent);
						}
						displayMessage("Download complete");
					} catch (IOException ioe) {
						ioe.printStackTrace();
						displayMessage("An error has occured during native library download");
						return;
					} finally {
						if (out != null) {
							try {
								out.close();
							} catch (IOException ignore) {
							}
						}
					}
					if (checkNativeCertificates(nativeLibEntry.getCertificates())) {
						localNativeFile.setLastModified(lastModified);
						loadNativesAndStart(localNativeFile);
					} else {
						displayError("The native librairies aren't properly signed");
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (is != null) {
					try {
						is.close();
					} catch (IOException ignore) {
					}
				}
			}
		} else {
			loadNativesAndStart(localNativeFile);
		}
	}

}