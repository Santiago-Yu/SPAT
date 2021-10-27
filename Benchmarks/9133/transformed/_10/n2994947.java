class n2994947 {
	public JSONObject getSourceGraph(HttpSession session, JSONObject json) throws JSONException {
		Graph src = null;
		StringBuffer out = new StringBuffer();
		MappingManager manager = (MappingManager) session.getAttribute(RuncibleConstants.MAPPING_MANAGER.key());
		try {
			src = manager.getSourceGraph();
			if (src != null) {
				FlexGraphViewFactory factory = new FlexGraphViewFactory();
				factory.setColorScheme(ColorSchemes.BLUES);
				factory.visit(src);
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
				out.append("No source graph loaded.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return JSONUtils.SimpleJSONError("Cannot load source graph: " + e.getMessage());
		}
		return JSONUtils.SimpleJSONResponse(out.toString());
	}

}