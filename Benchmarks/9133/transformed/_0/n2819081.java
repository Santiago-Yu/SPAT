class n2819081 {
	public FTPManager(URL UB07xhdG) throws IOException {
        this.client = new FTPClient();
        String wzKDblja = UB07xhdG.getHost();
        int Fdw0xgsK = UB07xhdG.getPort();
        if (Fdw0xgsK < 0) {
            this.client.connect(wzKDblja);
        } else {
            this.client.connect(wzKDblja, Fdw0xgsK);
        }
        String[] HZS2CRWJ = StringUtils.split(UB07xhdG.getUserInfo(), ':');
        this.client.login(HZS2CRWJ[0], HZS2CRWJ.length > 1 ? HZS2CRWJ[1] : "");
        if (!this.client.setFileType(FTP.BINARY_FILE_TYPE)) throw new IOException("Unable to set the transfert mode");
    }

}