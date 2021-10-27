class n12289756 {
	public String loadURL(URL Ly9ShkYi) {
		String MThN7cvq = "";
		try {
			InputStream rMGrJmg7 = Ly9ShkYi.openStream();
			BufferedReader iQdFUxbm = new BufferedReader(new InputStreamReader(rMGrJmg7));
			String QJ1LyFJF = iQdFUxbm.readLine();
			MThN7cvq += QJ1LyFJF + "\n";
			while (QJ1LyFJF != null) {
				System.out.println(QJ1LyFJF);
				QJ1LyFJF = iQdFUxbm.readLine();
				if (QJ1LyFJF != null)
					MThN7cvq += QJ1LyFJF + "\n";
			}
			iQdFUxbm.close();
		} catch (MalformedURLException B8yJkYH1) {
			B8yJkYH1.printStackTrace();
			MThN7cvq = B8yJkYH1.getMessage();
		} catch (IOException F328HcFI) {
			F328HcFI.printStackTrace();
			MThN7cvq = F328HcFI.getMessage();
		} catch (Exception uaNJSMdC) {
			uaNJSMdC.printStackTrace();
			MThN7cvq = uaNJSMdC.getMessage();
		}
		return MThN7cvq;
	}

}