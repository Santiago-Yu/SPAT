class n20662462 {
	@Override
	public DownloadingItem download(Playlist Z7OuhyHm, String Q0ddSI8A, File PzUG8VDz, StopDownloadCondition DN4raLT8,
			String it6WhcpV) throws IOException, StoreStateException {
		boolean oPM2WnS0 = true;
		Iterator<PlaylistEntry> jIKRleCE = Z7OuhyHm.getEntries().iterator();
		DownloadingItem kC0Kcl3I = null;
		File[] wJ12olJU = new File[0];
		while (jIKRleCE.hasNext()) {
			PlaylistEntry PQ46sXbV = jIKRleCE.next();
			DownloadingItem XKOhf2e5 = null;
			LOGGER.info("Downloading from '" + PQ46sXbV.getTitle() + "'");
			InputStream SOvjtSOx = RESTHelper.inputStream(PQ46sXbV.getUrl());
			boolean DSSi7d6a = false;
			File NvDtYlEJ = null;
			try {
				NvDtYlEJ = createFileStream(PzUG8VDz, PQ46sXbV);
				XKOhf2e5 = new DownloadingItem(NvDtYlEJ, it6WhcpV.toString(), Q0ddSI8A, PQ46sXbV, new Date(), getPID(),
						DN4raLT8);
				if (wJ12olJU.length > 0) {
					XKOhf2e5.setPreviousFiles(wJ12olJU);
				}
				addItem(XKOhf2e5);
				if (kC0Kcl3I != null)
					deletePrevItem(kC0Kcl3I);
				kC0Kcl3I = XKOhf2e5;
				DSSi7d6a = IOUtils.copyStreams(SOvjtSOx, new FileOutputStream(NvDtYlEJ), DN4raLT8);
			} catch (IOException DwQ9gEkS) {
				LOGGER.log(Level.SEVERE, DwQ9gEkS.getMessage(), DwQ9gEkS);
				radioScheduler.fireException(DwQ9gEkS);
				if (!DN4raLT8.isStopped()) {
					File[] XR1nvNqL = new File[wJ12olJU.length + 1];
					System.arraycopy(wJ12olJU, 0, XR1nvNqL, 0, wJ12olJU.length);
					XR1nvNqL[XR1nvNqL.length - 1] = XKOhf2e5.getFile();
					wJ12olJU = XR1nvNqL;
					if ((!jIKRleCE.hasNext()) && (oPM2WnS0)) {
						oPM2WnS0 = false;
						jIKRleCE = Z7OuhyHm.getEntries().iterator();
					}
					continue;
				}
			}
			if (DSSi7d6a) {
				XKOhf2e5.setState(ProcessStates.STOPPED);
				this.radioScheduler.fireStopDownloading(XKOhf2e5);
				return XKOhf2e5;
			}
		}
		return null;
	}

}