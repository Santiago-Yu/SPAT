class n13456572 {
	public void transferOutputFiles() throws IOException {
		HashSet<GridNode> nodes = (HashSet) batchTask.returnNodeCollection();
		Iterator<GridNode> ic = nodes.iterator();
		InetAddress addLocal = InetAddress.getLocalHost();
		String hostnameLocal = addLocal.getHostName();
		while (ic.hasNext()) {
			GridNode node = ic.next();
			String address = node.getPhysicalAddress();
			InetAddress addr = InetAddress.getByName(address);
			byte[] rawAddr = addr.getAddress();
			Map<String, String> attributes = node.getAttributes();
			InetAddress hostname = InetAddress.getByAddress(rawAddr);
			if (hostname.getHostName().equals(hostnameLocal))
				continue;
			String[] usernamePass = inputNodes.get(hostname.getHostName());
			FTPClient ftp = new FTPClient();
			String gridPath = attributes.get("GRIDGAIN_HOME");
			ftp.connect(hostname);
			ftp.login(usernamePass[0], usernamePass[1]);
			int reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				System.err.println("FTP server refused connection.");
				continue;
			}
			ftp.changeWorkingDirectory(gridPath + "/bin");
			ftp.setFileType(FTPClient.COMPRESSED_TRANSFER_MODE);
			ftp.setRemoteVerificationEnabled(false);
			ftp.setFileType(FTPClient.ASCII_FILE_TYPE);
			FTPFile[] fs = ftp.listFiles();
			for (FTPFile f : fs) {
				if (f.isDirectory())
					continue;
				String fileName = f.getName();
				if (!fileName.endsWith(".txt"))
					continue;
				System.out.println(f.getName());
				FileOutputStream out = new FileOutputStream(
						"../repast.simphony.distributedBatch/" + "remoteOutput/" + f.getName());
				try {
					ftp.retrieveFile(fileName, out);
				} catch (Exception e) {
					continue;
				} finally {
					if (out != null)
						out.close();
				}
			}
			ftp.logout();
			ftp.disconnect();
		}
	}

}