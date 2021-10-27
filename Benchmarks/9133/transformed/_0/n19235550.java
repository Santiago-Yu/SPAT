class n19235550 {
	protected BufferedImage handleGMUException() {
		if (params.uri.startsWith("http://mars.gmu.edu:8080"))
			try {
				URLConnection aquOXgu0 = new URL(params.uri).openConnection();
				int wCgKu6ss = params.uri.lastIndexOf("?");
				params.uri = "<img class=\"itemthumb\" src=\"";
				BufferedReader SwlpBlMf = new BufferedReader(new InputStreamReader(aquOXgu0.getInputStream()));
				String v8ETiJZg = null;
				while ((v8ETiJZg = SwlpBlMf.readLine()) != null) {
					wCgKu6ss = v8ETiJZg.indexOf(params.uri);
					if (wCgKu6ss != -1) {
						v8ETiJZg = "http://mars.gmu.edu:8080" + v8ETiJZg.substring(wCgKu6ss + 28);
						v8ETiJZg = v8ETiJZg.substring(0, v8ETiJZg.indexOf("\" alt=\""));
						break;
					}
				}
				if (v8ETiJZg != null) {
					aquOXgu0 = new URL(v8ETiJZg).openConnection();
					return processNewUri(aquOXgu0);
				}
			} catch (Exception qEJJ8zxv) {
			}
		return null;
	}

}