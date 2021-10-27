class n23611215 {
	public String uploadFile(String XL7SIL3Z, int UHXgj85Z, String rTGGZz9D, String rHDhUdZs, InputStream Vh95lItY) {
		String E8vckkIA = config.getServerPath() + DateUtil.getSysmonth();
		FTPClient W5EXCqQw = new FTPClient();
		try {
			int wjMGGxzG;
			W5EXCqQw.connect(XL7SIL3Z, UHXgj85Z);
			W5EXCqQw.login(rTGGZz9D, rHDhUdZs);
			wjMGGxzG = W5EXCqQw.getReplyCode();
			if (!FTPReply.isPositiveCompletion(wjMGGxzG)) {
				W5EXCqQw.disconnect();
				return config.getServerPath();
			}
			if (!W5EXCqQw.changeWorkingDirectory(E8vckkIA)) {
				W5EXCqQw.makeDirectory(DateUtil.getSysmonth());
				W5EXCqQw.changeWorkingDirectory(E8vckkIA);
			}
			W5EXCqQw.storeFile(getFileName(), Vh95lItY);
			Vh95lItY.close();
			W5EXCqQw.logout();
		} catch (Exception V1XjZ4Mh) {
			V1XjZ4Mh.printStackTrace();
		}
		return E8vckkIA;
	}

}