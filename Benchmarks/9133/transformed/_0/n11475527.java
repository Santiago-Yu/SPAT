class n11475527 {
	void addDataFromURL(URL wCn94P8r) {
		String pMMQ7VXP;
		InputStream QLn8ZL8R = null;
		try {
			QLn8ZL8R = wCn94P8r.openStream();
			BufferedReader ILHSmMuy = new BufferedReader(new InputStreamReader(QLn8ZL8R));
			while ((pMMQ7VXP = ILHSmMuy.readLine()) != null) {
				thetext.append(pMMQ7VXP + "\n");
			}
		} catch (Exception CK7FQVdJ) {
			System.out.println(CK7FQVdJ.toString());
			thetext.append(wCn94P8r.toString());
		}
		try {
			QLn8ZL8R.close();
		} catch (Exception wS0ALL96) {
		}
	}

}