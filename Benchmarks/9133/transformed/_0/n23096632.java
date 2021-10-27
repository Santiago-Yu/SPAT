class n23096632 {
	public void fetchCourses(String opCGWIaV) {
		if (opCGWIaV == null) {
			throw new NullPointerException("jsonurl");
		}
		InputStreamReader zwgDevva = null;
		try {
			URL uXDX4l1f = new URL(opCGWIaV);
			zwgDevva = new InputStreamReader(uXDX4l1f.openConnection().getInputStream());
			JSONObject BB0sKN8s = (JSONObject) JSONValue.parse(zwgDevva);
			JSONArray Yta6cI4N = (JSONArray) BB0sKN8s.get("courses");
			ListIterator<JSONObject> e3eg7QLK = Yta6cI4N.listIterator();
			SimpleDateFormat qEajWM0g = new SimpleDateFormat("yyyy-MM-dd");
			while (e3eg7QLK.hasNext()) {
				JSONObject kyDxXasU = e3eg7QLK.next();
				Course RDOQI7tb;
				try {
					RDOQI7tb = new Course((String) kyDxXasU.get("course"),
							qEajWM0g.parse((String) kyDxXasU.get("start_date")),
							qEajWM0g.parse((String) kyDxXasU.get("end_date")));
					courses.add(RDOQI7tb);
				} catch (ParseException GeeTH92J) {
				}
			}
			zwgDevva.close();
		} catch (IOException CMYyBzec) {
		} finally {
			if (zwgDevva != null) {
				try {
					zwgDevva.close();
				} catch (IOException Eejm3ydX) {
				}
			}
		}
	}

}