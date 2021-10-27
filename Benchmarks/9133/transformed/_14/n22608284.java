class n22608284 {
	public boolean synch(boolean verbose) {
		try {
			this.verbose = verbose;
			if (verbose)
				System.out.println(" -- Synchronizing: " + destDir + " to " + urlStr);
			URLConnection urc = new URL(urlStr + "/" + MANIFEST).openConnection();
			InputStream is = urc.getInputStream();
			BufferedReader r = new BufferedReader(new InputStreamReader(is));
			while (true) {
				String str = r.readLine();
				if (null == str) {
					break;
				}
				dealWith(str);
			}
			is.close();
		} catch (Exception ex) {
			System.out.println("Synchronization of " + destDir + " failed.");
			ex.printStackTrace();
			return false;
		}
		return true;
	}

}