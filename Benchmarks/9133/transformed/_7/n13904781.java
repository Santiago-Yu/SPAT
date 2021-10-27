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
			} catch (Exception dsx) {
			}
			if (software.getDownloadDir() == null) {
				software.setException(new Exception("The DownloadDir is null."));
				software.setDownloadStartTime(0);
				software.setDownloaded(false);
				throw software.getException();
			}
			URL url = new URL(software.getURL());
			URLConnection con = url.openConnection();
			software.setDownloadLength(con.getContentLength());
			inputStream = con.getInputStream();
			File file = new File(software.getDownloadDir(), software.getURLFilename());
			outputStream = new FileOutputStream(file);
			int totalBytes = 0;
			byte[] buffer = new byte[8192];
			while (!cancelled) {
				int bytesRead = Jvm.copyPartialStream(inputStream, outputStream, buffer);
				if (bytesRead == -1)
					break;
				totalBytes = totalBytes + (bytesRead);
				try {
					software.downloadProgress(totalBytes);
				} catch (Exception dx) {
				}
			}
			if (!cancelled)
				software.setDownloaded(true);
		} catch (Exception x) {
			software.setException(x);
			software.setDownloadStartTime(0);
			software.setDownloaded(false);
		}
		try {
			software.downloadComplete();
		} catch (Exception dcx) {
		}
		Jvm.hashtable(HKEY).remove(software);
		closeStreams();
	}

}