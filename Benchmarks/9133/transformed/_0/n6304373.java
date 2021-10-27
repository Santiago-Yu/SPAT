class n6304373 {
	public static String uploadOrDeleteMediaOrTemplates(String ltFMgumi, String TkVaSH2T, String TVTNI2kD,
			HttpServletRequest Qlo54yJB, HttpSession fpCY70z0) {
		FTPClient i2HiR1UC = new FTPClient();
		CofaxToolsUser CcbRiu8l = (CofaxToolsUser) fpCY70z0.getAttribute("user");
		StringBuffer b35EmQxS = new StringBuffer();
		StringBuffer NXyuVjQ7 = new StringBuffer();
		String pKJCkfHh = "";
		String rndcvbw9 = "";
		String kUntPTW5 = "";
		String pYyZJDjw = "";
		String bG3ya56S = CofaxToolsServlet.fileTransferFolder;
		String vjjqlUdP = "";
		ArrayList woJloVNg = new ArrayList();
		StringBuffer LerCZ54g = new StringBuffer();
		LerCZ54g.append("Status:<BR>");
		if (ltFMgumi.equals("Upload")) {
			rndcvbw9 = (String) CcbRiu8l.workingPubConfigElementsHash.get("TESTFTPSERVER");
			kUntPTW5 = (String) CcbRiu8l.workingPubConfigElementsHash.get("TESTFTPLOGIN");
			pYyZJDjw = (String) CcbRiu8l.workingPubConfigElementsHash.get("TESTFTPPASSWORD");
			if (TkVaSH2T.equals("Media")) {
				pKJCkfHh = (String) CcbRiu8l.workingPubConfigElementsHash.get("TESTIMAGESFOLDER");
			}
			if (TkVaSH2T.equals("Templates")) {
				pKJCkfHh = (String) CcbRiu8l.workingPubConfigElementsHash.get("TESTTEMPLATEFOLDER");
			}
		}
		if (ltFMgumi.equals("Delete")) {
			kUntPTW5 = (String) CcbRiu8l.workingPubConfigElementsHash.get("LIVEFTPLOGIN");
			pYyZJDjw = (String) CcbRiu8l.workingPubConfigElementsHash.get("LIVEFTPPASSWORD");
			if (TkVaSH2T.equals("Media")) {
				rndcvbw9 = (String) CcbRiu8l.workingPubConfigElementsHash.get("LIVEIMAGESSERVER");
				pKJCkfHh = (String) CcbRiu8l.workingPubConfigElementsHash.get("LIVEIMAGESFOLDER");
			}
			if (TkVaSH2T.equals("Templates")) {
				rndcvbw9 = (String) CcbRiu8l.workingPubConfigElementsHash.get("LIVEFTPSERVER");
				pKJCkfHh = (String) CcbRiu8l.workingPubConfigElementsHash.get("LIVETEMPLATEFOLDER");
			}
		}
		ArrayList sLnQQ8W3 = new ArrayList();
		int Ygfn6bbO = Integer.parseInt(TVTNI2kD);
		for (int MZbEiLkQ = 0; MZbEiLkQ < Ygfn6bbO; MZbEiLkQ++) {
			String xRdOBNJh = String.valueOf(MZbEiLkQ);
			String W7k8GXMv = Qlo54yJB.getParameter(xRdOBNJh);
			if (W7k8GXMv != null) {
				sLnQQ8W3.add(W7k8GXMv);
			}
		}
		if (ltFMgumi.equals("Upload")) {
			try {
				int gsglsg5W;
				i2HiR1UC.connect(rndcvbw9);
				CofaxToolsUtil.log(i2HiR1UC.getReplyString());
				gsglsg5W = i2HiR1UC.getReplyCode();
				if (!FTPReply.isPositiveCompletion(gsglsg5W)) {
					i2HiR1UC.disconnect();
					return ("FTP server refused connection.");
				} else {
					i2HiR1UC.login(kUntPTW5, pYyZJDjw);
				}
				for (int uKaEuRIa = 0; uKaEuRIa < sLnQQ8W3.size(); uKaEuRIa++) {
					String NPiDxrur = (String) sLnQQ8W3.get(uKaEuRIa);
					String WHexS74D = stripName(NPiDxrur);
					NPiDxrur = stripPath(NPiDxrur);
					try {
						i2HiR1UC.changeWorkingDirectory(WHexS74D);
						OutputStream C4fOlg8G;
						C4fOlg8G = new FileOutputStream(bG3ya56S + NPiDxrur);
						i2HiR1UC.retrieveFile(NPiDxrur, C4fOlg8G);
						CofaxToolsUtil.log("CofaxToolsFTP uploadOrDeleteMediaOrTemplates retrieving file: "
								+ i2HiR1UC.getReplyString());
						LerCZ54g.append("Retrieving file " + NPiDxrur + " to local disk.<BR>");
						C4fOlg8G.close();
					} catch (java.io.IOException Hvam0dRU) {
						return ("CofaxToolsFTP uploadOrDeleteMediaOrTemplates ERROR: cannot write file" + Hvam0dRU);
					}
				}
				i2HiR1UC.logout();
				i2HiR1UC.disconnect();
			} catch (IOException i1UdQnAt) {
				CofaxToolsUtil.log(
						"CofaxToolsFTP uploadOrDeleteMediaOrTemplates ERROR: Could not connect to server: " + i1UdQnAt);
				return ("Could not connect to server: " + i1UdQnAt);
			}
			kUntPTW5 = (String) CcbRiu8l.workingPubConfigElementsHash.get("LIVEFTPLOGIN");
			pYyZJDjw = (String) CcbRiu8l.workingPubConfigElementsHash.get("LIVEFTPPASSWORD");
			if (TkVaSH2T.equals("Media")) {
				rndcvbw9 = (String) CcbRiu8l.workingPubConfigElementsHash.get("LIVEIMAGESSERVER");
				vjjqlUdP = (String) CcbRiu8l.workingPubConfigElementsHash.get("LIVEIMAGESFOLDER");
			}
			if (TkVaSH2T.equals("Templates")) {
				rndcvbw9 = (String) CcbRiu8l.workingPubConfigElementsHash.get("LIVEFTPSERVER");
				vjjqlUdP = (String) CcbRiu8l.workingPubConfigElementsHash.get("LIVETEMPLATEFOLDER");
			}
			woJloVNg = splitServers(rndcvbw9);
			for (int oDN8xcDC = 0; oDN8xcDC < woJloVNg.size(); oDN8xcDC++) {
				try {
					int BM3skfHx;
					String bPSPpIAx = (String) woJloVNg.get(oDN8xcDC);
					i2HiR1UC.connect(bPSPpIAx);
					CofaxToolsUtil.log(i2HiR1UC.getReplyString());
					BM3skfHx = i2HiR1UC.getReplyCode();
					if (!FTPReply.isPositiveCompletion(BM3skfHx)) {
						i2HiR1UC.disconnect();
						CofaxToolsUtil
								.log("CofaxToolsFTP uploadOrDeleteMediaOrTemplates ERROR: server refused connection: "
										+ bPSPpIAx);
						return ("CofaxToolsFTP uploadOrDeleteMediaOrTemplates FTP server refused connection.");
					} else {
						i2HiR1UC.login(kUntPTW5, pYyZJDjw);
					}
					for (int MwoMoh7c = 0; MwoMoh7c < sLnQQ8W3.size(); MwoMoh7c++) {
						String o6ki97tq = (String) sLnQQ8W3.get(MwoMoh7c);
						CofaxToolsUtil.log("Original String " + o6ki97tq);
						CofaxToolsUtil.log("Search for " + pKJCkfHh);
						CofaxToolsUtil.log("Replace " + vjjqlUdP);
						String sBtd6XdX = CofaxToolsUtil.replace(o6ki97tq, pKJCkfHh, vjjqlUdP);
						CofaxToolsUtil.log("Results: " + sBtd6XdX);
						sBtd6XdX = stripName(sBtd6XdX);
						o6ki97tq = stripPath(o6ki97tq);
						try {
							InputStream H9rshRiU;
							H9rshRiU = new FileInputStream(bG3ya56S + o6ki97tq);
							CofaxToolsUtil.log("Reading file : " + bG3ya56S + o6ki97tq);
							boolean OGt4y2nC = i2HiR1UC.changeWorkingDirectory(sBtd6XdX);
							if (OGt4y2nC == false) {
								CofaxToolsUtil.log("CofaxToolsFTP uploadOrDeleteMediaOrTemplates directory: " + sBtd6XdX
										+ " does not exist. Attempting to create.");
								LerCZ54g.append(
										"Directory: " + sBtd6XdX + " does not exist. Attempting to create.<BR>");
								boolean PELhmex7 = i2HiR1UC.makeDirectory(sBtd6XdX);
								CofaxToolsUtil.log("CofaxToolsFTP uploadOrDeleteMediaOrTemplates results: " + PELhmex7);
								LerCZ54g.append("Results: " + PELhmex7 + "<BR>");
							}
							boolean QIcfORmW = i2HiR1UC.storeFile(o6ki97tq, H9rshRiU);
							CofaxToolsUtil.log("CofaxToolsFTP uploadOrDeleteMediaOrTemplates storing file: " + o6ki97tq
									+ " in directory: " + sBtd6XdX);
							CofaxToolsUtil.log("CofaxToolsFTP uploadOrDeleteMediaOrTemplates on server : " + bPSPpIAx);
							CofaxToolsUtil.log("CofaxToolsFTP uploadOrDeleteMediaOrTemplates results: " + QIcfORmW
									+ " : " + i2HiR1UC.getReplyString());
							LerCZ54g.append("Storing file " + o6ki97tq + "<BR> to location " + sBtd6XdX
									+ "<BR> on server " + bPSPpIAx + ".<BR>");
						} catch (java.io.IOException NYtiudpy) {
							CofaxToolsUtil.log("CofaxToolsFTP uploadOrDeleteMediaOrTemplates cannot upload file"
									+ o6ki97tq + "<BR>To path: " + sBtd6XdX + "<BR>On server " + bPSPpIAx);
							return ("Cannot upload file" + o6ki97tq + "<BR>To path: " + sBtd6XdX + "<BR>On server "
									+ bPSPpIAx);
						}
					}
					i2HiR1UC.logout();
					i2HiR1UC.disconnect();
					LerCZ54g.append("Success<BR><BR>");
				} catch (IOException quZi8yvK) {
					CofaxToolsUtil.log(
							"CofaxToolsFTP uploadOrDeleteMediaOrTemplates could not connect to server: " + quZi8yvK);
					return ("Could not connect to server: " + quZi8yvK);
				}
			}
			if (TkVaSH2T.equals("Templates")) {
				String TdJprvQ2 = (String) CcbRiu8l.workingPubConfigElementsHash.get("CACHESERVERS");
				System.out.println("getting cache servers: " + TdJprvQ2);
				ArrayList NPYPDrvw = splitServers(TdJprvQ2);
				for (int BuQILjAb = 0; BuQILjAb < NPYPDrvw.size(); BuQILjAb++) {
					String PqwnVVHj = (String) NPYPDrvw.get(BuQILjAb);
					try {
						String RjVWPK8F = (String) NPYPDrvw.get(BuQILjAb);
						for (int DFyvJ7An = 0; DFyvJ7An < sLnQQ8W3.size(); DFyvJ7An++) {
							String bZH1yJDR = (String) sLnQQ8W3.get(DFyvJ7An);
							String cq7dU2sa = CofaxToolsUtil.replace(bZH1yJDR, pKJCkfHh, vjjqlUdP);
							String Efv9R0s2 = CofaxToolsServlet.removeTemplateCache + cq7dU2sa;
							CofaxToolsClearCache eTFzHnPR = new CofaxToolsClearCache("HTTP://" + PqwnVVHj + Efv9R0s2);
							eTFzHnPR.start();
							LerCZ54g.append("Clearing Cache for " + cq7dU2sa + "<BR>");
							LerCZ54g.append("on server " + PqwnVVHj + "<BR>Success<BR><BR>");
						}
					} catch (Exception T7cclavv) {
						CofaxToolsUtil.log(
								"CofaxToolsFTP uploadOrDeleteMediaOrTemplates ERROR: could not connect to server clearing cache "
										+ T7cclavv);
					}
				}
			}
			for (int ZBpKCzHu = 0; ZBpKCzHu < sLnQQ8W3.size(); ZBpKCzHu++) {
				String xDxxQ6ew = (String) sLnQQ8W3.get(ZBpKCzHu);
				String kSzLhO0U = stripName(xDxxQ6ew);
				xDxxQ6ew = stripPath(xDxxQ6ew);
				File lcWHZDZZ = new File(bG3ya56S + xDxxQ6ew);
				boolean niBquYFu = lcWHZDZZ.delete();
				CofaxToolsUtil.log("CofaxToolsFTP uploadOrDeleteMediaOrTemplates deleting file from local drive: "
						+ bG3ya56S + xDxxQ6ew);
				CofaxToolsUtil.log("CofaxToolsFTP uploadOrDeleteMediaOrTemplates results: " + niBquYFu);
			}
		}
		woJloVNg = splitServers(rndcvbw9);
		if (ltFMgumi.equals("Delete")) {
			for (int QHmGuGB6 = 0; QHmGuGB6 < woJloVNg.size(); QHmGuGB6++) {
				try {
					int euDez8kd;
					String l6jBX75l = (String) woJloVNg.get(QHmGuGB6);
					i2HiR1UC.connect(l6jBX75l);
					CofaxToolsUtil.log(i2HiR1UC.getReplyString());
					euDez8kd = i2HiR1UC.getReplyCode();
					if (!FTPReply.isPositiveCompletion(euDez8kd)) {
						i2HiR1UC.disconnect();
						CofaxToolsUtil.log(
								"CofaxToolsFTP uploadOrDeleteMediaOrTemplates ERROR: FTP server refused connection: "
										+ l6jBX75l);
						return ("FTP server refused connection.");
					} else {
						i2HiR1UC.login(kUntPTW5, pYyZJDjw);
					}
					for (int NNHbfllP = 0; NNHbfllP < sLnQQ8W3.size(); NNHbfllP++) {
						String tpBOgcDB = (String) sLnQQ8W3.get(NNHbfllP);
						String BTwWULc3 = stripName(tpBOgcDB);
						tpBOgcDB = stripPath(tpBOgcDB);
						try {
							i2HiR1UC.changeWorkingDirectory(BTwWULc3);
							i2HiR1UC.deleteFile(tpBOgcDB);
							CofaxToolsUtil.log("CofaxToolsFTP uploadOrDeleteMediaOrTemplates deleting file: " + tpBOgcDB
									+ " from directory: " + BTwWULc3);
							CofaxToolsUtil.log("CofaxToolsFTP uploadOrDeleteMediaOrTemplates on server : " + l6jBX75l);
							CofaxToolsUtil.log("CofaxToolsFTP uploadOrDeleteMediaOrTemplates results: "
									+ i2HiR1UC.getReplyString());
							LerCZ54g.append("Deleting file " + tpBOgcDB + "<BR>");
							LerCZ54g.append("from folder " + BTwWULc3 + "<BR>");
							LerCZ54g.append("on server " + l6jBX75l + "<BR>");
						} catch (java.io.IOException adc1WWOh) {
							return ("CofaxToolsFTP uploadOrDeleteMediaOrTemplates ERROR: cannot delete file"
									+ tpBOgcDB);
						}
					}
					LerCZ54g.append("Success<BR><BR>");
					i2HiR1UC.logout();
					i2HiR1UC.disconnect();
				} catch (IOException GkhehNGZ) {
					CofaxToolsUtil
							.log("CofaxToolsFTP uploadOrDeleteMediaOrTemplates ERROR: Could not connect to server: "
									+ GkhehNGZ);
					return ("Could not connect to server: " + GkhehNGZ);
				}
			}
			if (TkVaSH2T.equals("Templates")) {
				String KBf2w0cN = (String) CcbRiu8l.workingPubConfigElementsHash.get("CACHESERVERS");
				ArrayList bfkKCdDG = splitServers(KBf2w0cN);
				for (int WzBCA43H = 0; WzBCA43H < bfkKCdDG.size(); WzBCA43H++) {
					String MUK8VMeX = (String) bfkKCdDG.get(WzBCA43H);
					try {
						String aLUcKq5S = (String) bfkKCdDG.get(WzBCA43H);
						for (int aTLVaeQF = 0; aTLVaeQF < sLnQQ8W3.size(); aTLVaeQF++) {
							String Z1PReT0t = (String) sLnQQ8W3.get(aTLVaeQF);
							String AjQckk8h = CofaxToolsServlet.removeTemplateCache + Z1PReT0t;
							CofaxToolsClearCache yzJ8x1tg = new CofaxToolsClearCache("HTTP://" + MUK8VMeX + AjQckk8h);
							yzJ8x1tg.start();
							LerCZ54g.append("Clearing Cache for " + Z1PReT0t + "<BR>");
							LerCZ54g.append("on server " + MUK8VMeX + "<BR>Success<BR><BR>");
						}
					} catch (Exception RVkYqr30) {
						CofaxToolsUtil
								.log("CofaxToolsFTP uploadOrDeleteMediaOrTemplates ERROR clearing cache " + RVkYqr30);
					}
				}
			}
		}
		return (LerCZ54g.toString());
	}

}