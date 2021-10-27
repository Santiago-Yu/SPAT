class n14054923 {
	protected Document getRawResults(String ji6heOTQ, Map q6rAtpqm) throws Exception {
		int BElzC4w7 = 0;
		Iterator Y5wvvBWa = q6rAtpqm.keySet().iterator();
		while (Y5wvvBWa.hasNext()) {
			String My1b1hku = BElzC4w7++ == 0 ? "?" : "&";
			String MWaEWhy3 = (String) Y5wvvBWa.next();
			if (q6rAtpqm.get(MWaEWhy3) != null) {
				ji6heOTQ += My1b1hku + MWaEWhy3 + "=" + q6rAtpqm.get(MWaEWhy3);
			}
		}
		URL tx8IQXgb = new URL(ji6heOTQ);
		URLConnection kIZIPmBh = tx8IQXgb.openConnection();
		kIZIPmBh.connect();
		SAXBuilder ccGAaQx3 = new SAXBuilder();
		return ccGAaQx3.build(kIZIPmBh.getInputStream());
	}

}