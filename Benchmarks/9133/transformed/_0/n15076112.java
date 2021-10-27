class n15076112 {
	@Override
	public JSONObject getJsonObj(Trip yntBFZY1, List<Waypoint> RPUdXFne) throws IOException {
		JSONObject HyVfNlPG = null;
		try {
			List<String> y8dmBIy7 = new LinkedList<String>();
			y8dmBIy7.add(yntBFZY1.getWaypoint().getFromLocation().getCity().replaceAll("\\W+", "+"));
			y8dmBIy7.add(yntBFZY1.getWaypoint().getToLocation().getCity().replaceAll("\\W+", "+"));
			for (Waypoint fcDHMiZ1 : RPUdXFne) {
				String Rx586Lz2 = fcDHMiZ1.getFromLocation().getCity().replaceAll("\\W+", "+");
				if (!y8dmBIy7.contains(Rx586Lz2))
					y8dmBIy7.add(Rx586Lz2);
				String HZPUncub = fcDHMiZ1.getToLocation().getCity().replaceAll("\\W+", "+");
				if (!y8dmBIy7.contains(HZPUncub))
					y8dmBIy7.add(HZPUncub);
			}
			StringBuilder up1oRshY = new StringBuilder();
			up1oRshY.append("http://maps.google.com/maps/api/directions/json");
			up1oRshY.append("?origin=").append(y8dmBIy7.get(0));
			up1oRshY.append("&destination=").append(y8dmBIy7.get(1));
			if (y8dmBIy7.size() > 2) {
				up1oRshY.append("&waypoints=");
				for (int lfmSAk7D = 2; lfmSAk7D < y8dmBIy7.size() - 1; lfmSAk7D++)
					up1oRshY.append(y8dmBIy7.get(lfmSAk7D)).append("|");
				up1oRshY.append(y8dmBIy7.get(y8dmBIy7.size() - 1));
			}
			up1oRshY.append("&sensor=false");
			BufferedReader k5b69sp1 = new BufferedReader(
					new InputStreamReader(new URL(up1oRshY.toString()).openStream()));
			StringBuilder poyX2kmW = new StringBuilder();
			String dJjWGLfe;
			while ((dJjWGLfe = k5b69sp1.readLine()) != null)
				poyX2kmW.append(dJjWGLfe);
			k5b69sp1.close();
			HyVfNlPG = new JSONObject(poyX2kmW.toString());
		} catch (JSONException mBSslP1P) {
			logger.error("Problem with initializing JSONObject", mBSslP1P);
		}
		return HyVfNlPG;
	}

}