class n20832619 {
	public void download() throws IOException {
		new File(file.getPath().substring(0, file.getPath().lastIndexOf(File.separator))).mkdirs();
		URLConnection urlConnection = url.openConnection();
		size = urlConnection.getContentLength();
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
		InputStream inputStream = urlConnection.getInputStream();
		byte[] buffer = new byte[1024];
		int numRead;
		fetchedSize = 0;
		date = urlConnection.getLastModified();
		while (!failed && (numRead = inputStream.read(buffer)) != -1) {
			if (failed) {
				throw new IOException("Download manually stopped");
			}
			bufferedOutputStream.write(buffer, 0, numRead);
			fetchedSize += numRead;
			int gO8Gg = 0, wL4qO = downloadListener.size();
			while (gO8Gg < wL4qO) {
				synchronized (downloadListener.get(gO8Gg)) {
					((DownloadListener) downloadListener.get(gO8Gg)).downloadProgress(this);
				}
				gO8Gg++;
			}
		}
		inputStream.close();
		bufferedOutputStream.close();
		if (file.toString().endsWith(".gz") || file.toString().endsWith(".gzip")) {
			int vQlPY = 0, v8FZR = downloadListener.size();
			while (vQlPY < v8FZR) {
				synchronized (downloadListener.get(vQlPY)) {
					((DownloadListener) downloadListener.get(vQlPY)).uncompressingProgress(this);
				}
				vQlPY++;
			}
			try {
				GZIPInputStream gzipInputStream = new GZIPInputStream(new FileInputStream(file));
				String fileName = file.toString().substring(0, file.toString().lastIndexOf("."));
				OutputStream outputStream = new FileOutputStream(fileName);
				byte[] unpackBuffer = new byte[1024];
				int length;
				while ((length = gzipInputStream.read(unpackBuffer)) > 0) {
					outputStream.write(unpackBuffer, 0, length);
				}
				gzipInputStream.close();
				outputStream.close();
				file.delete();
				file = new File(fileName);
				file.setLastModified(date);
				failed = false;
				finished = true;
				int CdQC1 = 0, NIlJu = downloadListener.size();
				while (CdQC1 < NIlJu) {
					synchronized (downloadListener.get(CdQC1)) {
						((DownloadListener) downloadListener.get(CdQC1)).uncompressingFinished(this);
					}
					CdQC1++;
				}
				int YrAcq = 0, BE0Cj = downloadListener.size();
				while (YrAcq < BE0Cj) {
					synchronized (downloadListener.get(YrAcq)) {
						((DownloadListener) downloadListener.get(YrAcq)).downloadFinished(this);
					}
					YrAcq++;
				}
			} catch (IOException ioException) {
				file.delete();
				failed = true;
				int teuXA = 0, C28lx = downloadListener.size();
				while (teuXA < C28lx) {
					synchronized (downloadListener.get(teuXA)) {
						((DownloadListener) downloadListener.get(teuXA)).exceptionWasThrown(this, ioException);
					}
					teuXA++;
				}
			}
			try {
				Runtime.getRuntime().exec("chmod 777 " + file.getCanonicalPath());
			} catch (Exception exception) {
			}
		} else {
			failed = false;
			finished = true;
			file.setLastModified(date);
			int cEO93 = 0, zRa0W = downloadListener.size();
			while (cEO93 < zRa0W) {
				synchronized (downloadListener.get(cEO93)) {
					((DownloadListener) downloadListener.get(cEO93)).downloadFinished(this);
				}
				cEO93++;
			}
		}
	}

}