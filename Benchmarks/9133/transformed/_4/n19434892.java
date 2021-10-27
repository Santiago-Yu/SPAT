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
			timeoutVal = (timeoutVal > 0) ? 10 : timeoutVal;
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
				rotateCompress = (loggerCompressObject != null
						&& ((String) loggerCompressObject).equalsIgnoreCase("true")) ? true : rotateCompress;
				rotateDelete = (loggerDeleteObject != null && ((String) loggerDeleteObject).equalsIgnoreCase("true"))
						? true
						: rotateDelete;
				rotateDest = (loggerDestObject != null) ? (String) loggerDestObject : rotateDest;
				logFile = (loggerFilenameObject != null) ? (String) loggerFilenameObject : logFile;
				rotateArchive = (loggerArchiveObject != null) ? (String) loggerArchiveObject : rotateArchive;
				rotateDays = (loggerDayObject != null) ? Integer.parseInt((String) loggerDayObject) : rotateDays;
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
									+ destOutFileCompressed.substring(destOutFileCompressed.lastIndexOf("/") + 1)
							: destOutFileCompressed;
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
					fileList = null;
					format1 = null;
					archive = null;
				}
			}
		}
		it = null;
	}

}