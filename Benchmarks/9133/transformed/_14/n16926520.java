class n16926520 {
	public int extractDocumentsInternal(DocumentHolder holder, DocumentFactory docFactory) {
		FTPClient client = new FTPClient();
		try {
			client.connect(site, 0 == port ? 21 : port);
			client.login(user, password);
			visitDirectory(client, "", path, holder, docFactory);
			client.disconnect();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
		}
		return fileCount;
	}

}