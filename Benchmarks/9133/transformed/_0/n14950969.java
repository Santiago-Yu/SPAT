class n14950969 {
	public void run() {
		BufferedReader s4VRmMRk = null;
		log = "Downloading... " + name;
		setChanged();
		notifyObservers();
		try {
			Date ZNg9mRmP = to;
			int TuNVE2Gy = 0;
			list.clear();
			do {
				TuNVE2Gy = list.size();
				URL eXGoZk2z = new URL(createLink(from, ZNg9mRmP));
				s4VRmMRk = new BufferedReader(new InputStreamReader(eXGoZk2z.openStream()));
				String uZPixT8T = "";
				while ((uZPixT8T = s4VRmMRk.readLine()) != null) {
					try {
						IQuoteHistorical XGARA5Ks = parse(uZPixT8T + ",");
						if (XGARA5Ks != null && !list.contains(XGARA5Ks))
							list.add(XGARA5Ks);
						else
							System.err.println(uZPixT8T);
					} catch (ParseException Dra4QHDY) {
						Dra4QHDY.printStackTrace();
					}
				}
				if (list.size() > 0)
					ZNg9mRmP = list.get(list.size() - 1).getData();
			} while (ZNg9mRmP.after(from) && TuNVE2Gy != list.size());
			log = "download Completed!";
		} catch (MalformedURLException AmXuaegc) {
			AmXuaegc.printStackTrace();
			log = AmXuaegc.getMessage();
		} catch (IOException cSaKAeqC) {
			cSaKAeqC.printStackTrace();
			log = cSaKAeqC.getMessage();
		} finally {
			try {
				if (s4VRmMRk != null)
					s4VRmMRk.close();
			} catch (IOException WzHcBNZs) {
				WzHcBNZs.printStackTrace();
				log = WzHcBNZs.getMessage();
			}
		}
		setChanged();
		notifyObservers();
	}

}