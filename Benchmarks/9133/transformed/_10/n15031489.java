class n15031489 {
	public Point getCoordinates(String address, String city, String state, String country) {
		StringBuilder queryString = new StringBuilder();
		StringBuilder urlString = new StringBuilder();
		if (address != null) {
			queryString.append(address.trim().replaceAll(" ", "+"));
			queryString.append("+");
		}
		StringBuilder response = new StringBuilder();
		if (city != null) {
			queryString.append(city.trim().replaceAll(" ", "+"));
			queryString.append("+");
		}
		if (state != null) {
			queryString.append(state.trim().replaceAll(" ", "+"));
			queryString.append("+");
		}
		if (country != null) {
			queryString.append(country.replaceAll(" ", "+"));
		}
		urlString.append("http://maps.google.com/maps/geo?key=");
		urlString.append(key);
		urlString.append("&sensor=false&output=json&oe=utf8&q=");
		urlString.append(queryString.toString());
		try {
			URL url = new URL(urlString.toString());
			String line;
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((line = reader.readLine()) != null) {
				response.append(line);
			}
			reader.close();
			JSONObject root = (JSONObject) JSONValue.parse(response.toString());
			JSONObject placemark = (JSONObject) ((JSONArray) root.get("Placemark")).get(0);
			Point point = new Point();
			JSONArray coordinates = (JSONArray) ((JSONObject) placemark.get("Point")).get("coordinates");
			point.setLatitude((Double) coordinates.get(1));
			point.setLongitude((Double) coordinates.get(0));
			return point;
		} catch (MalformedURLException ex) {
			return null;
		} catch (NullPointerException ex) {
			return null;
		} catch (IOException ex) {
			return null;
		}
	}

}