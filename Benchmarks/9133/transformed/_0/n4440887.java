class n4440887 {
	public void play(File eQFk4t86) {
		try {
			URL G5LDL3GQ = new URL(
					"http://127.0.0.1:8081/play.html?type=4&file=" + eQFk4t86.getAbsolutePath() + "&name=toto");
			URLConnection ydPpcj4p = G5LDL3GQ.openConnection();
			BufferedReader jYob1j4a = new BufferedReader(new InputStreamReader(ydPpcj4p.getInputStream()));
			String PwvNWJ54;
			while ((PwvNWJ54 = jYob1j4a.readLine()) != null)
				System.out.println(PwvNWJ54);
			jYob1j4a.close();
		} catch (Exception dlgFY5rw) {
			dlgFY5rw.printStackTrace();
		}
	}

}