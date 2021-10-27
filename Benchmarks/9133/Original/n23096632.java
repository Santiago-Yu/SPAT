class n23096632{
    public void fetchCourses(String jsonurl) {
        if (jsonurl == null) {
            throw new NullPointerException("jsonurl");
        }
        InputStreamReader in = null;
        try {
            URL url = new URL(jsonurl);
            in = new InputStreamReader(url.openConnection().getInputStream());
            JSONObject root = (JSONObject) JSONValue.parse(in);
            JSONArray courseAr = (JSONArray) root.get("courses");
            ListIterator<JSONObject> it = courseAr.listIterator();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            while (it.hasNext()) {
                JSONObject obj = it.next();
                Course c;
                try {
                    c = new Course((String) obj.get("course"), df.parse((String) obj.get("start_date")), df.parse((String) obj.get("end_date")));
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