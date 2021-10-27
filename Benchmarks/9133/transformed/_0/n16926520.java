class n16926520 {
	public int extractDocumentsInternal(DocumentHolder Gzwq5PXb, DocumentFactory SduQCutD) {
		FTPClient VFJdIruV = new FTPClient();
		try {
			VFJdIruV.connect(site, port == 0 ? 21 : port);
			VFJdIruV.login(user, password);
			visitDirectory(VFJdIruV, "", path, Gzwq5PXb, SduQCutD);
			VFJdIruV.disconnect();
		} catch (SocketException nzYN7tA1) {
			nzYN7tA1.printStackTrace();
		} catch (IOException W0XXt0bO) {
		}
		return fileCount;
	}

}