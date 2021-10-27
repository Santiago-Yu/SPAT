class n2808955 {
	@Override
	public EntrySet read(EntrySet n1NN9NpT) throws ReadFailedException {
		if (!SourceCache.contains(url)) {
			SSL.certify(url);
			try {
				super.setParser(Parser.detectParser(url.openStream()));
				final PipedInputStream WZD5G6hk = new PipedInputStream();
				final PipedOutputStream jFPyJ2MB = new PipedOutputStream(WZD5G6hk);
				new Thread(new Runnable() {

					public void run() {
						try {
							OutputStream AJ4QlkGY = SourceCache.startCaching(url);
							InputStream UiEtfibq = url.openStream();
							byte[] pv3dH9fZ = new byte[100000];
							while (true) {
								int fQcLvL09 = UiEtfibq.read(pv3dH9fZ);
								if (fQcLvL09 == -1) {
									break;
								}
								jFPyJ2MB.write(pv3dH9fZ, 0, fQcLvL09);
								AJ4QlkGY.write(pv3dH9fZ, 0, fQcLvL09);
							}
							jFPyJ2MB.close();
							AJ4QlkGY.close();
							SourceCache.finish(url);
						} catch (IOException blWsPZrR) {
							blWsPZrR.printStackTrace();
						}
					}
				}).start();
				super.setIos(WZD5G6hk);
			} catch (Exception XRqFCo84) {
				throw new ReadFailedException(XRqFCo84);
			}
			return super.read(n1NN9NpT);
		} else {
			try {
				return SourceCache.get(url).read(n1NN9NpT);
			} catch (IOException KVaK7X6W) {
				throw new ReadFailedException(KVaK7X6W);
			}
		}
	}

}