class n12066447 {
	protected void truncate(final File sOHKKt15) {
		LogLog.debug("Compression of file: " + sOHKKt15.getAbsolutePath() + " started.");
		if (FileUtils.isFileOlder(sOHKKt15, ManagementFactory.getRuntimeMXBean().getStartTime())) {
			final File YKYmP1fA = new File(this.getBackupDir());
			if (!YKYmP1fA.exists() && !YKYmP1fA.mkdirs()) {
				throw new AppenderInitializationError("Can't create backup dir for backup storage");
			}
			SimpleDateFormat Vt0R9vqM;
			try {
				Vt0R9vqM = new SimpleDateFormat(this.getBackupDateFormat());
			} catch (final Exception j2vAv8D7) {
				throw new AppenderInitializationError(
						"Invalid date formate for backup files: " + this.getBackupDateFormat(), j2vAv8D7);
			}
			final String JDN2PS8j = Vt0R9vqM.format(new Date(sOHKKt15.lastModified()));
			final File TV53inXo = new File(YKYmP1fA, sOHKKt15.getName() + "." + JDN2PS8j + ".zip");
			ZipOutputStream j13hK3pA = null;
			FileInputStream mEpxc9VM = null;
			try {
				j13hK3pA = new ZipOutputStream(new FileOutputStream(TV53inXo));
				final ZipEntry PfYwlpPr = new ZipEntry(sOHKKt15.getName());
				PfYwlpPr.setMethod(ZipEntry.DEFLATED);
				PfYwlpPr.setCrc(FileUtils.checksumCRC32(sOHKKt15));
				j13hK3pA.putNextEntry(PfYwlpPr);
				mEpxc9VM = FileUtils.openInputStream(sOHKKt15);
				final byte[] T4VDf2vP = new byte[1024];
				int ehpSM1A9;
				while ((ehpSM1A9 = mEpxc9VM.read(T4VDf2vP)) != -1) {
					j13hK3pA.write(T4VDf2vP, 0, ehpSM1A9);
				}
			} catch (final Exception weiWNBk6) {
				throw new AppenderInitializationError("Can't create zip file", weiWNBk6);
			} finally {
				if (j13hK3pA != null) {
					try {
						j13hK3pA.close();
					} catch (final IOException AowUhr9H) {
						LogLog.warn("Can't close zip file", AowUhr9H);
					}
				}
				if (mEpxc9VM != null) {
					try {
						mEpxc9VM.close();
					} catch (final IOException VXyLBvu7) {
						LogLog.warn("Can't close zipped file", VXyLBvu7);
					}
				}
			}
			if (!sOHKKt15.delete()) {
				throw new AppenderInitializationError("Can't delete old log file " + sOHKKt15.getAbsolutePath());
			}
		}
	}

}