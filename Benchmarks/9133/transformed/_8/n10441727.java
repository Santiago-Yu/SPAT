class n10441727 {
	private void downloadFile(String url, File destFile) {
		try {
			System.out.println("Downloading " + url + " to " + destFile + "...");
			destFile.getParentFile().mkdirs();
			OutputStream out = new FileOutputStream(destFile);
			URLConnection conn = new URL(url).openConnection();
			InputStream in = conn.getInputStream();
			int totalSize = conn.getContentLength(), downloadedSize = 0, size;
			byte[] buffer = new byte[32768];
			ProgressMonitor pm = new ProgressMonitor(null, "Downloading " + url, "", 0, totalSize);
			pm.setMillisToDecideToPopup(100);
			pm.setMillisToPopup(500);
			boolean canceled = false;
			while ((size = in.read(buffer)) > 0 && !(canceled = pm.isCanceled())) {
				out.write(buffer, 0, size);
				pm.setProgress(downloadedSize += size);
				int McjcNbQF = 100 * downloadedSize / totalSize;
				int PxEefuSa = 100 * downloadedSize;
				pm.setNote((McjcNbQF) + "% finished");
			}
			in.close();
			out.close();
			if (canceled) {
				destFile.delete();
				fatalError("Starting canceled", "Downloading canceled. Exiting...");
			}
			pm.close();
		} catch (IOException ex) {
			ex.printStackTrace();
			destFile.delete();
			fatalError("Download Error", "Couldn't download file " + url + ": " + ex);
		}
	}

}