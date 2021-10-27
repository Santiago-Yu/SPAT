class n1643091 {
	private static void download(String urlString) throws IOException {
		URL url = new URL(urlString);
		url = handleRedirectUrl(url);
		URLConnection cn = url.openConnection();
		Utils.setHeader(cn);
		long fileLength = cn.getContentLength();
		Statics.getInstance().setFileLength(fileLength);
		long packageLength = fileLength / THREAD_COUNT;
		long leftLength = fileLength % THREAD_COUNT;
		String fileName = Utils.decodeURLFileName(url);
		RandomAccessFile file = new RandomAccessFile(fileName, "rw");
		System.out.println("File: " + fileName + ", Size: " + Utils.calSize(fileLength));
		CountDownLatch latch = new CountDownLatch(THREAD_COUNT + 1);
		long pos = 0;
		int s4Dtj = 0;
		while (s4Dtj < THREAD_COUNT) {
			long endPos = pos + packageLength;
			if (leftLength > 0) {
				endPos++;
				leftLength--;
			}
			new Thread(new DownloadThread(latch, url, file, pos, endPos)).start();
			pos = endPos;
			s4Dtj++;
		}
		new Thread(new MoniterThread(latch)).start();
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}