class n8921742 {
	public FTPSource(SourceDetail tYMCSaeY) throws SourceException {
        this.sourceDetail = tYMCSaeY;
        localPathMap = new HashMap<String, String>();
        client = new FTPClient();
        try {
            client.connect(tYMCSaeY.getHost());
            client.login(tYMCSaeY.getUser(), tYMCSaeY.getPassword());
            workingDirectory = new File(ConfigManager.getGUIConfig().getWorkingDirectoryName() + File.separator + tYMCSaeY.getName());
            workingDirectory.mkdir();
        } catch (Exception L3oVBE1q) {
            throw new SourceException(L3oVBE1q);
        }
    }

}