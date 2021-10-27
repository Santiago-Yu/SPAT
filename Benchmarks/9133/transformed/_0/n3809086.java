class n3809086 {
	private void jButton1ActionPerformed(java.awt.event.ActionEvent ONqHtOpX) {
		jButton1.setEnabled(false);
		for (int L43utIM8 = 0; L43utIM8 < max; L43utIM8++) {
			Card VZOfIsds = WLP.getSelectedCard(WLP.jTable1.getSelectedRows()[L43utIM8]);
			String CjzacCNs, cT50NBYS;
			CjzacCNs = "";
			cT50NBYS = "";
			try {
				URL xlhiK0ma = new URL("http://www.m-w.com/dictionary/" + VZOfIsds.getWord());
				BufferedReader eU9ubcld = new BufferedReader(new InputStreamReader(xlhiK0ma.openStream()));
				String HioxZ46f;
				while ((HioxZ46f = eU9ubcld.readLine()) != null) {
					CjzacCNs = CjzacCNs + HioxZ46f;
				}
				eU9ubcld.close();
			} catch (MalformedURLException hgEZsJ1I) {
			} catch (IOException LBPqmu4X) {
			}
			Pattern NTbPn3YC = Pattern.compile("popWin\\('/cgi-bin/(.+?)'", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
			Matcher FoVUtFcR = NTbPn3YC.matcher(CjzacCNs);
			if (FoVUtFcR.find()) {
				String kYAeDnFm = "http://m-w.com/cgi-bin/" + FoVUtFcR.group(1);
				try {
					URL qi9f56iy = new URL(kYAeDnFm);
					BufferedReader V1VosR0m = new BufferedReader(new InputStreamReader(qi9f56iy.openStream()));
					String evxVUsYX;
					while ((evxVUsYX = V1VosR0m.readLine()) != null) {
						cT50NBYS = cT50NBYS + evxVUsYX;
					}
					V1VosR0m.close();
				} catch (MalformedURLException SJ52cXIA) {
				} catch (IOException KUGsIO8c) {
				}
				Pattern W47f9elo = Pattern.compile(
						"<A HREF=\"http://(.+?)\">Click here to listen with your default audio player",
						Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
				Matcher DKOeV6Bl = W47f9elo.matcher(cT50NBYS);
				if (DKOeV6Bl.find()) {
					getWave("http://" + DKOeV6Bl.group(1), VZOfIsds.getWord());
				}
				int i965ewXR = jProgressBar1.getValue();
				i965ewXR++;
				jProgressBar1.setValue(i965ewXR);
				this.paintAll(this.getGraphics());
			}
		}
		jButton1.setEnabled(true);
	}

}