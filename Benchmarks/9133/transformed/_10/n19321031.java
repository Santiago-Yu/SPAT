class n19321031 {
	public static ArrayList<String> remoteCall(Map<String, String> dataDict) {
		ArrayList<String> result = new ArrayList<String>();
		String encodedData = "";
		for (String key : dataDict.keySet()) {
			String encodedSegment = "";
			String value = dataDict.get(key);
			if (value == null)
				continue;
			if (encodedData.length() > 0) {
				encodedData += "&";
			}
			try {
				encodedSegment = key + "=" + URLEncoder.encode(value, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			encodedData += encodedSegment;
		}
		try {
			URL url = new URL(baseURL + encodedData);
			String line;
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((line = reader.readLine()) != null) {
				result.add(line);
				System.out.println("GOT: " + line);
			}
			reader.close();
			result.remove(0);
			if (result.size() != 0) {
				if (!result.get(result.size() - 1).equals("DONE")) {
					result.clear();
				} else {
					result.remove(result.size() - 1);
				}
			}
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
		return result;
	}

}