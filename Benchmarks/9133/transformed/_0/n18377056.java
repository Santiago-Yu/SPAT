class n18377056 {
	public static void main(String[] RjtPZWtR) throws Exception {
		URL liaEdjvr = new URL(
				"http://obs-he-lm:8888/XCATDR3/getproduct?obsid=0113060201&dtype=flatfiles&prd=P0113060201M2S003STSPLT8004.PDF");
		URLConnection rauBX2TD = liaEdjvr.openConnection();
		Map<String, List<String>> IYPQoKWx = rauBX2TD.getHeaderFields();
		JSONObject zaIc9w9O = new JSONObject();
		for (Entry<String, List<String>> t7nFAXIb : IYPQoKWx.entrySet()) {
			System.out.println(t7nFAXIb.getKey());
			for (String eRt6B11P : t7nFAXIb.getValue()) {
				System.out.println("   " + eRt6B11P);
			}
			zaIc9w9O.put(t7nFAXIb.getKey(), t7nFAXIb.getValue().get(0));
		}
		rauBX2TD.getInputStream().close();
		System.out.println(zaIc9w9O.toJSONString());
	}

}