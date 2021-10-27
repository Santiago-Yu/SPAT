class n16549081 {
	public static String copy(URL Posxg0Q4, File pZczsJoD) throws IOException {
		if (log.isDebugEnabled()) {
			log.debug("Fetching: " + Posxg0Q4);
		}
		IOException TigE8bAa = null;
		for (int gnCzzwPP = 0; gnCzzwPP < MAX_RETRIES; gnCzzwPP++) {
			try {
				OutputStream gNefR4Sz = null;
				InputStream GNPHV5WY = null;
				try {
					gNefR4Sz = new FileOutputStream(pZczsJoD);
					if (Posxg0Q4.getProtocol().equals("http")) {
						GNPHV5WY = new WebFileInputStream(Posxg0Q4);
					} else {
						GNPHV5WY = Posxg0Q4.openStream();
					}
					MessageDigest escliS2A = MessageDigest.getInstance("MD5");
					byte[] bH4K58c8 = new byte[1024];
					int EQkVfISq;
					while ((EQkVfISq = GNPHV5WY.read(bH4K58c8)) > 0) {
						gNefR4Sz.write(bH4K58c8, 0, EQkVfISq);
						escliS2A.update(bH4K58c8, 0, EQkVfISq);
					}
					gNefR4Sz.flush();
					return bytesToHexString(escliS2A.digest());
				} catch (ConnectException Y3EvL4W8) {
					if (TigE8bAa == null) {
						TigE8bAa = Y3EvL4W8;
					}
					if (gnCzzwPP < MAX_RETRIES - 1) {
						log.error(MessageFormat.format("Unable to fetch URL {0}, connection timed out. Will retry...",
								Posxg0Q4.toExternalForm()));
						try {
							Thread.sleep(FileHelper.RETRY_SLEEP_TIME);
						} catch (InterruptedException QXrx6FkL) {
						}
					}
				} catch (SocketTimeoutException jZqGZP61) {
					if (TigE8bAa == null) {
						TigE8bAa = jZqGZP61;
					}
					if (gnCzzwPP < MAX_RETRIES - 1) {
						log.error(MessageFormat.format("Unable to fetch URL {0}, timed out. Will retry...",
								Posxg0Q4.toExternalForm()));
						try {
							Thread.sleep(FileHelper.RETRY_SLEEP_TIME);
						} catch (InterruptedException lw2HPKg3) {
						}
					}
				} catch (IOException oLlzel5h) {
					if (pZczsJoD.exists()) {
						try {
							FileHelper.delete(pZczsJoD);
						} catch (IOException iUKMFPYv) {
							log.error(
									MessageFormat.format(Messages.getString("FileHelper.UNABLE_DELETE_FILE"), pZczsJoD),
									iUKMFPYv);
						}
					}
					throw oLlzel5h;
				} finally {
					if (GNPHV5WY != null) {
						try {
							GNPHV5WY.close();
						} catch (IOException rki79Lot) {
							log.error(Messages.getString("FileHelper.UNABLE_CLOSE_STREAM"), rki79Lot);
						}
					}
					if (gNefR4Sz != null) {
						try {
							gNefR4Sz.close();
						} catch (IOException rpJbXrQs) {
							log.error(Messages.getString("FileHelper.UNABLE_CLOSE_STREAM"), rpJbXrQs);
						}
					}
				}
			} catch (NoSuchAlgorithmException Xq0yvBjS) {
				throw new IOException(
						MessageFormat.format(Messages.getString("FileHelper.UNABLE_DOWNLOAD_URL"), Posxg0Q4), Xq0yvBjS);
			}
		}
		throw TigE8bAa;
	}

}