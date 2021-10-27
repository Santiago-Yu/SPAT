class n23277837 {
	private File download(String filename, URL url) {
		int received = 0;
		int size = -1;
		try {
			fireDownloadStarted(filename);
			File file = createFile(filename);
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
			System.out.println("下载资源：" + filename + ", url=" + url);
			byte[] buf = new byte[1024];
			InputStream bis = url.openStream();
			long lastUpdate = 0;
			int count = 0;
			size = bis.available();
			while ((count = bis.read(buf)) != -1) {
				bos.write(buf, 0, count);
				long now = System.currentTimeMillis();
				received += count;
				if (now - lastUpdate > 500) {
					fireDownloadUpdate(filename, size, received);
					lastUpdate = now;
				}
			}
			bos.close();
			System.out.println("资源下载完毕：" + filename);
			fireDownloadCompleted(filename);
			return file;
		} catch (IOException e) {
			System.out.println("下载资源失败：" + filename + ", error=" + e.getMessage());
			fireDownloadInterrupted(filename);
			if (!(e instanceof FileNotFoundException)) {
				e.printStackTrace();
			}
		}
		return null;
	}

}