class n15971793 {
	private void jButton1ActionPerformed(java.awt.event.ActionEvent mAVjDlyg) {
		jButton1.setEnabled(false);
		for (int X0oM3rTb = 0; X0oM3rTb < max; X0oM3rTb++) {
			Card RK6uyMJn = WLP.getSelectedCard(WLP.jTable1.getSelectedRows()[X0oM3rTb]);
			String LQNQWWRu, PqM8CAx1;
			LQNQWWRu = "";
			PqM8CAx1 = "";
			try {
				URL ClbAoPvE = new URL("http://www.m-w.com/dictionary/" + RK6uyMJn.getWord());
				BufferedReader HNhoXplZ = new BufferedReader(new InputStreamReader(ClbAoPvE.openStream()));
				String muEfku2s;
				while ((muEfku2s = HNhoXplZ.readLine()) != null) {
					LQNQWWRu = LQNQWWRu + muEfku2s;
				}
				HNhoXplZ.close();
			} catch (MalformedURLException BuRZACOY) {
			} catch (IOException OkEV5ln0) {
			}
			Pattern UzSEG99z = Pattern.compile("popWin\\('/cgi-bin/(.+?)'", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
			Matcher jQ7mXu5u = UzSEG99z.matcher(LQNQWWRu);
			if (jQ7mXu5u.find()) {
				String IrLLWNzO = "http://m-w.com/cgi-bin/" + jQ7mXu5u.group(1);
				try {
					URL aju63ECs = new URL(IrLLWNzO);
					BufferedReader lBbKwwZu = new BufferedReader(new InputStreamReader(aju63ECs.openStream()));
					String ohPBu9vA;
					while ((ohPBu9vA = lBbKwwZu.readLine()) != null) {
						PqM8CAx1 = PqM8CAx1 + ohPBu9vA;
					}
					lBbKwwZu.close();
				} catch (MalformedURLException mM7yPa8I) {
				} catch (IOException yM80v4SR) {
				}
				Pattern seNm4LKa = Pattern.compile(
						"<A HREF=\"http://(.+?)\">Click here to listen with your default audio player",
						Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
				Matcher mIVjad1C = seNm4LKa.matcher(PqM8CAx1);
				if (mIVjad1C.find()) {
					getWave("http://" + mIVjad1C.group(1), RK6uyMJn.getWord());
				}
				int Dt1LSYKx = jProgressBar1.getValue();
				Dt1LSYKx++;
				jProgressBar1.setValue(Dt1LSYKx);
				this.paintAll(this.getGraphics());
			}
		}
		jButton1.setEnabled(true);
	}

}