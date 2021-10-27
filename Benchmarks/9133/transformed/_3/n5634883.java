class n5634883 {
	public void run() {
		try {
			URL url = new URL(URL_STR + "?req=list");
			URLConnection connection = url.openConnection(getProxy());
			connection.setRequestProperty("User-Agent", USER_AGENT);
			BufferedReader bufferedRdr = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line = null;
			int foundCount = 0;
			ArrayList<String> names = new ArrayList<String>();
			ArrayList<String> songs = new ArrayList<String>();
			ArrayList<Integer> scores = new ArrayList<Integer>();
			ArrayList<Float> factors = new ArrayList<Float>();
			String[] subparts;
			String[] ssubparts;
			int tlscore;
			float tlfactor;
			while ((line = bufferedRdr.readLine()) != null) {
				if (!(line.length() > 2))
					;
				else {
					try {
						subparts = line.split(" ", 3);
						if (subparts.length != 3) {
							Util.debug(28,
									"Not enough subentry in online toplist file: ." + KeyboardHero.APP_NAME + ".tls!");
							continue;
						}
						tlscore = Integer.parseInt(subparts[1]);
						tlfactor = Float.parseFloat(subparts[0]);
						scores.add(tlscore);
						factors.add(tlfactor);
						ssubparts = hexdecode(subparts[2]).split("?", 2);
						if (ssubparts.length != 2) {
							Util.debug(26, "Not enough subsubentry in online toplist file: ." + KeyboardHero.APP_NAME
									+ ".tls!");
							continue;
						}
						songs.add(ssubparts[0]);
						names.add(ssubparts[1]);
						foundCount++;
					} catch (NumberFormatException e) {
						Util.debug(24, "Corrupted toplist score and/or level number in the online toplist!");
					} catch (ArrayIndexOutOfBoundsException e) {
						Util.debug(25, "Corrupted toplist entry in the online toplist!");
					}
				}
			}
			bufferedRdr.close();
			((DialogToplist) KeyboardHero.getDialogs().get("toplist")).setContent(names.toArray(new String[0]),
					scores.toArray(new Integer[0]), songs.toArray(new String[0]), factors.toArray(new Float[0]),
					foundCount, -1);
		} catch (Exception e) {
			((DialogToplist) KeyboardHero.getDialogs().get("toplist"))
					.setStatusText(Util.getMsg("CannotToplist") + "!\n\n" + e.toString(), false);
		}
	}

}