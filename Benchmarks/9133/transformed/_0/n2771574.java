class n2771574 {
	protected IStatus run(IProgressMonitor ugy3DCRd) {
		try {
			updateRunning = true;
			distributor = getFromFile("[SERVER]", "csz", getAppPath() + "/server.ini");
			MAC = getFromFile("[SPECIFICINFO]", "MAC", getAppPath() + "/register.ini");
			serial = getFromFile("[SPECIFICINFO]", "serial", getAppPath() + "/register.ini");
			if (MAC.equals("not_found") || serial.equals("not_found") || !serial.startsWith(distributor)) {
				try {
					MAC = getFromFile("[SPECIFICINFO]", "MAC", getAppPath() + "/register.ini");
					serial = getFromFile("[SPECIFICINFO]", "serial", getAppPath() + "/register.ini");
				} catch (Exception SQmm1gM7) {
					System.out.println(SQmm1gM7);
				}
			} else {
				try {
					url = new URL("http://" + getFromFile("[SERVER]", "url", getAppPath() + "/server.ini"));
				} catch (MalformedURLException uCkvezHM) {
					System.out.println(uCkvezHM);
				}
				download = "/download2.php?distributor=" + distributor + "&&mac=" + MAC + "&&serial=" + serial;
				readXML();
				if (htmlMessage.contains("error")) {
					try {
						PrintWriter HTRpbDXN = new PrintWriter(getAppPath() + "/register.ini");
						HTRpbDXN.write("");
						HTRpbDXN.close();
					} catch (IOException XFi6b9G5) {
						System.out.println(XFi6b9G5);
					}
					setProperty(IProgressConstants.ICON_PROPERTY, IconImg.liveUpIco);
					if (isModal(this)) {
						showResults2();
					} else {
						setProperty(IProgressConstants.KEEP_PROPERTY, Boolean.TRUE);
						setProperty(IProgressConstants.ACTION_PROPERTY, getUpdateCompletedAction2());
					}
				} else {
					if (!getDBVersion().equals(latestVersion)) {
						try {
							OutputStream YdVsOJB5 = null;
							HttpURLConnection nlkNOFtY = null;
							InputStream IIk6nqqy = null;
							int g0bznZuc;
							try {
								URL Nf20Guxg = new URL(fileLoc);
								String sRqo1ukE = getAppPath() + "/temp/" + getFileName(Nf20Guxg);
								File GUdm3oVr = new File(sRqo1ukE);
								GUdm3oVr.delete();
								YdVsOJB5 = new BufferedOutputStream(new FileOutputStream(sRqo1ukE));
								ugy3DCRd.beginTask("Connecting to NWD Server", 100);
								nlkNOFtY = (HttpURLConnection) Nf20Guxg.openConnection();
								nlkNOFtY.setConnectTimeout(20000);
								nlkNOFtY.connect();
								if (nlkNOFtY.getResponseCode() / 100 != 2) {
									System.out.println("Error: " + nlkNOFtY.getResponseCode());
									return null;
								}
								ugy3DCRd.worked(100);
								ugy3DCRd.done();
								g0bznZuc = nlkNOFtY.getContentLength();
								ugy3DCRd.beginTask("Download Worm Definition", g0bznZuc);
								IIk6nqqy = nlkNOFtY.getInputStream();
								byte[] WE8b0PFG;
								String f699BfZR;
								long YsVFi5da = 0;
								boolean R5eUHF7q = true;
								while (R5eUHF7q) {
									if (g0bznZuc - YsVFi5da > 1024) {
										WE8b0PFG = new byte[1024];
									} else {
										WE8b0PFG = new byte[(int) (g0bznZuc - YsVFi5da)];
									}
									int BgaoAZ7P = IIk6nqqy.read(WE8b0PFG);
									if (BgaoAZ7P == -1) {
										break;
									}
									YdVsOJB5.write(WE8b0PFG, 0, BgaoAZ7P);
									YsVFi5da += BgaoAZ7P;
									f699BfZR = Long.toString(YsVFi5da / 1024) + " KB";
									ugy3DCRd.worked(BgaoAZ7P);
									ugy3DCRd.subTask(f699BfZR + " of " + Integer.toString(g0bznZuc / 1024) + " KB");
									if (g0bznZuc == YsVFi5da) {
										R5eUHF7q = false;
									}
									if (ugy3DCRd.isCanceled())
										return Status.CANCEL_STATUS;
								}
								if (IIk6nqqy != null) {
									IIk6nqqy.close();
								}
								if (YdVsOJB5 != null) {
									YdVsOJB5.close();
								}
								try {
									ZipFile nosin1Nk = new ZipFile(sRqo1ukE);
									Enumeration fhHbZtn4 = nosin1Nk.entries();
									while (fhHbZtn4.hasMoreElements()) {
										ZipEntry bwjNthnZ = (ZipEntry) fhHbZtn4.nextElement();
										long kKhhkC4y = bwjNthnZ.getSize();
										if (kKhhkC4y > 0) {
											if (bwjNthnZ.getName().endsWith("script")) {
												InputStream k08RqyVE = nosin1Nk.getInputStream(bwjNthnZ);
												FileOutputStream P0vYwO7p = new FileOutputStream(oldLoc[0]);
												int lRYMVTm5;
												while ((lRYMVTm5 = k08RqyVE.read()) != -1) {
													P0vYwO7p.write(lRYMVTm5);
												}
												k08RqyVE.close();
												P0vYwO7p.close();
											} else if (bwjNthnZ.getName().endsWith("data")) {
												InputStream l1coOnZz = nosin1Nk.getInputStream(bwjNthnZ);
												FileOutputStream PP6lSk9y = new FileOutputStream(oldLoc[1]);
												int lhaD7lqP;
												while ((lhaD7lqP = l1coOnZz.read()) != -1) {
													PP6lSk9y.write(lhaD7lqP);
												}
												l1coOnZz.close();
												PP6lSk9y.close();
											}
										}
									}
									File CoJ8i4Mp = new File(sRqo1ukE);
									CoJ8i4Mp.deleteOnExit();
								} catch (Exception mDIemPr6) {
									mDIemPr6.printStackTrace();
								}
								try {
									ugy3DCRd.done();
									ugy3DCRd.beginTask("Install Worm Definition", 10000);
									ugy3DCRd.worked(2500);
									CorePlugin.getDefault().getRawPacketHandler().removeRawPacketListener(p);
									p = null;
									if (!wormDB.getConn().isClosed()) {
										shutdownDB();
									}
									System.out.println(wormDB.getConn().isClosed());
									for (int e5C4mLyl = 0; e5C4mLyl < 2; e5C4mLyl++) {
										try {
											Process eFAPFiCV = Runtime.getRuntime()
													.exec("cmd /c copy \"" + oldLoc[e5C4mLyl].replace("/", "\\")
															+ "\" \"" + newLoc[e5C4mLyl].replace("/", "\\") + "\"/y");
										} catch (Exception WUWkExAa) {
											WUWkExAa.printStackTrace();
										}
										new File(oldLoc[e5C4mLyl]).deleteOnExit();
									}
									ugy3DCRd.worked(2500);
									initialArray();
									p = new PacketPrinter();
									CorePlugin.getDefault().getRawPacketHandler().addRawPacketListener(p);
									ugy3DCRd.worked(2500);
									ugy3DCRd.done();
									setProperty(IProgressConstants.ICON_PROPERTY, IconImg.liveUpIco);
									if (isModal(this)) {
										showResults();
									} else {
										setProperty(IProgressConstants.KEEP_PROPERTY, Boolean.TRUE);
										setProperty(IProgressConstants.ACTION_PROPERTY, getUpdateCompletedAction());
									}
								} catch (Exception ftzN16K8) {
									setProperty(IProgressConstants.ICON_PROPERTY, IconImg.liveUpIco);
									if (isModal(this)) {
										showResults2();
									} else {
										setProperty(IProgressConstants.KEEP_PROPERTY, Boolean.TRUE);
										setProperty(IProgressConstants.ACTION_PROPERTY, getUpdateCompletedAction2());
									}
									System.out.println(ftzN16K8);
								} finally {
								}
							} catch (Exception mRBfUgtG) {
								mRBfUgtG.printStackTrace();
							}
						} catch (Exception S9QFqBlq) {
							setProperty(IProgressConstants.ICON_PROPERTY, IconImg.liveUpIco);
							if (isModal(this)) {
								showResults2();
							} else {
								setProperty(IProgressConstants.KEEP_PROPERTY, Boolean.TRUE);
								setProperty(IProgressConstants.ACTION_PROPERTY, getUpdateCompletedAction2());
							}
							S9QFqBlq.printStackTrace();
						}
					} else {
						cancel();
						setProperty(IProgressConstants.ICON_PROPERTY, IconImg.liveUpIco);
						if (isModal(this)) {
							showResults1();
						} else {
							setProperty(IProgressConstants.KEEP_PROPERTY, Boolean.TRUE);
							setProperty(IProgressConstants.ACTION_PROPERTY, getUpdateCompletedAction1());
						}
					}
				}
			}
			return Status.OK_STATUS;
		} catch (Exception nqoDiWcj) {
			showResults2();
			return Status.OK_STATUS;
		} finally {
			lock.release();
			updateRunning = false;
			if (getValue("AUTO_UPDATE"))
				schedule(10800000);
		}
	}

}