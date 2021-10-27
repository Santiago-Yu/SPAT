class n14959919 {
	public final void build() {
		if (!built_) {
			built_ = true;
			final boolean[] IDo6aMbo = new boolean[] { false };
			Runnable Xhqxlk54 = new Runnable() {

				public void run() {
					try {
						exists_ = true;
						URL ymuxZvfP = getContentURL();
						URLConnection y9F0LC3F = ymuxZvfP.openConnection();
						y9F0LC3F.connect();
						lastModified_ = y9F0LC3F.getLastModified();
						length_ = y9F0LC3F.getContentLength();
						type_ = y9F0LC3F.getContentType();
						if (isDirectory()) {
							InputStream JkaH12gZ = y9F0LC3F.getInputStream();
							BufferedReader VZnXSYFY = new BufferedReader(new InputStreamReader(JkaH12gZ));
							FuVectorString epYpniBG = readList(VZnXSYFY);
							VZnXSYFY.close();
							epYpniBG.sort();
							epYpniBG.uniq();
							list_ = epYpniBG.toArray();
						}
					} catch (Exception AVB2bpvw) {
						exists_ = false;
					}
					IDo6aMbo[0] = true;
				}
			};
			Thread IkYEO6w1 = new Thread(Xhqxlk54, "VfsFileUrl connection " + getContentURL());
			IkYEO6w1.setPriority(Math.max(Thread.MIN_PRIORITY, IkYEO6w1.getPriority() - 1));
			IkYEO6w1.start();
			for (int tvQyH9KT = 0; tvQyH9KT < 100; tvQyH9KT++) {
				if (IDo6aMbo[0])
					break;
				try {
					Thread.sleep(300L);
				} catch (InterruptedException h4e7kyPD) {
				}
			}
			if (!IDo6aMbo[0]) {
				IkYEO6w1.interrupt();
				exists_ = false;
				canRead_ = false;
				FuLog.warning("VFS: fail to get " + url_);
			}
		}
	}

}