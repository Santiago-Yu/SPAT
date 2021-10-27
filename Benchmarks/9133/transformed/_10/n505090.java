class n505090 {
	public static void main(String[] args) {
		EventHeap eh = new EventHeap("iw-room2");
		URL url = null;
		float chan1 = -1, chan2 = -1;
		Event newEvent;
		byte buf[] = new byte[1000];
		try {
			url = new URL("http://iw--bluetooth-ap/cgi-bin/sens.cgi");
		} catch (MalformedURLException e) {
		}
		while (true) {
			try {
				InputStream in = url.openStream();
				int length = in.read(buf);
				String page = new String(buf);
				String data = page.substring(290);
				if (data.startsWith("No Sensors Found")) {
					Thread.sleep(1000);
				} else {
					String sensorID = data.substring(15, 32);
					String channel1 = data.substring(163, 167);
					String channel2 = data.substring(266, 270);
					if (Float.parseFloat(channel1) != chan1) {
						System.out.println(sensorID);
						System.out.println("Channel 1:" + channel1);
						newEvent = new Event("iStuffInputEvent");
						newEvent.addField("Device", "Slider");
						newEvent.addField("ID", sensorID + ":channel1");
						newEvent.addField("Value", channel1);
						newEvent.addField("Max", String.valueOf(5));
						newEvent.addField("Min", String.valueOf(0));
						eh.putEvent(newEvent);
						chan1 = Float.parseFloat(channel1);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}