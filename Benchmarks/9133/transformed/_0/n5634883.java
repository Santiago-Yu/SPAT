class n5634883 {
	public void run() {
		try {
			URL x7avE3hz = new URL(URL_STR + "?req=list");
			URLConnection NT9P60Y0 = x7avE3hz.openConnection(getProxy());
			NT9P60Y0.setRequestProperty("User-Agent", USER_AGENT);
			BufferedReader rLKbe9Wh = new BufferedReader(new InputStreamReader(NT9P60Y0.getInputStream()));
			String q4EAt2S0 = null;
			int a8HZYkhs = 0;
			ArrayList<String> NA6sKrG8 = new ArrayList<String>();
			ArrayList<String> oSzoZRzH = new ArrayList<String>();
			ArrayList<Integer> Hvc6qiwA = new ArrayList<Integer>();
			ArrayList<Float> MBSJtswl = new ArrayList<Float>();
			String[] j6YG3wfq;
			String[] JVme8qAK;
			int Dxeb2OIP;
			float uBRkOZyZ;
			while ((q4EAt2S0 = rLKbe9Wh.readLine()) != null) {
				if (q4EAt2S0.length() > 2) {
					try {
						j6YG3wfq = q4EAt2S0.split(" ", 3);
						if (j6YG3wfq.length != 3) {
							Util.debug(28,
									"Not enough subentry in online toplist file: ." + KeyboardHero.APP_NAME + ".tls!");
							continue;
						}
						Dxeb2OIP = Integer.parseInt(j6YG3wfq[1]);
						uBRkOZyZ = Float.parseFloat(j6YG3wfq[0]);
						Hvc6qiwA.add(Dxeb2OIP);
						MBSJtswl.add(uBRkOZyZ);
						JVme8qAK = hexdecode(j6YG3wfq[2]).split("?", 2);
						if (JVme8qAK.length != 2) {
							Util.debug(26, "Not enough subsubentry in online toplist file: ." + KeyboardHero.APP_NAME
									+ ".tls!");
							continue;
						}
						oSzoZRzH.add(JVme8qAK[0]);
						NA6sKrG8.add(JVme8qAK[1]);
						a8HZYkhs++;
					} catch (NumberFormatException rtdIM6jr) {
						Util.debug(24, "Corrupted toplist score and/or level number in the online toplist!");
					} catch (ArrayIndexOutOfBoundsException rZUr9kmh) {
						Util.debug(25, "Corrupted toplist entry in the online toplist!");
					}
				}
			}
			rLKbe9Wh.close();
			((DialogToplist) KeyboardHero.getDialogs().get("toplist")).setContent(NA6sKrG8.toArray(new String[0]),
					Hvc6qiwA.toArray(new Integer[0]), oSzoZRzH.toArray(new String[0]), MBSJtswl.toArray(new Float[0]),
					a8HZYkhs, -1);
		} catch (Exception kcmELh0z) {
			((DialogToplist) KeyboardHero.getDialogs().get("toplist"))
					.setStatusText(Util.getMsg("CannotToplist") + "!\n\n" + kcmELh0z.toString(), false);
		}
	}

}