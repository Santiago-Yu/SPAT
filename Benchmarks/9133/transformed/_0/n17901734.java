class n17901734 {
	public static void track(String knUJw2e6, String C6whOShM, String wGL6nlr4, String QEw1Y4Ym, String AWohndAV) {
		String a90gmBTj = "";
		try {
			URL YCdOUaOI = new URL(getTracUrl() + "newticket");
			BufferedReader Kz4QkjON = new BufferedReader(new InputStreamReader(YCdOUaOI.openStream()));
			String wYhC5huA = Kz4QkjON.readLine();
			while (wYhC5huA != null) {
				if (wYhC5huA.contains("__FORM_TOKEN")) {
					Pattern NSuJYie9 = Pattern.compile("value=\"[^\"]*\"");
					Matcher OA0wpwGZ = NSuJYie9.matcher(wYhC5huA);
					int r6La4GMZ = 0;
					OA0wpwGZ.find(r6La4GMZ);
					int ZyJs0ggz = OA0wpwGZ.start() + 7;
					int SogMUDfr = OA0wpwGZ.end() - 1;
					a90gmBTj = wYhC5huA.substring(ZyJs0ggz, SogMUDfr);
				}
				wYhC5huA = Kz4QkjON.readLine();
			}
			HttpClient a54q54j6 = new HttpClient();
			PostMethod afFKqeYd = new PostMethod(getTracUrl() + "newticket");
			afFKqeYd.setRequestHeader("Cookie", "trac_form_token=" + a90gmBTj);
			afFKqeYd.addParameter("__FORM_TOKEN", a90gmBTj);
			afFKqeYd.addParameter("reporter", knUJw2e6);
			afFKqeYd.addParameter("summary", C6whOShM);
			afFKqeYd.addParameter("type", "Fehler");
			afFKqeYd.addParameter("description", wGL6nlr4);
			afFKqeYd.addParameter("action", "create");
			afFKqeYd.addParameter("status", "new");
			afFKqeYd.addParameter("priority", QEw1Y4Ym);
			afFKqeYd.addParameter("milestone", "");
			afFKqeYd.addParameter("component", AWohndAV);
			afFKqeYd.addParameter("keywords", "BugReporter");
			afFKqeYd.addParameter("cc", "");
			afFKqeYd.addParameter("version", "");
			a54q54j6.executeMethod(afFKqeYd);
		} catch (IOException rVGEVtFI) {
			rVGEVtFI.printStackTrace();
		}
	}

}