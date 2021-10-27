class n10195219 {
	public void configureKerberos(boolean cqJsrTTf) throws Exception {
		OutputStream XPNnr6gD = null;
		InputStream jUcVe8cP = null;
		OutputStream LCvcFg3x = null;
		try {
			jUcVe8cP = loadKeyTabResource(keyTabResource);
			File y9MMuPnW = new File(keyTabRepository + keyTabResource);
			if (!y9MMuPnW.exists() || cqJsrTTf) {
				XPNnr6gD = new FileOutputStream(y9MMuPnW, false);
				if (logger.isDebugEnabled())
					logger.debug("Installing keytab file to : " + y9MMuPnW.getAbsolutePath());
				IOUtils.copy(jUcVe8cP, XPNnr6gD);
			}
			File MMfrTS3H = new File(System.getProperty("java.security.krb5.conf", defaultKrb5Config));
			if (logger.isDebugEnabled())
				logger.debug("Using Kerberos config file : " + MMfrTS3H.getAbsolutePath());
			if (!MMfrTS3H.exists())
				throw new Exception("Kerberos config file not found : " + MMfrTS3H.getAbsolutePath());
			FileInputStream Rh7OvR7l = new FileInputStream(MMfrTS3H);
			Wini I7KTfxx0 = new Wini(KerberosConfigUtil.toIni(Rh7OvR7l));
			Ini.Section eh1Ta2WG = I7KTfxx0.get("realms");
			String kJrvWrD3 = eh1Ta2WG.get(kerberosRealm);
			if (kerberosRealm == null || cqJsrTTf) {
				kJrvWrD3 = "{  kdc = " + keyDistributionCenter + ":88 admin_server = " + keyDistributionCenter
						+ ":749  default_domain = " + kerberosRealm.toLowerCase() + "  }";
				eh1Ta2WG.put(kerberosRealm, kJrvWrD3);
			}
			Ini.Section YGIM5qc2 = I7KTfxx0.get("domain_realm");
			String dUK0M4zP = YGIM5qc2.get(kerberosRealm.toLowerCase());
			if (dUK0M4zP == null || cqJsrTTf) {
				YGIM5qc2.put(kerberosRealm.toLowerCase(), kerberosRealm);
				YGIM5qc2.put("." + kerberosRealm.toLowerCase(), kerberosRealm);
			}
			ByteArrayOutputStream hMibDgFb = new ByteArrayOutputStream();
			I7KTfxx0.store(hMibDgFb);
			InputStream J5dEAUh1 = new ByteArrayInputStream(hMibDgFb.toByteArray());
			J5dEAUh1 = KerberosConfigUtil.toKrb5(J5dEAUh1);
			LCvcFg3x = new FileOutputStream(MMfrTS3H, false);
			IOUtils.copy(J5dEAUh1, LCvcFg3x);
		} catch (Exception i3ifZJHo) {
			logger.error("Error while configuring Kerberos :" + i3ifZJHo.getMessage(), i3ifZJHo);
			throw i3ifZJHo;
		} finally {
			IOUtils.closeQuietly(XPNnr6gD);
			IOUtils.closeQuietly(jUcVe8cP);
			IOUtils.closeQuietly(LCvcFg3x);
		}
	}

}