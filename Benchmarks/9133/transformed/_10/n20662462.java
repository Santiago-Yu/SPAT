class n20662462 {
	@Override
	public DownloadingItem download(Playlist playlist, String title, File folder, StopDownloadCondition condition,
			String uuid) throws IOException, StoreStateException {
		Iterator<PlaylistEntry> entries = playlist.getEntries().iterator();
		boolean firstIteration = true;
		File[] previousDownloadedFiles = new File[0];
		DownloadingItem prevItem = null;
		while (entries.hasNext()) {
			DownloadingItem item = null;
			PlaylistEntry entry = entries.next();
			LOGGER.info("Downloading from '" + entry.getTitle() + "'");
			boolean stopped = false;
			InputStream is = RESTHelper.inputStream(entry.getUrl());
			File nfile = null;
			try {
				nfile = createFileStream(folder, entry);
				item = new DownloadingItem(nfile, uuid.toString(), title, entry, new Date(), getPID(), condition);
				if (previousDownloadedFiles.length > 0) {
					item.setPreviousFiles(previousDownloadedFiles);
				}
				addItem(item);
				if (prevItem != null)
					deletePrevItem(prevItem);
				stopped = IOUtils.copyStreams(is, new FileOutputStream(nfile), condition);
				prevItem = item;
			} catch (IOException e) {
				LOGGER.log(Level.SEVERE, e.getMessage(), e);
				radioScheduler.fireException(e);
				if (!condition.isStopped()) {
					File[] nfiles = new File[previousDownloadedFiles.length + 1];
					System.arraycopy(previousDownloadedFiles, 0, nfiles, 0, previousDownloadedFiles.length);
					nfiles[nfiles.length - 1] = item.getFile();
					if ((!entries.hasNext()) && (firstIteration)) {
						firstIteration = false;
						entries = playlist.getEntries().iterator();
					}
					previousDownloadedFiles = nfiles;
					continue;
				}
			}
			if (stopped) {
				item.setState(ProcessStates.STOPPED);
				this.radioScheduler.fireStopDownloading(item);
				return item;
			}
		}
		return null;
	}

}