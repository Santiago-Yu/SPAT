class n2994948 {
	public JSONObject getTargetGraph(HttpSession session, JSONObject json) throws JSONException {
		Graph tgt = null;
		StringBuffer out = new StringBuffer();
		MappingManager manager = (MappingManager) session.getAttribute(RuncibleConstants.MAPPING_MANAGER.key());
		try {
			tgt = manager.getTargetGraph();
			if (tgt != null) {
				FlexGraphViewFactory factory = new FlexGraphViewFactory();
				factory.setColorScheme(ColorSchemes.ORANGES);
				factory.visit(tgt);
				GraphViewRenderer renderer = new FlexGraphViewRenderer();
				GraphView view = factory.getGraphView();
				renderer.setGraphView(view);
				StringWriter writer = new StringWriter();
				InputStream xmlStream = renderer.renderGraphView();
				IOUtils.copy(xmlStream, writer);
				writer.close();
				System.out.println(writer.toString());
				out.append(writer.toString());
			} else {
				out.append("No target graph loaded.");
			}
		} catch (Exception e) {
			return JSONUtils.SimpleJSONError("Cannot load target graph: " + e.getMessage());
		}
		return JSONUtils.SimpleJSONResponse(out.toString());
	}

}