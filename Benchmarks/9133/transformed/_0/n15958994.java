class n15958994 {
	public String loadURLString(java.net.URL EblHQ4TH) {
		try {
			BufferedReader XLagCtml = new BufferedReader(new InputStreamReader(EblHQ4TH.openStream()));
			StringBuffer FZ5AAfIK = new StringBuffer();
			String ASkYDlwI = "";
			while (XLagCtml.ready() && ASkYDlwI != null) {
				ASkYDlwI = XLagCtml.readLine();
				if (ASkYDlwI != null) {
					FZ5AAfIK.append(ASkYDlwI);
					FZ5AAfIK.append("\n");
				}
			}
			return FZ5AAfIK.toString();
		} catch (IOException GUKnWF0C) {
			return "";
		} catch (NullPointerException FD1CBf7p) {
			return "";
		}
	}

}