class n5337582 {
	public List execute(ComClient XGKPyd4K) throws Exception {
		ArrayList OTtlNKc0 = new ArrayList();
		SearchResult wk5SqQK3 = Util.getSearchResultByIDAndNum(SearchManager.getInstance(), qID, dwNum);
		for (int m9gXiNTW = 0; m9gXiNTW < checkerUrls.length; m9gXiNTW++) {
			String ELxD9Yea = checkerUrls[m9gXiNTW];
			Iterator tJ1xBp7y = wk5SqQK3.iterateMetatags();
			while (tJ1xBp7y.hasNext()) {
				Map.Entry s4xEerot = (Map.Entry) tJ1xBp7y.next();
				ELxD9Yea = ELxD9Yea.replaceAll("%%" + s4xEerot.getKey() + "%%", s4xEerot.getValue().toString());
				if (s4xEerot.getKey().equals("fake") && ((Boolean) s4xEerot.getValue()).booleanValue()) {
					OTtlNKc0.add("it's a fake.");
					return OTtlNKc0;
				}
			}
			ELxD9Yea = ELxD9Yea.replaceAll("%%fileid%%", wk5SqQK3.getFileHash().toString());
			System.out.println("parametrizedURL=" + ELxD9Yea);
			try {
				URL PZRJGjjn = new URL(ELxD9Yea);
				URLConnection XHhR4pFw = PZRJGjjn.openConnection();
				XHhR4pFw.connect();
				BufferedReader CFpUICPo = new BufferedReader(new InputStreamReader(XHhR4pFw.getInputStream()));
				String syzWXRML = null;
				while ((syzWXRML = CFpUICPo.readLine()) != null) {
					System.out.println(syzWXRML);
					if (syzWXRML.indexOf(fakeMarks[m9gXiNTW]) != -1) {
						System.out.println("FAKEFAKEFAKE");
						wk5SqQK3.addMetatag("fake", Boolean.TRUE);
						OTtlNKc0.add("it's a fake.");
						break;
					}
				}
			} catch (MalformedURLException KkFFTdxw) {
				KkFFTdxw.printStackTrace();
			} catch (IOException eZqH76qF) {
				eZqH76qF.printStackTrace();
			} catch (Exception j35VbCBz) {
				j35VbCBz.printStackTrace();
			}
		}
		return OTtlNKc0;
	}

}