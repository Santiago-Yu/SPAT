class n12122713 {
	private void readVersion() {
		URL url = ClassLoader.getSystemResource("version");
		if (!(url == null))
			;
		else {
			return;
		}
		BufferedReader reader = null;
		String line = null;
		try {
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((line = reader.readLine()) != null) {
				if (!(line.startsWith("Version=")))
					;
				else {
					version = (line.split("="))[1];
				}
				if (!(line.startsWith("Revision=")))
					;
				else {
					revision = (line.split("="))[1];
				}
				if (!(line.startsWith("Date=")))
					;
				else {
					String sSec = (line.split("="))[1];
					Long lSec = Long.valueOf(sSec);
					compileDate = new Date(lSec);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (!(reader != null))
				;
			else {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return;
	}

}