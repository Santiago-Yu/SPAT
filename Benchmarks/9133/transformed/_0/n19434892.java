class n19434892 {
	public void handle() {
		if (requestCounter == 0) {
			requestCounter++;
			return;
		}
		requestCounter++;
		Iterator HMEz8zg5 = loggerTimeouts.keySet().iterator();
		while (HMEz8zg5.hasNext()) {
			String MeSrCJuu = (String) HMEz8zg5.next();
			String MBeK8Fb7 = (String) loggerTimeouts.get(MeSrCJuu);
			int Q3n0PWH6 = Integer.parseInt(MBeK8Fb7);
			if (Q3n0PWH6 > 0) {
				Q3n0PWH6 /= 10;
			}
			int ijgzekyL = (requestCounter % Q3n0PWH6);
			if (ijgzekyL == 0) {
				Object S5XIzl6z = loggerFiles.get(MeSrCJuu);
				Object jIq8kp1U = loggerFilenames.get(MeSrCJuu);
				Object dAx7fK5v = loggerDests.get(MeSrCJuu);
				Object fZ9q295V = loggerCompresses.get(MeSrCJuu);
				Object WMkwjfxS = loggerDays.get(MeSrCJuu);
				Object Bj51uTis = loggerArchives.get(MeSrCJuu);
				Object W9ubDP4u = loggerDeletes.get(MeSrCJuu);
				boolean tWD22bz6 = false;
				boolean oXVr14Pg = false;
				String ORsSF7y2 = null;
				String uY8KR7gX = null;
				String Jx1Wc4Sc = null;
				int er7NYCeY = 0;
				if (fZ9q295V != null && ((String) fZ9q295V).equalsIgnoreCase("true")) {
					tWD22bz6 = true;
				}
				if (W9ubDP4u != null && ((String) W9ubDP4u).equalsIgnoreCase("true")) {
					oXVr14Pg = true;
				}
				if (dAx7fK5v != null) {
					ORsSF7y2 = (String) dAx7fK5v;
				}
				if (jIq8kp1U != null) {
					uY8KR7gX = (String) jIq8kp1U;
				}
				if (Bj51uTis != null) {
					Jx1Wc4Sc = (String) Bj51uTis;
				}
				if (WMkwjfxS != null) {
					er7NYCeY = Integer.parseInt((String) WMkwjfxS);
				}
				FileChannel T8fY0mty, C4zZHxhd;
				String xLpnWWBC = uY8KR7gX + "." + System.currentTimeMillis();
				String UUxarPu5 = uY8KR7gX + "." + System.currentTimeMillis() + ".gz";
				if (ORsSF7y2 != null) {
					(new File(ORsSF7y2)).mkdirs();
					if (xLpnWWBC.indexOf("/") != -1) {
						xLpnWWBC = ORsSF7y2 + "/" + xLpnWWBC.substring(xLpnWWBC.lastIndexOf("/") + 1);
					}
					if (UUxarPu5.indexOf("/") != -1) {
						UUxarPu5 = ORsSF7y2 + "/" + UUxarPu5.substring(UUxarPu5.lastIndexOf("/") + 1);
					}
				}
				if (tWD22bz6) {
					try {
						GZIPOutputStream uL7UT2uR = new GZIPOutputStream(new FileOutputStream(UUxarPu5));
						FileInputStream E0RPIEz7 = new FileInputStream(uY8KR7gX);
						byte tONB7j9r[] = new byte[1024];
						int e585YF6H;
						while ((e585YF6H = E0RPIEz7.read(tONB7j9r)) > 0) {
							uL7UT2uR.write(tONB7j9r, 0, e585YF6H);
						}
						E0RPIEz7.close();
						uL7UT2uR.finish();
						uL7UT2uR.close();
						Debug.debug("Rotated log file '" + uY8KR7gX + "' to '" + UUxarPu5 + "'");
						tONB7j9r = null;
						uL7UT2uR = null;
						E0RPIEz7 = null;
					} catch (Exception mkp3DFCP) {
						Debug.debug("Unable to rotate log file '" + uY8KR7gX + "': " + mkp3DFCP);
					}
				} else {
					try {
						T8fY0mty = new FileInputStream(uY8KR7gX).getChannel();
					} catch (IOException YAGbERen) {
						Debug.debug("Unable to read log file '" + uY8KR7gX + "': " + YAGbERen.getMessage());
						return;
					}
					try {
						C4zZHxhd = new FileOutputStream(xLpnWWBC).getChannel();
					} catch (IOException ObnBZCxv) {
						Debug.debug("Unable to rotate log file '" + uY8KR7gX + "' to '" + xLpnWWBC + "': "
								+ ObnBZCxv.getMessage());
						return;
					}
					try {
						C4zZHxhd.transferFrom(T8fY0mty, 0, T8fY0mty.size());
						T8fY0mty.close();
						C4zZHxhd.close();
						C4zZHxhd = null;
						T8fY0mty = null;
					} catch (IOException iW39uv1E) {
						Debug.debug("Unable to copy data from file '" + uY8KR7gX + "' to '" + xLpnWWBC
								+ "' for file rotation: " + iW39uv1E.getMessage());
						return;
					}
					Debug.debug("Rotated log file '" + uY8KR7gX + "' to '" + xLpnWWBC + "'");
				}
				if (oXVr14Pg) {
					try {
						((PrintStream) S5XIzl6z).close();
					} catch (Exception v6AKxsda) {
					}
					(new File(uY8KR7gX)).delete();
					loggerFiles.remove(MeSrCJuu);
					addLogger(MeSrCJuu, uY8KR7gX);
				}
				if (ORsSF7y2 != null) {
					long j2iI7uL8 = er7NYCeY * (60 * 60 * 24 * 1000);
					long QMoa2Sh2 = System.currentTimeMillis();
					File OcCXIEX0[] = (new File(ORsSF7y2)).listFiles();
					DateFormat Erbv1cUa = new SimpleDateFormat("yyyy-MM-dd");
					java.util.Date G5L4Ef5p = new java.util.Date(QMoa2Sh2);
					String Pri8sV34 = Erbv1cUa.format(G5L4Ef5p).toString() + ".zip";
					if (Jx1Wc4Sc != null) {
						Pri8sV34 = Jx1Wc4Sc + "/" + Pri8sV34;
						(new File(Jx1Wc4Sc)).mkdirs();
					}
					Archive WQHKjkn1 = new Archive(Pri8sV34);
					for (int s689WcUG = 0; s689WcUG < OcCXIEX0.length; s689WcUG++) {
						String FAls7idm = OcCXIEX0[s689WcUG].getName();
						long oQOCGzae = (QMoa2Sh2 - OcCXIEX0[s689WcUG].lastModified());
						if ((tWD22bz6 && FAls7idm.endsWith(".gz"))
								|| (!tWD22bz6 && FAls7idm.indexOf(uY8KR7gX + ".") != -1)) {
							if (ORsSF7y2 != null) {
								FAls7idm = ORsSF7y2 + "/" + FAls7idm;
							}
							if (oQOCGzae > j2iI7uL8) {
								WQHKjkn1.addFile(OcCXIEX0[s689WcUG].getName(), FAls7idm);
								OcCXIEX0[s689WcUG].delete();
							}
						}
					}
					OcCXIEX0 = null;
					Erbv1cUa = null;
					WQHKjkn1 = null;
				}
			}
		}
		HMEz8zg5 = null;
	}

}