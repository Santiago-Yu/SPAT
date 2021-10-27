class n4071091 {
	public void execute(JobExecutionContext oH2cVloj) throws JobExecutionException {
		log.info("FileMonitorJob - executing its JOB at " + new Date() + " by " + oH2cVloj.getTrigger().getName());
		FTPClient xhZ25BBz = new FTPClient();
		OutputStream nbLvnrIq = null;
		Calendar Js7EKAOQ = Calendar.getInstance();
		Js7EKAOQ.set(Calendar.DAY_OF_MONTH, Js7EKAOQ.get(Calendar.DAY_OF_MONTH) - 1);
		Date lkHqODr6 = Js7EKAOQ.getTime();
		try {
			Session mBovXM54 = CustomSystemSession.create(r);
			xhZ25BBz.connect(ftpHostname);
			xhZ25BBz.login(ftpUsername, ftpPassword);
			FTPFile[] YzW0pyhw = xhZ25BBz.listFiles();
			if (YzW0pyhw != null) {
				for (FTPFile Nwv4AtPZ : YzW0pyhw) {
					String lZisxWZf = Nwv4AtPZ.getName();
					xhZ25BBz.changeWorkingDirectory("/" + lZisxWZf + "/");
					Node UYQ7R6DA = null;
					@SuppressWarnings("deprecation")
					Query aAiTU10M = mBovXM54.getWorkspace().getQueryManager()
							.createQuery("/jcr:root/users/element(*, user)[\n" + "  @alias = '"
									+ lZisxWZf.replaceAll("'", "''") + "'\n" + "]\n"
									+ "order by @lastModified descending", Query.XPATH);
					NodeIterator YJKfBl72 = aAiTU10M.execute().getNodes();
					if (YJKfBl72.hasNext()) {
						UYQ7R6DA = YJKfBl72.nextNode();
					} else if (mBovXM54.getRootNode().hasNode("users/" + lZisxWZf)) {
						UYQ7R6DA = mBovXM54.getRootNode().getNode("users/" + lZisxWZf);
					}
					FTPFile[] oCWnvjim = xhZ25BBz.listFiles();
					if (oCWnvjim != null && UYQ7R6DA != null) {
						for (FTPFile anVaarIP : oCWnvjim) {
							String FAHVgUZi = anVaarIP.getName();
							xhZ25BBz.changeWorkingDirectory("/" + lZisxWZf + "/" + FAHVgUZi + "/");
							FTPFile[] SKSLmK8W = xhZ25BBz.listFiles();
							if (SKSLmK8W != null) {
								for (FTPFile ZYtpQuwI : SKSLmK8W) {
									String HCu6LwOW = ZYtpQuwI.getName();
									xhZ25BBz.changeWorkingDirectory(
											"/" + lZisxWZf + "/" + FAHVgUZi + "/" + HCu6LwOW + "/");
									Date NvMaoror = ZYtpQuwI.getTimestamp().getTime();
									if (NvMaoror.after(lkHqODr6)) {
										FTPFile[] d0ePXNn3 = xhZ25BBz.listFiles();
										if (d0ePXNn3 != null) {
											for (FTPFile onhpamKv : d0ePXNn3) {
												processImage(lZisxWZf, FAHVgUZi, HCu6LwOW, NvMaoror, onhpamKv, xhZ25BBz,
														UYQ7R6DA, mBovXM54);
											}
										}
									}
								}
							}
						}
					}
				}
			}
			mBovXM54.logout();
			xhZ25BBz.logout();
		} catch (IOException mgDVN4lp) {
			log.info("Error communicating with FTP server.");
			log.error("Error communicating with FTP server.", mgDVN4lp);
			mgDVN4lp.printStackTrace();
		} catch (RepositoryException hxhWhNFD) {
			log.info("Error communicating with repository.");
			log.error("Error communicating with repository.", hxhWhNFD);
			hxhWhNFD.printStackTrace();
		} finally {
			IOUtils.closeQuietly(nbLvnrIq);
			try {
				xhZ25BBz.disconnect();
			} catch (IOException YzX974Dv) {
				log.error("Problem disconnecting from FTP server", YzX974Dv);
			}
		}
	}

}