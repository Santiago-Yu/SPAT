class n15031489 {
	public Point getCoordinates(String rjToBkMV, String OGzvTgvw, String pQDgXqY1, String bnHYToDo) {
		StringBuilder ZO7RxKKK = new StringBuilder();
		StringBuilder pqgvWGNa = new StringBuilder();
		StringBuilder BZS5R7aN = new StringBuilder();
		if (rjToBkMV != null) {
			ZO7RxKKK.append(rjToBkMV.trim().replaceAll(" ", "+"));
			ZO7RxKKK.append("+");
		}
		if (OGzvTgvw != null) {
			ZO7RxKKK.append(OGzvTgvw.trim().replaceAll(" ", "+"));
			ZO7RxKKK.append("+");
		}
		if (pQDgXqY1 != null) {
			ZO7RxKKK.append(pQDgXqY1.trim().replaceAll(" ", "+"));
			ZO7RxKKK.append("+");
		}
		if (bnHYToDo != null) {
			ZO7RxKKK.append(bnHYToDo.replaceAll(" ", "+"));
		}
		pqgvWGNa.append("http://maps.google.com/maps/geo?key=");
		pqgvWGNa.append(key);
		pqgvWGNa.append("&sensor=false&output=json&oe=utf8&q=");
		pqgvWGNa.append(ZO7RxKKK.toString());
		try {
			URL pE49sI3q = new URL(pqgvWGNa.toString());
			BufferedReader uomtzo29 = new BufferedReader(new InputStreamReader(pE49sI3q.openStream()));
			String wQvJOOPY;
			while ((wQvJOOPY = uomtzo29.readLine()) != null) {
				BZS5R7aN.append(wQvJOOPY);
			}
			uomtzo29.close();
			JSONObject JbmhlXKv = (JSONObject) JSONValue.parse(BZS5R7aN.toString());
			JSONObject MHGot16B = (JSONObject) ((JSONArray) JbmhlXKv.get("Placemark")).get(0);
			JSONArray IqDBsQ31 = (JSONArray) ((JSONObject) MHGot16B.get("Point")).get("coordinates");
			Point clCY5wIs = new Point();
			clCY5wIs.setLatitude((Double) IqDBsQ31.get(1));
			clCY5wIs.setLongitude((Double) IqDBsQ31.get(0));
			return clCY5wIs;
		} catch (MalformedURLException Q9duxqwE) {
			return null;
		} catch (NullPointerException VejmGJRl) {
			return null;
		} catch (IOException OFtlzEqG) {
			return null;
		}
	}

}