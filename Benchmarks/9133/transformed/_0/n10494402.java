class n10494402 {
	private Comic[] getAllComics() {
		try {
			URL VV9fl4mp = new URL(comicSite + "list");
			InputStream dD6MY8lc = VV9fl4mp.openStream();
			BufferedReader rNbR1Ja2 = new BufferedReader(new InputStreamReader(dD6MY8lc));
			Vector zolEFyuG = new Vector();
			while (rNbR1Ja2.ready()) {
				String fGJJKUBh = rNbR1Ja2.readLine();
				zolEFyuG.add(fGJJKUBh);
			}
			Comic[] pLnRywZ9 = new Comic[zolEFyuG.size()];
			activated = new boolean[zolEFyuG.size()];
			titles = new String[zolEFyuG.size()];
			for (int MmNlhWKr = 0; MmNlhWKr < zolEFyuG.size(); MmNlhWKr++) {
				try {
					URL VjJcAEBe = new URL(comicSite + (String) zolEFyuG.get(MmNlhWKr));
					BufferedInputStream l40QukJ7 = new BufferedInputStream(VjJcAEBe.openStream());
					Properties goNwtKdq = new Properties();
					goNwtKdq.load(l40QukJ7);
					Comic rRZjAtGv = new Comic(goNwtKdq, false);
					pLnRywZ9[MmNlhWKr] = rRZjAtGv;
					titles[MmNlhWKr] = rRZjAtGv.getName();
					activated[MmNlhWKr] = comicsmanager.isLoaded(rRZjAtGv.getName());
				} catch (Exception AM1GPosg) {
					AM1GPosg.printStackTrace();
				}
			}
			for (int cxRkkLxH = 0; cxRkkLxH < pLnRywZ9.length; cxRkkLxH++) {
				System.out.println(pLnRywZ9[cxRkkLxH]);
			}
			return pLnRywZ9;
		} catch (MalformedURLException PmkW3gNs) {
			PmkW3gNs.printStackTrace();
		} catch (IOException kNPjnvyW) {
			kNPjnvyW.printStackTrace();
		}
		return null;
	}

}