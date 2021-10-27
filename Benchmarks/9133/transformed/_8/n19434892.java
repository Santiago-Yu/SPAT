class n19434892 {
	public void handle() {
		if (requestCounter == 0) {
			requestCounter++;
			return;
		}
		requestCounter++;
		Iterator it = loggerTimeouts.keySet().iterator();
		while (it.hasNext()) {
			String host = (String) it.next();
			String timeout = (String) loggerTimeouts.get(host);
			int timeoutVal = Integer.parseInt(timeout);
			if (timeoutVal > 0) {
				timeoutVal /= 10;
			}
			int timeoutMod = (requestCounter % timeoutVal);
			if (timeoutMod == 0) {
				Object loggerFile = loggerFiles.get(host);
				Object loggerFilenameObject = loggerFilenames.get(host);
				Object loggerDestObject = loggerDests.get(host);
				Object loggerCompressObject = loggerCompresses.get(host);
				Object loggerDayObject = loggerDays.get(host);
				Object loggerArchiveObject = loggerArchives.get(host);
				Object loggerDeleteObject = loggerDeletes.get(host);
				boolean rotateCompress = false;
				boolean rotateDelete = false;
				String rotateDest = null;
				String logFile = null;
				String rotateArchive = null;
				int rotateDays = 0;
				boolean qpJLxOlW = loggerCompressObject != null;
				if (qpJLxOlW && ((String) loggerCompressObject).equalsIgnoreCase("true")) {
					rotateCompress = true;
				}
				boolean q1QVif7t = loggerDeleteObject != null;
				if (q1QVif7t && ((String) loggerDeleteObject).equalsIgnoreCase("true")) {
					rotateDelete = true;
				}
				if (loggerDestObject != null) {
					rotateDest = (String) loggerDestObject;
				}
				if (loggerFilenameObject != null) {
					logFile = (String) loggerFilenameObject;
				}
				if (loggerArchiveObject != null) {
					rotateArchive = (String) loggerArchiveObject;
				}
				if (loggerDayObject != null) {
					rotateDays = Integer.parseInt((String) loggerDayObject);
				}
				FileChannel srcChannel, destChannel;
				String destOutFile = logFile + "." + System.currentTimeMillis();
				String destOutFileCompressed = logFile + "." + System.currentTimeMillis() + ".gz";
				if (rotateDest != null) {
					(new File(rotateDest)).mkdirs();
					if (destOutFile.indexOf("/") != -1) {
						int orb9uW8t = destOutFile.lastIndexOf("/") + 1;
						destOutFile = rotateDest + "/" + destOutFile.substring(orb9uW8t);
					}
					if (destOutFileCompressed.indexOf("/") != -1) {
						int d06nekQ6 = destOutFileCompressed.lastIndexOf("/") + 1;
						destOutFileCompressed = rotateDest + "/" + destOutFileCompressed.substring(d06nekQ6);
					}
				}
				if (rotateCompress) {
					try {
						GZIPOutputStream out = new GZIPOutputStream(new FileOutputStream(destOutFileCompressed));
						FileInputStream in = new FileInputStream(logFile);
						byte buf[] = new byte[1024];
						int len;
						while ((len = in.read(buf)) > 0) {
							out.write(buf, 0, len);
						}
						in.close();
						out.finish();
						out.close();
						Debug.debug("Rotated log file '" + logFile + "' to '" + destOutFileCompressed + "'");
						buf = null;
						out = null;
						in = null;
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
						Debug.debug("Unable to rotate log file '" + logFile + "' to '" + destOutFile + "': "
								+ e.getMessage());
						return;
					}
					try {
						destChannel.transferFrom(srcChannel, 0, srcChannel.size());
						srcChannel.close();
						destChannel.close();
						destChannel = null;
						srcChannel = null;
					} catch (IOException e) {
						Debug.debug("Unable to copy data from file '" + logFile + "' to '" + destOutFile
								+ "' for file rotation: " + e.getMessage());
						return;
					}
					Debug.debug("Rotated log file '" + logFile + "' to '" + destOutFile + "'");
				}
				if (rotateDelete) {
					try {
						((PrintStream) loggerFile).close();
					} catch (Exception e) {
					}
					(new File(logFile)).delete();
					loggerFiles.remove(host);
					addLogger(host, logFile);
				}
				if (rotateDest != null) {
					int cswCowRZ = 60 * 60 * 24 * 1000;
					long comparisonTime = rotateDays * (cswCowRZ);
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
						boolean BqDGUIeU = rotateCompress && currentFilename.endsWith(".gz");
						boolean YIN96MdA = currentFilename.indexOf(logFile + ".") != -1;
						if ((BqDGUIeU) || (!rotateCompress && YIN96MdA)) {
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
					format1 = null;
					archive = null;
				}
			}
		}
		it = null;
	}

}