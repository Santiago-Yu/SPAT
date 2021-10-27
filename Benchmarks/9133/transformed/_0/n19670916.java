class n19670916 {
	private void pushResource(String MHBsjtwu, String fOg2vxwh, String Kh45A4GN, List<String> HYmAzThq)
			throws IOException {
		String q5A8Ok4b = "http://" + MHBsjtwu + "/upload";
		HttpURLConnection F1eczVmK = null;
		DataOutputStream TNez13bk = null;
		FileInputStream Y0KluQCi = null;
		String XKVfwc03 = "\r\n";
		String Q0R76iu8 = "--";
		String yusBLvDG = "232404jkg4220957934FW";
		int INHrot7H, CT4I95vZ, PuD1vttJ;
		byte[] lwJ9r0nr;
		int LyCl6TGE = 1 * 1024 * 1024;
		try {
			File XEHifXKZ = new File(Kh45A4GN);
			if (!XEHifXKZ.exists()) {
				LOG.error("JTellaAdapter: Resource file could not be found for push: " + Kh45A4GN);
				return;
			}
			List<File> abbgjMG9 = new ArrayList<File>();
			for (String a07SuiY3 : HYmAzThq) {
				File dTGHQhqc = new File(a07SuiY3);
				if (!dTGHQhqc.exists()) {
					LOG.error("JTellaAdapter: Attachment file could not be found for push: " + a07SuiY3);
					return;
				}
				abbgjMG9.add(dTGHQhqc);
			}
			LOG.debug("JTellaAdapter: Initiating push to: " + q5A8Ok4b);
			URL VSOd3q9s = new URL(q5A8Ok4b);
			F1eczVmK = (HttpURLConnection) VSOd3q9s.openConnection();
			F1eczVmK.setDoInput(true);
			F1eczVmK.setDoOutput(true);
			F1eczVmK.setUseCaches(false);
			F1eczVmK.setRequestMethod("POST");
			F1eczVmK.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + yusBLvDG);
			F1eczVmK.setRequestProperty("Connection", "Keep-Alive");
			F1eczVmK.setRequestProperty("User-Agent", "UP2P");
			F1eczVmK.setRequestProperty("Accept", "[star]/[star]");
			TNez13bk = new DataOutputStream(F1eczVmK.getOutputStream());
			TNez13bk.writeBytes(Q0R76iu8 + yusBLvDG + XKVfwc03);
			TNez13bk.writeBytes("Content-Disposition: form-data; name=\"up2p:community\"" + XKVfwc03 + XKVfwc03);
			TNez13bk.writeBytes(fOg2vxwh + XKVfwc03);
			TNez13bk.writeBytes(Q0R76iu8 + yusBLvDG + XKVfwc03);
			TNez13bk.writeBytes("Content-Disposition: form-data; name=\"up2p:pushupload\"" + XKVfwc03 + XKVfwc03
					+ "true" + XKVfwc03);
			TNez13bk.writeBytes(Q0R76iu8 + yusBLvDG + XKVfwc03);
			boolean kOHXHPVu = false;
			boolean FT0V6KQv = false;
			File E5pJIs0U = null;
			while (!kOHXHPVu) {
				if (!FT0V6KQv) {
					E5pJIs0U = XEHifXKZ;
				} else {
					E5pJIs0U = abbgjMG9.remove(0);
				}
				LOG.debug("JTellaAdapter: PUSHing file: " + E5pJIs0U.getAbsolutePath());
				TNez13bk.writeBytes("Content-Disposition: form-data; name=\"up2p:filename\";" + " filename=\""
						+ E5pJIs0U.getName() + "\"" + XKVfwc03);
				TNez13bk.writeBytes(XKVfwc03);
				Y0KluQCi = new FileInputStream(E5pJIs0U);
				CT4I95vZ = Y0KluQCi.available();
				PuD1vttJ = Math.min(CT4I95vZ, LyCl6TGE);
				lwJ9r0nr = new byte[PuD1vttJ];
				INHrot7H = Y0KluQCi.read(lwJ9r0nr, 0, PuD1vttJ);
				while (INHrot7H > 0) {
					TNez13bk.write(lwJ9r0nr, 0, PuD1vttJ);
					CT4I95vZ = Y0KluQCi.available();
					PuD1vttJ = Math.min(CT4I95vZ, LyCl6TGE);
					INHrot7H = Y0KluQCi.read(lwJ9r0nr, 0, PuD1vttJ);
				}
				TNez13bk.writeBytes(XKVfwc03);
				if (abbgjMG9.isEmpty()) {
					TNez13bk.writeBytes(Q0R76iu8 + yusBLvDG + Q0R76iu8 + XKVfwc03);
				} else {
					TNez13bk.writeBytes(Q0R76iu8 + yusBLvDG + XKVfwc03);
				}
				FT0V6KQv = true;
				if (abbgjMG9.isEmpty()) {
					kOHXHPVu = true;
				}
			}
			BufferedReader Kvcp0In0 = new BufferedReader(new InputStreamReader(F1eczVmK.getInputStream()));
			while (Kvcp0In0.readLine() != null)
				;
			Kvcp0In0.close();
			LOG.debug("JTellaAdapter: Push upload was succesful.");
		} catch (MalformedURLException boyNZgIk) {
			LOG.error("JTellaAdapter: pushResource Malformed URL: " + boyNZgIk);
			throw new IOException("pushResource failed for URL: " + q5A8Ok4b);
		} catch (IOException CqLMyEdN) {
			LOG.error("JTellaAdapter: pushResource IOException: " + CqLMyEdN);
			throw new IOException("pushResource failed for URL: " + q5A8Ok4b);
		} finally {
			try {
				if (Y0KluQCi != null) {
					Y0KluQCi.close();
				}
				if (TNez13bk != null) {
					TNez13bk.flush();
				}
				if (TNez13bk != null) {
					TNez13bk.close();
				}
				if (F1eczVmK != null) {
					F1eczVmK.disconnect();
				}
			} catch (IOException Wf8xDBo1) {
				LOG.error("JTellaAdapter: pushResource failed to close connection streams.");
			}
		}
	}

}