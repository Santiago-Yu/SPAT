class n16518661 {
	public String quebraLink(String EoYdNz9A) throws StringIndexOutOfBoundsException {
		EoYdNz9A = EoYdNz9A.replace(".url", "");
		int W2ybU0Nb = 0;
		final String SaRWAVcz = EoYdNz9A.replace("#", "");
		boolean qzJTc3BV = false;
		char WfsBwqhe;
		String HPc7KB5i;
		String iRsqB0I5 = "";
		HPc7KB5i = EoYdNz9A.replace("#", "");
		HPc7KB5i = HPc7KB5i.replace(".url", "");
		HPc7KB5i = HPc7KB5i.replace(".html", "");
		HPc7KB5i = HPc7KB5i.replace("http://", "");
		if (HPc7KB5i.contains("clubedodownload")) {
			for (int kkWfbUXY = 7; kkWfbUXY < SaRWAVcz.length(); kkWfbUXY++) {
				if (HPc7KB5i.charAt(kkWfbUXY) == '/') {
					for (int ExYXyIYz = kkWfbUXY + 1; ExYXyIYz < HPc7KB5i.length(); ExYXyIYz++) {
						iRsqB0I5 += HPc7KB5i.charAt(ExYXyIYz);
					}
					if (iRsqB0I5.contains("//:ptth")) {
						iRsqB0I5 = inverteFrase(iRsqB0I5);
						if (isValid(iRsqB0I5)) {
							return iRsqB0I5;
						}
					} else if (iRsqB0I5.contains("http://")) {
						if (isValid(iRsqB0I5)) {
							return iRsqB0I5;
						}
					}
				}
			}
		}
		if (HPc7KB5i.contains("protetordelink.tv")) {
			for (int vMDL9CfF = HPc7KB5i.length() - 1; vMDL9CfF >= 0; vMDL9CfF--) {
				WfsBwqhe = HPc7KB5i.charAt(vMDL9CfF);
				if (WfsBwqhe == '/') {
					for (int ezRTGVbk = vMDL9CfF + 1; ezRTGVbk < HPc7KB5i.length(); ezRTGVbk++) {
						iRsqB0I5 += HPc7KB5i.charAt(ezRTGVbk);
					}
					iRsqB0I5 = HexToChar(iRsqB0I5);
					if (iRsqB0I5.contains("ptth")) {
						if (precisaRepassar(iRsqB0I5)) {
							iRsqB0I5 = quebraLink(iRsqB0I5);
							iRsqB0I5 = inverteFrase(iRsqB0I5);
							if (isValid(iRsqB0I5)) {
								return iRsqB0I5;
							}
						} else {
							iRsqB0I5 = inverteFrase(iRsqB0I5);
							if (isValid(iRsqB0I5)) {
								return iRsqB0I5;
							}
						}
					} else {
						if (precisaRepassar(iRsqB0I5)) {
							iRsqB0I5 = quebraLink(iRsqB0I5);
							if (isValid(iRsqB0I5)) {
								return iRsqB0I5;
							}
						} else {
							if (isValid(iRsqB0I5)) {
								return iRsqB0I5;
							}
						}
					}
				}
			}
		}
		if (HPc7KB5i.contains("baixeaquifilmes")) {
			for (int H9B1enVL = 0; H9B1enVL < HPc7KB5i.length(); H9B1enVL++) {
				WfsBwqhe = HPc7KB5i.charAt(H9B1enVL);
				if (WfsBwqhe == '?') {
					for (int FdshpnAa = H9B1enVL + 1; FdshpnAa < HPc7KB5i.length(); FdshpnAa++) {
						iRsqB0I5 += HPc7KB5i.charAt(FdshpnAa);
					}
					if (iRsqB0I5.contains(":ptth")) {
						iRsqB0I5 = inverteFrase(iRsqB0I5);
						if (precisaRepassar(iRsqB0I5)) {
							iRsqB0I5 = quebraLink(iRsqB0I5);
							if (isValid(iRsqB0I5)) {
								return iRsqB0I5;
							}
						} else {
							if (isValid(iRsqB0I5)) {
								return iRsqB0I5;
							}
						}
					} else {
						if (precisaRepassar(iRsqB0I5)) {
							iRsqB0I5 = quebraLink(iRsqB0I5);
							if (isValid(iRsqB0I5)) {
								return iRsqB0I5;
							}
						} else {
							if (isValid(iRsqB0I5)) {
								return iRsqB0I5;
							}
						}
					}
				}
			}
		}
		if (HPc7KB5i.contains("downloadsgratis")) {
			for (int XA5eDH5v = 0; XA5eDH5v < HPc7KB5i.length(); XA5eDH5v++) {
				WfsBwqhe = HPc7KB5i.charAt(XA5eDH5v);
				if (WfsBwqhe == '!') {
					for (int KU6NEuY9 = XA5eDH5v + 1; KU6NEuY9 < HPc7KB5i.length(); KU6NEuY9++) {
						iRsqB0I5 += HPc7KB5i.charAt(KU6NEuY9);
					}
					if (precisaRepassar(QuebraLink.decode64(iRsqB0I5))) {
						iRsqB0I5 = quebraLink(QuebraLink.decode64(iRsqB0I5));
						if (isValid(iRsqB0I5)) {
							return iRsqB0I5;
						}
					} else {
						if (isValid(iRsqB0I5)) {
							return iRsqB0I5;
						}
					}
				}
			}
		}
		iRsqB0I5 = "";
		if (HPc7KB5i.contains("vinxp")) {
			System.out.println("¨¦");
			for (int V4FudyO9 = 1; V4FudyO9 < HPc7KB5i.length(); V4FudyO9++) {
				if (HPc7KB5i.charAt(V4FudyO9) == '=') {
					for (int nyVqBEzb = V4FudyO9 + 1; nyVqBEzb < HPc7KB5i.length(); nyVqBEzb++) {
						iRsqB0I5 += HPc7KB5i.charAt(nyVqBEzb);
					}
					break;
				}
			}
			if (iRsqB0I5.contains(".vinxp")) {
				iRsqB0I5 = iRsqB0I5.replace(".vinxp", "");
			}
			iRsqB0I5 = decodeCifraDeCesar(iRsqB0I5);
			System.out.println(iRsqB0I5);
			return iRsqB0I5;
		}
		if (HPc7KB5i.contains("?")) {
			String XlH8yQtA = "";
			iRsqB0I5 = "";
			if (HPc7KB5i.contains("go!")) {
				HPc7KB5i = HPc7KB5i.replace("?go!", "?");
			}
			if (HPc7KB5i.contains("=")) {
				for (int p18Ix7Dy = 0; p18Ix7Dy < HPc7KB5i.length(); p18Ix7Dy++) {
					WfsBwqhe = HPc7KB5i.charAt(p18Ix7Dy);
					if (WfsBwqhe == '=') {
						for (int AlSFokLC = p18Ix7Dy + 1; AlSFokLC < HPc7KB5i.length(); AlSFokLC++) {
							iRsqB0I5 += HPc7KB5i.charAt(AlSFokLC);
						}
						XlH8yQtA = QuebraLink.decode64(iRsqB0I5);
						break;
					}
				}
				if (XlH8yQtA.contains("http")) {
					iRsqB0I5 = "";
					for (int qBMsEHvc = 0; qBMsEHvc < XlH8yQtA.length(); qBMsEHvc++) {
						WfsBwqhe = XlH8yQtA.charAt(qBMsEHvc);
						if (WfsBwqhe == 'h') {
							for (int A6gR50tu = qBMsEHvc; A6gR50tu < XlH8yQtA.length(); A6gR50tu++) {
								iRsqB0I5 += XlH8yQtA.charAt(A6gR50tu);
							}
							iRsqB0I5 = iRsqB0I5.replace("!og", "");
							if (precisaRepassar(iRsqB0I5)) {
								iRsqB0I5 = quebraLink(iRsqB0I5);
								if (isValid(iRsqB0I5)) {
									return iRsqB0I5;
								}
							} else {
								if (isValid(iRsqB0I5)) {
									return iRsqB0I5;
								}
							}
						}
					}
				}
				if (XlH8yQtA.contains("ptth")) {
					iRsqB0I5 = "";
					XlH8yQtA = inverteFrase(XlH8yQtA);
					for (int zWKNDphr = 0; zWKNDphr < XlH8yQtA.length(); zWKNDphr++) {
						WfsBwqhe = XlH8yQtA.charAt(zWKNDphr);
						if (WfsBwqhe == 'h') {
							for (int Aa1d3KvV = zWKNDphr; Aa1d3KvV < XlH8yQtA.length(); Aa1d3KvV++) {
								iRsqB0I5 += XlH8yQtA.charAt(Aa1d3KvV);
							}
							iRsqB0I5 = iRsqB0I5.replace("!og", "");
							if (precisaRepassar(iRsqB0I5)) {
								iRsqB0I5 = quebraLink(iRsqB0I5);
								if (isValid(iRsqB0I5)) {
									return iRsqB0I5;
								}
							} else {
								if (isValid(iRsqB0I5)) {
									return iRsqB0I5;
								}
							}
						}
					}
				}
			}
			XlH8yQtA = "";
			for (int CIPxfT9S = 0; CIPxfT9S < HPc7KB5i.length(); CIPxfT9S++) {
				WfsBwqhe = HPc7KB5i.charAt(CIPxfT9S);
				if (WfsBwqhe == '?') {
					for (int lkOASpYx = CIPxfT9S + 1; lkOASpYx < HPc7KB5i.length(); lkOASpYx++) {
						XlH8yQtA += HPc7KB5i.charAt(lkOASpYx);
					}
					EoYdNz9A = QuebraLink.decode64(XlH8yQtA);
					break;
				}
			}
			if (EoYdNz9A.contains("http")) {
				iRsqB0I5 = "";
				for (int qJVWp0aY = 0; qJVWp0aY < EoYdNz9A.length(); qJVWp0aY++) {
					WfsBwqhe = EoYdNz9A.charAt(qJVWp0aY);
					if (WfsBwqhe == 'h') {
						for (int UQGCNXad = qJVWp0aY; UQGCNXad < EoYdNz9A.length(); UQGCNXad++) {
							iRsqB0I5 += EoYdNz9A.charAt(UQGCNXad);
						}
						iRsqB0I5 = iRsqB0I5.replace("!og", "");
						if (precisaRepassar(iRsqB0I5)) {
							iRsqB0I5 = quebraLink(iRsqB0I5);
							if (isValid(iRsqB0I5)) {
								return iRsqB0I5;
							}
						} else {
							if (isValid(iRsqB0I5)) {
								return iRsqB0I5;
							}
						}
					}
				}
			}
			if (EoYdNz9A.contains("ptth")) {
				iRsqB0I5 = "";
				XlH8yQtA = inverteFrase(EoYdNz9A);
				for (int o6bPjTeb = 0; o6bPjTeb < XlH8yQtA.length(); o6bPjTeb++) {
					WfsBwqhe = XlH8yQtA.charAt(o6bPjTeb);
					if (WfsBwqhe == 'h') {
						for (int xUNonzJf = o6bPjTeb; xUNonzJf < XlH8yQtA.length(); xUNonzJf++) {
							iRsqB0I5 += XlH8yQtA.charAt(xUNonzJf);
						}
						iRsqB0I5 = iRsqB0I5.replace("!og", "");
						if (precisaRepassar(iRsqB0I5)) {
							iRsqB0I5 = quebraLink(iRsqB0I5);
							if (isValid(iRsqB0I5)) {
								return iRsqB0I5;
							}
						} else {
							if (isValid(iRsqB0I5)) {
								return iRsqB0I5;
							}
						}
					}
				}
			}
			HPc7KB5i = SaRWAVcz;
			EoYdNz9A = HPc7KB5i;
			iRsqB0I5 = "";
		}
		if (HPc7KB5i.contains("?")) {
			String bC5w5SZN = "";
			iRsqB0I5 = "";
			if (HPc7KB5i.contains("go!")) {
				HPc7KB5i = HPc7KB5i.replace("?go!", "?");
			}
			if (HPc7KB5i.contains("=")) {
				for (int TJl2c6nt = 0; TJl2c6nt < HPc7KB5i.length(); TJl2c6nt++) {
					WfsBwqhe = HPc7KB5i.charAt(TJl2c6nt);
					if (WfsBwqhe == '=') {
						for (int aoxj8ycB = TJl2c6nt + 1; aoxj8ycB < HPc7KB5i.length(); aoxj8ycB++) {
							iRsqB0I5 += HPc7KB5i.charAt(aoxj8ycB);
						}
						bC5w5SZN = bC5w5SZN.replace(".", "");
						try {
							bC5w5SZN = HexToChar(iRsqB0I5);
						} catch (Exception Xnp4HvZv) {
							System.err.println("erro hex 1?");
							qzJTc3BV = true;
						}
						break;
					}
				}
				if (bC5w5SZN.contains("http") && !qzJTc3BV) {
					iRsqB0I5 = "";
					for (int RZgcrTWT = 0; RZgcrTWT < bC5w5SZN.length(); RZgcrTWT++) {
						WfsBwqhe = bC5w5SZN.charAt(RZgcrTWT);
						if (WfsBwqhe == 'h') {
							for (int zOEdWMed = RZgcrTWT; zOEdWMed < bC5w5SZN.length(); zOEdWMed++) {
								iRsqB0I5 += bC5w5SZN.charAt(zOEdWMed);
							}
							iRsqB0I5 = iRsqB0I5.replace("!og", "");
							if (precisaRepassar(iRsqB0I5)) {
								iRsqB0I5 = quebraLink(iRsqB0I5);
								if (isValid(iRsqB0I5)) {
									return iRsqB0I5;
								}
							} else {
								if (isValid(iRsqB0I5)) {
									return iRsqB0I5;
								}
							}
						}
					}
				}
				if (bC5w5SZN.contains("ptth") && !qzJTc3BV) {
					iRsqB0I5 = "";
					bC5w5SZN = inverteFrase(bC5w5SZN);
					for (int ci9k4R3Z = 0; ci9k4R3Z < bC5w5SZN.length(); ci9k4R3Z++) {
						WfsBwqhe = bC5w5SZN.charAt(ci9k4R3Z);
						if (WfsBwqhe == 'h') {
							for (int CEm9KvYc = ci9k4R3Z; CEm9KvYc < bC5w5SZN.length(); CEm9KvYc++) {
								iRsqB0I5 += bC5w5SZN.charAt(CEm9KvYc);
							}
							iRsqB0I5 = iRsqB0I5.replace("!og", "");
							if (precisaRepassar(iRsqB0I5)) {
								iRsqB0I5 = quebraLink(iRsqB0I5);
								if (isValid(iRsqB0I5)) {
									return iRsqB0I5;
								}
							} else {
								if (isValid(iRsqB0I5)) {
									return iRsqB0I5;
								}
							}
						}
					}
				}
			}
			qzJTc3BV = false;
			bC5w5SZN = "";
			for (int oQfiluTP = 0; oQfiluTP < HPc7KB5i.length(); oQfiluTP++) {
				WfsBwqhe = HPc7KB5i.charAt(oQfiluTP);
				if (WfsBwqhe == '?') {
					for (int mgA8ZG35 = oQfiluTP + 1; mgA8ZG35 < HPc7KB5i.length(); mgA8ZG35++) {
						bC5w5SZN += HPc7KB5i.charAt(mgA8ZG35);
					}
					bC5w5SZN = bC5w5SZN.replace(".", "");
					try {
						EoYdNz9A = HexToChar(bC5w5SZN);
					} catch (Exception ovi4sym5) {
						System.err.println("erro hex 2?");
						qzJTc3BV = true;
					}
					break;
				}
			}
			if (EoYdNz9A.contains("http") && !qzJTc3BV) {
				iRsqB0I5 = "";
				for (int qCKfIFJG = 0; qCKfIFJG < EoYdNz9A.length(); qCKfIFJG++) {
					WfsBwqhe = EoYdNz9A.charAt(qCKfIFJG);
					if (WfsBwqhe == 'h') {
						for (int oDHfmYef = qCKfIFJG; oDHfmYef < EoYdNz9A.length(); oDHfmYef++) {
							iRsqB0I5 += EoYdNz9A.charAt(oDHfmYef);
						}
						iRsqB0I5 = iRsqB0I5.replace("!og", "");
						if (precisaRepassar(iRsqB0I5)) {
							iRsqB0I5 = quebraLink(iRsqB0I5);
							if (isValid(iRsqB0I5)) {
								return iRsqB0I5;
							}
						} else {
							if (isValid(iRsqB0I5)) {
								return iRsqB0I5;
							}
						}
					}
				}
			}
			if (EoYdNz9A.contains("ptth") && !qzJTc3BV) {
				iRsqB0I5 = "";
				bC5w5SZN = inverteFrase(EoYdNz9A);
				for (int pJyGHpoK = 0; pJyGHpoK < bC5w5SZN.length(); pJyGHpoK++) {
					WfsBwqhe = bC5w5SZN.charAt(pJyGHpoK);
					if (WfsBwqhe == 'h') {
						for (int LTkoBKmJ = pJyGHpoK; LTkoBKmJ < bC5w5SZN.length(); LTkoBKmJ++) {
							iRsqB0I5 += bC5w5SZN.charAt(LTkoBKmJ);
						}
						iRsqB0I5 = iRsqB0I5.replace("!og", "");
						if (precisaRepassar(iRsqB0I5)) {
							iRsqB0I5 = quebraLink(iRsqB0I5);
							if (isValid(iRsqB0I5)) {
								return iRsqB0I5;
							}
						} else {
							if (isValid(iRsqB0I5)) {
								return iRsqB0I5;
							}
						}
					}
				}
			}
			HPc7KB5i = SaRWAVcz;
			EoYdNz9A = HPc7KB5i;
			iRsqB0I5 = "";
		}
		if (HPc7KB5i.contains("?") && !HPc7KB5i.contains("id=") && !HPc7KB5i.contains("url=")
				&& !HPc7KB5i.contains("link=") && !HPc7KB5i.contains("r=http") && !HPc7KB5i.contains("r=ftp")) {
			for (int zqqds6OT = 0; zqqds6OT < HPc7KB5i.length(); zqqds6OT++) {
				WfsBwqhe = HPc7KB5i.charAt(zqqds6OT);
				if (WfsBwqhe == '?') {
					iRsqB0I5 = "";
					for (int v4wzFMtl = zqqds6OT + 1; v4wzFMtl < HPc7KB5i.length(); v4wzFMtl++) {
						iRsqB0I5 += HPc7KB5i.charAt(v4wzFMtl);
					}
					if (iRsqB0I5.contains("ptth")) {
						iRsqB0I5 = inverteFrase(iRsqB0I5);
						if (precisaRepassar(iRsqB0I5)) {
							iRsqB0I5 = quebraLink(iRsqB0I5);
							if (isValid(iRsqB0I5)) {
								return iRsqB0I5;
							}
						} else {
							if (isValid(iRsqB0I5)) {
								return iRsqB0I5;
							}
						}
					} else {
						if (precisaRepassar(iRsqB0I5)) {
							iRsqB0I5 = quebraLink(iRsqB0I5);
							if (isValid(iRsqB0I5)) {
								return iRsqB0I5;
							}
						} else {
							if (isValid(iRsqB0I5)) {
								return iRsqB0I5;
							}
						}
					}
				}
			}
		}
		if ((EoYdNz9A.contains("url=")) || (EoYdNz9A.contains("link=")) || (EoYdNz9A.contains("?r=http"))
				|| (EoYdNz9A.contains("?r=ftp"))) {
			if (!EoYdNz9A.contains("//:ptth")) {
				for (int EaHH6cdb = 0; EaHH6cdb < EoYdNz9A.length(); EaHH6cdb++) {
					WfsBwqhe = EoYdNz9A.charAt(EaHH6cdb);
					if (WfsBwqhe == '=') {
						for (int atWdCbfB = EaHH6cdb + 1; atWdCbfB < EoYdNz9A.length(); atWdCbfB++) {
							WfsBwqhe = EoYdNz9A.charAt(atWdCbfB);
							iRsqB0I5 += WfsBwqhe;
						}
						break;
					}
				}
				if (precisaRepassar(iRsqB0I5)) {
					iRsqB0I5 = quebraLink(iRsqB0I5);
					if (isValid(iRsqB0I5)) {
						return iRsqB0I5;
					}
				} else {
					if (isValid(iRsqB0I5)) {
						return iRsqB0I5;
					}
				}
			}
		}
		if (HPc7KB5i.contains("//:ptth") || HPc7KB5i.contains("//:sptth")) {
			if (HPc7KB5i.contains("=")) {
				for (int SfFopXpv = 0; SfFopXpv < HPc7KB5i.length(); SfFopXpv++) {
					WfsBwqhe = HPc7KB5i.charAt(SfFopXpv);
					if (WfsBwqhe == '=') {
						for (int JZIe1J0N = HPc7KB5i.length() - 1; JZIe1J0N > SfFopXpv; JZIe1J0N--) {
							WfsBwqhe = HPc7KB5i.charAt(JZIe1J0N);
							iRsqB0I5 += WfsBwqhe;
						}
						break;
					}
				}
				if (precisaRepassar(iRsqB0I5)) {
					iRsqB0I5 = quebraLink(iRsqB0I5);
					if (isValid(iRsqB0I5)) {
						return iRsqB0I5;
					}
				} else {
					if (isValid(iRsqB0I5)) {
						return iRsqB0I5;
					}
				}
			}
			iRsqB0I5 = inverteFrase(HPc7KB5i);
			if (precisaRepassar(iRsqB0I5)) {
				iRsqB0I5 = quebraLink(iRsqB0I5);
				if (isValid(iRsqB0I5)) {
					return iRsqB0I5;
				}
			} else {
				if (isValid(iRsqB0I5)) {
					return iRsqB0I5;
				}
			}
		}
		if (HPc7KB5i.contains("?go!")) {
			HPc7KB5i = HPc7KB5i.replace("?go!", "?down!");
			iRsqB0I5 = HPc7KB5i;
			if (precisaRepassar(iRsqB0I5)) {
				iRsqB0I5 = quebraLink(iRsqB0I5);
				if (isValid(iRsqB0I5)) {
					return iRsqB0I5;
				}
			} else {
				if (isValid(iRsqB0I5)) {
					return iRsqB0I5;
				}
			}
		}
		if (HPc7KB5i.contains("down!")) {
			HPc7KB5i = HPc7KB5i.replace("down!", "");
			return quebraLink(HPc7KB5i);
		}
		iRsqB0I5 = "";
		for (int xKm4bfHV = HPc7KB5i.length() - 4; xKm4bfHV >= 0; xKm4bfHV--) {
			WfsBwqhe = HPc7KB5i.charAt(xKm4bfHV);
			if (WfsBwqhe == '=') {
				for (int S0TCbHiO = xKm4bfHV + 1; S0TCbHiO < HPc7KB5i.length(); S0TCbHiO++) {
					iRsqB0I5 += HPc7KB5i.charAt(S0TCbHiO);
				}
				break;
			}
		}
		String RqmvSJ40 = "";
		try {
			RqmvSJ40 = HexToChar(iRsqB0I5);
		} catch (Exception t1OynJK1) {
			System.err.println("erro hex 3?");
		}
		if (RqmvSJ40.contains("http://")) {
			if (precisaRepassar(RqmvSJ40)) {
				RqmvSJ40 = quebraLink(RqmvSJ40);
				if (isValid(RqmvSJ40)) {
					iRsqB0I5 = RqmvSJ40;
					return iRsqB0I5;
				}
			} else {
				if (isValid(RqmvSJ40)) {
					iRsqB0I5 = RqmvSJ40;
					return iRsqB0I5;
				}
			}
		} else if (RqmvSJ40.contains("//:ptth")) {
			RqmvSJ40 = inverteFrase(RqmvSJ40);
			if (precisaRepassar(RqmvSJ40)) {
				RqmvSJ40 = quebraLink(RqmvSJ40);
				if (isValid(RqmvSJ40)) {
					iRsqB0I5 = RqmvSJ40;
					return iRsqB0I5;
				}
			} else {
				if (isValid(RqmvSJ40)) {
					iRsqB0I5 = RqmvSJ40;
					return iRsqB0I5;
				}
			}
		} else {
			RqmvSJ40 = iRsqB0I5;
		}
		RqmvSJ40 = decode64(iRsqB0I5);
		if (RqmvSJ40.contains("http://")) {
			if (precisaRepassar(RqmvSJ40)) {
				RqmvSJ40 = quebraLink(iRsqB0I5);
				if (isValid(RqmvSJ40)) {
					iRsqB0I5 = RqmvSJ40;
					return iRsqB0I5;
				}
			} else {
				if (isValid(RqmvSJ40)) {
					iRsqB0I5 = RqmvSJ40;
					return iRsqB0I5;
				}
			}
		} else if (RqmvSJ40.contains("//:ptth")) {
			RqmvSJ40 = inverteFrase(RqmvSJ40);
			if (precisaRepassar(RqmvSJ40)) {
				iRsqB0I5 = quebraLink(iRsqB0I5);
				if (isValid(RqmvSJ40)) {
					iRsqB0I5 = RqmvSJ40;
					return iRsqB0I5;
				}
			} else {
				if (isValid(RqmvSJ40)) {
					iRsqB0I5 = RqmvSJ40;
					return iRsqB0I5;
				}
			}
		} else {
			RqmvSJ40 = iRsqB0I5;
		}
		try {
			RqmvSJ40 = decodeAscii(iRsqB0I5);
		} catch (NumberFormatException e0dVDFFw) {
			System.err.println("erro ascii");
		}
		if (RqmvSJ40.contains("http://")) {
			if (precisaRepassar(RqmvSJ40)) {
				RqmvSJ40 = quebraLink(iRsqB0I5);
				if (isValid(RqmvSJ40)) {
					iRsqB0I5 = RqmvSJ40;
					return iRsqB0I5;
				}
			} else {
				if (isValid(RqmvSJ40)) {
					iRsqB0I5 = RqmvSJ40;
					return iRsqB0I5;
				}
			}
		} else if (RqmvSJ40.contains("//:ptth")) {
			RqmvSJ40 = inverteFrase(RqmvSJ40);
			if (precisaRepassar(RqmvSJ40)) {
				RqmvSJ40 = quebraLink(RqmvSJ40);
				if (isValid(RqmvSJ40)) {
					iRsqB0I5 = RqmvSJ40;
					return iRsqB0I5;
				}
			} else {
				if (isValid(RqmvSJ40)) {
					iRsqB0I5 = RqmvSJ40;
					return iRsqB0I5;
				}
			}
		} else {
			RqmvSJ40 = null;
		}
		iRsqB0I5 = "";
		int ziLBeZvm = 0;
		WfsBwqhe = '\0';
		RqmvSJ40 = "";
		iRsqB0I5 = "";
		for (int cNq05RwC = HPc7KB5i.length() - 4; cNq05RwC >= 0; cNq05RwC--) {
			WfsBwqhe = HPc7KB5i.charAt(cNq05RwC);
			if (WfsBwqhe == '=' || WfsBwqhe == '?') {
				for (int VN8u5flw = cNq05RwC + 1; VN8u5flw < HPc7KB5i.length(); VN8u5flw++) {
					if (HPc7KB5i.charAt(VN8u5flw) == '.') {
						break;
					}
					iRsqB0I5 += HPc7KB5i.charAt(VN8u5flw);
				}
				break;
			}
		}
		RqmvSJ40 = iRsqB0I5;
		String B2cBOOPN = "";
		String zuzelXUA = "";
		do {
			try {
				B2cBOOPN = HexToChar(RqmvSJ40);
				zuzelXUA = HexToChar(inverteFrase(RqmvSJ40));
				if (!B2cBOOPN.isEmpty() && B2cBOOPN.length() > 5 && !B2cBOOPN.contains("") && !B2cBOOPN.contains("¡ì")
						&& !B2cBOOPN.contains("?") && !B2cBOOPN.contains("")) {
					RqmvSJ40 = HexToChar(RqmvSJ40);
				} else if (!inverteFrase(zuzelXUA).isEmpty() && inverteFrase(zuzelXUA).length() > 5
						&& !inverteFrase(zuzelXUA).contains("?") && !inverteFrase(zuzelXUA).contains("¡ì")
						&& !inverteFrase(zuzelXUA).contains("?")) {
					RqmvSJ40 = HexToChar(inverteFrase(RqmvSJ40));
				}
			} catch (NumberFormatException whDNpEb4) {
			}
			B2cBOOPN = decode64(RqmvSJ40);
			zuzelXUA = decode64(inverteFrase(RqmvSJ40));
			if (!B2cBOOPN.contains("?") && !B2cBOOPN.contains("?")) {
				RqmvSJ40 = decode64(RqmvSJ40);
			} else if (!zuzelXUA.contains("?") && !zuzelXUA.contains("?")) {
				RqmvSJ40 = decode64(inverteFrase(RqmvSJ40));
			}
			try {
				B2cBOOPN = decodeAscii(RqmvSJ40);
				zuzelXUA = decodeAscii(inverteFrase(RqmvSJ40));
				if (!B2cBOOPN.contains("?") && !B2cBOOPN.contains("?") && !B2cBOOPN.contains("¡ì")
						&& !B2cBOOPN.contains("?") && !B2cBOOPN.contains("*") && !B2cBOOPN.contains("\"")
						&& !B2cBOOPN.contains("^")) {
					RqmvSJ40 = decodeAscii(RqmvSJ40);
				} else if (!zuzelXUA.contains("?") && !zuzelXUA.contains("?") && !zuzelXUA.contains("¡ì")
						&& !zuzelXUA.contains("?") && !zuzelXUA.contains("*") && !zuzelXUA.contains("\"")
						&& !zuzelXUA.contains("^")) {
					RqmvSJ40 = decodeAscii(inverteFrase(RqmvSJ40));
				}
			} catch (NumberFormatException oRxr1eVQ) {
			}
			ziLBeZvm++;
			if (RqmvSJ40.contains("http")) {
				iRsqB0I5 = RqmvSJ40;
				if (precisaRepassar(iRsqB0I5)) {
					iRsqB0I5 = quebraLink(iRsqB0I5);
					if (isValid(iRsqB0I5)) {
						return iRsqB0I5;
					}
				} else {
					if (isValid(iRsqB0I5)) {
						return iRsqB0I5;
					}
				}
			} else if (RqmvSJ40.contains("ptth")) {
				iRsqB0I5 = inverteFrase(RqmvSJ40);
				if (precisaRepassar(iRsqB0I5)) {
					iRsqB0I5 = quebraLink(iRsqB0I5);
					if (isValid(iRsqB0I5)) {
						return iRsqB0I5;
					}
				} else {
					if (isValid(iRsqB0I5)) {
						return iRsqB0I5;
					}
				}
			}
		} while (!isValid(iRsqB0I5) && ziLBeZvm <= 20);
		B2cBOOPN = null;
		zuzelXUA = null;
		RqmvSJ40 = null;
		String JisSaa2v = "";
		try {
			JisSaa2v = readHTML(SaRWAVcz);
		} catch (IOException qM9MYfIZ) {
		}
		JisSaa2v = JisSaa2v.toLowerCase();
		if (JisSaa2v.contains("trocabotao")) {
			iRsqB0I5 = "";
			for (int XlRkbYlN = JisSaa2v.indexOf("trocabotao"); XlRkbYlN < JisSaa2v.length(); XlRkbYlN++) {
				if (Character.isDigit(JisSaa2v.charAt(XlRkbYlN))) {
					int ocYBzeby = XlRkbYlN;
					while (Character.isDigit(JisSaa2v.charAt(ocYBzeby))) {
						iRsqB0I5 += JisSaa2v.charAt(ocYBzeby);
						ocYBzeby++;
					}
					W2ybU0Nb = Integer.parseInt(iRsqB0I5);
					break;
				}
			}
			if (W2ybU0Nb != 0) {
				for (int H1NTKA74 = 7; H1NTKA74 < SaRWAVcz.length(); H1NTKA74++) {
					WfsBwqhe = SaRWAVcz.charAt(H1NTKA74);
					if (WfsBwqhe == '/') {
						iRsqB0I5 = SaRWAVcz.substring(0, H1NTKA74 + 1) + "linkdiscover.php?cod=" + W2ybU0Nb;
						break;
					}
				}
				DataInputStream UQqlkTc8 = null;
				try {
					URL DDRSr55f = new URL(iRsqB0I5);
					InputStream AENuYzQc = DDRSr55f.openStream();
					UQqlkTc8 = new DataInputStream(new BufferedInputStream(AENuYzQc));
					JisSaa2v = "";
					int Le97tVo2;
					while ((Le97tVo2 = UQqlkTc8.read()) != -1) {
						WfsBwqhe = (char) Le97tVo2;
						JisSaa2v += WfsBwqhe;
					}
					iRsqB0I5 = JisSaa2v.replaceAll(" ", "");
					if (precisaRepassar(iRsqB0I5)) {
						iRsqB0I5 = quebraLink(iRsqB0I5);
						if (isValid(iRsqB0I5)) {
							return iRsqB0I5;
						}
					} else {
						if (isValid(iRsqB0I5)) {
							return iRsqB0I5;
						}
					}
				} catch (MalformedURLException EAGyYNQ1) {
					System.out.println("URL mal formada.");
				} catch (IOException T8YxvXLC) {
				} finally {
					try {
						if (UQqlkTc8 != null) {
							UQqlkTc8.close();
						}
					} catch (IOException ri8a9Dwq) {
						System.err.println("Falha ao fechar fluxo.");
					}
				}
			}
		}
		if (precisaRepassar(SaRWAVcz)) {
			if (SaRWAVcz.substring(8).contains("http")) {
				iRsqB0I5 = SaRWAVcz.substring(SaRWAVcz.indexOf("http", 8), SaRWAVcz.length());
				if (isValid(iRsqB0I5)) {
					return iRsqB0I5;
				}
			}
		}
		iRsqB0I5 = "";
		StringBuffer sF8botAU = null;
		try {
			sF8botAU = new StringBuffer(readHTML(SaRWAVcz));
			for (String mVLpEyao : getLibrary()) {
				if (sF8botAU.toString().toLowerCase().contains(mVLpEyao)) {
					for (int VROYZmC0 = sF8botAU.toString().indexOf(mVLpEyao); VROYZmC0 >= 0; VROYZmC0--) {
						if (sF8botAU.toString().charAt(VROYZmC0) == '"') {
							for (int P08OxBaF = VROYZmC0 + 1; P08OxBaF < sF8botAU.length(); P08OxBaF++) {
								if (sF8botAU.toString().charAt(P08OxBaF) == '"') {
									if (precisaRepassar(iRsqB0I5)) {
										iRsqB0I5 = quebraLink(iRsqB0I5);
										if (isValid(iRsqB0I5)) {
											return iRsqB0I5;
										}
									} else {
										if (isValid(iRsqB0I5)) {
											return iRsqB0I5;
										}
									}
								} else {
									iRsqB0I5 += sF8botAU.toString().charAt(P08OxBaF);
								}
							}
						}
					}
				}
			}
		} catch (IOException yZvgVjEv) {
		}
		GUIQuebraLink.isBroken = false;
		return "Desculpe o link n?o pode ser quebrado.";
	}

}