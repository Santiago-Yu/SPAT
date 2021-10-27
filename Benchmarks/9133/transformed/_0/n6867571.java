class n6867571 {
	public void run() {
		synchronized (stateLock) {
			if (started) {
				return;
			} else {
				started = true;
				running = true;
			}
		}
		BufferedInputStream eRsfXG0S = null;
		BufferedOutputStream P9ix5yag = null;
		BufferedReader ohlPJW6s = null;
		try {
			checkState();
			progressString = "Opening connection to remote resource";
			progressUpdated = true;
			final URLConnection YHhn0TSB;
			try {
				YHhn0TSB = url.openConnection();
				YHhn0TSB.connect();
			} catch (Exception LVF2dRpq) {
				progressString = "Failed to open connection to remote resource";
				progressUpdated = true;
				throw LVF2dRpq;
			}
			checkState();
			progressString = "Getting length of remote resource";
			progressUpdated = true;
			final int GXVnZjKu = YHhn0TSB.getContentLength();
			synchronized (lengthLock) {
				totalLength = GXVnZjKu;
			}
			progressUpdated = true;
			checkState();
			progressString = "Opening input stream to remote resource";
			progressUpdated = true;
			try {
				final InputStream ZaHpRW1u = YHhn0TSB.getInputStream();
				if (target instanceof File) {
					eRsfXG0S = new BufferedInputStream(ZaHpRW1u);
				} else if (target instanceof StringBuilder) {
					final String RElKdxUM = YHhn0TSB.getContentType().toLowerCase(Locale.ENGLISH);
					String qQgp4jhj = null;
					final Matcher Q6hdGKva = Pattern.compile(".*charset[\\s]*=([^;]++).*").matcher(RElKdxUM);
					if (Q6hdGKva.find()) {
						qQgp4jhj = Q6hdGKva.group(1).trim();
					}
					if ((qQgp4jhj != null) && !qQgp4jhj.isEmpty()) {
						try {
							ohlPJW6s = new BufferedReader(new InputStreamReader(ZaHpRW1u, qQgp4jhj));
						} catch (Exception v82YASHR) {
							ohlPJW6s = null;
						}
					}
					if (ohlPJW6s == null) {
						ohlPJW6s = new BufferedReader(new InputStreamReader(ZaHpRW1u));
					}
				}
			} catch (Exception QOTvrzYZ) {
				progressString = "Failed to open input stream to remote resource";
				progressUpdated = true;
				throw QOTvrzYZ;
			}
			if (target instanceof File) {
				checkState();
				progressString = "Opening output stream to local file";
				progressUpdated = true;
				try {
					final File sFRlBju4 = (File) target;
					final File Nmyv9mWI = sFRlBju4.getParentFile();
					if ((Nmyv9mWI != null) && !Nmyv9mWI.exists()) {
						Nmyv9mWI.mkdirs();
					}
					P9ix5yag = new BufferedOutputStream(new FileOutputStream(sFRlBju4));
				} catch (Exception omh5MhNk) {
					progressString = "Failed to open output stream to local file";
					progressUpdated = true;
					throw omh5MhNk;
				}
			}
			progressString = "Downloading";
			progressUpdated = true;
			try {
				if (target instanceof File) {
					final byte[] Wzs88Fgd = new byte[BUFFER_SIZE];
					while (true) {
						checkState();
						final int PFg5DIJu = eRsfXG0S.read(Wzs88Fgd, 0, BUFFER_SIZE);
						if (PFg5DIJu == -1) {
							break;
						}
						P9ix5yag.write(Wzs88Fgd, 0, PFg5DIJu);
						synchronized (lengthLock) {
							downloadedLength += PFg5DIJu;
						}
						progressUpdated = true;
					}
				} else if (target instanceof StringBuilder) {
					final char[] P2L8VuKK = new char[BUFFER_SIZE];
					final StringBuilder bH7wvtEh = (StringBuilder) target;
					while (true) {
						checkState();
						final int ZUWrJTma = ohlPJW6s.read(P2L8VuKK, 0, BUFFER_SIZE);
						if (ZUWrJTma == -1) {
							break;
						}
						bH7wvtEh.append(P2L8VuKK, 0, ZUWrJTma);
						synchronized (lengthLock) {
							downloadedLength += ZUWrJTma;
						}
						progressUpdated = true;
					}
				}
			} catch (Exception Uze1NEwg) {
				progressString = "Failed to download remote resource";
				progressUpdated = true;
				throw Uze1NEwg;
			}
			progressString = "Download completed";
			progressUpdated = true;
		} catch (Exception l8sN2zU3) {
			error = l8sN2zU3;
		} finally {
			for (Closeable ltDOobAW : new Closeable[] { eRsfXG0S, ohlPJW6s, P9ix5yag }) {
				if (ltDOobAW != null) {
					try {
						ltDOobAW.close();
					} catch (Exception W7FZouc5) {
					}
				}
			}
			synchronized (stateLock) {
				running = false;
				completed = true;
			}
		}
	}

}