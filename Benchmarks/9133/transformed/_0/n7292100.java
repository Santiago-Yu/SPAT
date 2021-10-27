class n7292100 {
	public Ftp(Resource Y5dQmm8W, String n8s7Y55m) throws Exception {
        super(Y5dQmm8W, n8s7Y55m);
        client = new FTPClient();
        client.addProtocolCommandListener(new CommandLogger());
        client.connect(Y5dQmm8W.getString("host"), Integer.parseInt(Y5dQmm8W.getString("port")));
        client.login(Y5dQmm8W.getString("user"), Y5dQmm8W.getString("pw"));
        client.setFileType(FTPClient.BINARY_FILE_TYPE);
        client.enterLocalPassiveMode();
    }

}