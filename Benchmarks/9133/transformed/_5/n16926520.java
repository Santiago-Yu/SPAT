class n16926520 {
	public int extractDocumentsInternal(DocumentHolder holder, DocumentFactory docFactory) {
		FTPClient client = new FTPClient();
		try {
			if (port == 0)
				client.connect(site, 21);
			else
				client.connect(site, port);
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