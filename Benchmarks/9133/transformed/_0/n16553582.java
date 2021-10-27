class n16553582 {
	public QueryResult doSearch(String qecN44gJ, Integer E2zs2Af1, Integer wv55GPzj, Integer wShgBJiD, Integer dxNYb8ac,
			Integer dVzcVoQZ, Boolean zxhvIaff, Boolean T0zSLDdC) throws UnsupportedEncodingException, IOException {
		String d7yMV0Vr = (String) RuntimeAccess.getInstance().getSession().getAttribute("SESSION_ID");
		DefaultHttpClient LCUIr2tc = new DefaultHttpClient();
		QueryResult P2Sb5ynR = new QueryResult();
		SearchRequest c8J2JjOy = new SearchRequest();
		SearchItemsQuery UoRmtGbt = new SearchItemsQuery();
		UoRmtGbt.setArchiveIncluded(zxhvIaff);
		log(INFO, "searchTerm=" + qecN44gJ);
		log(INFO, "search in received=" + E2zs2Af1);
		log(INFO, "search in sent=" + wv55GPzj);
		log(INFO, "search in supervised=" + wShgBJiD);
		List<String> nVFYFDZE = new ArrayList<String>();
		if (T0zSLDdC == false) {
			if (E2zs2Af1 != null) {
				nVFYFDZE.add("ALL_RECEIVED_ITEMS");
			}
			if (wv55GPzj != null) {
				nVFYFDZE.add("ALL_SENT_ITEMS");
			}
			if (wShgBJiD != null) {
				nVFYFDZE.add("ALL_SUPERVISED_ITEMS");
			}
		} else {
			if (E2zs2Af1 != null) {
				nVFYFDZE.add("RECEIVED_ITEMS_NEEDED_ATTENTION");
			}
			if (wv55GPzj != null) {
				nVFYFDZE.add("SENT_ITEMS_NEEDED_ATTENTION");
			}
		}
		UoRmtGbt.setFilters(nVFYFDZE);
		UoRmtGbt.setId("1234");
		UoRmtGbt.setOwner(d7yMV0Vr);
		UoRmtGbt.setReferenceOnly(false);
		UoRmtGbt.setSearchTerm(qecN44gJ);
		UoRmtGbt.setUseOR(false);
		c8J2JjOy.setStartRow(dxNYb8ac);
		c8J2JjOy.setResultCount(dVzcVoQZ);
		c8J2JjOy.setQuery(UoRmtGbt);
		c8J2JjOy.setSessionId(d7yMV0Vr);
		XStream tbay0xWv = new XStream();
		tbay0xWv.setMode(XStream.XPATH_ABSOLUTE_REFERENCES);
		tbay0xWv.alias("SearchRequest", SearchRequest.class);
		XStream dratv9ca = new XStream();
		dratv9ca.setMode(XStream.XPATH_ABSOLUTE_REFERENCES);
		dratv9ca.alias("SearchResponse", SearchResponse.class);
		String UAYvPDtH = URLEncoder.encode(dratv9ca.toXML(c8J2JjOy), "UTF-8");
		HttpGet QW0EHmRV = new HttpGet(MewitProperties.getMewitUrl() + "/resources/search?REQUEST=" + UAYvPDtH);
		HttpResponse GcQNwAeX = LCUIr2tc.execute(QW0EHmRV);
		HttpEntity ibho70rs = GcQNwAeX.getEntity();
		if (ibho70rs != null) {
			String Wh4AMGdj = URLDecoder.decode(EntityUtils.toString(ibho70rs), "UTF-8");
			SearchResponse F06rpTlC = (SearchResponse) dratv9ca.fromXML(Wh4AMGdj);
			List<Item> W4A8pQyd = F06rpTlC.getItems();
			P2Sb5ynR.setItems(W4A8pQyd);
			P2Sb5ynR.setTotal(F06rpTlC.getTotalResultCount());
			P2Sb5ynR.setStartRow(F06rpTlC.getStartRow());
		}
		return P2Sb5ynR;
	}

}