class n22554509 {
	public void initialize(AtomPropsMenu menu) {
		propertiesMenu = menu;
		if (shieldings == null) {
			try {
				URL url = this.getClass().getClassLoader().getResource(RF);
				InputStreamReader isr = new InputStreamReader(url.openStream());
				BufferedReader br = new BufferedReader(isr);
				shieldings = new Hashtable();
				SharcReader sr1 = new SharcReader(br);
				while (sr1.hasNext()) {
					SharcShielding ss1 = sr1.next();
					shieldings.put(ss1.getMethod(), ss1);
				}
				int i = 0;
				String[] shieldingNames = new String[shieldings.size()];
				Enumeration k = shieldings.keys();
				while (k.hasMoreElements()) {
					shieldingNames[i] = (String) k.nextElement();
					i++;
				}
				dialog = new SelectSharcReference(null, shieldingNames, true);
			} catch (Exception ex) {
				shieldings = null;
			}
		}
	}

}