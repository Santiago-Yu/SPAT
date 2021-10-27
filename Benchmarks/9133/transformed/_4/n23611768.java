class n23611768 {
	private static void reconfigureDebug() {
		useFile = false;
		logValue = 0;
		String methodString = NodeUtil.walkNodeTree(Server.getConfig(),
				"//configuration/object[@type='engine.debug']/property[@type='engine.method']/@value");
		String levelString = NodeUtil.walkNodeTree(Server.getConfig(),
				"//configuration/object[@type='engine.debug']/property[@type='engine.level']/@value");
		String quietString = NodeUtil.walkNodeTree(Server.getConfig(),
				"//configuration/object[@type='engine.debug']/property[@type='engine.quiet']/@value");
		String fileString = NodeUtil.walkNodeTree(Server.getConfig(),
				"//configuration/object[@type='engine.debug']/property[@type='engine.file']/@value");
		String filemodeString = NodeUtil.walkNodeTree(Server.getConfig(),
				"//configuration/object[@type='engine.debug']/property[@type='engine.filemode']/@value");
		String calltraceString = NodeUtil.walkNodeTree(Server.getConfig(),
				"//configuration/object[@type='engine.debug']/property[@type='engine.calltrace']/@value");
		String rotateTimeoutString = NodeUtil.walkNodeTree(Server.getConfig(),
				"//configuration/object[@type='engine.debug']/property[@type='engine.rotatetimeout']/@value");
		String rotateDestString = NodeUtil.walkNodeTree(Server.getConfig(),
				"//configuration/object[@type='engine.debug']/property[@type='engine.rotatedest']/@value");
		String rotateCompressString = NodeUtil.walkNodeTree(Server.getConfig(),
				"//configuration/object[@type='engine.debug']/property[@type='engine.rotatecompress']/@value");
		String rotateDaysString = NodeUtil.walkNodeTree(Server.getConfig(),
				"//configuration/object[@type='engine.debug']/property[@type='engine.rotatedays']/@value");
		String rotateArchiveString = NodeUtil.walkNodeTree(Server.getConfig(),
				"//configuration/object[@type='engine.debug']/property[@type='engine.rotatearchive']/@value");
		String rotateDeleteString = NodeUtil.walkNodeTree(Server.getConfig(),
				"//configuration/object[@type='engine.debug']/property[@type='engine.rotatedelete']/@value");
		String dirName = ".";
		rotateTimeout = (rotateTimeoutString != null) ? Integer.parseInt(rotateTimeoutString) : rotateTimeout;
		rotateDest = (rotateDestString != null) ? rotateDestString : rotateDest;
		rotateCompress = (rotateCompressString != null && rotateCompressString.equalsIgnoreCase("true")) ? true
				: rotateCompress;
		rotateDays = (rotateDaysString != null) ? Integer.parseInt(rotateDaysString) : rotateDays;
		rotateArchive = (rotateArchiveString != null) ? rotateArchiveString : rotateArchive;
		rotateDelete = (rotateDeleteString != null && rotateDeleteString.equalsIgnoreCase("true")) ? true
				: rotateDelete;
		if (fileString != null && fileString.indexOf("/") != -1) {
			dirName = fileString.substring(0, fileString.lastIndexOf("/"));
			(new File(dirName)).mkdirs();
		}
		logMethod = (methodString != null) ? methodString : "file";
		logValue = (levelString != null) ? Integer.parseInt(levelString) : 0;
		calltrace = (calltraceString != null && calltraceString.equalsIgnoreCase("true")) ? true : false;
		logMethod = (logMethod == null) ? "file" : logMethod;
		if (quietString != null) {
			beQuiet = (quietString.equalsIgnoreCase("true")) ? true : beQuiet;
		}
		if (logMethod != null) {
			if (logMethod.equalsIgnoreCase("file")) {
				logFile = (fileString != null) ? fileString : "log.txt";
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
				ps = (filemodeString != null && filemodeString.equalsIgnoreCase("append"))
						? new PrintStream(new FileOutputStream(logfile, true))
						: new PrintStream(new FileOutputStream(logfile));
				isFile = true;
				Calendar calendar = new GregorianCalendar();
				Date date = calendar.getTime();
				DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
				ps.println();
				ps.println("--- Log file opened " + format1.format(date) + " ---");
			} catch (FileNotFoundException e) {
				System.out.println("Debug: Unable to instantiate debugger: " + e.getMessage());
				System.exit(-1);
			} catch (Exception e) {
				System.out.println("Debug: Unable to instantiate debugger - internal error: " + e.getMessage());
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
						FileChannel srcChannel, destChannel;
						String destOutFile = logFile + "." + System.currentTimeMillis();
						String destOutFileCompressed = logFile + "." + System.currentTimeMillis() + ".gz";
						if (rotateDest != null) {
							(new File(rotateDest)).mkdirs();
							destOutFile = (destOutFile.indexOf("/") != -1)
									? rotateDest + "/" + destOutFile.substring(destOutFile.lastIndexOf("/") + 1)
									: destOutFile;
							destOutFileCompressed = (destOutFileCompressed.indexOf("/") != -1)
									? rotateDest + "/"
											+ destOutFileCompressed
													.substring(destOutFileCompressed.lastIndexOf("/") + 1)
									: destOutFileCompressed;
						}
						if (rotateCompress) {
							try {
								GZIPOutputStream out = new GZIPOutputStream(
										new FileOutputStream(destOutFileCompressed));
								FileInputStream in = new FileInputStream(logFile);
								byte buf[] = new byte[1024];
								int len;
								while ((len = in.read(buf)) > 0) {
									out.write(buf, 0, len);
								}
								in.close();
								out.finish();
								out.close();
								buf = null;
								in = null;
								out = null;
								Debug.debug("Rotated log file '" + logFile + "' to '" + destOutFileCompressed + "'");
							} catch (Exception e) {
								Debug.debug("Unable to rotate log file '" + logFile + "': " + e);
							}
						} else {
							try {
								srcChannel = new FileInputStream(logFile).getChannel();
							} catch (IOException e) {
								Debug.debug("Unable to read log file '" + logFile + "': " + e.getMessage());
								return;
							}
							try {
								destChannel = new FileOutputStream(destOutFile).getChannel();
							} catch (IOException e) {
								Debug.debug("Unable to rotate log file to '" + destOutFile + "': " + e.getMessage());
								return;
							}
							try {
								destChannel.transferFrom(srcChannel, 0, srcChannel.size());
								srcChannel.close();
								destChannel.close();
								srcChannel = null;
								destChannel = null;
							} catch (IOException e) {
								Debug.debug("Unable to copy data for file rotation: " + e.getMessage());
								return;
							}
							Debug.debug("Rotated log file '" + logFile + "' to '" + destOutFile + "'");
						}
						if (rotateDelete && isFile) {
							try {
								ps.close();
							} catch (Exception e) {
							}
							isFile = false;
							ps = null;
							(new File(logFile)).delete();
							reconfigureDebug();
						}
						if (rotateDest != null) {
							long comparisonTime = rotateDays * (60 * 60 * 24 * 1000);
							long currentTime = System.currentTimeMillis();
							File fileList[] = (new File(rotateDest)).listFiles();
							DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
							java.util.Date date = new java.util.Date(currentTime);
							String archiveFile = format1.format(date).toString() + ".zip";
							if (rotateArchive != null) {
								archiveFile = rotateArchive + "/" + archiveFile;
								(new File(rotateArchive)).mkdirs();
							}
							Archive archive = new Archive(archiveFile);
							for (int i = 0; i < fileList.length; i++) {
								String currentFilename = fileList[i].getName();
								long timeDifference = (currentTime - fileList[i].lastModified());
								if ((rotateCompress && currentFilename.endsWith(".gz"))
										|| (!rotateCompress && currentFilename.indexOf(logFile + ".") != -1)) {
									currentFilename = (rotateDest != null) ? rotateDest + "/" + currentFilename
											: currentFilename;
									if (timeDifference > comparisonTime) {
										archive.addFile(fileList[i].getName(), currentFilename);
										fileList[i].delete();
									}
								}
							}
							archive = null;
							fileList = null;
							format1 = null;
							date = null;
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