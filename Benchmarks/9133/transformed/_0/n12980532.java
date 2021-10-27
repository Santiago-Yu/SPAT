class n12980532 {
	public String htmlContentSimple(String Uvdll4xJ, String sz9zHdab) {
		StringBuffer yptXPE6i = new StringBuffer();
		URL W2q1Ts6a = null;
		BufferedReader hQLyK9IQ = null;
		try {
			W2q1Ts6a = new URL(Uvdll4xJ);
			hQLyK9IQ = new BufferedReader(new InputStreamReader(W2q1Ts6a.openStream(), sz9zHdab));
			String qoDUG61H;
			while ((qoDUG61H = hQLyK9IQ.readLine()) != null) {
				yptXPE6i.append(qoDUG61H).append("\r\n");
			}
		} catch (MalformedURLException x0Zi3F2G) {
			x0Zi3F2G.printStackTrace();
		} catch (IOException xLKHgK5Z) {
			xLKHgK5Z.printStackTrace();
		} finally {
			if (hQLyK9IQ != null)
				try {
					hQLyK9IQ.close();
				} catch (IOException uvWhaqtb) {
					uvWhaqtb.printStackTrace();
				}
		}
		return yptXPE6i.toString();
	}

}