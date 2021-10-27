class n10135488 {
	@Override
	public void run() {
		try {
			byte[] buf = new byte[1024];
			long pos = begin;
			URLConnection cn = url.openConnection();
			Utils.setHeader(cn);
			cn.setRequestProperty("Range", "bytes=" + begin + "-" + end);
			int len;
			BufferedInputStream bis = new BufferedInputStream(cn.getInputStream());
			while ((len = bis.read(buf)) > 0) {
				synchronized (file) {
					file.seek(pos);
					file.write(buf, 0, len);
				}
				pos += len;
				Statics.getInstance().addComleted(len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		latch.countDown();
	}

}