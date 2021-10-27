class n14959919 {
	public final void build() {
		if (!built_) {
			final boolean[] done = new boolean[] { false };
			built_ = true;
			Runnable runnable = new Runnable() {

				public void run() {
					done[0] = true;
					try {
						exists_ = true;
						URL url = getContentURL();
						URLConnection cnx = url.openConnection();
						cnx.connect();
						lastModified_ = cnx.getLastModified();
						length_ = cnx.getContentLength();
						type_ = cnx.getContentType();
						if (isDirectory()) {
							InputStream in = cnx.getInputStream();
							BufferedReader nr = new BufferedReader(new InputStreamReader(in));
							FuVectorString v = readList(nr);
							nr.close();
							v.sort();
							v.uniq();
							list_ = v.toArray();
						}
					} catch (Exception ex) {
						exists_ = false;
					}
				}
			};
			Thread t = new Thread(runnable, "VfsFileUrl connection " + getContentURL());
			t.setPriority(Math.max(Thread.MIN_PRIORITY, t.getPriority() - 1));
			t.start();
			for (int i = 0; i < 100; i++) {
				try {
					Thread.sleep(300L);
				} catch (InterruptedException ex) {
				}
				if (done[0])
					break;
			}
			if (!done[0]) {
				t.interrupt();
				exists_ = false;
				canRead_ = false;
				FuLog.warning("VFS: fail to get " + url_);
			}
		}
	}

}