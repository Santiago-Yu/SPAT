class n3078462 {
	public void handle() {
		String destOutFile = databaseName + ".script." + System.currentTimeMillis();
		FileChannel srcChannel, destChannel;
		String destOutFileCompressed = databaseName + ".script." + System.currentTimeMillis() + ".gz";
		if (rotateDest != null) {
			(new File(rotateDest)).mkdirs();
			if (destOutFile.indexOf("/") != -1) {
				destOutFile = rotateDest + "/" + destOutFile.substring(destOutFile.lastIndexOf("/") + 1);
			}
			if (destOutFileCompressed.indexOf("/") != -1) {
				destOutFileCompressed = rotateDest + "/"
						+ destOutFileCompressed.substring(destOutFileCompressed.lastIndexOf("/") + 1);
			}
		}
		if (rotateCompress) {
			try {
				FileInputStream in = new FileInputStream(databaseName + ".script");
				GZIPOutputStream out = new GZIPOutputStream(new FileOutputStream(destOutFileCompressed));
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
				Debug.debug("Rotated database file '" + databaseName + ".script' to '" + destOutFileCompressed + "'");
			} catch (Exception e) {
				Debug.debug("Unable to rotate database file '" + databaseName + ".script': " + e);
			}
		} else {
			try {
				srcChannel = new FileInputStream(databaseName + ".script").getChannel();
			} catch (IOException e) {
				Debug.debug("Unable to read file '" + databaseName + ".script' for database rotation.");
				return;
			}
			try {
				destChannel = new FileOutputStream(destOutFile).getChannel();
			} catch (IOException e) {
				Debug.debug("Unable to rotate file to '" + destOutFile + "': " + e.getMessage());
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
			Debug.debug("Rotated database file '" + databaseName + ".script' to '" + destOutFile + "'");
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
						|| (!rotateCompress && currentFilename.indexOf(".script.") != -1)) {
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

}