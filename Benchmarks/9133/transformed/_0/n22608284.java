class n22608284 {
	public boolean synch(boolean FT3Jlnw5) {
		try {
			this.verbose = FT3Jlnw5;
			if (FT3Jlnw5)
				System.out.println(" -- Synchronizing: " + destDir + " to " + urlStr);
			URLConnection sMEESQZ3 = new URL(urlStr + "/" + MANIFEST).openConnection();
			InputStream RdcDA0PI = sMEESQZ3.getInputStream();
			BufferedReader Dj935vYk = new BufferedReader(new InputStreamReader(RdcDA0PI));
			while (true) {
				String FaFmz4Vn = Dj935vYk.readLine();
				if (FaFmz4Vn == null) {
					break;
				}
				dealWith(FaFmz4Vn);
			}
			RdcDA0PI.close();
		} catch (Exception Jfy5nZf4) {
			System.out.println("Synchronization of " + destDir + " failed.");
			Jfy5nZf4.printStackTrace();
			return false;
		}
		return true;
	}

}