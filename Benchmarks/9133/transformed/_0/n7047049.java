class n7047049 {
	public URL grabCover(String e71gPruE, String NQmbkNyg) {
		if (idf.jCheckBox3.isSelected()) {
			println("Searching cover for: " + e71gPruE);
			e71gPruE = e71gPruE.trim();
			URL E2sGe6Le = null;
			int KvxT7Y73 = 0;
			try {
				URL QazpUcZ8 = new URL("http://www.gracenote.com/search/?query="
						+ e71gPruE.toLowerCase().replaceAll(" ", "+") + "&search_type=artist");
				BufferedReader Hd8C6kX0 = new BufferedReader(new InputStreamReader(QazpUcZ8.openStream()));
				println("" + QazpUcZ8);
				String zPx4tBgi;
				String JOxxpHjO = "";
				while ((zPx4tBgi = Hd8C6kX0.readLine()) != null)
					JOxxpHjO += zPx4tBgi;
				boolean eXC5930t = true;
				String ZCPwDr7A = JOxxpHjO;
				while (eXC5930t) {
					String oRrgKzLd = "<div class=\"album-name large\"><strong>Album:</strong> <a href=\"";
					if (JOxxpHjO.indexOf(oRrgKzLd) <= 0) {
						println("Artist was not found!");
						Hd8C6kX0.close();
						return null;
					}
					ZCPwDr7A = ZCPwDr7A.substring(ZCPwDr7A.indexOf(oRrgKzLd) + oRrgKzLd.length());
					String xpW1D5Am = ZCPwDr7A.substring(0, ZCPwDr7A.indexOf("\""));
					URL ritklfVZ = new URL("http://www.gracenote.com" + xpW1D5Am);
					println("" + ritklfVZ);
					BufferedReader F2MInwSM = new BufferedReader(new InputStreamReader(ritklfVZ.openStream()));
					String NsUoqChF;
					String wpqll6pl = "";
					while ((NsUoqChF = F2MInwSM.readLine()) != null)
						wpqll6pl += NsUoqChF;
					if (!(wpqll6pl.toUpperCase().indexOf(NQmbkNyg.toUpperCase()) < 0 && idf.jCheckBox2.isSelected())) {
						String lIRQ6Ixj = "<div class=\"album-image\"><img src=\"";
						String gMBPP3W9 = wpqll6pl.substring(wpqll6pl.indexOf(lIRQ6Ixj) + lIRQ6Ixj.length());
						gMBPP3W9 = gMBPP3W9.substring(0, gMBPP3W9.indexOf("\""));
						E2sGe6Le = new URL("http://www.gracenote.com" + gMBPP3W9);
						if (E2sGe6Le.toString().indexOf("covers/default") <= 0
								&& E2sGe6Le.toString().indexOf("covers/") > 0) {
							eXC5930t = false;
						}
					}
					F2MInwSM.close();
				}
				Hd8C6kX0.close();
				println(E2sGe6Le.toString());
			} catch (Exception GfB4D8N6) {
				println("error " + GfB4D8N6 + "\n");
				GfB4D8N6.printStackTrace();
			}
			return E2sGe6Le;
		} else {
			return null;
		}
	}

}