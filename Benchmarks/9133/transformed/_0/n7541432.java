class n7541432 {
	public void run() {
		String jsH7kdmX, w1DHAQBl;
		jsH7kdmX = "";
		w1DHAQBl = "";
		try {
			URL V4SCuqXm = new URL("http://www.m-w.com/dictionary/" + Word);
			BufferedReader wTU6OvK4 = new BufferedReader(new InputStreamReader(V4SCuqXm.openStream()));
			String bk0u28Xm;
			while (((bk0u28Xm = wTU6OvK4.readLine()) != null) && (!stopped)) {
				jsH7kdmX = jsH7kdmX + bk0u28Xm;
			}
			wTU6OvK4.close();
		} catch (MalformedURLException XohTCOfY) {
		} catch (IOException ljah0p1E) {
		}
		Pattern FW5ZJXWm = Pattern.compile("popWin\\('/cgi-bin/(.+?)'", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		Matcher rIvLypou = FW5ZJXWm.matcher(jsH7kdmX);
		if ((!stopped) && (rIvLypou.find())) {
			String AHFgSIsA = "http://m-w.com/cgi-bin/" + rIvLypou.group(1);
			try {
				URL fXh5wtdO = new URL(AHFgSIsA);
				BufferedReader zKVeZb8V = new BufferedReader(new InputStreamReader(fXh5wtdO.openStream()));
				String kU9LsgUT;
				while (((kU9LsgUT = zKVeZb8V.readLine()) != null) && (!stopped)) {
					w1DHAQBl = w1DHAQBl + kU9LsgUT;
				}
				zKVeZb8V.close();
			} catch (MalformedURLException MWyJam2P) {
			} catch (IOException peFrCqzS) {
			}
			Pattern A9UD2PcW = Pattern.compile(
					"<A HREF=\"http://(.+?)\">Click here to listen with your default audio player",
					Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
			Matcher D5NPvbcT = A9UD2PcW.matcher(w1DHAQBl);
			if ((!stopped) && (D5NPvbcT.find())) {
				if (getWave("http://" + D5NPvbcT.group(1)))
					label.setEnabled(true);
			}
		}
		button.setEnabled(true);
	}

}