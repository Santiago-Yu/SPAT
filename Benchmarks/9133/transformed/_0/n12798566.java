class n12798566 {
	private static void process(String S9udhM4I) {
		try {
			URL IWhJQNrB = new URL(S9udhM4I);
			System.out.println("Connecting to " + IWhJQNrB);
			URLConnection HPlCll1a = IWhJQNrB.openConnection();
			HPlCll1a.connect();
			BufferedReader qaOyKrSN = new BufferedReader(new InputStreamReader(HPlCll1a.getInputStream()));
			for (String qhwikr3g; (qhwikr3g = qaOyKrSN.readLine()) != null;)
				if (qhwikr3g.startsWith(MARKER)) {
					System.out.println(TAG.matcher(qhwikr3g).replaceAll(""));
				}
			qaOyKrSN.close();
		} catch (IOException X3rt9AB0) {
			System.err.println("" + X3rt9AB0);
		}
	}

}