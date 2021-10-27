class n23096632 {
	public void fetchCourses(String jsonurl) {
		InputStreamReader in = null;
		if (jsonurl == null) {
			throw new NullPointerException("jsonurl");
		}
		try {
			URL url = new URL(jsonurl);
			in = new InputStreamReader(url.openConnection().getInputStream());
			JSONObject root = (JSONObject) JSONValue.parse(in);
			JSONArray courseAr = (JSONArray) root.get("courses");
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			ListIterator<JSONObject> it = courseAr.listIterator();
			while (it.hasNext()) {
				Course c;
				JSONObject obj = it.next();
				try {
					c = new Course((String) obj.get("course"), df.parse((String) obj.get("start_date")),
							df.parse((String) obj.get("end_date")));
					courses.add(c);
				} catch (ParseException pe) {
				}
			}
			in.close();
		} catch (IOException e) {
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
				}
			}
		}
	}

}