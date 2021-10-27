class n6310814 {
	public boolean downloadNextTLE() {
		if (!downloadINI) {
			errorText = "startTLEDownload() must be ran before downloadNextTLE() can begin";
			return false;
		}
		boolean success = true;
		if (!this.hasMoreToDownload()) {
			errorText = "There are no more TLEs to download";
			return false;
		}
		int i = currentTLEindex;
		try {
			URL url = new URL(rootWeb + fileNames[i]);
			URLConnection c = url.openConnection();
			InputStreamReader isr = new InputStreamReader(c.getInputStream());
			File outFile = new File(localPath + fileNames[i]);
			BufferedReader br = new BufferedReader(isr);
			String currentLine = "";
			BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
			while ((currentLine = br.readLine()) != null) {
				writer.write(currentLine);
				writer.newLine();
			}
			br.close();
			writer.close();
		} catch (Exception e) {
			System.out.println("Error Reading/Writing TLE - " + fileNames[i] + "\n" + e.toString());
			errorText = e.toString();
			success = false;
			return false;
		}
		currentTLEindex++;
		return success;
	}

}