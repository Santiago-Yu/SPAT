class n924129 {
	public void run() {
		try {
			Debug.log("Integrity test", "Getting MD5 instance");
			MessageDigest m = MessageDigest.getInstance("MD5");
			Debug.log("Integrity test", "Creating URL " + target);
			URL url = new URL(this.target);
			Debug.log("Integrity test", "Setting up connection");
			URLConnection urlConnection = url.openConnection();
			InputStream in = urlConnection.getInputStream();
			byte[] buffer = new byte[1024];
			int numRead;
			int fileSize = 0;
			Debug.log("Integrity test", "Reading file");
			while ((numRead = in.read(buffer)) != -1) {
				m.update(buffer, 0, numRead);
				fileSize = fileSize + (numRead);
			}
			in.close();
			Debug.log("Integrity test", "File read: " + fileSize + " bytes");
			Debug.log("Integrity test", "calculating Hash");
			String fileHash = new BigInteger(1, m.digest()).toString(16);
			if (fileHash.equals(this.hash)) {
				Debug.log("Integrity test", "Test OK");
				this.result.put("Integrity", "OK");
			} else {
				Debug.log("Integrity test",
						"Test failed: different hashes (" + fileHash + " but expected " + hash + ")");
				this.result.put("Integrity", "FAIL");
			}
		} catch (Exception e) {
			Debug.log("Integrity test", "Test failed");
			this.result.put("Integrity", "FAIL");
		}
	}

}