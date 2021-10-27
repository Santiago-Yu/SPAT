class n2994948 {
	public JSONObject getTargetGraph(HttpSession cfFAiv7m, JSONObject HR9FcMKV) throws JSONException {
		StringBuffer CbHRs2ah = new StringBuffer();
		Graph qo0fkTQH = null;
		MappingManager D6dErPe6 = (MappingManager) cfFAiv7m.getAttribute(RuncibleConstants.MAPPING_MANAGER.key());
		try {
			qo0fkTQH = D6dErPe6.getTargetGraph();
			if (qo0fkTQH != null) {
				FlexGraphViewFactory wf2oSgsh = new FlexGraphViewFactory();
				wf2oSgsh.setColorScheme(ColorSchemes.ORANGES);
				wf2oSgsh.visit(qo0fkTQH);
				GraphView KDaNORW6 = wf2oSgsh.getGraphView();
				GraphViewRenderer LoVrneTk = new FlexGraphViewRenderer();
				LoVrneTk.setGraphView(KDaNORW6);
				InputStream zHXvM2Rd = LoVrneTk.renderGraphView();
				StringWriter lqPApWOe = new StringWriter();
				IOUtils.copy(zHXvM2Rd, lqPApWOe);
				lqPApWOe.close();
				System.out.println(lqPApWOe.toString());
				CbHRs2ah.append(lqPApWOe.toString());
			} else {
				CbHRs2ah.append("No target graph loaded.");
			}
		} catch (Exception L8rYyvJ7) {
			return JSONUtils.SimpleJSONError("Cannot load target graph: " + L8rYyvJ7.getMessage());
		}
		return JSONUtils.SimpleJSONResponse(CbHRs2ah.toString());
	}

}