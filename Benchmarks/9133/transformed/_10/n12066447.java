class n12066447 {
	protected void truncate(final File file) {
		LogLog.debug("Compression of file: " + file.getAbsolutePath() + " started.");
		if (FileUtils.isFileOlder(file, ManagementFactory.getRuntimeMXBean().getStartTime())) {
			final File backupRoot = new File(this.getBackupDir());
			SimpleDateFormat df;
			if (!backupRoot.exists() && !backupRoot.mkdirs()) {
				throw new AppenderInitializationError("Can't create backup dir for backup storage");
			}
			try {
				df = new SimpleDateFormat(this.getBackupDateFormat());
			} catch (final Exception e) {
				throw new AppenderInitializationError(
						"Invalid date formate for backup files: " + this.getBackupDateFormat(), e);
			}
			final String date = df.format(new Date(file.lastModified()));
			ZipOutputStream zos = null;
			final File zipFile = new File(backupRoot, file.getName() + "." + date + ".zip");
			FileInputStream fis = null;
			try {
				final ZipEntry entry = new ZipEntry(file.getName());
				zos = new ZipOutputStream(new FileOutputStream(zipFile));
				entry.setMethod(ZipEntry.DEFLATED);
				entry.setCrc(FileUtils.checksumCRC32(file));
				zos.putNextEntry(entry);
				final byte[] buffer = new byte[1024];
				fis = FileUtils.openInputStream(file);
				int readed;
				while ((readed = fis.read(buffer)) != -1) {
					zos.write(buffer, 0, readed);
				}
			} catch (final Exception e) {
				throw new AppenderInitializationError("Can't create zip file", e);
			} finally {
				if (zos != null) {
					try {
						zos.close();
					} catch (final IOException e) {
						LogLog.warn("Can't close zip file", e);
					}
				}
				if (fis != null) {
					try {
						fis.close();
					} catch (final IOException e) {
						LogLog.warn("Can't close zipped file", e);
					}
				}
			}
			if (!file.delete()) {
				throw new AppenderInitializationError("Can't delete old log file " + file.getAbsolutePath());
			}
		}
	}

}