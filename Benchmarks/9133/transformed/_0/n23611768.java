class n23611768 {
	private static void reconfigureDebug() {
		useFile = false;
		logValue = 0;
		String GYN4a207 = NodeUtil.walkNodeTree(Server.getConfig(),
				"//configuration/object[@type='engine.debug']/property[@type='engine.method']/@value");
		String EkAVwu4H = NodeUtil.walkNodeTree(Server.getConfig(),
				"//configuration/object[@type='engine.debug']/property[@type='engine.level']/@value");
		String l4wgRIPE = NodeUtil.walkNodeTree(Server.getConfig(),
				"//configuration/object[@type='engine.debug']/property[@type='engine.quiet']/@value");
		String mIShLkeR = NodeUtil.walkNodeTree(Server.getConfig(),
				"//configuration/object[@type='engine.debug']/property[@type='engine.file']/@value");
		String xL5WL6XI = NodeUtil.walkNodeTree(Server.getConfig(),
				"//configuration/object[@type='engine.debug']/property[@type='engine.filemode']/@value");
		String qKFn6xUm = NodeUtil.walkNodeTree(Server.getConfig(),
				"//configuration/object[@type='engine.debug']/property[@type='engine.calltrace']/@value");
		String l8ZtwMRy = NodeUtil.walkNodeTree(Server.getConfig(),
				"//configuration/object[@type='engine.debug']/property[@type='engine.rotatetimeout']/@value");
		String GVDmnPyW = NodeUtil.walkNodeTree(Server.getConfig(),
				"//configuration/object[@type='engine.debug']/property[@type='engine.rotatedest']/@value");
		String yd035XZf = NodeUtil.walkNodeTree(Server.getConfig(),
				"//configuration/object[@type='engine.debug']/property[@type='engine.rotatecompress']/@value");
		String IupM03Gu = NodeUtil.walkNodeTree(Server.getConfig(),
				"//configuration/object[@type='engine.debug']/property[@type='engine.rotatedays']/@value");
		String nQt3F2vf = NodeUtil.walkNodeTree(Server.getConfig(),
				"//configuration/object[@type='engine.debug']/property[@type='engine.rotatearchive']/@value");
		String tcVGEFbO = NodeUtil.walkNodeTree(Server.getConfig(),
				"//configuration/object[@type='engine.debug']/property[@type='engine.rotatedelete']/@value");
		String cXvO2tP7 = ".";
		if (l8ZtwMRy != null) {
			rotateTimeout = Integer.parseInt(l8ZtwMRy);
		}
		if (GVDmnPyW != null) {
			rotateDest = GVDmnPyW;
		}
		if (yd035XZf != null && yd035XZf.equalsIgnoreCase("true")) {
			rotateCompress = true;
		}
		if (IupM03Gu != null) {
			rotateDays = Integer.parseInt(IupM03Gu);
		}
		if (nQt3F2vf != null) {
			rotateArchive = nQt3F2vf;
		}
		if (tcVGEFbO != null && tcVGEFbO.equalsIgnoreCase("true")) {
			rotateDelete = true;
		}
		if (mIShLkeR != null && mIShLkeR.indexOf("/") != -1) {
			cXvO2tP7 = mIShLkeR.substring(0, mIShLkeR.lastIndexOf("/"));
			(new File(cXvO2tP7)).mkdirs();
		}
		if (GYN4a207 != null) {
			logMethod = GYN4a207;
		} else {
			logMethod = "file";
		}
		if (EkAVwu4H != null) {
			logValue = Integer.parseInt(EkAVwu4H);
		} else {
			logValue = 0;
		}
		if (qKFn6xUm != null && qKFn6xUm.equalsIgnoreCase("true")) {
			calltrace = true;
		} else {
			calltrace = false;
		}
		if (logMethod == null) {
			logMethod = "file";
		}
		if (l4wgRIPE != null) {
			if (l4wgRIPE.equalsIgnoreCase("true")) {
				beQuiet = true;
			}
		}
		if (logMethod != null) {
			if (logMethod.equalsIgnoreCase("file")) {
				if (mIShLkeR != null) {
					logFile = mIShLkeR;
				} else {
					logFile = "log.txt";
				}
				useFile = true;
			}
		} else {
			System.err.println("*** A debugging method (debug.method) is required in properties file!");
			System.err.println("*** Please refer to configuration documentation.");
			System.exit(-1);
		}
		timesRepeated = 0;
		lastMessage = null;
		if (useFile) {
			logfile = new File(logFile);
			try {
				if (xL5WL6XI != null && xL5WL6XI.equalsIgnoreCase("append")) {
					ps = new PrintStream(new FileOutputStream(logfile, true));
				} else {
					ps = new PrintStream(new FileOutputStream(logfile));
				}
				isFile = true;
				Calendar UB5cdRsq = new GregorianCalendar();
				Date aTxQnqaP = UB5cdRsq.getTime();
				DateFormat ThmKcBQV = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
				ps.println();
				ps.println("--- Log file opened " + ThmKcBQV.format(aTxQnqaP) + " ---");
			} catch (FileNotFoundException KzXBGfft) {
				System.out.println("Debug: Unable to instantiate debugger: " + KzXBGfft.getMessage());
				System.exit(-1);
			} catch (Exception aSgdPdaj) {
				System.out.println("Debug: Unable to instantiate debugger - internal error: " + aSgdPdaj.getMessage());
				System.exit(-1);
			}
		}
		if (!registeredSchedule) {
			registeredSchedule = true;
			if (Server.getScheduler() != null) {
				Server.getScheduler().register("Log File Rotator for '" + logFile + "'", new SchedulerInterface() {

					public int getScheduleRate() {
						if (rotateTimeout != 0) {
							return rotateTimeout / 10;
						}
						return 0;
					}

					public void handle() {
						FileChannel BBeIBEkq, bE2l1Xz2;
						String vFX7Hgg9 = logFile + "." + System.currentTimeMillis();
						String LwgHcCMa = logFile + "." + System.currentTimeMillis() + ".gz";
						if (rotateDest != null) {
							(new File(rotateDest)).mkdirs();
							if (vFX7Hgg9.indexOf("/") != -1) {
								vFX7Hgg9 = rotateDest + "/" + vFX7Hgg9.substring(vFX7Hgg9.lastIndexOf("/") + 1);
							}
							if (LwgHcCMa.indexOf("/") != -1) {
								LwgHcCMa = rotateDest + "/" + LwgHcCMa.substring(LwgHcCMa.lastIndexOf("/") + 1);
							}
						}
						if (rotateCompress) {
							try {
								GZIPOutputStream I8kboCCB = new GZIPOutputStream(new FileOutputStream(LwgHcCMa));
								FileInputStream fj9ETpIw = new FileInputStream(logFile);
								byte ksSutaoW[] = new byte[1024];
								int VRYEryIq;
								while ((VRYEryIq = fj9ETpIw.read(ksSutaoW)) > 0) {
									I8kboCCB.write(ksSutaoW, 0, VRYEryIq);
								}
								fj9ETpIw.close();
								I8kboCCB.finish();
								I8kboCCB.close();
								ksSutaoW = null;
								fj9ETpIw = null;
								I8kboCCB = null;
								Debug.debug("Rotated log file '" + logFile + "' to '" + LwgHcCMa + "'");
							} catch (Exception oEqEcZyy) {
								Debug.debug("Unable to rotate log file '" + logFile + "': " + oEqEcZyy);
							}
						} else {
							try {
								BBeIBEkq = new FileInputStream(logFile).getChannel();
							} catch (IOException ScqHKZRA) {
								Debug.debug("Unable to read log file '" + logFile + "': " + ScqHKZRA.getMessage());
								return;
							}
							try {
								bE2l1Xz2 = new FileOutputStream(vFX7Hgg9).getChannel();
							} catch (IOException Qsgn1IIj) {
								Debug.debug(
										"Unable to rotate log file to '" + vFX7Hgg9 + "': " + Qsgn1IIj.getMessage());
								return;
							}
							try {
								bE2l1Xz2.transferFrom(BBeIBEkq, 0, BBeIBEkq.size());
								BBeIBEkq.close();
								bE2l1Xz2.close();
								BBeIBEkq = null;
								bE2l1Xz2 = null;
							} catch (IOException ftzPo3Hf) {
								Debug.debug("Unable to copy data for file rotation: " + ftzPo3Hf.getMessage());
								return;
							}
							Debug.debug("Rotated log file '" + logFile + "' to '" + vFX7Hgg9 + "'");
						}
						if (rotateDelete && isFile) {
							try {
								ps.close();
							} catch (Exception tFUMKmwi) {
							}
							isFile = false;
							ps = null;
							(new File(logFile)).delete();
							reconfigureDebug();
						}
						if (rotateDest != null) {
							long Qd8VxfAp = rotateDays * (60 * 60 * 24 * 1000);
							long Kb9p7MqU = System.currentTimeMillis();
							File UZ8TWsB0[] = (new File(rotateDest)).listFiles();
							DateFormat rVYhy6OA = new SimpleDateFormat("yyyy-MM-dd");
							java.util.Date MqmamIN8 = new java.util.Date(Kb9p7MqU);
							String R5v0nKuZ = rVYhy6OA.format(MqmamIN8).toString() + ".zip";
							if (rotateArchive != null) {
								R5v0nKuZ = rotateArchive + "/" + R5v0nKuZ;
								(new File(rotateArchive)).mkdirs();
							}
							Archive GvPROSie = new Archive(R5v0nKuZ);
							for (int IN8ZhK0X = 0; IN8ZhK0X < UZ8TWsB0.length; IN8ZhK0X++) {
								String h0roIxlC = UZ8TWsB0[IN8ZhK0X].getName();
								long nQhGotwQ = (Kb9p7MqU - UZ8TWsB0[IN8ZhK0X].lastModified());
								if ((rotateCompress && h0roIxlC.endsWith(".gz"))
										|| (!rotateCompress && h0roIxlC.indexOf(logFile + ".") != -1)) {
									if (rotateDest != null) {
										h0roIxlC = rotateDest + "/" + h0roIxlC;
									}
									if (nQhGotwQ > Qd8VxfAp) {
										GvPROSie.addFile(UZ8TWsB0[IN8ZhK0X].getName(), h0roIxlC);
										UZ8TWsB0[IN8ZhK0X].delete();
									}
								}
							}
							GvPROSie = null;
							UZ8TWsB0 = null;
							rVYhy6OA = null;
							MqmamIN8 = null;
						}
					}

					public String identString() {
						return "Debug Rotator for logs";
					}
				});
			}
		}
	}

}