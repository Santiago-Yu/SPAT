class n924129 {
	public void run() {
		try {
			Debug.log("Integrity test", "Getting MD5 instance");
			MessageDigest zE6Ss0T0 = MessageDigest.getInstance("MD5");
			Debug.log("Integrity test", "Creating URL " + target);
			URL kBl4uGeq = new URL(this.target);
			Debug.log("Integrity test", "Setting up connection");
			URLConnection gQJSWF6x = kBl4uGeq.openConnection();
			InputStream QRlcP00Q = gQJSWF6x.getInputStream();
			byte[] cW0ygucE = new byte[1024];
			int tcN5l0av;
			int sboNdsaf = 0;
			Debug.log("Integrity test", "Reading file");
			while ((tcN5l0av = QRlcP00Q.read(cW0ygucE)) != -1) {
				zE6Ss0T0.update(cW0ygucE, 0, tcN5l0av);
				sboNdsaf += tcN5l0av;
			}
			QRlcP00Q.close();
			Debug.log("Integrity test", "File read: " + sboNdsaf + " bytes");
			Debug.log("Integrity test", "calculating Hash");
			String P95nltGt = new BigInteger(1, zE6Ss0T0.digest()).toString(16);
			if (P95nltGt.equals(this.hash)) {
				Debug.log("Integrity test", "Test OK");
				this.result.put("Integrity", "OK");
			} else {
				Debug.log("Integrity test",
						"Test failed: different hashes (" + P95nltGt + " but expected " + hash + ")");
				this.result.put("Integrity", "FAIL");
			}
		} catch (Exception mN8k6KcW) {
			Debug.log("Integrity test", "Test failed");
			this.result.put("Integrity", "FAIL");
		}
	}

}