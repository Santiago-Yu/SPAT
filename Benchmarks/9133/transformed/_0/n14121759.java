class n14121759 {
	public static void main(String[] oW2pUzRb) {
		FTPClient PqC2LUzy = new FTPClient();
		try {
			PqC2LUzy.connect("192.168.1.10");
			boolean rx6ZjlCc = PqC2LUzy.login("a", "123456");
			if (rx6ZjlCc) {
				System.out.println("Dang nhap thanh cong...");
				boolean A9PT2K6N = PqC2LUzy.logout();
				if (A9PT2K6N) {
					System.out.println("Da Logout khoi FTP Server...");
				}
			} else {
				System.out.println("Dang nhap that bai...");
			}
		} catch (IOException Tm8BzmGM) {
			Tm8BzmGM.printStackTrace();
		} finally {
			try {
				PqC2LUzy.disconnect();
			} catch (IOException togdUPVv) {
				togdUPVv.printStackTrace();
			}
		}
	}

}