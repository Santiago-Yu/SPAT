class n4683894 {
	public void run() {
		if (currentNode == null || currentNode.equals("")) {
			JOptionPane.showMessageDialog(null, "Please select a genome to download first", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		String OpRJElDv = parameter.getTemporaryFilesPath() + currentNode;
		String EeSsR8NT = NCBI_FTP_PATH + currentPath;
		String Z0ivqDES = EeSsR8NT + "/" + currentNode;
		try {
			ftp.connect(NCBI_FTP_HOST);
			int wiZ3WnIS = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(wiZ3WnIS)) {
				ftp.disconnect();
				JOptionPane.showMessageDialog(null, "FTP server refused connection", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
			ftp.login("anonymous", "anonymous@big.ac.cn");
			inProgress = true;
			ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
			long u81GrM2V = getFileSize(EeSsR8NT, currentNode);
			if (u81GrM2V == -1)
				throw new FileNotFoundException();
			BufferedOutputStream six7jd3o = new BufferedOutputStream(new FileOutputStream(OpRJElDv));
			BufferedInputStream eL6Mb4jl = new BufferedInputStream(ftp.retrieveFileStream(Z0ivqDES),
					ftp.getBufferSize());
			byte[] wsnZJord = new byte[1024];
			long c0pLsBQn = 0;
			int LEURMHCH = 0;
			int cLkBhf1A = 0;
			int jDssFyM9;
			while ((jDssFyM9 = eL6Mb4jl.read(wsnZJord)) != -1) {
				six7jd3o.write(wsnZJord, 0, jDssFyM9);
				c0pLsBQn += 1024;
				if ((LEURMHCH = new Long(c0pLsBQn * 100 / u81GrM2V).intValue()) > cLkBhf1A) {
					progressBar.setValue(LEURMHCH < 100 ? LEURMHCH : 99);
					cLkBhf1A = LEURMHCH;
				}
			}
			eL6Mb4jl.close();
			six7jd3o.close();
			ftp.completePendingCommand();
			progressBar.setValue(100);
			fileDownloaded = OpRJElDv;
			JOptionPane.showMessageDialog(null, "File successfully downloaded", "Congratulation!",
					JOptionPane.INFORMATION_MESSAGE);
			ftp.logout();
		} catch (SocketException yJmvW3Uh) {
			JOptionPane.showMessageDialog(null, "Error occurs while trying to connect server", "Error",
					JOptionPane.ERROR_MESSAGE);
		} catch (FileNotFoundException n30Vwj65) {
			JOptionPane.showMessageDialog(null, "This file is not found on the server", "Error",
					JOptionPane.ERROR_MESSAGE);
		} catch (IOException XvPlb34p) {
			JOptionPane.showMessageDialog(null, "Error occurs while fetching data", "Error", JOptionPane.ERROR_MESSAGE);
		} finally {
			inProgress = false;
			if (ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException LzVSvEKm) {
				}
			}
		}
	}

}