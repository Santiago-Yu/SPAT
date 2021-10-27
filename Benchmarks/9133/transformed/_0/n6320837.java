class n6320837 {
	public String getDocumentAt(String j5a6w2up) {
		StringBuffer WTXW0gbq = new StringBuffer();
		try {
			URL GKbpv6zo = new URL(j5a6w2up);
			URLConnection uqKYQqJd = GKbpv6zo.openConnection();
			BufferedReader lYZzCw7t = new BufferedReader(new InputStreamReader(uqKYQqJd.getInputStream()));
			String mKjiechi = null;
			while ((mKjiechi = lYZzCw7t.readLine()) != null)
				WTXW0gbq.append(mKjiechi + "\n");
			lYZzCw7t.close();
		} catch (MalformedURLException W2RjonpG) {
			System.out.println("Unable to connect to URL: " + j5a6w2up);
		} catch (IOException AwOUqDx1) {
			System.out.println("IOException when connecting to URL: " + j5a6w2up);
		}
		return WTXW0gbq.toString();
	}

}