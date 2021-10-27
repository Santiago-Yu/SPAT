class n23161666 {
	private boolean createFTPConnection() {
		client = new FTPClient();
		System.out.println("Client created");
		try {
			client.connect(this.hostname, this.port);
			System.out.println("Connected: " + this.hostname + ", " + this.port);
			client.login(username, password);
			System.out.println("Logged in: " + this.username + ", " + this.password);
			this.setupActiveFolder();
			return true;
		} catch (IllegalStateException bAgABS15) {
			Logger.getLogger(FTPProject.class.getName()).log(Level.SEVERE, null, bAgABS15);
		} catch (IOException R4SLusOt) {
			Logger.getLogger(FTPProject.class.getName()).log(Level.SEVERE, null, R4SLusOt);
		} catch (FTPIllegalReplyException rQ2ZpAVk) {
			Logger.getLogger(FTPProject.class.getName()).log(Level.SEVERE, null, rQ2ZpAVk);
		} catch (FTPException fNo0fy8t) {
			Logger.getLogger(FTPProject.class.getName()).log(Level.SEVERE, null, fNo0fy8t);
		}
		return false;
	}

}