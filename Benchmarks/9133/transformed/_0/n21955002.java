class n21955002 {
	public void run() {
		String oG2ZT03o, VQg0PA2a;
		oG2ZT03o = "";
		VQg0PA2a = "";
		try {
			URL G7EkSaJ8 = new URL("http://www.m-w.com/dictionary/" + Word);
			BufferedReader xdUDqyln = new BufferedReader(new InputStreamReader(G7EkSaJ8.openStream()));
			String VfXgTOZu;
			while (((VfXgTOZu = xdUDqyln.readLine()) != null) && (!stopped)) {
				oG2ZT03o = oG2ZT03o + VfXgTOZu;
			}
			xdUDqyln.close();
		} catch (MalformedURLException HE9aU9vN) {
		} catch (IOException tNiv4xm0) {
		}
		Pattern qFnR7g9k = Pattern.compile("popWin\\('/cgi-bin/(.+?)'", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		Matcher fapXmik4 = qFnR7g9k.matcher(oG2ZT03o);
		if ((!stopped) && (fapXmik4.find())) {
			String YGDMe660 = "http://m-w.com/cgi-bin/" + fapXmik4.group(1);
			try {
				URL atTJyJGV = new URL(YGDMe660);
				BufferedReader bHhYl2BI = new BufferedReader(new InputStreamReader(atTJyJGV.openStream()));
				String LqEbz1bl;
				while (((LqEbz1bl = bHhYl2BI.readLine()) != null) && (!stopped)) {
					VQg0PA2a = VQg0PA2a + LqEbz1bl;
				}
				bHhYl2BI.close();
			} catch (MalformedURLException Vj5zwrHY) {
			} catch (IOException RvnxvqhG) {
			}
			Pattern kc4Ut7wl = Pattern.compile(
					"<A HREF=\"http://(.+?)\">Click here to listen with your default audio player",
					Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
			Matcher yqLJGfBh = kc4Ut7wl.matcher(VQg0PA2a);
			if ((!stopped) && (yqLJGfBh.find())) {
				if (getWave("http://" + yqLJGfBh.group(1)))
					label.setEnabled(true);
			}
		}
		button.setEnabled(true);
	}

}