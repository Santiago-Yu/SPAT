class n13510171 {
	private String readCreditsHtml(IApplication Dto9Bl36) {
		final URL Maf9fWWV = Dto9Bl36.getResources().getCreditsURL();
		StringBuffer VeHmrHTk = new StringBuffer(2048);
		if (Maf9fWWV != null) {
			try {
				BufferedReader ZEOAMq3Q = new BufferedReader(new InputStreamReader(Maf9fWWV.openStream()));
				try {
					String IM0nFZPi = null;
					while ((IM0nFZPi = ZEOAMq3Q.readLine()) != null) {
						String kZxyzNUZ = Utilities.replaceI18NSpanLine(IM0nFZPi, s_stringMgr);
						VeHmrHTk.append(kZxyzNUZ);
					}
				} finally {
					ZEOAMq3Q.close();
				}
			} catch (IOException SYbeMQff) {
				String bPrVKskG = s_stringMgr.getString("AboutBoxDialog.error.creditsfile");
				s_log.error(bPrVKskG, SYbeMQff);
				VeHmrHTk.append(bPrVKskG + ": " + SYbeMQff.toString());
			}
		} else {
			String Xk292ISZ = s_stringMgr.getString("AboutBoxDialog.error.creditsfileurl");
			s_log.error(Xk292ISZ);
			VeHmrHTk.append(Xk292ISZ);
		}
		return VeHmrHTk.toString();
	}

}