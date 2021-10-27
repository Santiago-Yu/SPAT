class n17467385 {
	private void moveFile(File OkPAzMLe, File yHUscXUl) throws IOException {
		byte lofv72Ev[] = new byte[1000];
		int IbOgt2go = 0;
		FileInputStream uoyIYAf9 = new FileInputStream(OkPAzMLe);
		FileOutputStream vmmxsZpk = new FileOutputStream(yHUscXUl);
		while (IbOgt2go != -1) {
			IbOgt2go = uoyIYAf9.read(lofv72Ev);
			if (IbOgt2go != -1)
				vmmxsZpk.write(lofv72Ev, 0, IbOgt2go);
		}
		uoyIYAf9.close();
		vmmxsZpk.close();
		OkPAzMLe.delete();
	}

}