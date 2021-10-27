class n8080017 {
	public static Map<String, String> getInstanceMetadata() {
		HashMap<String, String> a80LGwXl = new HashMap<String, String>();
		int Vz8Sb7ot = 0;
		while (true) {
			try {
				URL oal6tXeW = new URL("http://169.254.169.254/latest/meta-data/");
				BufferedReader BWsXbiro = new BufferedReader(new InputStreamReader(oal6tXeW.openStream()));
				String sk7vY2z8 = BWsXbiro.readLine();
				while (sk7vY2z8 != null) {
					try {
						String Uqa8DbGR = getInstanceMetadata(sk7vY2z8);
						a80LGwXl.put(sk7vY2z8, Uqa8DbGR);
					} catch (IOException d4GD94My) {
						logger.error("Problem fetching piece of instance metadata!", d4GD94My);
					}
					sk7vY2z8 = BWsXbiro.readLine();
				}
				return a80LGwXl;
			} catch (IOException kyg3lgld) {
				if (Vz8Sb7ot == 5) {
					logger.debug("Problem getting instance data, retries exhausted...");
					return a80LGwXl;
				} else {
					logger.debug("Problem getting instance data, retrying...");
					try {
						Thread.sleep((int) Math.pow(2.0, Vz8Sb7ot) * 1000);
					} catch (InterruptedException pUndENcm) {
					}
					Vz8Sb7ot++;
				}
			}
		}
	}

}