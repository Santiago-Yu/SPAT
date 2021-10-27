class n7292100 {
	public Ftp(Resource resource, String basePath) throws Exception {
        client = new FTPClient();
        super(resource, basePath);
        client.addProtocolCommandListener(new CommandLogger());
        client.connect(resource.getString("host"), Integer.parseInt(resource.getString("port")));
        client.login(resource.getString("user"), resource.getString("pw"));
        client.setFileType(FTPClient.BINARY_FILE_TYPE);
        client.enterLocalPassiveMode();
    }

}