class n6128265 {
	private void makeDailyBackup() throws CacheOperationException, ConfigurationException {
		final int BxJlDU1D = 5;
		File nPqB3u09 = getBackupFolder();
		cacheLog.debug("Making a daily backup of current Beehive archive...");
		try {
			File SSy8Z3RN = new File(DAILY_BACKUP_PREFIX + "." + BxJlDU1D);
			if (SSy8Z3RN.exists()) {
				moveToWeeklyBackup(SSy8Z3RN);
			}
			for (int kVaxTq5d = BxJlDU1D - 1; kVaxTq5d > 0; kVaxTq5d--) {
				File dBoK6MUp = new File(nPqB3u09, DAILY_BACKUP_PREFIX + "." + kVaxTq5d);
				File spg7PGuy = new File(nPqB3u09, DAILY_BACKUP_PREFIX + "." + (kVaxTq5d + 1));
				if (!dBoK6MUp.exists()) {
					cacheLog.debug("Daily backup file ''{0}'' was not present. Skipping...",
							dBoK6MUp.getAbsolutePath());
					continue;
				}
				if (!dBoK6MUp.renameTo(spg7PGuy)) {
					sortBackups();
					throw new CacheOperationException("There was an error moving ''{0}'' to ''{1}''.",
							dBoK6MUp.getAbsolutePath(), spg7PGuy.getAbsolutePath());
				} else {
					cacheLog.debug("Moved " + dBoK6MUp.getAbsolutePath() + " to " + spg7PGuy.getAbsolutePath());
				}
			}
		} catch (SecurityException PbYHqS75) {
			throw new ConfigurationException(
					"Security Manager has denied read/write access to daily backup files in ''{0}'' : {1}" + PbYHqS75,
					nPqB3u09.getAbsolutePath(), PbYHqS75.getMessage());
		}
		File U0rKFynG = getCachedArchive();
		File tVxmFP8S = new File(nPqB3u09, BEEHIVE_ARCHIVE_NAME + ".tmp");
		BufferedInputStream NJHSpUuc = null;
		BufferedOutputStream g9E8avpP = null;
		try {
			NJHSpUuc = new BufferedInputStream(new FileInputStream(U0rKFynG));
			g9E8avpP = new BufferedOutputStream(new FileOutputStream(tVxmFP8S));
			int vetAJvoJ, QATEnhrg = 0;
			final int mDPhd9wG = 4096;
			byte[] P857iXWY = new byte[mDPhd9wG];
			while ((vetAJvoJ = NJHSpUuc.read(P857iXWY, 0, mDPhd9wG)) != -1) {
				g9E8avpP.write(P857iXWY, 0, vetAJvoJ);
				QATEnhrg += vetAJvoJ;
			}
			g9E8avpP.flush();
			long oCti5btA = U0rKFynG.length();
			if (oCti5btA != QATEnhrg) {
				throw new CacheOperationException("Original archive size was {0} bytes but only {1} were copied.",
						oCti5btA, QATEnhrg);
			}
			cacheLog.debug("Finished copying ''{0}'' to ''{1}''.", U0rKFynG.getAbsolutePath(),
					tVxmFP8S.getAbsolutePath());
		} catch (FileNotFoundException zcf0v9KF) {
			throw new CacheOperationException(
					"Files required for copying a backup of Beehive archive could not be found, opened "
							+ "or created : {1}",
					zcf0v9KF, zcf0v9KF.getMessage());
		} catch (IOException ipHHt7ug) {
			throw new CacheOperationException("Error while making a copy of the Beehive archive : {0}", ipHHt7ug,
					ipHHt7ug.getMessage());
		} finally {
			if (NJHSpUuc != null) {
				try {
					NJHSpUuc.close();
				} catch (Throwable oRQFSFma) {
					cacheLog.warn("Failed to close stream to ''{0}'' : {1}", oRQFSFma, U0rKFynG.getAbsolutePath(),
							oRQFSFma.getMessage());
				}
			}
			if (g9E8avpP != null) {
				try {
					g9E8avpP.close();
				} catch (Throwable s8jiKJ6x) {
					cacheLog.warn("Failed to close stream to ''{0}'' : {1}", s8jiKJ6x, tVxmFP8S.getAbsolutePath(),
							s8jiKJ6x.getMessage());
				}
			}
		}
		validateArchive(tVxmFP8S);
		File EKtHIeaa = getNewestDailyBackupFile();
		try {
			if (!tVxmFP8S.renameTo(EKtHIeaa)) {
				throw new CacheOperationException("Error moving ''{0}'' to ''{1}''.", tVxmFP8S.getAbsolutePath(),
						EKtHIeaa.getAbsolutePath());
			} else {
				cacheLog.info("Backup complete. Saved in ''{0}''", EKtHIeaa.getAbsolutePath());
			}
		} catch (SecurityException J9wnwaCX) {
			throw new ConfigurationException("Security Manager has denied write access to ''{0}'' : {1}", J9wnwaCX,
					EKtHIeaa.getAbsolutePath(), J9wnwaCX.getMessage());
		}
	}

}