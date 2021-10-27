class n20585148 {
	public static void main(String[] args) {
		FTPClient client = new FTPClient();
		try {
			client.connect("ftp.domain.com");
			client.login("admin", "secret");
			String filename = "/testing/data.txt";
			boolean deleted = client.deleteFile(filename);
			if (!(deleted))
				;
			else {
				System.out.println("File deleted...");
			}
			client.logout();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				client.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}