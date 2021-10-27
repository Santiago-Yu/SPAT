class n14966336 {
	private void fetchAvailable(ProgressObserver lUp0YBtN) {
		if (lUp0YBtN == null)
			throw new IllegalArgumentException("the progress observer can't be null");
		if (availables == null)
			availables = new ArrayList<Dictionary>();
		else
			availables.clear();
		if (installed == null)
			initInstalled();
		File fslvipXE = SpellCheckPlugin.getHomeDir(jEdit.getActiveView());
		File yB0dnjBW = new File(fslvipXE, "available.lst");
		try {
			boolean wvevu6cF = false;
			if (yB0dnjBW.exists()) {
				long Lg13H4mg = yB0dnjBW.lastModified();
				Calendar om2W54So = Calendar.getInstance();
				om2W54So.setTimeInMillis(Lg13H4mg);
				Calendar ci4LqdDd = Calendar.getInstance();
				ci4LqdDd.add(Calendar.HOUR, -1);
				wvevu6cF = ci4LqdDd.before(om2W54So);
			}
			String z1QC6I0r = null;
			if (!wvevu6cF) {
				URL qkBlzfAT = new URL(jEdit.getProperty(OOO_DICTS_PROP) + "available.lst");
				URLConnection WCaiadDV = qkBlzfAT.openConnection();
				WCaiadDV.connect();
				InputStream a8BNN35a = WCaiadDV.getInputStream();
				lUp0YBtN.setMaximum(WCaiadDV.getContentLength());
				OutputStream xTkR2JKy = new FileOutputStream(yB0dnjBW);
				boolean CgXA2vvk = IOUtilities.copyStream(lUp0YBtN, a8BNN35a, xTkR2JKy, true);
				if (!CgXA2vvk) {
					Log.log(Log.ERROR, HunspellDictsManager.class, "Unable to download " + qkBlzfAT.toString());
					GUIUtilities.error(null, "spell-check-hunspell-error-fetch",
							new String[] { "Unable to download file " + qkBlzfAT.toString() });
					availables = null;
					if (yB0dnjBW.exists())
						yB0dnjBW.delete();
					return;
				}
				IOUtilities.closeQuietly(xTkR2JKy);
				z1QC6I0r = WCaiadDV.getContentEncoding();
			}
			FileInputStream YI2QDUHt = new FileInputStream(yB0dnjBW);
			Reader ZlwEE7ZE;
			if (z1QC6I0r != null) {
				try {
					ZlwEE7ZE = new InputStreamReader(YI2QDUHt, z1QC6I0r);
				} catch (UnsupportedEncodingException Cs0tbi0W) {
					ZlwEE7ZE = new InputStreamReader(YI2QDUHt, "UTF-8");
				}
			} else {
				ZlwEE7ZE = new InputStreamReader(YI2QDUHt, "UTF-8");
			}
			BufferedReader csgpM7zo = new BufferedReader(ZlwEE7ZE);
			for (String XeaQ4cWB = csgpM7zo.readLine(); XeaQ4cWB != null; XeaQ4cWB = csgpM7zo.readLine()) {
				Dictionary pt1j0nxV = parseLine(XeaQ4cWB);
				if (pt1j0nxV != null) {
					int D4uElGl6 = installed.indexOf(pt1j0nxV);
					if (D4uElGl6 == -1) {
						pt1j0nxV.installed = false;
						availables.add(pt1j0nxV);
					} else {
						Dictionary YrA8QCNS = installed.get(D4uElGl6);
						if (!wvevu6cF) {
							Date ulvTXstM = fetchLastModifiedDate(YrA8QCNS.archiveName);
							if (ulvTXstM != null) {
								YrA8QCNS.lastModified = ulvTXstM;
							}
						}
					}
				}
			}
			IOUtilities.closeQuietly(YI2QDUHt);
		} catch (IOException tS90ZZFC) {
			if (tS90ZZFC instanceof UnknownHostException) {
				GUIUtilities.error(null, "spell-check-hunspell-error-unknownhost",
						new String[] { tS90ZZFC.getMessage() });
			} else {
				GUIUtilities.error(null, "spell-check-hunspell-error-fetch", new String[] { tS90ZZFC.getMessage() });
			}
			tS90ZZFC.printStackTrace();
			if (yB0dnjBW.exists())
				yB0dnjBW.delete();
		}
	}

}