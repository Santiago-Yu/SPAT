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
		if (rotateTimeoutString != null) {
			rotateTimeout = Integer.parseInt(rotateTimeoutString);
		}
		String dirName = ".";
		if (rotateDestString != null) {
			rotateDest = rotateDestString;
		}
		if (rotateCompressString != null && rotateCompressString.equalsIgnoreCase("true")) {
			rotateCompress = true;
		}
		if (rotateDaysString != null) {
			rotateDays = Integer.parseInt(rotateDaysString);
		}
		if (rotateArchiveString != null) {
			rotateArchive = rotateArchiveString;
		}
		if (rotateDeleteString != null && rotateDeleteString.equalsIgnoreCase("true")) {
			rotateDelete = true;
		}
		if (fileString != null && fileString.indexOf("/") != -1) {
			dirName = fileString.substring(0, fileString.lastIndexOf("/"));
			(new File(dirName)).mkdirs();
		}
		if (methodString != null) {
			logMethod = methodString;
		} else {
			logMethod = "file";
		}
		if (levelString != null) {
			logValue = Integer.parseInt(levelString);
		} else {
			logValue = 0;
		}
		if (calltraceString != null && calltraceString.equalsIgnoreCase("true")) {
			calltrace = true;
		} else {
			calltrace = false;
		}
		if (logMethod == null) {
			logMethod = "file";
		}
		if (quietString != null) {
			if (quietString.equalsIgnoreCase("true")) {
				beQuiet = true;
			}
		}
		if (logMethod != null) {
			if (logMethod.equalsIgnoreCase("file")) {
				if (fileString != null) {
					logFile = fileString;
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
				if (filemodeString != null && filemodeString.equalsIgnoreCase("append")) {
					ps = new PrintStream(new FileOutputStream(logfile, true));
				} else {
					ps = new PrintStream(new FileOutputStream(logfile));
				}
				Calendar calendar = new GregorianCalendar();
				isFile = true;
				DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
				Date date = calendar.getTime();
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
						String destOutFile = logFile + "." + System.currentTimeMillis();
						FileChannel srcChannel, destChannel;
						String destOutFileCompressed = logFile + "." + System.currentTimeMillis() + ".gz";
						if (rotateDest != null) {
							(new File(rotateDest)).mkdirs();
							if (destOutFile.indexOf("/") != -1) {
								destOutFile = rotateDest + "/"
										+ destOutFile.substring(destOutFile.lastIndexOf("/") + 1);
							}
							if (destOutFileCompressed.indexOf("/") != -1) {
								destOutFileCompressed = rotateDest + "/"
										+ destOutFileCompressed.substring(destOutFileCompressed.lastIndexOf("/") + 1);
							}
						}
						if (rotateCompress) {
							try {
								FileInputStream in = new FileInputStream(logFile);
								GZIPOutputStream out = new GZIPOutputStream(
										new FileOutputStream(destOutFileCompressed));
								int len;
								byte buf[] = new byte[1024];
								while ((len = in.read(buf)) > 0) {
									out.write(buf, 0, len);
								}
								in.close();
								out.finish();
								out.close();
								in = null;
								buf = null;
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
								destChannel = null;
								srcChannel = null;
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
							long currentTime = System.currentTimeMillis();
							long comparisonTime = rotateDays * (60 * 60 * 24 * 1000);
							DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
							File fileList[] = (new File(rotateDest)).listFiles();
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
									if (rotateDest != null) {
										currentFilename = rotateDest + "/" + currentFilename;
									}
									if (timeDifference > comparisonTime) {
										archive.addFile(fileList[i].getName(), currentFilename);
										fileList[i].delete();
									}
								}
							}
							fileList = null;
							archive = null;
							date = null;
							format1 = null;
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