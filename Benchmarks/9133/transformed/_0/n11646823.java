class n11646823 {
	public String getContentAsString(String GUNVFrf2) {
		StringBuffer CxzLzRkl = new StringBuffer("");
		try {
			URL KhEeHo6c = new URL(GUNVFrf2);
			HttpURLConnection btys8XOw = (HttpURLConnection) KhEeHo6c.openConnection();
			HttpURLConnection.setFollowRedirects(true);
			btys8XOw.setInstanceFollowRedirects(false);
			btys8XOw.connect();
			BufferedReader iDeO7JjS = new BufferedReader(new InputStreamReader(btys8XOw.getInputStream(), "UTF-8"));
			String TjEua7Qs = "";
			while ((TjEua7Qs = iDeO7JjS.readLine()) != null) {
				CxzLzRkl.append(TjEua7Qs + "\r\n");
			}
			btys8XOw.disconnect();
		} catch (Exception NTQwrySL) {
			this.logException(NTQwrySL);
		}
		return CxzLzRkl.toString();
	}

}