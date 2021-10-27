class n13439950 {
	public String readRemoteFile() throws IOException {
		String z0MESyNg = "";
		boolean WkvmQdRb = false;
		URL mOb6QFxu = new URL(StaticData.remoteFile);
		InputStream dbCOdKhH = mOb6QFxu.openStream();
		BufferedReader p4ulNGbM = new BufferedReader(new InputStreamReader(dbCOdKhH));
		String AbCMWzm2;
		AbCMWzm2 = p4ulNGbM.readLine();
		z0MESyNg = AbCMWzm2;
		while (!WkvmQdRb) {
			try {
				AbCMWzm2 = p4ulNGbM.readLine();
				if (AbCMWzm2 == null) {
					WkvmQdRb = true;
					p4ulNGbM.close();
				} else
					z0MESyNg += AbCMWzm2;
			} catch (EOFException QJ8oqDgs) {
				WkvmQdRb = true;
			} catch (IOException Z4yhvCYZ) {
				System.out.println("IO Error : " + Z4yhvCYZ.getMessage());
			}
		}
		return z0MESyNg;
	}

}