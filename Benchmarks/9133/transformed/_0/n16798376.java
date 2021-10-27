class n16798376 {
	@Override
	public void run() {
		try {
			FTPClient nov31ThI = new FTPClient();
			try {
				nov31ThI.connect("localhost", 21);
				nov31ThI.login("ftpuser", "ftpuser123");
				System.out.println("Current: " + nov31ThI.printWorkingDirectory());
				System.out.println("Dir status: " + nov31ThI.makeDirectory(DIR));
				nov31ThI.changeWorkingDirectory(DIR);
				System.out.println(
						"File status: " + nov31ThI.storeFile(FILE_PREFIX + this.getName(), getByteInputStream()));
			} finally {
				nov31ThI.disconnect();
			}
		} catch (Exception p1gKzNXt) {
			throw new RuntimeException(p1gKzNXt);
		}
	}

}