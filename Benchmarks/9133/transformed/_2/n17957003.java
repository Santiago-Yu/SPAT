class n17957003 {
	private Date getArtifactFileLastUpdate(Artifact artifact) {
		URL url = null;
		try {
			url = new URL(baseUrl + artifact.getOrganisationName().replaceAll("\\.", "/") + "/"
					+ artifact.getName().replaceAll("\\.", "/") + "/" + artifact.getVersion() + "/");
		} catch (MalformedURLException e) {
			log.warn("cannot retrieve last modifcation date", e);
			return null;
		}
		URLConnection urlConnection = null;
		InputStream inputStream = null;
		try {
			urlConnection = url.openConnection();
			inputStream = urlConnection.getInputStream();
		} catch (FileNotFoundException e) {
			log.warn("cannot retrieve last modifcation date", e);
			return null;
		} catch (IOException e) {
			log.warn("cannot retrieve last modifcation date", e);
			return null;
		}
		StringBuffer buffer = new StringBuffer();
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		String line = null;
		try {
			for (; (line = reader.readLine()) != null;) {
				buffer.append(line);
			}
		} catch (IOException e) {
			log.warn("cannot retrieve last modifcation date", e);
			return new Date(0);
		}
		Pattern pattern = Pattern.compile(
				"<a href=\"" + artifact.getName() + "-" + artifact.getVersion() + ".jar\">" + artifact.getName() + "-"
						+ artifact.getVersion() + ".jar</a> *(\\d{2}-[a-zA-Z]{3}-\\d{4} \\d{2}:\\d{2})");
		Matcher m = pattern.matcher(buffer);
		if (m.find()) {
			String dateStr = m.group(1);
			try {
				return mavenDateFormateur.parse(dateStr);
			} catch (ParseException e) {
				log.warn("cannot retrieve last modifcation date", e);
				return new Date(0);
			}
		}
		log.warn("cannot retrieve last modifcation date");
		return new Date(0);
	}

}