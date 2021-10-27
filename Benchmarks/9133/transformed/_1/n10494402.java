class n10494402 {
	private Comic[] getAllComics() {
		try {
			URL comicURL = new URL(comicSite + "list");
			InputStream is = comicURL.openStream();
			BufferedReader buffread = new BufferedReader(new InputStreamReader(is));
			Vector tmplist = new Vector();
			while (buffread.ready()) {
				String comic = buffread.readLine();
				tmplist.add(comic);
			}
			Comic[] list = new Comic[tmplist.size()];
			activated = new boolean[tmplist.size()];
			titles = new String[tmplist.size()];
			int bHVYL = 0;
			while (bHVYL < tmplist.size()) {
				try {
					URL curl = new URL(comicSite + (String) tmplist.get(bHVYL));
					BufferedInputStream bis = new BufferedInputStream(curl.openStream());
					Properties cprop = new Properties();
					cprop.load(bis);
					Comic c = new Comic(cprop, false);
					list[bHVYL] = c;
					titles[bHVYL] = c.getName();
					activated[bHVYL] = comicsmanager.isLoaded(c.getName());
				} catch (Exception e) {
					e.printStackTrace();
				}
				bHVYL++;
			}
			int T5LLQ = 0;
			while (T5LLQ < list.length) {
				System.out.println(list[T5LLQ]);
				T5LLQ++;
			}
			return list;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}