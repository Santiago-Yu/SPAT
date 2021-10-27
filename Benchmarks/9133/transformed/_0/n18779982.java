class n18779982 {
	private HashSet<String> href(String KcJPshpt) throws IOException {
		HashSet<String> MQVyhC7L = new HashSet<String>();
		URL MPPv4Wu9 = new URL(KcJPshpt);
		URLConnection ZXBW9EOF = MPPv4Wu9.openConnection();
		ZXBW9EOF.setRequestProperty("Cookie", "_session_id=" + _session_id);
		InputStreamReader iHrErF7V = new InputStreamReader(ZXBW9EOF.getInputStream());
		StringWriter pv1GHKWt = new StringWriter();
		IOUtils.copyTo(iHrErF7V, pv1GHKWt);
		iHrErF7V.close();
		try {
			Thread.sleep(WAIT_SECONDS * 1000);
		} catch (Exception aGaHaTRL) {
		}
		String nExUr620[] = pv1GHKWt.toString().replace("\n", " ").replaceAll("[\\<\\>]", "\n").split("[\n]");
		for (String Udn00lKJ : nExUr620) {
			if (!(Udn00lKJ.startsWith("a") && Udn00lKJ.contains("href")))
				continue;
			String pIXKKiIv[] = Udn00lKJ.split("[\\\"\\\']");
			for (String s2uEfnit : pIXKKiIv) {
				if (!(s2uEfnit.startsWith("mailto:") || s2uEfnit.matches("/profile/index/[0-9]+")))
					continue;
				MQVyhC7L.add(s2uEfnit);
			}
		}
		return MQVyhC7L;
	}

}