class n505090 {
	public static void main(String[] tUCrwKUe) {
		URL igLXAWuw = null;
		EventHeap B3PGmAK0 = new EventHeap("iw-room2");
		Event DIQ4KTei;
		float xpB9lUzf = -1, QRFc8gue = -1;
		try {
			igLXAWuw = new URL("http://iw--bluetooth-ap/cgi-bin/sens.cgi");
		} catch (MalformedURLException LTtI3SMh) {
		}
		byte zJGeiOpQ[] = new byte[1000];
		while (true) {
			try {
				InputStream cf6p4j53 = igLXAWuw.openStream();
				int NEoO1iA9 = cf6p4j53.read(zJGeiOpQ);
				String aoCQmbnW = new String(zJGeiOpQ);
				String Ce1RosHl = aoCQmbnW.substring(290);
				if (Ce1RosHl.startsWith("No Sensors Found")) {
					Thread.sleep(1000);
				} else {
					String ChmzInu3 = Ce1RosHl.substring(15, 32);
					String oIt7EqMa = Ce1RosHl.substring(163, 167);
					String d4NI6hrs = Ce1RosHl.substring(266, 270);
					if (Float.parseFloat(oIt7EqMa) != xpB9lUzf) {
						System.out.println(ChmzInu3);
						System.out.println("Channel 1:" + oIt7EqMa);
						DIQ4KTei = new Event("iStuffInputEvent");
						DIQ4KTei.addField("Device", "Slider");
						DIQ4KTei.addField("ID", ChmzInu3 + ":channel1");
						DIQ4KTei.addField("Value", oIt7EqMa);
						DIQ4KTei.addField("Max", String.valueOf(5));
						DIQ4KTei.addField("Min", String.valueOf(0));
						B3PGmAK0.putEvent(DIQ4KTei);
						xpB9lUzf = Float.parseFloat(oIt7EqMa);
					}
				}
			} catch (Exception RTA24mC6) {
				RTA24mC6.printStackTrace();
			}
		}
	}

}