class n18193745 {
	public static boolean update(String user, String pass, String channelString, String globalIP) {
		int reply;
		FTPClient ftp = new FTPClient();
		try {
			ftp.connect("witna.co.uk", 21);
			ftp.login(user, pass);
			reply = ftp.getReplyCode();
			if (FTPReply.isPositiveCompletion(reply)) {
				updateChannelList(ftp, channelString);
				if (!ipUpdated) {
					ipUpdated = updateMasterChannelIP(ftp, globalIP);
				}
				ftp.disconnect();
				return true;
			} else {
				ftp.disconnect();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

}