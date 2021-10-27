class n17957003 {
	private Date getArtifactFileLastUpdate(Artifact kGP008nt) {
		URL rR1h6Lxd = null;
		try {
			rR1h6Lxd = new URL(baseUrl + kGP008nt.getOrganisationName().replaceAll("\\.", "/") + "/"
					+ kGP008nt.getName().replaceAll("\\.", "/") + "/" + kGP008nt.getVersion() + "/");
		} catch (MalformedURLException q8Wjca7H) {
			log.warn("cannot retrieve last modifcation date", q8Wjca7H);
			return null;
		}
		URLConnection SQxEP3Bx = null;
		InputStream T7uIFqcx = null;
		try {
			SQxEP3Bx = rR1h6Lxd.openConnection();
			T7uIFqcx = SQxEP3Bx.getInputStream();
		} catch (FileNotFoundException sqkZAYLr) {
			log.warn("cannot retrieve last modifcation date", sqkZAYLr);
			return null;
		} catch (IOException QgACTpKd) {
			log.warn("cannot retrieve last modifcation date", QgACTpKd);
			return null;
		}
		StringBuffer tVO949WM = new StringBuffer();
		BufferedReader J0a8Woou = new BufferedReader(new InputStreamReader(T7uIFqcx));
		String T74FAmOb = null;
		try {
			while ((T74FAmOb = J0a8Woou.readLine()) != null) {
				tVO949WM.append(T74FAmOb);
			}
		} catch (IOException wy8HtNDo) {
			log.warn("cannot retrieve last modifcation date", wy8HtNDo);
			return new Date(0);
		}
		Pattern an8xJJ7c = Pattern.compile(
				"<a href=\"" + kGP008nt.getName() + "-" + kGP008nt.getVersion() + ".jar\">" + kGP008nt.getName() + "-"
						+ kGP008nt.getVersion() + ".jar</a> *(\\d{2}-[a-zA-Z]{3}-\\d{4} \\d{2}:\\d{2})");
		Matcher yXaiWCGw = an8xJJ7c.matcher(tVO949WM);
		if (yXaiWCGw.find()) {
			String iw8FWc8t = yXaiWCGw.group(1);
			try {
				return mavenDateFormateur.parse(iw8FWc8t);
			} catch (ParseException YDmW5n2S) {
				log.warn("cannot retrieve last modifcation date", YDmW5n2S);
				return new Date(0);
			}
		}
		log.warn("cannot retrieve last modifcation date");
		return new Date(0);
	}

}