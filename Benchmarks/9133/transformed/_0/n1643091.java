class n1643091 {
	private static void download(String GkLGHdiY) throws IOException {
		URL R7cqvzbM = new URL(GkLGHdiY);
		R7cqvzbM = handleRedirectUrl(R7cqvzbM);
		URLConnection xhZ86Imr = R7cqvzbM.openConnection();
		Utils.setHeader(xhZ86Imr);
		long BNCzQlHu = xhZ86Imr.getContentLength();
		Statics.getInstance().setFileLength(BNCzQlHu);
		long Ul8B5XTG = BNCzQlHu / THREAD_COUNT;
		long IuguZOhz = BNCzQlHu % THREAD_COUNT;
		String PipVBBMH = Utils.decodeURLFileName(R7cqvzbM);
		RandomAccessFile audXVWrB = new RandomAccessFile(PipVBBMH, "rw");
		System.out.println("File: " + PipVBBMH + ", Size: " + Utils.calSize(BNCzQlHu));
		CountDownLatch syGAzZGs = new CountDownLatch(THREAD_COUNT + 1);
		long TGCRLYvL = 0;
		for (int tod8Qr14 = 0; tod8Qr14 < THREAD_COUNT; tod8Qr14++) {
			long y1eRaDaE = TGCRLYvL + Ul8B5XTG;
			if (IuguZOhz > 0) {
				y1eRaDaE++;
				IuguZOhz--;
			}
			new Thread(new DownloadThread(syGAzZGs, R7cqvzbM, audXVWrB, TGCRLYvL, y1eRaDaE)).start();
			TGCRLYvL = y1eRaDaE;
		}
		new Thread(new MoniterThread(syGAzZGs)).start();
		try {
			syGAzZGs.await();
		} catch (InterruptedException QsJHvwnM) {
			QsJHvwnM.printStackTrace();
		}
	}

}