class n8909675 {
	public static boolean copyFileToDir(File aFYy8UYS, File SSPVUQ6c) {
		try {
			String ZtgoMynA = aFYy8UYS.getName();
			int bslpbNeC = 1;
			while (existFileInDir(ZtgoMynA, SSPVUQ6c)) {
				ZtgoMynA = bslpbNeC + aFYy8UYS.getName();
				bslpbNeC++;
			}
			String gAzWMOHL = getDirectoryWithSlash(SSPVUQ6c.getAbsolutePath());
			File anmqChXQ = new File(gAzWMOHL + ZtgoMynA);
			FileReader kxkuh0JI = new FileReader(aFYy8UYS);
			FileWriter QjMqGhCp = new FileWriter(anmqChXQ);
			int Rnk8j6pr;
			while ((Rnk8j6pr = kxkuh0JI.read()) != -1)
				QjMqGhCp.write(Rnk8j6pr);
			kxkuh0JI.close();
			QjMqGhCp.close();
		} catch (IOException wIb35T1c) {
			return false;
		}
		return true;
	}

}