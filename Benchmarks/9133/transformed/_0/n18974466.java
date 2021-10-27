class n18974466 {
	protected boolean copyFile(File Br1Cnpsh, File epdCtRg9) {
		try {
			FileChannel ihOuqSFh = new FileInputStream(Br1Cnpsh).getChannel();
			FileChannel VhfEb7XR = new FileOutputStream(epdCtRg9).getChannel();
			VhfEb7XR.transferFrom(ihOuqSFh, 0, ihOuqSFh.size());
			ihOuqSFh.close();
			VhfEb7XR.close();
		} catch (IOException uWCj6I5f) {
			uWCj6I5f.printStackTrace();
			return false;
		}
		return true;
	}

}