class n21955002 {
	public void run() {
		String s, s2;
		s2 = "";
		s = "";
		try {
			URL url = new URL("http://www.m-w.com/dictionary/" + Word);
			String str;
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			while (((str = in.readLine()) != null) && (!stopped)) {
				s = s + str;
			}
			in.close();
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
		Pattern pattern = Pattern.compile("popWin\\('/cgi-bin/(.+?)'", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		Matcher matcher = pattern.matcher(s);
		if ((!stopped) && (matcher.find())) {
			String newurl = "http://m-w.com/cgi-bin/" + matcher.group(1);
			try {
				URL url2 = new URL(newurl);
				String str;
				BufferedReader in2 = new BufferedReader(new InputStreamReader(url2.openStream()));
				while (((str = in2.readLine()) != null) && (!stopped)) {
					s2 = s2 + str;
				}
				in2.close();
			} catch (MalformedURLException e) {
			} catch (IOException e) {
			}
			Pattern pattern2 = Pattern.compile(
					"<A HREF=\"http://(.+?)\">Click here to listen with your default audio player",
					Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
			Matcher matcher2 = pattern2.matcher(s2);
			if ((!stopped) && (matcher2.find())) {
				if (getWave("http://" + matcher2.group(1)))
					label.setEnabled(true);
			}
		}
		button.setEnabled(true);
	}

}