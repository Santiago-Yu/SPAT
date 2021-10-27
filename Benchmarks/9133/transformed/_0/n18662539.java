class n18662539 {
	@Override
	public void start() {
		try {
			ftp = new FTPClient();
			ftp.connect(this.url.getHost(), this.url.getPort() == -1 ? this.url.getDefaultPort() : this.url.getPort());
			String juQFZVzm = "anonymous";
			String BvoGSN1H = "";
			if (this.url.getUserInfo() != null) {
				juQFZVzm = this.url.getUserInfo().split(":")[0];
				BvoGSN1H = this.url.getUserInfo().split(":")[1];
			}
			ftp.login(juQFZVzm, BvoGSN1H);
			long u8NxfpYf = 0;
			if (getFile().exists())
				u8NxfpYf = getFile().length();
			else
				getFile().createNewFile();
			ftp.download(this.url.getPath(), getFile(), u8NxfpYf, new FTPDTImpl());
			ftp.disconnect(true);
		} catch (Exception MXIPnWC3) {
			MXIPnWC3.printStackTrace();
			speedTimer.cancel();
		}
	}

}