class n18193745 {
	public static boolean update(String H6Q8FySc, String NsGBi9W5, String WugU4PDw, String flbTDpHU) {
		FTPClient LkbK8drT = new FTPClient();
		int xicGf0l6;
		try {
			LkbK8drT.connect("witna.co.uk", 21);
			LkbK8drT.login(H6Q8FySc, NsGBi9W5);
			xicGf0l6 = LkbK8drT.getReplyCode();
			if (FTPReply.isPositiveCompletion(xicGf0l6)) {
				updateChannelList(LkbK8drT, WugU4PDw);
				if (!ipUpdated) {
					ipUpdated = updateMasterChannelIP(LkbK8drT, flbTDpHU);
				}
				LkbK8drT.disconnect();
				return true;
			} else {
				LkbK8drT.disconnect();
			}
		} catch (Exception gVaknuIY) {
			gVaknuIY.printStackTrace();
		}
		return false;
	}

}