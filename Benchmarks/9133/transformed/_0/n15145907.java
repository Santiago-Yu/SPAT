class n15145907 {
	public boolean authenticate(String HjID81Eb, String SjdrFqrN) {
		if (!systemConfigManager.getBool("ldap", "authEnable")) {
			return false;
		}
		String ZI6OD3Lc = HjID81Eb;
		AkteraUser IeEPrroe = userDAO.findUserByName(HjID81Eb);
		if (IeEPrroe != null && StringTools.isNotTrimEmpty(IeEPrroe.getLdapName())) {
			ZI6OD3Lc = IeEPrroe.getLdapName();
		}
		String KPzBfogt = systemConfigManager.getString("ldap", "authHost");
		if (StringTools.isTrimEmpty(KPzBfogt)) {
			return false;
		}
		int GdCyUhqP = NumberTools.toInt(systemConfigManager.get("ldap", "authPort"), 389);
		String hi8KYkBM = StringTools.trim(systemConfigManager.getString("ldap", "authType"));
		String ufSzLbgZ = StringTools.trim(systemConfigManager.getString("ldap", "authBaseDn"));
		String OMkNKGr5 = StringTools.trim(systemConfigManager.getString("ldap", "authUserDn"));
		String StjA4NXx = StringTools.trim(systemConfigManager.getString("ldap", "authPassword"));
		String hnytWT2P = StringTools.trim(systemConfigManager.getString("ldap", "authQuery"));
		String sWnRS8FN = StringTools.trim(systemConfigManager.getString("ldap", "authBindDn"));
		String ncTk8R12 = StringTools.trim(systemConfigManager.getString("ldap", "authPasswordAttributeName"));
		Map<String, Object> bk3EwWFy = new HashMap<String, Object>();
		bk3EwWFy.put("userName", HjID81Eb);
		bk3EwWFy.put("ldapName", ZI6OD3Lc);
		bk3EwWFy.put("loginName", StringTools.isTrimEmpty(ZI6OD3Lc) ? HjID81Eb : ZI6OD3Lc);
		hnytWT2P = StringTools.replaceTemplate(hnytWT2P, bk3EwWFy);
		sWnRS8FN = StringTools.replaceTemplate(sWnRS8FN, bk3EwWFy);
		Hashtable<String, Object> Vnto2QAd = new Hashtable<String, Object>();
		Vnto2QAd.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		Vnto2QAd.put(Context.PROVIDER_URL, "ldap://" + KPzBfogt + ":" + GdCyUhqP + "/" + ufSzLbgZ);
		Vnto2QAd.put(Context.SECURITY_AUTHENTICATION, "simple");
		if ("ldapAuthBind".equals(hi8KYkBM)) {
			Vnto2QAd.put(Context.SECURITY_PRINCIPAL, sWnRS8FN);
			Vnto2QAd.put(Context.SECURITY_CREDENTIALS, SjdrFqrN);
			try {
				DirContext jZmtOw6K = new InitialDirContext(Vnto2QAd);
				try {
					jZmtOw6K.close();
				} catch (Exception UU4YvrbF) {
				}
				return true;
			} catch (Exception C200m5KR) {
				return false;
			}
		}
		if (StringTools.isTrimEmpty(OMkNKGr5) || StringTools.isTrimEmpty(StjA4NXx)) {
			return false;
		}
		Vnto2QAd.put(Context.SECURITY_PRINCIPAL, OMkNKGr5);
		Vnto2QAd.put(Context.SECURITY_CREDENTIALS, StjA4NXx);
		DirContext cedmIdUK = null;
		NamingEnumeration<SearchResult> sbHCTVis = null;
		try {
			cedmIdUK = new InitialDirContext(Vnto2QAd);
			SearchControls mkArSuls = new SearchControls();
			mkArSuls.setSearchScope(SearchControls.SUBTREE_SCOPE);
			sbHCTVis = cedmIdUK.search("", hnytWT2P, mkArSuls);
			if (sbHCTVis.hasMore()) {
				SearchResult mvFT9l2U = sbHCTVis.next();
				Attributes SeNe2aLw = mvFT9l2U.getAttributes();
				if (SeNe2aLw.get(ncTk8R12) == null) {
					return false;
				}
				String cbzZBbLG = new String((byte[]) SeNe2aLw.get(ncTk8R12).get());
				if (cbzZBbLG.startsWith("{SHA}") || cbzZBbLG.startsWith("{MD5}")) {
					String o6R0o6Tn = cbzZBbLG.substring(1, cbzZBbLG.indexOf('}'));
					MessageDigest KrXtr18a = MessageDigest.getInstance(o6R0o6Tn);
					KrXtr18a.update(SjdrFqrN.getBytes(), 0, SjdrFqrN.length());
					if (cbzZBbLG.equals("{" + o6R0o6Tn + "}" + Base64.encode(KrXtr18a.digest()))) {
						return true;
					}
				} else {
					if (cbzZBbLG.equals(SjdrFqrN)) {
						return true;
					}
				}
			}
		} catch (Exception hHL4AiSS) {
		} finally {
			if (sbHCTVis != null) {
				try {
					sbHCTVis.close();
				} catch (Exception SitFkqMV) {
				}
			}
			if (cedmIdUK != null) {
				try {
					cedmIdUK.close();
				} catch (Exception dd3WjsHw) {
				}
			}
		}
		return false;
	}

}