class n3520277 {
	private void downloadFile(String directory, String fileName) {
		String urlstr = updateURL + directory + fileName;
		URL url = null;
		int position = 0;
		try {
			Logger.msg(threadName + "Download new file from " + urlstr);
			url = new URL(urlstr);
			URLConnection conn = url.openConnection();
			BufferedInputStream in = new BufferedInputStream(conn.getInputStream());
			BufferedOutputStream out = new BufferedOutputStream(
					new FileOutputStream(updateDirectory + System.getProperty("file.separator") + fileName));
			int i = in.read();
			while (i != -1) {
				if (isInterrupted()) {
					setWasInterrupted();
					in.close();
					out.flush();
					out.close();
					interrupt();
					return;
				}
				out.write(i);
				position += 1;
				i = in.read();
				if (position % 1000 == 0) {
					Enumeration<DownloadFilesListener> en = listener.elements();
					while (en.hasMoreElements()) {
						DownloadFilesListener currentListener = en.nextElement();
						currentListener.progress(1000);
					}
				}
			}
			Enumeration<DownloadFilesListener> en = listener.elements();
			while (en.hasMoreElements()) {
				DownloadFilesListener currentListener = en.nextElement();
				currentListener.progress(1000);
			}
			in.close();
			out.flush();
			out.close();
			Logger.msg(threadName + "Saved file " + fileName + " to " + updateDirectory
					+ System.getProperty("file.separator") + fileName);
		} catch (Exception e) {
			Logger.err(threadName + "Error (" + e.toString() + ")");
		}
	}

}