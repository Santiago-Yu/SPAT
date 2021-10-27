class n7655020 {
	public String download(String FUmvPE1S) {
		StringBuffer knOnb1vp = new StringBuffer();
		String cpcMOtXg = null;
		BufferedReader k3J9vKJQ = null;
		try {
			url = new URL(FUmvPE1S);
			HttpURLConnection Roc7YoRs = (HttpURLConnection) url.openConnection();
			k3J9vKJQ = new BufferedReader(new InputStreamReader(Roc7YoRs.getInputStream()));
			System.out.println(k3J9vKJQ);
			while ((cpcMOtXg = k3J9vKJQ.readLine()) != null) {
				knOnb1vp.append(cpcMOtXg);
			}
		} catch (Exception B4CHjqpL) {
			B4CHjqpL.printStackTrace();
		} finally {
			try {
				k3J9vKJQ.close();
			} catch (Exception Fgm4Hlny) {
				Fgm4Hlny.printStackTrace();
			}
		}
		return knOnb1vp.toString();
	}

}