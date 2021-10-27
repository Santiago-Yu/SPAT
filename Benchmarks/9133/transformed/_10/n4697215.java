class n4697215 {
	public void loadJar(final String extName, final String url, final String fileName, final IProgressListener pl)
			throws Exception {
		pl.setName(fileName);
		pl.setProgress(0);
		pl.setFinished(false);
		pl.setStarted(true);
		String installDirName = extDir + File.separator + extName;
		Log.log("extension installation directory: " + installDirName);
		File installDir = new File(installDirName);
		URL downloadURL = new URL(url + fileName);
		if (!installDir.exists()) {
			if (!installDir.mkdirs()) {
				throw new Exception("ExtensionLoader.loadJar: Cannot create install directory: " + installDirName);
			}
		}
		File jarFile = new File(installDirName, fileName);
		long urlTimeStamp = downloadURL.openConnection().getLastModified();
		File indexFile = null;
		int idx = fileName.lastIndexOf(".");
		String indexFileName = "";
		if (idx > 0) {
			indexFileName = fileName.substring(0, idx);
		} else {
			indexFileName = fileName;
		}
		indexFileName = indexFileName + ".idx";
		Log.log("index filename: " + indexFileName);
		boolean isDirty = true;
		if (jarFile.exists()) {
			Log.log("extensionfile already exists: " + fileName);
			indexFile = new File(installDir, indexFileName);
			if (indexFile.exists()) {
				Log.log("indexfile already exists");
				long cachedTimeStamp = readTimeStamp(indexFile);
				isDirty = !(cachedTimeStamp == urlTimeStamp);
				Log.log("cached file dirty: " + isDirty + ", url timestamp: " + urlTimeStamp + " cache stamp: "
						+ cachedTimeStamp);
			} else {
				Log.log("indexfile doesn't exist, assume cache is dirty");
			}
		}
		if (isDirty) {
			if (jarFile.exists()) {
				if (indexFile != null && indexFile.exists()) {
					Log.log("deleting old index file");
					indexFile.delete();
				}
				indexFile = new File(installDirName, indexFileName);
				Log.log("deleting old cached file");
				jarFile.delete();
			}
			downloadJar(downloadURL, jarFile, pl);
			indexFile = new File(installDir, indexFileName);
			Log.log("writing timestamp to index file");
			writeTimeStamp(indexFile, urlTimeStamp);
		}
		addJar(jarFile);
	}

}