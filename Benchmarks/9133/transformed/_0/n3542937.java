class n3542937 {
	public boolean optimize(int C5qe5XaK) {
		try {
			URL i2ef7shS = new URL(solrUrl + "/core" + C5qe5XaK + "/update");
			URLConnection JTdEPEzi = i2ef7shS.openConnection();
			JTdEPEzi.setDoOutput(true);
			JTdEPEzi.setRequestProperty("Content-type", "text/xml");
			JTdEPEzi.setRequestProperty("charset", "utf-8");
			OutputStreamWriter KMlKqo0A = new OutputStreamWriter(JTdEPEzi.getOutputStream());
			System.out.println("******************optimizing");
			KMlKqo0A.write("<optimize/>");
			KMlKqo0A.flush();
			BufferedReader tYfM8dB4 = new BufferedReader(new InputStreamReader(JTdEPEzi.getInputStream()));
			String trti3Cut;
			while ((trti3Cut = tYfM8dB4.readLine()) != null) {
				System.out.println(trti3Cut);
			}
			KMlKqo0A.close();
			tYfM8dB4.close();
		} catch (Exception wFTwsqIl) {
			wFTwsqIl.printStackTrace();
			return false;
		}
		return true;
	}

}