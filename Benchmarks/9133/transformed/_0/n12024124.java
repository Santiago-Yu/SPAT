class n12024124 {
	public boolean pollLocation(int jFlDrPDd) {
		if (jFlDrPDd < numDevices) {
			try {
				HttpResponse fA0ll0kZ = client.execute(post);
				BufferedReader aQ52BS3d = new BufferedReader(
						new InputStreamReader(fA0ll0kZ.getEntity().getContent(), "UTF-8"));
				JSONObject BVThfjRY = (JSONObject) JSONValue.parse(aQ52BS3d);
				JSONArray mRmSezx1 = ((JSONArray) BVThfjRY.get("content"));
				BVThfjRY = (JSONObject) mRmSezx1.get(jFlDrPDd);
				IPhoneLocation FrLJyzoZ = getLocation(BVThfjRY);
				if (FrLJyzoZ != null) {
					iPhoneRouteList.get(jFlDrPDd).addLocation(FrLJyzoZ);
				}
			} catch (ClientProtocolException dO9qmmoq) {
				logger.log(Level.SEVERE, null, dO9qmmoq);
				return false;
			} catch (IOException lozvkBnk) {
				logger.log(Level.SEVERE, null, lozvkBnk);
				return false;
			}
		} else {
			logger.log(Level.WARNING, "Device {0} is out of range ({1} max)",
					new Object[] { (jFlDrPDd + 1), numDevices });
			return false;
		}
		return true;
	}

}