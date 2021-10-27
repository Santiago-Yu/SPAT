class n16931472 {
	public void handler(Map<String, String> result, TargetPage target) {
		try {
			URL url = new URL(target.getUrl());
			String line = null;
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((line = reader.readLine()) != null) {
				for (Map.Entry<String, String> entry : result.entrySet()) {
					if (line.indexOf(target.getInclude()) != -1) {
						int fromIndex = line.indexOf(target.getFromStr());
						String r = line.substring(fromIndex + target.getFromStr().length(),
								line.indexOf(target.getToStr(), fromIndex));
						entry.setValue(r);
						line = line.substring(line.indexOf(target.getToStr()) + target.getToStr().length());
					}
				}
			}
			reader.close();
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
	}

}