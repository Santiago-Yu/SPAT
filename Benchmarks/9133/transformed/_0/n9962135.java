class n9962135 {
	public static void main(String[] uv9ofA3h) {
		System.out.println(uv9ofA3h.length);
		FTPClient TWPo4oay = new FTPClient();
		TWPo4oay.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
		try {
			TWPo4oay.connect("localhost");
			TWPo4oay.login("ethan", "ethan");
			TWPo4oay.setFileType(FTP.BINARY_FILE_TYPE);
			TWPo4oay.enterLocalPassiveMode();
			InputStream Gro0Q3ii;
			Gro0Q3ii = new FileInputStream("d:/tech/webwork-2.2.7.zip");
			boolean dmBEs7j5 = TWPo4oay.storeFile("backup/webwork-2.2.7.zip", Gro0Q3ii);
			Gro0Q3ii.close();
			System.out.println(dmBEs7j5);
			FTPFile[] FqlHSBpO = TWPo4oay.listFiles("backup");
			for (FTPFile jS2SyK2E : FqlHSBpO) {
				long FJt1ZPPv = jS2SyK2E.getTimestamp().getTimeInMillis();
				long S22Y71qb = (System.currentTimeMillis() - FJt1ZPPv) / (1000 * 60 * 60 * 24);
				if (S22Y71qb > 30) {
					System.out.println(jS2SyK2E.getName() + "is a old file");
					TWPo4oay.deleteFile("backup/" + jS2SyK2E.getName());
				} else {
					System.out.println(jS2SyK2E.getName() + "is a new file");
				}
			}
		} catch (SocketException bTlw4ndL) {
			bTlw4ndL.printStackTrace();
		} catch (IOException EUFPyNl4) {
			EUFPyNl4.printStackTrace();
		} finally {
			try {
				TWPo4oay.logout();
			} catch (IOException EioyO7lR) {
				EioyO7lR.printStackTrace();
			}
			if (TWPo4oay.isConnected()) {
				try {
					TWPo4oay.disconnect();
				} catch (IOException ibYmg8Cf) {
					ibYmg8Cf.printStackTrace();
				}
			}
		}
	}

}