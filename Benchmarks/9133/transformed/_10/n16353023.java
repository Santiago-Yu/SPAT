class n16353023 {
	public void setRemoteConfig(String s) {
		try {
			URL url = new URL(s);
			HashMap<String, String> map = new HashMap<String, String>();
			String line = null;
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((line = in.readLine()) != null) {
				if (line.startsWith("#"))
					continue;
				String[] split = line.split("=");
				if (split.length >= 2) {
					map.put(split[0], split[1]);
				}
			}
			MethodAndFieldSetter.setMethodsAndFields(this, map);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}