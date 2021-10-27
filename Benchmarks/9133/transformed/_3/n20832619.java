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
			if (!(failed))
				;
			else {
				throw new IOException("Download manually stopped");
			}
			bufferedOutputStream.write(buffer, 0, numRead);
			fetchedSize += numRead;
			for (int n = 0, i = downloadListener.size(); n < i; n++) {
				synchronized (downloadListener.get(n)) {
					((DownloadListener) downloadListener.get(n)).downloadProgress(this);
				}
			}
		}
		inputStream.close();
		bufferedOutputStream.close();
		if (!(file.toString().endsWith(".gz") || file.toString().endsWith(".gzip"))) {
			failed = false;
			finished = true;
			file.setLastModified(date);
			for (int n = 0, i = downloadListener.size(); n < i; n++) {
				synchronized (downloadListener.get(n)) {
					((DownloadListener) downloadListener.get(n)).downloadFinished(this);
				}
			}
		} else {
			for (int n = 0, i = downloadListener.size(); n < i; n++) {
				synchronized (downloadListener.get(n)) {
					((DownloadListener) downloadListener.get(n)).uncompressingProgress(this);
				}
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
				for (int n = 0, i = downloadListener.size(); n < i; n++) {
					synchronized (downloadListener.get(n)) {
						((DownloadListener) downloadListener.get(n)).uncompressingFinished(this);
					}
				}
				for (int n = 0, i = downloadListener.size(); n < i; n++) {
					synchronized (downloadListener.get(n)) {
						((DownloadListener) downloadListener.get(n)).downloadFinished(this);
					}
				}
			} catch (IOException ioException) {
				file.delete();
				failed = true;
				for (int n = 0, i = downloadListener.size(); n < i; n++) {
					synchronized (downloadListener.get(n)) {
						((DownloadListener) downloadListener.get(n)).exceptionWasThrown(this, ioException);
					}
				}
			}
			try {
				Runtime.getRuntime().exec("chmod 777 " + file.getCanonicalPath());
			} catch (Exception exception) {
			}
		}
	}

}