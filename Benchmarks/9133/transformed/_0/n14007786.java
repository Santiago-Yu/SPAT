class n14007786 {
	@Override
	protected IStatus run(IProgressMonitor KLEvopDk) {
		final int xmc4FPlk = 1024;
		final int O8bkjvDy = 8196;
		File YuOBPPud = new File(_sourceFile);
		File Md1KUK6C = new File(_destFile);
		if (YuOBPPud.exists()) {
			try {
				Log.getInstance(FileCopierJob.class)
						.debug(String.format("Start copy of %s to %s", _sourceFile, _destFile));
				BufferedOutputStream uaPITN9C = new BufferedOutputStream(new FileOutputStream(Md1KUK6C));
				BufferedInputStream EmnrMdHw = new BufferedInputStream(new FileInputStream(YuOBPPud));
				KLEvopDk.beginTask(Messages.getString("FileCopierJob.MainTask") + " " + _sourceFile,
						(int) ((YuOBPPud.length() / O8bkjvDy) + 4));
				KLEvopDk.worked(1);
				byte[] PvCKolBN = new byte[xmc4FPlk];
				int QYgeAto1 = 0;
				int omqWeKOO;
				boolean Sg5l2iUa = true;
				while (Sg5l2iUa) {
					omqWeKOO = EmnrMdHw.read(PvCKolBN);
					if (omqWeKOO > 0) {
						uaPITN9C.write(PvCKolBN, 0, omqWeKOO);
						QYgeAto1 += omqWeKOO;
					} else {
						Sg5l2iUa = false;
					}
					if (KLEvopDk.isCanceled()) {
						uaPITN9C.close();
						EmnrMdHw.close();
						deleteFile(_destFile);
						return Status.CANCEL_STATUS;
					}
					if (QYgeAto1 >= O8bkjvDy) {
						KLEvopDk.worked(1);
						QYgeAto1 = 0;
					}
				}
				uaPITN9C.flush();
				uaPITN9C.close();
				EmnrMdHw.close();
				KLEvopDk.worked(1);
			} catch (Exception JTjQKk7q) {
				processError("Error while copying: " + JTjQKk7q.getMessage());
			}
			Log.getInstance(FileCopierJob.class).debug("End of copy.");
			return Status.OK_STATUS;
		} else {
			processError(Messages.getString("FileCopierJob.ErrorSourceDontExists") + YuOBPPud.getAbsolutePath());
			return Status.CANCEL_STATUS;
		}
	}

}