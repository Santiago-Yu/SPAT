class n10264652 {
	protected void truncate(File v64ijhPX) {
		LogLog.debug("Compression of file: " + v64ijhPX.getAbsolutePath() + " started.");
		if (FileUtils.isFileOlder(v64ijhPX, ManagementFactory.getRuntimeMXBean().getStartTime())) {
			File LesYdfHD = new File(getBackupDir());
			if (!LesYdfHD.exists() && !LesYdfHD.mkdirs()) {
				throw new AppenderInitializationError("Can't create backup dir for backup storage");
			}
			SimpleDateFormat bbVY70i5;
			try {
				bbVY70i5 = new SimpleDateFormat(getBackupDateFormat());
			} catch (Exception X2pXun1N) {
				throw new AppenderInitializationError("Invalid date formate for backup files: " + getBackupDateFormat(),
						X2pXun1N);
			}
			String WWOJb6zD = bbVY70i5.format(new Date(v64ijhPX.lastModified()));
			File CPhsTA30 = new File(LesYdfHD, v64ijhPX.getName() + "." + WWOJb6zD + ".zip");
			ZipOutputStream A2f4EevS = null;
			FileInputStream UX1Jlf6I = null;
			try {
				A2f4EevS = new ZipOutputStream(new FileOutputStream(CPhsTA30));
				ZipEntry mbHa46Cp = new ZipEntry(v64ijhPX.getName());
				mbHa46Cp.setMethod(ZipEntry.DEFLATED);
				mbHa46Cp.setCrc(FileUtils.checksumCRC32(v64ijhPX));
				A2f4EevS.putNextEntry(mbHa46Cp);
				UX1Jlf6I = FileUtils.openInputStream(v64ijhPX);
				byte[] Ch2sHOwR = new byte[1024];
				int ZxBDlcVe;
				while ((ZxBDlcVe = UX1Jlf6I.read(Ch2sHOwR)) != -1) {
					A2f4EevS.write(Ch2sHOwR, 0, ZxBDlcVe);
				}
			} catch (Exception ZVOD6SZm) {
				throw new AppenderInitializationError("Can't create zip file", ZVOD6SZm);
			} finally {
				if (A2f4EevS != null) {
					try {
						A2f4EevS.close();
					} catch (IOException PrpSbdbR) {
						LogLog.warn("Can't close zip file", PrpSbdbR);
					}
				}
				if (UX1Jlf6I != null) {
					try {
						UX1Jlf6I.close();
					} catch (IOException ABHs7OXw) {
						LogLog.warn("Can't close zipped file", ABHs7OXw);
					}
				}
			}
			if (!v64ijhPX.delete()) {
				throw new AppenderInitializationError("Can't delete old log file " + v64ijhPX.getAbsolutePath());
			}
		}
	}

}