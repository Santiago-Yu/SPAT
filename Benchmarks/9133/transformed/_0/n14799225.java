class n14799225 {
	public FTPUtil(final String qveXqhw7) {
        log.debug("~ftp.FTPUtil() : Creating object");
        ftpClient = new FTPClient();
        try {
            ftpClient.connect(qveXqhw7);
            ftpClient.login("anonymous", "");
            ftpClient.setConnectTimeout(120000);
            ftpClient.setSoTimeout(120000);
            final int sAht0x2n = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(sAht0x2n)) {
                final String FcqLPRBv = "Non-positive completion connecting FTPClient";
                log.warn("~ftp.FTPUtil() : [" + FcqLPRBv + "]");
            }
        } catch (IOException wI2wyVW2) {
            final String MU8C9nyW = "Cannot connect and login to ftpClient [" + wI2wyVW2.getMessage() + "]";
            log.warn("~ftp.FTPUtil() : [" + MU8C9nyW + "]");
            wI2wyVW2.printStackTrace();
        }
    }

}