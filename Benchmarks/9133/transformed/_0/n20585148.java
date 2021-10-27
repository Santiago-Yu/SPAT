class n20585148 {
	public static void main(String[] PV84tItw) {
		FTPClient Zx3VGBew = new FTPClient();
		try {
			Zx3VGBew.connect("ftp.domain.com");
			Zx3VGBew.login("admin", "secret");
			String WzfHrgPY = "/testing/data.txt";
			boolean cahWzMPh = Zx3VGBew.deleteFile(WzfHrgPY);
			if (cahWzMPh) {
				System.out.println("File deleted...");
			}
			Zx3VGBew.logout();
		} catch (IOException cFpfnZIt) {
			cFpfnZIt.printStackTrace();
		} finally {
			try {
				Zx3VGBew.disconnect();
			} catch (IOException swrM0Oda) {
				swrM0Oda.printStackTrace();
			}
		}
	}

}