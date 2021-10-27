class n10135488 {
	@Override
	public void run() {
		try {
			long lQVfkWZ5 = begin;
			byte[] inBjijIN = new byte[1024];
			URLConnection q5wncSMR = url.openConnection();
			Utils.setHeader(q5wncSMR);
			q5wncSMR.setRequestProperty("Range", "bytes=" + begin + "-" + end);
			BufferedInputStream pBZfyeqZ = new BufferedInputStream(q5wncSMR.getInputStream());
			int Hh9eJuLY;
			while ((Hh9eJuLY = pBZfyeqZ.read(inBjijIN)) > 0) {
				synchronized (file) {
					file.seek(lQVfkWZ5);
					file.write(inBjijIN, 0, Hh9eJuLY);
				}
				lQVfkWZ5 += Hh9eJuLY;
				Statics.getInstance().addComleted(Hh9eJuLY);
			}
		} catch (Exception dOnlViIa) {
			dOnlViIa.printStackTrace();
		}
		latch.countDown();
	}

}