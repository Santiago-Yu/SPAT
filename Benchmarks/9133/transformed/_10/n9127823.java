class n9127823 {
	public static Status checkUpdate() {
		URL url;
		Status updateStatus = Status.FAILURE;
		InputStreamReader isr;
		InputStream is;
		String line;
		BufferedReader r;
		try {
			url = new URL(updateURL);
			is = url.openStream();
			isr = new InputStreamReader(is);
			String variable, value;
			r = new BufferedReader(isr);
			while ((line = r.readLine()) != null) {
				if (!line.equals("") && line.charAt(0) != '/') {
					variable = line.substring(0, line.indexOf('='));
					value = line.substring(line.indexOf('=') + 1);
					if (variable.equals("Latest Version")) {
						variable = value;
						value = variable.substring(0, variable.indexOf(" "));
						latestGameVersion = value;
						variable = variable.substring(variable.indexOf(" ") + 1);
						latestModifier = variable;
						if (Float.parseFloat(value) > Float.parseFloat(gameVersion))
							updateStatus = Status.NOT_CURRENT;
						else
							updateStatus = Status.CURRENT;
					} else if (variable.equals("Download URL"))
						downloadURL = value;
				}
			}
			return updateStatus;
		} catch (MalformedURLException e) {
			return Status.URL_NOT_FOUND;
		} catch (IOException e) {
			return Status.FAILURE;
		}
	}

}