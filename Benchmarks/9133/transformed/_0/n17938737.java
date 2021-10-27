class n17938737 {
	@SuppressWarnings("unchecked")
	private List<String> getLogFile() {
		String v0MuUHSl = "";
		Realm isib0kOk = null;
		if (null == node) {
			if (null != System.getProperty("ThinClientManager.server.Codebase"))
				try {
					v0MuUHSl = new URL(System.getProperty("ThinClientManager.server.Codebase")).getHost();
				} catch (final MalformedURLException qIHdXWF9) {
					qIHdXWF9.printStackTrace();
				}
		} else {
			isib0kOk = (Realm) node.getLookup().lookup(Realm.class);
			if (null != isib0kOk.getSchemaProviderName())
				v0MuUHSl = isib0kOk.getSchemaProviderName();
			else if (null != isib0kOk.getConnectionDescriptor().getHostname())
				v0MuUHSl = isib0kOk.getConnectionDescriptor().getHostname();
		}
		if (v0MuUHSl.length() == 0)
			v0MuUHSl = "localhost";
		try {
			final URL IpiuZwai = new URL("http", v0MuUHSl, 8080, fileName);
			final BufferedReader BrJpyEWV = new BufferedReader(new InputStreamReader(IpiuZwai.openStream()));
			final ArrayList<String> FscgCd5z = new ArrayList<String>();
			String MisQeEXG;
			if (isClient) {
				while ((MisQeEXG = BrJpyEWV.readLine()) != null)
					if (MisQeEXG.contains(macAdress))
						FscgCd5z.add(MisQeEXG);
				if (FscgCd5z.size() == 0)
					FscgCd5z.add(Messages.getString("LogDetailView.getLogFile.NoEntrysForTC", macAdress));
			} else
				while ((MisQeEXG = BrJpyEWV.readLine()) != null)
					FscgCd5z.add(MisQeEXG);
			BrJpyEWV.close();
			if (FscgCd5z.size() == 0)
				FscgCd5z.add(Messages.getString("LogDetailView.getLogFile.NoEntrys"));
			return FscgCd5z;
		} catch (final MalformedURLException uK7Xccwa) {
			uK7Xccwa.printStackTrace();
			ErrorManager.getDefault().notify(uK7Xccwa);
		} catch (final IOException qRYvMl16) {
			qRYvMl16.printStackTrace();
			ErrorManager.getDefault().notify(qRYvMl16);
		}
		return Collections.EMPTY_LIST;
	}

}