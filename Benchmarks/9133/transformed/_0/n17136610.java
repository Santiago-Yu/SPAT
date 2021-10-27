class n17136610 {
	public void run() {
		ArrayList<Thread> rz8wLb7H = new ArrayList<Thread>();
		class ftpLinkElem extends Thread {

			TreeNode jLQRKjhJ;

			FTPClient REjq6tJK;

			protected ftpLinkElem(TreeNode KoCWcS41, FTPClient UqlZEPoY) {
				super();
				this.jLQRKjhJ = KoCWcS41;
				this.REjq6tJK = UqlZEPoY;
			}

			public void run() {
				try {
					String rneqrx7x = getFileLocation(jLQRKjhJ.getURL());
					FTPFile[] py0IDhzD = REjq6tJK.listFiles(rneqrx7x);
					if (py0IDhzD[0].isFile()) {
						int JAzUp8uv = REjq6tJK.getReplyCode();
						String kbLF6VT7 = REjq6tJK.getReplyString();
						if (!FTPReply.isPositiveCompletion(JAzUp8uv)) {
							REjq6tJK.disconnect();
							System.out.print("[FAILED] " + kbLF6VT7);
							failedList.add(jLQRKjhJ);
							failCnt++;
						}
						System.out.println("FTP Response: " + kbLF6VT7);
					} else {
						System.out.print("[FAILED]");
						failedList.add(jLQRKjhJ);
						failCnt++;
					}
				} catch (IOException k2GkeAcf) {
					k2GkeAcf.printStackTrace();
				}
			}
		}
		updateCurStatus("Checking ftp links", "");
		for (TreeNode aXaXUz99 : ftpURLs) {
			try {
				FTPClient QgwTQ2vN = new FTPClient();
				QgwTQ2vN.connect(FTPSERVER);
				QgwTQ2vN.login(FTPUSER, FTPPW);
				updateCurStatus(aXaXUz99.getURL(), "");
				ftpLinkElem OshB1UUP = new ftpLinkElem(aXaXUz99, QgwTQ2vN);
				OshB1UUP.start();
				rz8wLb7H.add(OshB1UUP);
			} catch (IOException GvheB9oG) {
				GvheB9oG.printStackTrace();
			}
		}
		for (Thread mFbNCuEk : rz8wLb7H) {
			try {
				if (mFbNCuEk.isAlive()) {
					mFbNCuEk.join();
				}
			} catch (InterruptedException kqvyEBZo) {
				kqvyEBZo.printStackTrace();
			}
		}
	}

}