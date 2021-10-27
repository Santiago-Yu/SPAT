class n3520277 {
	private void downloadFile(String DIPASuhq, String xzXTBEJW) {
		URL Qb7zEZPX = null;
		String HG1Wp1mI = updateURL + DIPASuhq + xzXTBEJW;
		int Hi4SufcV = 0;
		try {
			Logger.msg(threadName + "Download new file from " + HG1Wp1mI);
			Qb7zEZPX = new URL(HG1Wp1mI);
			URLConnection ekk08DDf = Qb7zEZPX.openConnection();
			BufferedInputStream GFQKs7Ca = new BufferedInputStream(ekk08DDf.getInputStream());
			BufferedOutputStream rwrgAL5k = new BufferedOutputStream(
					new FileOutputStream(updateDirectory + System.getProperty("file.separator") + xzXTBEJW));
			int GrhbSzpf = GFQKs7Ca.read();
			while (GrhbSzpf != -1) {
				if (isInterrupted()) {
					setWasInterrupted();
					GFQKs7Ca.close();
					rwrgAL5k.flush();
					rwrgAL5k.close();
					interrupt();
					return;
				}
				rwrgAL5k.write(GrhbSzpf);
				GrhbSzpf = GFQKs7Ca.read();
				Hi4SufcV += 1;
				if (Hi4SufcV % 1000 == 0) {
					Enumeration<DownloadFilesListener> TaRMHLId = listener.elements();
					while (TaRMHLId.hasMoreElements()) {
						DownloadFilesListener YPsrxtZm = TaRMHLId.nextElement();
						YPsrxtZm.progress(1000);
					}
				}
			}
			Enumeration<DownloadFilesListener> xA9mGKZs = listener.elements();
			while (xA9mGKZs.hasMoreElements()) {
				DownloadFilesListener yw3OhN4G = xA9mGKZs.nextElement();
				yw3OhN4G.progress(1000);
			}
			GFQKs7Ca.close();
			rwrgAL5k.flush();
			rwrgAL5k.close();
			Logger.msg(threadName + "Saved file " + xzXTBEJW + " to " + updateDirectory
					+ System.getProperty("file.separator") + xzXTBEJW);
		} catch (Exception bVlpyT1y) {
			Logger.err(threadName + "Error (" + bVlpyT1y.toString() + ")");
		}
	}

}