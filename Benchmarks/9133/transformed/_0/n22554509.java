class n22554509 {
	public void initialize(AtomPropsMenu oJTMmyai) {
		propertiesMenu = oJTMmyai;
		if (shieldings == null) {
			try {
				URL sEs9nPFd = this.getClass().getClassLoader().getResource(RF);
				InputStreamReader UCyJEX9N = new InputStreamReader(sEs9nPFd.openStream());
				BufferedReader oRggjIBK = new BufferedReader(UCyJEX9N);
				SharcReader D3RwH7Mt = new SharcReader(oRggjIBK);
				shieldings = new Hashtable();
				while (D3RwH7Mt.hasNext()) {
					SharcShielding G7HaQaaY = D3RwH7Mt.next();
					shieldings.put(G7HaQaaY.getMethod(), G7HaQaaY);
				}
				String[] epmlCWxH = new String[shieldings.size()];
				int qp1mZIjF = 0;
				Enumeration KipmMaBG = shieldings.keys();
				while (KipmMaBG.hasMoreElements()) {
					epmlCWxH[qp1mZIjF] = (String) KipmMaBG.nextElement();
					qp1mZIjF++;
				}
				dialog = new SelectSharcReference(null, epmlCWxH, true);
			} catch (Exception AqsXcXqt) {
				shieldings = null;
			}
		}
	}

}