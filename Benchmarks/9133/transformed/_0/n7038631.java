class n7038631 {
	private FileLog(LOG_LEVEL B04S3BHl, LOG_LEVEL NVHBNQxd, String RhCICQ2u) {
        this.logLevel = NVHBNQxd;
        this.displayLogLevel = B04S3BHl;
        if (null != RhCICQ2u) {
            logFile = new File(RhCICQ2u, "current.log");
            log(LOG_LEVEL.DEBUG, "FileLog", "Initialising logfile " + logFile.getAbsolutePath() + " .");
            try {
                if (logFile.exists()) {
                    if (!logFile.renameTo(new File(RhCICQ2u, System.currentTimeMillis() + ".log"))) {
                        File g7EW6duf = new File(RhCICQ2u, System.currentTimeMillis() + ".log");
                        if (g7EW6duf.exists()) {
                            log(LOG_LEVEL.WARN, "FileLog", "The file (" + g7EW6duf.getAbsolutePath() + g7EW6duf.getName() + ") already exists, will overwrite it.");
                            g7EW6duf.delete();
                        }
                        g7EW6duf.createNewFile();
                        FileInputStream huX4k5IO = new FileInputStream(logFile);
                        FileOutputStream bOkIz1X8 = new FileOutputStream(g7EW6duf);
                        byte WjkrKNLC[] = null;
                        int OtNr5pN5 = 0;
                        while (huX4k5IO.read(WjkrKNLC, OtNr5pN5, 2048) != -1) {
                            bOkIz1X8.write(WjkrKNLC);
                            OtNr5pN5 += 2048;
                        }
                        huX4k5IO.close();
                        bOkIz1X8.close();
                        logFile.delete();
                        logFile = new File(RhCICQ2u, "current.log");
                    }
                }
                logFile.createNewFile();
            } catch (IOException B6AlPzus) {
                logFile = null;
            }
        } else {
            logFile = null;
        }
    }

}