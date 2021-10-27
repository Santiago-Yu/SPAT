class n8255076 {
	public static void main(String D0bNR1PZ[]) {
		if (D0bNR1PZ.length < 1) {
			printUsage();
		}
		URL CNXNyEt0;
		BufferedReader NpPrqHCB = null;
		try {
			CNXNyEt0 = new URL(D0bNR1PZ[0]);
			HttpURLConnection SclHKuUI = (HttpURLConnection) CNXNyEt0.openConnection();
			int fyD4BtXy = SclHKuUI.getResponseCode();
			if (fyD4BtXy == 200) {
				NpPrqHCB = new BufferedReader(new InputStreamReader(SclHKuUI.getInputStream()));
				String c2AJMNzF = null;
				while ((c2AJMNzF = NpPrqHCB.readLine()) != null) {
					System.out.println(c2AJMNzF);
				}
			} else {
				System.out
						.println("Response code " + fyD4BtXy + " means there was an error reading url " + D0bNR1PZ[0]);
			}
		} catch (IOException PkZRauxU) {
			System.err.println("IOException attempting to read url " + D0bNR1PZ[0]);
			PkZRauxU.printStackTrace();
		} finally {
			if (NpPrqHCB != null) {
				try {
					NpPrqHCB.close();
				} catch (Exception q8HixqqN) {
				}
			}
		}
	}

}