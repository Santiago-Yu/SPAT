class n2099971 {
	public static void download(String pLTgzpYH[], boolean AqOZTi3H) {
		if (pLTgzpYH.length < 1) {
			System.err.println("usage: java copyURL URL [LocalFile]");
			System.exit(1);
		}
		try {
			String gqPiB8yP = pLTgzpYH[1];
			File uA9E3EKs = new File(gqPiB8yP);
			String o9WMiIsH = gqPiB8yP.substring(gqPiB8yP.length() - 4);
			String bRLc7xzC = gqPiB8yP.substring(0, gqPiB8yP.length() - 4);
			System.out.println("Name is:" + bRLc7xzC);
			System.out.println("Ext. is:" + o9WMiIsH);
			if (!AqOZTi3H) {
				while (uA9E3EKs.canRead()) {
					bRLc7xzC += "-";
					uA9E3EKs = new File(bRLc7xzC + o9WMiIsH);
				}
				pLTgzpYH[1] = bRLc7xzC + o9WMiIsH;
			} else {
				uA9E3EKs = new File(bRLc7xzC + o9WMiIsH);
				uA9E3EKs.delete();
				uA9E3EKs = new File(bRLc7xzC + o9WMiIsH + ".tmp");
				uA9E3EKs.delete();
			}
			pLTgzpYH[1] = bRLc7xzC + o9WMiIsH;
			String wWcaGVAP = pLTgzpYH[0];
			if (wWcaGVAP.contains("download.php") && wWcaGVAP.contains("cpc-live.com")) {
				String dA1aiG4X = "http://cpc-live.com/data/";
				while (!wWcaGVAP.startsWith("type=")) {
					wWcaGVAP = wWcaGVAP.substring((1));
				}
				wWcaGVAP = wWcaGVAP.replace("type=", "");
				while (!wWcaGVAP.startsWith("&")) {
					dA1aiG4X += wWcaGVAP.charAt(0);
					wWcaGVAP = wWcaGVAP.substring(1);
				}
				while (!wWcaGVAP.startsWith("fichier=")) {
					wWcaGVAP = wWcaGVAP.substring((1));
				}
				wWcaGVAP = wWcaGVAP.replace("fichier=", "");
				dA1aiG4X += "/" + wWcaGVAP;
				wWcaGVAP = dA1aiG4X;
			}
			wWcaGVAP = wWcaGVAP.replace(" ", "%20");
			wWcaGVAP = wWcaGVAP.replace("(", "%28");
			wWcaGVAP = wWcaGVAP.replace(")", "%29");
			wWcaGVAP = wWcaGVAP.replace("[", "%5B");
			wWcaGVAP = wWcaGVAP.replace("]", "%5D");
			URL CWGzHg7f = new URL(wWcaGVAP);
			System.out.println("Opening connection to " + wWcaGVAP + "...");
			HttpURLConnection G8mS5hS9 = (HttpURLConnection) CWGzHg7f.openConnection();
			G8mS5hS9.setRequestMethod("GET");
			BufferedInputStream FF3KUBdo = new BufferedInputStream(CWGzHg7f.openStream());
			int TiubIWSY = 0;
			try {
				System.out.print("Copying resource (type: " + G8mS5hS9.getContentType());
				Date fj8BMJTG = new Date(G8mS5hS9.getLastModified());
				int kPTOpQk2 = G8mS5hS9.getContentLength();
				System.out.println(", modified on: " + fj8BMJTG.toString() + ")...");
				System.out.flush();
				TiubIWSY = 0;
				BufferedOutputStream AvrXCa4M = null;
				try {
					if (pLTgzpYH.length < 2) {
						String aQuKgAcK = null;
						StringTokenizer xfdGMs1g = new StringTokenizer(CWGzHg7f.getFile(), "/");
						while (xfdGMs1g.hasMoreTokens()) {
							aQuKgAcK = xfdGMs1g.nextToken();
						}
						AvrXCa4M = new BufferedOutputStream(new FileOutputStream(aQuKgAcK));
					} else {
						AvrXCa4M = new BufferedOutputStream(new FileOutputStream(pLTgzpYH[1] + ".tmp"));
					}
					byte[] X7oDNAtM = new byte[BUFSIZE];
					int pZFplpab = 0;
					while (pZFplpab >= 0) {
						pZFplpab = FF3KUBdo.read(X7oDNAtM);
						if (pZFplpab > 0) {
							AvrXCa4M.write(X7oDNAtM, 0, pZFplpab);
						}
						TiubIWSY = TiubIWSY + pZFplpab;
					}
				} finally {
					AvrXCa4M.close();
				}
			} finally {
				FF3KUBdo.close();
			}
			File NDhvukrU = new File(pLTgzpYH[1] + ".tmp");
			File l8fbJgk7 = new File(pLTgzpYH[1]);
			NDhvukrU.renameTo(l8fbJgk7);
			System.out.println("\n" + TiubIWSY + " byte(s) copied");
			if (AqOZTi3H) {
				CPC.download = true;
			}
		} catch (MalformedURLException AEAjTvzZ) {
			AEAjTvzZ.printStackTrace();
		} catch (IOException efPPdwmB) {
			efPPdwmB.printStackTrace();
		}
	}

}