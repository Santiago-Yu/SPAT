class n19555516 {
	public void loadFromFile() {
		if (filename == null)
			return;
		try {
			BufferedReader UkFNmHxk;
			try {
				File xj2gzryK = new File(filename);
				if (!xj2gzryK.exists())
					return;
				UkFNmHxk = new BufferedReader(new FileReader(xj2gzryK));
			} catch (java.security.AccessControlException dLgRSeCa) {
				URL j62QNjki = new URL(filename);
				UkFNmHxk = new BufferedReader(new InputStreamReader(j62QNjki.openStream()));
			}
			String rKxHYAfy;
			while (true) {
				rKxHYAfy = UkFNmHxk.readLine();
				if (rKxHYAfy == null)
					break;
				String kuLPkxn7 = rKxHYAfy.substring(0, rKxHYAfy.indexOf("\t"));
				String Ged4B3lk = rKxHYAfy.substring(rKxHYAfy.indexOf("\t") + 1);
				String sbMuGeNo = Ged4B3lk.substring(0, Ged4B3lk.indexOf("\t"));
				String V4n4kUS6 = Ged4B3lk.substring(Ged4B3lk.indexOf("\t") + 1);
				String L4EOfslZ = V4n4kUS6.substring(0, V4n4kUS6.indexOf("\t"));
				String AX8NsgyV = V4n4kUS6.substring(V4n4kUS6.indexOf("\t") + 1);
				defineField(kuLPkxn7, sbMuGeNo, L4EOfslZ);
				setField(kuLPkxn7, AX8NsgyV, true);
			}
			UkFNmHxk.close();
		} catch (IOException bThGyTgj) {
			throw new JGameError("Error reading file '" + filename + "'.", false);
		}
	}

}