class n2994947 {
	public JSONObject getSourceGraph(HttpSession kI528b9S, JSONObject PkhqMK9F) throws JSONException {
		StringBuffer WeiaoNbD = new StringBuffer();
		Graph hyOMtgGq = null;
		MappingManager HcP3lrvW = (MappingManager) kI528b9S.getAttribute(RuncibleConstants.MAPPING_MANAGER.key());
		try {
			hyOMtgGq = HcP3lrvW.getSourceGraph();
			if (hyOMtgGq != null) {
				FlexGraphViewFactory ntqiAJtj = new FlexGraphViewFactory();
				ntqiAJtj.setColorScheme(ColorSchemes.BLUES);
				ntqiAJtj.visit(hyOMtgGq);
				GraphView HaDmfl7I = ntqiAJtj.getGraphView();
				GraphViewRenderer nkTnVKtg = new FlexGraphViewRenderer();
				nkTnVKtg.setGraphView(HaDmfl7I);
				InputStream qbYWqZJK = nkTnVKtg.renderGraphView();
				StringWriter Gl0Dq3YY = new StringWriter();
				IOUtils.copy(qbYWqZJK, Gl0Dq3YY);
				Gl0Dq3YY.close();
				System.out.println(Gl0Dq3YY.toString());
				WeiaoNbD.append(Gl0Dq3YY.toString());
			} else {
				WeiaoNbD.append("No source graph loaded.");
			}
		} catch (Exception GZCFcXWb) {
			GZCFcXWb.printStackTrace();
			return JSONUtils.SimpleJSONError("Cannot load source graph: " + GZCFcXWb.getMessage());
		}
		return JSONUtils.SimpleJSONResponse(WeiaoNbD.toString());
	}

}