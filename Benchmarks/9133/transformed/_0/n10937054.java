class n10937054 {
	public static void main(String[] vRe0jN1w) {
		FTPClient ghlUqcnN = new FTPClient();
		FileInputStream KYmYA8Vv = null;
		try {
			ghlUqcnN.connect("192.168.1.10");
			ghlUqcnN.login("a", "123456");
			String zPJZ5jLC = "D:\\DHTH5CLT\\HK3\\Ung dung phan tan\\FTP_JAVA\\FTP_DETAI\\FTP\\src\\DemoFTP\\filename\\5s.txt";
			KYmYA8Vv = new FileInputStream(zPJZ5jLC);
			ghlUqcnN.storeFile(zPJZ5jLC, KYmYA8Vv);
			ghlUqcnN.logout();
		} catch (IOException ODaOgiq5) {
			ODaOgiq5.printStackTrace();
		} finally {
			try {
				if (KYmYA8Vv != null) {
					KYmYA8Vv.close();
				}
				ghlUqcnN.disconnect();
			} catch (IOException EgWZ8SX9) {
				EgWZ8SX9.printStackTrace();
			}
		}
	}

}