class n6181660 {
	public void run() {
		FTPClient HkTdNkDK = null;
		try {
			StarkHhDownloaderEtcProperties YWcu3Ub4 = new StarkHhDownloaderEtcProperties(getUri());
			StarkHhDownloaderVarProperties UWtt9d8B = new StarkHhDownloaderVarProperties(getUri());
			HkTdNkDK = new FTPClient();
			int V0whdGXc;
			HkTdNkDK.connect(YWcu3Ub4.getHostname());
			log("Connecting to ftp server at " + YWcu3Ub4.getHostname() + ".");
			log("Server replied with '" + HkTdNkDK.getReplyString() + "'.");
			V0whdGXc = HkTdNkDK.getReplyCode();
			if (!FTPReply.isPositiveCompletion(V0whdGXc)) {
				throw UserException.newOk("FTP server refused connection.");
			}
			log("Connected to server, now logging in.");
			HkTdNkDK.login(YWcu3Ub4.getUsername(), YWcu3Ub4.getPassword());
			log("Server replied with '" + HkTdNkDK.getReplyString() + "'.");
			List<String> sUT1O0Cw = YWcu3Ub4.getDirectories();
			for (int zYAkWI7w = 0; zYAkWI7w < sUT1O0Cw.size(); zYAkWI7w++) {
				log("Checking the directory '" + sUT1O0Cw.get(zYAkWI7w) + "'.");
				boolean tuMRjaY5 = false;
				FTPFile[] ht9Hvrqv = HkTdNkDK.listFiles(sUT1O0Cw.get(zYAkWI7w));
				List<FTPFile> FdKAtJ40 = Arrays.asList(ht9Hvrqv);
				Collections.sort(FdKAtJ40, new Comparator<FTPFile>() {

					public int compare(FTPFile Y74qDBJE, FTPFile oQWTlxX8) {
						if (oQWTlxX8.getTimestamp().getTime().equals(Y74qDBJE.getTimestamp().getTime())) {
							return oQWTlxX8.getName().compareTo(Y74qDBJE.getName());
						} else {
							return Y74qDBJE.getTimestamp().getTime().compareTo(oQWTlxX8.getTimestamp().getTime());
						}
					}
				});
				for (FTPFile WZLhJKcE : FdKAtJ40) {
					if (WZLhJKcE.getType() == FTPFile.FILE_TYPE && (UWtt9d8B.getLastImportDate(zYAkWI7w) == null ? true
							: (WZLhJKcE.getTimestamp().getTime().equals(UWtt9d8B.getLastImportDate(zYAkWI7w).getDate())
									? WZLhJKcE.getName().compareTo(UWtt9d8B.getLastImportName(zYAkWI7w)) < 0
									: WZLhJKcE.getTimestamp().getTime()
											.after(UWtt9d8B.getLastImportDate(zYAkWI7w).getDate())))) {
						String BTK5QXIJ = sUT1O0Cw.get(zYAkWI7w) + "\\" + WZLhJKcE.getName();
						if (WZLhJKcE.getSize() == 0) {
							log("Ignoring '" + BTK5QXIJ + "'because it has zero length");
						} else {
							log("Attempting to download '" + BTK5QXIJ + "'.");
							InputStream jCFSzLLL = HkTdNkDK.retrieveFileStream(BTK5QXIJ);
							if (jCFSzLLL == null) {
								V0whdGXc = HkTdNkDK.getReplyCode();
								throw UserException.newOk("Can't download the file '" + WZLhJKcE.getName()
										+ "', server says: " + V0whdGXc + ".");
							}
							log("File stream obtained successfully.");
							hhImporter = new HhDataImportProcess(getContract().getId(), new Long(0), jCFSzLLL,
									BTK5QXIJ + ".df2", WZLhJKcE.getSize());
							hhImporter.run();
							List<VFMessage> DDEnLqlx = hhImporter.getMessages();
							hhImporter = null;
							if (DDEnLqlx.size() > 0) {
								for (VFMessage poHWfqtV : DDEnLqlx) {
									log(poHWfqtV.getDescription());
								}
								throw UserException.newInvalidParameter("Problem loading file.");
							}
						}
						if (!HkTdNkDK.completePendingCommand()) {
							throw UserException
									.newOk("Couldn't complete ftp transaction: " + HkTdNkDK.getReplyString());
						}
						UWtt9d8B.setLastImportDate(zYAkWI7w, new MonadDate(WZLhJKcE.getTimestamp().getTime()));
						UWtt9d8B.setLastImportName(zYAkWI7w, WZLhJKcE.getName());
						tuMRjaY5 = true;
					}
				}
				if (!tuMRjaY5) {
					log("No new files found.");
				}
			}
		} catch (UserException Xo0J6e5w) {
			try {
				log(Xo0J6e5w.getVFMessage().getDescription());
			} catch (ProgrammerException HQkIVepC) {
				throw new RuntimeException(HQkIVepC);
			} catch (UserException vXdvOqlk) {
				throw new RuntimeException(vXdvOqlk);
			}
		} catch (IOException yj1Qn5Z1) {
			try {
				log(yj1Qn5Z1.getMessage());
			} catch (ProgrammerException Q77m5h8c) {
				throw new RuntimeException(Q77m5h8c);
			} catch (UserException pkrs07iB) {
				throw new RuntimeException(pkrs07iB);
			}
		} catch (Throwable dpuWjvkl) {
			try {
				log("Exception: " + dpuWjvkl.getClass().getName() + " Message: " + dpuWjvkl.getMessage());
			} catch (ProgrammerException GOKY4pK8) {
				throw new RuntimeException(GOKY4pK8);
			} catch (UserException e1ywaUlh) {
				throw new RuntimeException(e1ywaUlh);
			}
			ChellowLogger.getLogger().logp(Level.SEVERE, "ContextListener", "contextInitialized",
					"Can't initialize context.", dpuWjvkl);
		} finally {
			if (HkTdNkDK != null && HkTdNkDK.isConnected()) {
				try {
					HkTdNkDK.logout();
					HkTdNkDK.disconnect();
					log("Logged out.");
				} catch (IOException cVkSkz4g) {
				} catch (ProgrammerException IOGTaLYK) {
				} catch (UserException mUNDGIko) {
				}
			}
		}
	}

}