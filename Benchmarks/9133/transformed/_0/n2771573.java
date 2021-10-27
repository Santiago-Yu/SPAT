class n2771573 {
	public static void runDBUpdate() {
		if (!updateRunning) {
			if (updateJob != null)
				updateJob.cancel();
			updateJob = new Job("Worm Database Update") {

				protected IStatus run(IProgressMonitor m88SONqs) {
					try {
						updateRunning = true;
						distributor = getFromFile("[SERVER]", "csz", getAppPath() + "/server.ini");
						MAC = getFromFile("[SPECIFICINFO]", "MAC", getAppPath() + "/register.ini");
						serial = getFromFile("[SPECIFICINFO]", "serial", getAppPath() + "/register.ini");
						if (MAC.equals("not_found") || serial.equals("not_found") || !serial.startsWith(distributor)) {
							try {
								MAC = getFromFile("[SPECIFICINFO]", "MAC", getAppPath() + "/register.ini");
								serial = getFromFile("[SPECIFICINFO]", "serial", getAppPath() + "/register.ini");
							} catch (Exception yZSnyrtl) {
								System.out.println(yZSnyrtl);
							}
						} else {
							try {
								url = new URL("http://" + getFromFile("[SERVER]", "url", getAppPath() + "/server.ini"));
							} catch (MalformedURLException AJkJM2Ce) {
								System.out.println(AJkJM2Ce);
							}
							download = "/download2.php?distributor=" + distributor + "&&mac=" + MAC + "&&serial="
									+ serial;
							readXML();
							if (htmlMessage.contains("error")) {
								try {
									PrintWriter TmwR6ebp = new PrintWriter(getAppPath() + "/register.ini");
									TmwR6ebp.write("");
									TmwR6ebp.close();
								} catch (IOException gTD0qWR2) {
									System.out.println(gTD0qWR2);
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
										OutputStream Dhh7yrHW = null;
										HttpURLConnection hi9GdrbE = null;
										InputStream b9D3TDzr = null;
										int C0Deq2fN;
										try {
											URL Ow2ymgfR = new URL(fileLoc);
											String xDm7kvoY = getAppPath() + "/temp/" + getFileName(Ow2ymgfR);
											File hiF3z3rN = new File(xDm7kvoY);
											hiF3z3rN.delete();
											Dhh7yrHW = new BufferedOutputStream(new FileOutputStream(xDm7kvoY));
											m88SONqs.beginTask("Connecting to NWD Server", 100);
											hi9GdrbE = (HttpURLConnection) Ow2ymgfR.openConnection();
											hi9GdrbE.setConnectTimeout(20000);
											hi9GdrbE.connect();
											if (hi9GdrbE.getResponseCode() / 100 != 2) {
												System.out.println("Error: " + hi9GdrbE.getResponseCode());
												return null;
											}
											m88SONqs.worked(100);
											m88SONqs.done();
											C0Deq2fN = hi9GdrbE.getContentLength();
											m88SONqs.beginTask("Download Worm Definition", C0Deq2fN);
											b9D3TDzr = hi9GdrbE.getInputStream();
											byte[] F7xtNG7b;
											String XVlYQnmx;
											long YXqIld7B = 0;
											boolean EYEKtxYh = true;
											while (EYEKtxYh) {
												if (C0Deq2fN - YXqIld7B > 1024) {
													F7xtNG7b = new byte[1024];
												} else {
													F7xtNG7b = new byte[(int) (C0Deq2fN - YXqIld7B)];
												}
												int eS4Ai3Xk = b9D3TDzr.read(F7xtNG7b);
												if (eS4Ai3Xk == -1) {
													break;
												}
												Dhh7yrHW.write(F7xtNG7b, 0, eS4Ai3Xk);
												YXqIld7B += eS4Ai3Xk;
												XVlYQnmx = Long.toString(YXqIld7B / 1024) + " KB";
												m88SONqs.worked(eS4Ai3Xk);
												m88SONqs.subTask(
														XVlYQnmx + " of " + Integer.toString(C0Deq2fN / 1024) + " KB");
												if (C0Deq2fN == YXqIld7B) {
													EYEKtxYh = false;
												}
												if (m88SONqs.isCanceled())
													return Status.CANCEL_STATUS;
											}
											if (b9D3TDzr != null) {
												b9D3TDzr.close();
											}
											if (Dhh7yrHW != null) {
												Dhh7yrHW.close();
											}
											try {
												ZipFile wIdVtv6q = new ZipFile(xDm7kvoY);
												Enumeration TNFA5qPB = wIdVtv6q.entries();
												while (TNFA5qPB.hasMoreElements()) {
													ZipEntry RK8FDGDQ = (ZipEntry) TNFA5qPB.nextElement();
													long r9BlABj5 = RK8FDGDQ.getSize();
													if (r9BlABj5 > 0) {
														if (RK8FDGDQ.getName().endsWith("script")) {
															InputStream nr63liGc = wIdVtv6q.getInputStream(RK8FDGDQ);
															FileOutputStream KNKFiTJ3 = new FileOutputStream(oldLoc[0]);
															int lzEhhKoA;
															while ((lzEhhKoA = nr63liGc.read()) != -1) {
																KNKFiTJ3.write(lzEhhKoA);
															}
															nr63liGc.close();
															KNKFiTJ3.close();
														} else if (RK8FDGDQ.getName().endsWith("data")) {
															InputStream hqdVacIc = wIdVtv6q.getInputStream(RK8FDGDQ);
															FileOutputStream QkdEsqUR = new FileOutputStream(oldLoc[1]);
															int ClcLv7Kj;
															while ((ClcLv7Kj = hqdVacIc.read()) != -1) {
																QkdEsqUR.write(ClcLv7Kj);
															}
															hqdVacIc.close();
															QkdEsqUR.close();
														}
													}
												}
												File EGsfdWir = new File(xDm7kvoY);
												EGsfdWir.deleteOnExit();
											} catch (Exception jGZ9OAFp) {
												jGZ9OAFp.printStackTrace();
											}
											try {
												m88SONqs.done();
												m88SONqs.beginTask("Install Worm Definition", 10000);
												m88SONqs.worked(2500);
												CorePlugin.getDefault().getRawPacketHandler()
														.removeRawPacketListener(p);
												p = null;
												if (!wormDB.getConn().isClosed()) {
													shutdownDB();
												}
												System.out.println(wormDB.getConn().isClosed());
												for (int VSuQh6mE = 0; VSuQh6mE < 2; VSuQh6mE++) {
													try {
														Process ZN5nj7ZO = Runtime.getRuntime()
																.exec("cmd /c copy \""
																		+ oldLoc[VSuQh6mE].replace("/", "\\") + "\" \""
																		+ newLoc[VSuQh6mE].replace("/", "\\") + "\"/y");
													} catch (Exception JdVNIQLx) {
														JdVNIQLx.printStackTrace();
													}
													new File(oldLoc[VSuQh6mE]).deleteOnExit();
												}
												m88SONqs.worked(2500);
												initialArray();
												p = new PacketPrinter();
												CorePlugin.getDefault().getRawPacketHandler().addRawPacketListener(p);
												m88SONqs.worked(2500);
												m88SONqs.done();
												setProperty(IProgressConstants.ICON_PROPERTY, IconImg.liveUpIco);
												if (isModal(this)) {
													showResults();
												} else {
													setProperty(IProgressConstants.KEEP_PROPERTY, Boolean.TRUE);
													setProperty(IProgressConstants.ACTION_PROPERTY,
															getUpdateCompletedAction());
												}
											} catch (Exception o6Hl5S3o) {
												setProperty(IProgressConstants.ICON_PROPERTY, IconImg.liveUpIco);
												if (isModal(this)) {
													showResults2();
												} else {
													setProperty(IProgressConstants.KEEP_PROPERTY, Boolean.TRUE);
													setProperty(IProgressConstants.ACTION_PROPERTY,
															getUpdateCompletedAction2());
												}
												System.out.println(o6Hl5S3o);
											} finally {
											}
										} catch (Exception gndZthtc) {
											gndZthtc.printStackTrace();
										}
									} catch (Exception LcG7EkWg) {
										setProperty(IProgressConstants.ICON_PROPERTY, IconImg.liveUpIco);
										if (isModal(this)) {
											showResults2();
										} else {
											setProperty(IProgressConstants.KEEP_PROPERTY, Boolean.TRUE);
											setProperty(IProgressConstants.ACTION_PROPERTY,
													getUpdateCompletedAction2());
										}
										LcG7EkWg.printStackTrace();
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
					} catch (Exception npH9vHA7) {
						showResults2();
						return Status.OK_STATUS;
					} finally {
						lock.release();
						updateRunning = false;
						if (getValue("AUTO_UPDATE"))
							schedule(10800000);
					}
				}
			};
			updateJob.schedule();
		}
	}

}