class n11245902 {
	public static void uploadFile(File AjPi55Hl, String KT77vRaS, String na3pithO, int EgPybV5D, String BclDFyGF,
			String NLGeLzSq, String GFlGhhpQ, boolean ax04P3fy) throws IOException {
		FTPClient dXlOOiZm = null;
		try {
			m_logCat.info("Uploading " + AjPi55Hl + " to " + na3pithO + ":" + EgPybV5D + " at " + BclDFyGF);
			dXlOOiZm = new FTPClient();
			int ujpOyk6c;
			dXlOOiZm.connect(na3pithO, EgPybV5D);
			m_logCat.info("Connected to " + na3pithO + "... Trying to authenticate");
			ujpOyk6c = dXlOOiZm.getReplyCode();
			if (!FTPReply.isPositiveCompletion(ujpOyk6c)) {
				dXlOOiZm.disconnect();
				m_logCat.error("FTP server " + na3pithO + " refused connection.");
				throw new IOException("Cannot connect to the FTP Server: connection refused.");
			}
			if (!dXlOOiZm.login(NLGeLzSq, GFlGhhpQ)) {
				dXlOOiZm.logout();
				throw new IOException("Cannot connect to the FTP Server: login / password is invalid!");
			}
			dXlOOiZm.setFileType(FTP.BINARY_FILE_TYPE);
			if (!dXlOOiZm.changeWorkingDirectory(BclDFyGF)) {
				m_logCat.warn("Remote working directory: " + BclDFyGF + "does not exist on the FTP Server ...");
				m_logCat.info("Trying to create remote directory: " + BclDFyGF);
				if (!dXlOOiZm.makeDirectory(BclDFyGF)) {
					m_logCat.error("Failed to create remote directory: " + BclDFyGF);
					throw new IOException("Failed to store " + AjPi55Hl + " in the remote directory: " + BclDFyGF);
				}
				if (!dXlOOiZm.changeWorkingDirectory(BclDFyGF)) {
					m_logCat.error("Failed to change directory. Unexpected error");
					throw new IOException("Failed to change to remote directory : " + BclDFyGF);
				}
			}
			if (KT77vRaS == null) {
				KT77vRaS = AjPi55Hl.getName();
				if (KT77vRaS.startsWith("/")) {
					KT77vRaS = KT77vRaS.substring(1);
				}
			}
			if (ax04P3fy) {
				String[] V0GiW3Uy = dXlOOiZm.listNames();
				String gWlbBDtv = AjPi55Hl + KT77vRaS;
				for (int EgwBsJvr = 0; EgwBsJvr < V0GiW3Uy.length; EgwBsJvr++) {
					if (V0GiW3Uy[EgwBsJvr].equals(KT77vRaS)) {
						m_logCat.debug("Found existing file on the server: " + KT77vRaS);
						boolean I1tQ4XNb = false;
						String ihKS3r3U = "_bak";
						int kVSc02I5 = 0;
						String zJSIb7N6 = null;
						while (!I1tQ4XNb) {
							if (kVSc02I5 == 0)
								zJSIb7N6 = ihKS3r3U;
							else
								zJSIb7N6 = ihKS3r3U + kVSc02I5;
							if (dXlOOiZm.rename(KT77vRaS, KT77vRaS + zJSIb7N6)) {
								m_logCat.info(KT77vRaS + " renamed to " + KT77vRaS + zJSIb7N6);
								I1tQ4XNb = true;
							} else {
								m_logCat.warn("Renaming to " + KT77vRaS + zJSIb7N6 + " has failed!, trying again ...");
								kVSc02I5++;
							}
						}
						break;
					}
				}
			}
			InputStream ybp2kXHd = new FileInputStream(AjPi55Hl);
			m_logCat.info("Starting transfert of " + AjPi55Hl);
			dXlOOiZm.storeFile(KT77vRaS, ybp2kXHd);
			m_logCat.info(AjPi55Hl + " uploaded successfully");
			ybp2kXHd.close();
			dXlOOiZm.logout();
		} catch (FTPConnectionClosedException D5ivVV9e) {
			m_logCat.error("Server closed connection.", D5ivVV9e);
		} finally {
			if (dXlOOiZm.isConnected()) {
				try {
					dXlOOiZm.disconnect();
				} catch (IOException KPzOAwQE) {
				}
			}
		}
	}

}