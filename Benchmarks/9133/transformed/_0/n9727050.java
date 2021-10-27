class n9727050 {
	private PrecomputedAnimatedModel loadPrecomputedModel_(URL eSYt3MhS) {
		if (precompCache.containsKey(eSYt3MhS.toExternalForm())) {
			return (precompCache.get(eSYt3MhS.toExternalForm()).copy());
		}
		TextureLoader.getInstance().getTexture("");
		List<SharedGroup> l93mpZ4y = new ArrayList<SharedGroup>();
		Map<String, Animation> Avkmvbki = new Hashtable<String, Animation>();
		if (eSYt3MhS.toExternalForm().endsWith(".amo")) {
			try {
				BufferedReader PFZ2vIRO = new BufferedReader(new InputStreamReader(eSYt3MhS.openStream()));
				String Dc2NCYbx = PFZ2vIRO.readLine();
				Dc2NCYbx = eSYt3MhS.toExternalForm().substring(0, eSYt3MhS.toExternalForm().lastIndexOf("/")) + "/"
						+ Dc2NCYbx;
				l93mpZ4y = loadOBJFrames(Dc2NCYbx);
				String Ij7sT7CJ;
				while ((Ij7sT7CJ = PFZ2vIRO.readLine()) != null) {
					StringTokenizer qLDt5ZnN = new StringTokenizer(Ij7sT7CJ);
					String vDplZbfQ = qLDt5ZnN.nextToken();
					int Hy6DVQH9 = Integer.valueOf(qLDt5ZnN.nextToken());
					int tEuvy0Ro = Integer.valueOf(qLDt5ZnN.nextToken());
					qLDt5ZnN.nextToken();
					Avkmvbki.put(vDplZbfQ, new Animation(vDplZbfQ, Hy6DVQH9, tEuvy0Ro));
				}
			} catch (FileNotFoundException rtEdwARJ) {
				rtEdwARJ.printStackTrace();
			} catch (IOException VS6ryhYO) {
				VS6ryhYO.printStackTrace();
			}
		} else {
			l93mpZ4y = loadOBJFrames(eSYt3MhS.toExternalForm());
		}
		PrecomputedAnimatedModel MsTkmb80 = new PrecomputedAnimatedModel(l93mpZ4y, Avkmvbki);
		precompCache.put(eSYt3MhS.toExternalForm(), MsTkmb80);
		return (MsTkmb80);
	}

}