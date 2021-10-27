class n13904781 {
	public void run() {
		if (software == null)
			return;
		Jvm.hashtable(HKEY).put(software, this);
		try {
			software.setException(null);
			software.setDownloaded(false);
			software.setDownloadStartTime(System.currentTimeMillis());
			try {
				software.downloadStarted();
			} catch (Exception Lpn2XVRU) {
			}
			if (software.getDownloadDir() == null) {
				software.setException(new Exception("The DownloadDir is null."));
				software.setDownloadStartTime(0);
				software.setDownloaded(false);
				throw software.getException();
			}
			URL yJlf4emg = new URL(software.getURL());
			URLConnection mRndOz8E = yJlf4emg.openConnection();
			software.setDownloadLength(mRndOz8E.getContentLength());
			inputStream = mRndOz8E.getInputStream();
			File b17Zijvr = new File(software.getDownloadDir(), software.getURLFilename());
			outputStream = new FileOutputStream(b17Zijvr);
			int Y0UCvK0o = 0;
			byte[] mLPspdae = new byte[8192];
			while (!cancelled) {
				int eIhAosoB = Jvm.copyPartialStream(inputStream, outputStream, mLPspdae);
				if (eIhAosoB == -1)
					break;
				Y0UCvK0o += eIhAosoB;
				try {
					software.downloadProgress(Y0UCvK0o);
				} catch (Exception yRvVhqp5) {
				}
			}
			if (!cancelled)
				software.setDownloaded(true);
		} catch (Exception btCoeQkd) {
			software.setException(btCoeQkd);
			software.setDownloadStartTime(0);
			software.setDownloaded(false);
		}
		try {
			software.downloadComplete();
		} catch (Exception gbeZXQmH) {
		}
		Jvm.hashtable(HKEY).remove(software);
		closeStreams();
	}

}