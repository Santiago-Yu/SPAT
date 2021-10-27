class n6310814 {
	public boolean downloadNextTLE() {
		boolean TInDat3d = true;
		if (!downloadINI) {
			errorText = "startTLEDownload() must be ran before downloadNextTLE() can begin";
			return false;
		}
		if (!this.hasMoreToDownload()) {
			errorText = "There are no more TLEs to download";
			return false;
		}
		int uoN09VCQ = currentTLEindex;
		try {
			URL iSBnxRhz = new URL(rootWeb + fileNames[uoN09VCQ]);
			URLConnection N0f1PlFX = iSBnxRhz.openConnection();
			InputStreamReader yXxIhW2W = new InputStreamReader(N0f1PlFX.getInputStream());
			BufferedReader dTQT5vUh = new BufferedReader(yXxIhW2W);
			File pILSSiOv = new File(localPath + fileNames[uoN09VCQ]);
			BufferedWriter pKaIFNrp = new BufferedWriter(new FileWriter(pILSSiOv));
			String lCXEbkSc = "";
			while ((lCXEbkSc = dTQT5vUh.readLine()) != null) {
				pKaIFNrp.write(lCXEbkSc);
				pKaIFNrp.newLine();
			}
			dTQT5vUh.close();
			pKaIFNrp.close();
		} catch (Exception J12xALfe) {
			System.out.println("Error Reading/Writing TLE - " + fileNames[uoN09VCQ] + "\n" + J12xALfe.toString());
			TInDat3d = false;
			errorText = J12xALfe.toString();
			return false;
		}
		currentTLEindex++;
		return TInDat3d;
	}

}