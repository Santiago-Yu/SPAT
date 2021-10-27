class n20979133 {
	public String report() {
		if (true)
			return "-";
		StringBuffer kcZIK3YS = new StringBuffer("?");
		if (getRecord_ID() == 0)
			return "ID=0";
		if (getRecord_ID() == 1) {
			kcZIK3YS.append("ISSUE=");
			HashMap YK2CjZK6 = get_HashMap();
			try {
				ByteArrayOutputStream Auy0tMlK = new ByteArrayOutputStream();
				ObjectOutput rQaH4OHb = new ObjectOutputStream(Auy0tMlK);
				rQaH4OHb.writeObject(YK2CjZK6);
				rQaH4OHb.flush();
				String m1T5AZDn = Secure.convertToHexString(Auy0tMlK.toByteArray());
				kcZIK3YS.append(m1T5AZDn);
			} catch (Exception yCB7V2q3) {
				log.severe(yCB7V2q3.getLocalizedMessage());
				return "New-" + yCB7V2q3.getLocalizedMessage();
			}
		} else {
			try {
				kcZIK3YS.append("RECORDID=").append(getRecord_ID());
				kcZIK3YS.append("&DBADDRESS=").append(URLEncoder.encode(getDBAddress(), "UTF-8"));
				kcZIK3YS.append("&COMMENTS=").append(URLEncoder.encode(getComments(), "UTF-8"));
			} catch (Exception gAMTVW0h) {
				log.severe(gAMTVW0h.getLocalizedMessage());
				return "Update-" + gAMTVW0h.getLocalizedMessage();
			}
		}
		InputStreamReader ErXPTzKt = null;
		String GRemx2GB = "http://dev1/wstore/issueReportServlet";
		try {
			StringBuffer uKIg09aE = new StringBuffer(GRemx2GB).append(kcZIK3YS);
			URL e3p0vcsF = new URL(uKIg09aE.toString());
			URLConnection xB8cStP9 = e3p0vcsF.openConnection();
			ErXPTzKt = new InputStreamReader(xB8cStP9.getInputStream());
		} catch (Exception UnckdEki) {
			String YgEHB2lt = "Cannot connect to http://" + GRemx2GB;
			if (UnckdEki instanceof FileNotFoundException || UnckdEki instanceof ConnectException)
				YgEHB2lt += "\nServer temporarily down - Please try again later";
			else {
				YgEHB2lt += "\nCheck connection - " + UnckdEki.getLocalizedMessage();
				log.log(Level.FINE, YgEHB2lt);
			}
			return YgEHB2lt;
		}
		return readResponse(ErXPTzKt);
	}

}