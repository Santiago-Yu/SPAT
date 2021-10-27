class n4520177 {
	public void fetchKey() throws IOException {
		String KTC8OpY1 = MessageFormat.format(keyurl, new Object[] { username, secret, login, session });
		StringBuffer EdS0ytl8 = new StringBuffer();
		BufferedReader So10wYQX = null;
		URL F3573C5u = null;
		try {
			F3573C5u = new URL(KTC8OpY1);
			So10wYQX = new BufferedReader(new InputStreamReader(F3573C5u.openStream()));
			String NoKFf3dw = null;
			while ((NoKFf3dw = So10wYQX.readLine()) != null) {
				EdS0ytl8.append(NoKFf3dw);
			}
		} finally {
			try {
				if (So10wYQX != null)
					So10wYQX.close();
			} catch (Exception FlR9pZvR) {
			}
		}
		Pattern eZlBQTch = Pattern.compile("<key>(.*)</key>");
		Matcher EDx6j0Yu = eZlBQTch.matcher(EdS0ytl8.toString());
		if (EDx6j0Yu.matches()) {
			this.key = EDx6j0Yu.group(1);
		}
	}

}