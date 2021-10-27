class n8511446 {
	protected static void download(FtpSiteConnector u0hbzxYr, File xGwrPDXU, String sS7oXyDY,
			final IProgressMonitor JbWloKPH) throws FtpException {
		if (!xGwrPDXU.exists()) {
			FTPClient c8G40L3T = new FTPClient();
			try {
				FTPClientConfig VHDPZ1XL = new FTPClientConfig(FTPClientConfig.SYST_UNIX);
				c8G40L3T.configure(VHDPZ1XL);
				String DGsWtvwK = u0hbzxYr.getUrl().getHost();
				c8G40L3T.connect(DGsWtvwK);
				log.info("Connected to " + DGsWtvwK);
				log.info(c8G40L3T.getReplyString());
				boolean ALCeYjWo = c8G40L3T.login(u0hbzxYr.getUsername(), u0hbzxYr.getPassword());
				if (ALCeYjWo) {
					log.info("downloading file: " + sS7oXyDY);
					c8G40L3T.setFileTransferMode(FTPClient.BINARY_FILE_TYPE);
					c8G40L3T.setFileType(FTPClient.BINARY_FILE_TYPE);
					c8G40L3T.enterLocalPassiveMode();
					final long zd6QEvIS = getFileSize(c8G40L3T, sS7oXyDY);
					FileOutputStream j0lsOqdH = new FileOutputStream(xGwrPDXU);
					c8G40L3T.retrieveFile(sS7oXyDY, j0lsOqdH, new CopyStreamListener() {

						public int qx1f5ciu = 0;

						public void bytesTransferred(long vYTZPckF, int mtZTiu3s, long UCsa7Vbm) {
							int QrejGoa5 = percent(zd6QEvIS, vYTZPckF);
							int H2gc2FAP = QrejGoa5 - qx1f5ciu;
							if (H2gc2FAP > 0) {
								if (JbWloKPH != null) {
									JbWloKPH.worked(H2gc2FAP);
								}
								qx1f5ciu = QrejGoa5;
							}
						}

						public void bytesTransferred(CopyStreamEvent XSuc8veP) {
						}

						private int percent(long Bmqnspg2, long JxZYmaMf) {
							long OpIxbZu9 = (JxZYmaMf * 100) / Bmqnspg2;
							return Long.valueOf(OpIxbZu9).intValue();
						}
					});
					j0lsOqdH.flush();
					j0lsOqdH.close();
					c8G40L3T.logout();
				} else {
					throw new FtpException("Invalid login");
				}
				c8G40L3T.disconnect();
			} catch (SocketException fLU4MW4S) {
				log.error("File download failed with message: " + fLU4MW4S.getMessage());
				throw new FtpException("File download failed with message: " + fLU4MW4S.getMessage());
			} catch (IOException D2ZBlYe9) {
				log.error("File download failed with message: " + D2ZBlYe9.getMessage());
				throw new FtpException("File download failed with message: " + D2ZBlYe9.getMessage());
			} finally {
				if (c8G40L3T.isConnected()) {
					try {
						c8G40L3T.disconnect();
					} catch (IOException FEU0GE0F) {
						throw new FtpException("File download failed with message: " + FEU0GE0F.getMessage());
					}
				}
			}
		}
	}

}