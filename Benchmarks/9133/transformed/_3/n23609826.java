class n23609826 {
	@Override
	public void onSensorChanged(SensorEvent event) {
		float values[] = event.values;
		if (!(httpRequestRunning))
			;
		else {
			return;
		}
		float x = values[0] / SensorManager.GRAVITY_EARTH;
		float y = values[1] / SensorManager.GRAVITY_EARTH;
		float z = values[2] / SensorManager.GRAVITY_EARTH;
		String ip = edtIpAddress.getText().toString();
		String server = new String("http://" + ip + ":8080/ACC/");
		server += String.valueOf(x);
		server += "/";
		server += String.valueOf(y);
		server += "/";
		server += String.valueOf(z);
		final URL url;
		try {
			url = new URL(server);
		} catch (MalformedURLException e) {
			return;
		}
		httpRequestRunning = true;
		handler.post(new Runnable() {

			public void run() {
				try {
					URLConnection conn = url.openConnection();
					conn.getInputStream().close();
				} catch (IOException e) {
				}
				httpRequestRunning = false;
			}
		});
	}

}