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
			Map m = con.getHeaderFields();
			Set s = m.keySet();
			Iterator i = s.iterator();
			while (i.hasNext()) {
				String x = (String) i.next();
				Object o = m.get(x);
				String y = null;
				if (o instanceof String)
					y = (String) o;
				else if (o instanceof Collection)
					y = "" + (Collection) o;
				else
					y = (o instanceof Integer) ? "" + (Integer) o : o.getClass().getName();
				System.out.println(" header " + x + " = " + y);
			}
			infile = new DataInputStream(con.getInputStream());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		open = true;
		count = 0;
		countLastRead = 0;
		return true;
	}

}