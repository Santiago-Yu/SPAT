class n20455386 {
	@Override
	public EntrySet read(EntrySet qclXSCBH) throws ReadFailedException {
		if (!SourceCache.contains(url)) {
			SSL.certify(url);
			try {
				super.setParser(Parser.detectParser(url.openStream(), url));
				final PipedInputStream nLq9sKQf = new PipedInputStream();
				final PipedOutputStream asYz4TYA = new PipedOutputStream(nLq9sKQf);
				new Thread(new Runnable() {

					public void run() {
						try {
							OutputStream wOO8nG9w = SourceCache.startCaching(url);
							InputStream ZS4oCXc1 = url.openStream();
							byte[] wLv6lBNF = new byte[100000];
							while (true) {
								int mnNT2xSd = ZS4oCXc1.read(wLv6lBNF);
								if (mnNT2xSd == -1) {
									break;
								}
								asYz4TYA.write(wLv6lBNF, 0, mnNT2xSd);
								wOO8nG9w.write(wLv6lBNF, 0, mnNT2xSd);
							}
							asYz4TYA.close();
							wOO8nG9w.close();
							SourceCache.finish(url);
						} catch (IOException yhLKAYzO) {
							yhLKAYzO.printStackTrace();
						}
					}
				}).start();
				super.setIos(nLq9sKQf);
			} catch (Exception qEIChpHa) {
				throw new ReadFailedException(qEIChpHa);
			}
			return super.read(qclXSCBH);
		} else {
			try {
				return SourceCache.get(url).read(qclXSCBH);
			} catch (IOException KUPtcifZ) {
				throw new ReadFailedException(KUPtcifZ);
			}
		}
	}

}