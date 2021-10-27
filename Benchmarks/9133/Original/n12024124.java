class n12024124{
    public boolean pollLocation(int device) {
        if (device < numDevices) {
            try {
                HttpResponse response = client.execute(post);
                BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
                JSONObject object = (JSONObject) JSONValue.parse(reader);
                JSONArray array = ((JSONArray) object.get("content"));
                object = (JSONObject) array.get(device);
                IPhoneLocation iPhoneLocation = getLocation(object);
                if (iPhoneLocation != null) {
                    iPhoneRouteList.get(device).addLocation(iPhoneLocation);
                }
            } catch (ClientProtocolException ex) {
                logger.log(Level.SEVERE, null, ex);
                return false;
            } catch (IOException ex) {
                logger.log(Level.SEVERE, null, ex);
                return false;
            }
        } else {
            logger.log(Level.WARNING, "Device {0} is out of range ({1} max)", new Object[] { (device + 1), numDevices });
            return false;
        }
        return true;
    }

}