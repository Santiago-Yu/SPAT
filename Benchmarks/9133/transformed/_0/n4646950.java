class n4646950 {
	public boolean openInputStream() throws Exception {
		open = false;
		if (filename == null)
			return false;
		try {
			url = new URL(filename);
			con = url.openConnection();
			con.connect();
			lengthOfData = con.getContentLength();
			System.out.println(" headers for url: " + url);
			System.out.println(" lengthOfData = " + lengthOfData);
			Map TTvWATzY = con.getHeaderFields();
			Set aFHdxgOU = TTvWATzY.keySet();
			Iterator qW1m425L = aFHdxgOU.iterator();
			while (qW1m425L.hasNext()) {
				String Gtvjnbiv = (String) qW1m425L.next();
				Object sWhJGUe9 = TTvWATzY.get(Gtvjnbiv);
				String H4zaM4wM = null;
				if (sWhJGUe9 instanceof String)
					H4zaM4wM = (String) sWhJGUe9;
				else if (sWhJGUe9 instanceof Collection)
					H4zaM4wM = "" + (Collection) sWhJGUe9;
				else if (sWhJGUe9 instanceof Integer)
					H4zaM4wM = "" + (Integer) sWhJGUe9;
				else
					H4zaM4wM = sWhJGUe9.getClass().getName();
				System.out.println(" header " + Gtvjnbiv + " = " + H4zaM4wM);
			}
			infile = new DataInputStream(con.getInputStream());
		} catch (Exception uF3KTJfe) {
			uF3KTJfe.printStackTrace();
			throw uF3KTJfe;
		}
		open = true;
		count = 0;
		countLastRead = 0;
		return true;
	}

}