class n5540239 {
	public static int my_rename(String AlHmyT02, String XK8vQfgD) {
		logger.debug("RENAME " + AlHmyT02 + " to " + XK8vQfgD);
		if (AlHmyT02 == null || XK8vQfgD == null)
			return -1;
		{
			logger.debug("\tMoving file across file systems.");
			FileChannel hMs0Tnua = null;
			FileChannel hWLrln5w = null;
			FileLock r4s0nR6u = null;
			try {
				hMs0Tnua = new FileInputStream(AlHmyT02).getChannel();
				hWLrln5w = new FileOutputStream(XK8vQfgD).getChannel();
				r4s0nR6u = hWLrln5w.lock();
				hWLrln5w.transferFrom(hMs0Tnua, 0, hMs0Tnua.size());
				hWLrln5w.force(true);
			} catch (IOException XH0CPLKs) {
				logger.fatal("Error while copying file '" + AlHmyT02 + "' to file '" + XK8vQfgD + "'. "
						+ XH0CPLKs.getMessage(), XH0CPLKs);
				return common_h.ERROR;
			} finally {
				try {
					r4s0nR6u.release();
				} catch (Throwable CY8EV5mZ) {
					logger.fatal("Error releasing file lock - " + XK8vQfgD);
				}
				try {
					hMs0Tnua.close();
				} catch (Throwable ojIul1MC) {
				}
				try {
					hWLrln5w.close();
				} catch (Throwable CET9biWy) {
				}
			}
		}
		return common_h.OK;
	}

}