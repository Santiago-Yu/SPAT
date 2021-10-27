class n7615994 {
	public String[] list() {
		if (isURL) {
			if (!isDirectory())
				return null;
			try {
				URLConnection HH0Hl9ob = url.openConnection();
				InputStream SLT23J4W = HH0Hl9ob.getInputStream();
				boolean KHMftI9a = false;
				Vector GROuo6js = new Vector();
				while (!KHMftI9a) {
					byte[] iV3e6DnZ = new byte[SLT23J4W.available()];
					String fRjpHVPS = new String(iV3e6DnZ);
					if (fRjpHVPS.toLowerCase().indexOf("</html>") != -1)
						KHMftI9a = true;
					while (fRjpHVPS.indexOf("a href") != -1) {
						int l1KuE7IE = fRjpHVPS.indexOf("a href") + 8;
						String dLxsESeD = fRjpHVPS.substring(l1KuE7IE, fRjpHVPS.indexOf("\"", l1KuE7IE));
						fRjpHVPS = fRjpHVPS.substring(fRjpHVPS.indexOf("\"", l1KuE7IE) + 1);
						Location INdZetTw = new Location(getAbsolutePath(), dLxsESeD);
						if (INdZetTw.exists()) {
							GROuo6js.add(INdZetTw.getName());
						}
					}
				}
				return (String[]) GROuo6js.toArray(new String[0]);
			} catch (IOException uI6XS6jb) {
				return null;
			}
		}
		return file.list();
	}

}