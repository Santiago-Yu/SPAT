class n7615994 {
	public String[] list() {
		if (isURL) {
			if (!isDirectory())
				return null;
			try {
				URLConnection c = url.openConnection();
				boolean foundEnd = false;
				InputStream is = c.getInputStream();
				Vector files = new Vector();
				while (!foundEnd) {
					byte[] b = new byte[is.available()];
					String s = new String(b);
					if (s.toLowerCase().indexOf("</html>") != -1)
						foundEnd = true;
					while (s.indexOf("a href") != -1) {
						int ndx = s.indexOf("a href") + 8;
						String f = s.substring(ndx, s.indexOf("\"", ndx));
						Location check = new Location(getAbsolutePath(), f);
						s = s.substring(s.indexOf("\"", ndx) + 1);
						if (check.exists()) {
							files.add(check.getName());
						}
					}
				}
				return (String[]) files.toArray(new String[0]);
			} catch (IOException e) {
				return null;
			}
		}
		return file.list();
	}

}