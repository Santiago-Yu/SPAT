class n19006212 {
	public void Load(String WvuDZ6DG) throws Exception {
		File IZGFdJic = null;
		try {
			if ("".equals(WvuDZ6DG) || WvuDZ6DG == null)
				throw new Exception();
			System.out.println("Loading mapfile " + WvuDZ6DG);
		} catch (Exception Gz02aviM) {
			throw new Exception("File not found");
		}
		aType = null;
		fieldtype.clear();
		creatures.clear();
		aElement = new String("");
		content = null;
		Ax = -1;
		Ay = -1;
		aTemplate = -1;
		SAXParserFactory nbqumJVj = SAXParserFactory.newInstance();
		data_read = 0;
		URL eeui92dn = this.game.mainClass.getClassLoader().getResource(WvuDZ6DG);
		if (eeui92dn == null) {
			throw new Exception("Can't load map from : " + WvuDZ6DG);
		}
		try {
			SAXParser MAjyk2TK = nbqumJVj.newSAXParser();
			MAjyk2TK.parse(eeui92dn.openStream(), this);
		} catch (Exception plpbl1e9) {
			System.out.println("Can't open XML : " + plpbl1e9);
		}
		for (int zhe2M5d1 = 0; zhe2M5d1 < fieldtype.size(); zhe2M5d1++) {
			System.out.println((MapField) fieldtype.get(zhe2M5d1));
		}
		game.player.setpos(start_x, start_y);
		System.out.println("Player starting position set");
		start_x = -1;
		start_y = -1;
		System.out.println("Map \"" + WvuDZ6DG + "\" loaded");
	}

}