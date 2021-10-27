class n13650923 {
	public boolean consolidateCrossrefGet(BiblioItem cnKBcPFC, ArrayList<BiblioItem> r61ynxNu) throws Exception {
		boolean Ryc1WKpG = false;
		String L7265DIZ = cnKBcPFC.getDOI();
		String N8GLYXyw = cnKBcPFC.getFirstAuthorSurname();
		String orFUROGQ = cnKBcPFC.getTitle();
		String KDo0Xo7E = null;
		String Oh3nwdem = cnKBcPFC.getPageRange();
		int YgGtp3VP = cnKBcPFC.getBeginPage();
		if (YgGtp3VP != -1) {
			KDo0Xo7E = "" + YgGtp3VP;
		} else if (Oh3nwdem != null) {
			StringTokenizer pXVIlUzo = new StringTokenizer(Oh3nwdem, "--");
			if (pXVIlUzo.countTokens() == 2) {
				KDo0Xo7E = pXVIlUzo.nextToken();
			} else if (pXVIlUzo.countTokens() == 1)
				KDo0Xo7E = Oh3nwdem;
		}
		if (N8GLYXyw != null) {
			N8GLYXyw = TextUtilities.removeAccents(N8GLYXyw);
		}
		if (orFUROGQ != null) {
			orFUROGQ = TextUtilities.removeAccents(orFUROGQ);
		}
		if (L7265DIZ != null) {
			if (L7265DIZ.startsWith("doi:") | L7265DIZ.startsWith("DOI:")) {
				L7265DIZ.substring(4, L7265DIZ.length());
				L7265DIZ = L7265DIZ.trim();
			}
			L7265DIZ = L7265DIZ.replace(" ", "");
			String UYN3yxFz = null;
			if (cCon != null) {
				PreparedStatement LNFoR435 = null;
				try {
					LNFoR435 = cCon.prepareStatement(QUERY_CROSSREF_SQL3);
					LNFoR435.setString(1, L7265DIZ);
					ResultSet or77iL5l = LNFoR435.executeQuery();
					if (or77iL5l.next()) {
						UYN3yxFz = or77iL5l.getString(1);
					}
					or77iL5l.close();
					LNFoR435.close();
				} catch (SQLException WfDxUScr) {
					System.err.println("EXCEPTION HANDLING CROSSREF CACHE");
					WfDxUScr.printStackTrace();
				} finally {
					try {
						if (LNFoR435 != null)
							LNFoR435.close();
					} catch (SQLException qyzEJJkr) {
					}
				}
				if (UYN3yxFz != null) {
					InputSource moO7R8Z8 = new InputSource();
					moO7R8Z8.setCharacterStream(new StringReader(UYN3yxFz));
					DefaultHandler tIHPPMdv = new crossrefUnixrefSaxParser(r61ynxNu);
					SAXParserFactory wz9VPjJb = SAXParserFactory.newInstance();
					SAXParser it5L5PL0 = wz9VPjJb.newSAXParser();
					it5L5PL0.parse(moO7R8Z8, tIHPPMdv);
					if (r61ynxNu.size() > 0) {
						if (!r61ynxNu.get(0).getError())
							Ryc1WKpG = true;
					}
				}
			}
			if (UYN3yxFz == null) {
				String XcRp2hPW = String.format(DOI_BASE_QUERY, crossref_id, crossref_pw, L7265DIZ);
				URL pq37pp60 = new URL("http://" + crossref_host + "/" + XcRp2hPW);
				System.out.println("Sending: " + pq37pp60.toString());
				HttpURLConnection yupKcOmV = null;
				try {
					yupKcOmV = (HttpURLConnection) pq37pp60.openConnection();
				} catch (Exception K1hW895D) {
					this.setProxy();
					try {
						yupKcOmV = (HttpURLConnection) pq37pp60.openConnection();
					} catch (Exception UqRyJXMP) {
						UqRyJXMP.printStackTrace();
						yupKcOmV = null;
					}
				}
				if (yupKcOmV != null) {
					try {
						yupKcOmV.setDoOutput(true);
						yupKcOmV.setDoInput(true);
						yupKcOmV.setRequestMethod("GET");
						yupKcOmV.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
						InputStream Mh5zzehk = yupKcOmV.getInputStream();
						UYN3yxFz = TextUtilities.convertStreamToString(Mh5zzehk);
						InputSource LjVrGjai = new InputSource();
						LjVrGjai.setCharacterStream(new StringReader(UYN3yxFz));
						DefaultHandler nwlX0ccU = new crossrefUnixrefSaxParser(r61ynxNu);
						SAXParserFactory HB5ld9I6 = SAXParserFactory.newInstance();
						SAXParser T4fjZOba = HB5ld9I6.newSAXParser();
						T4fjZOba.parse(LjVrGjai, nwlX0ccU);
						if (r61ynxNu.size() > 0) {
							if (!r61ynxNu.get(0).getError())
								Ryc1WKpG = true;
						}
						yupKcOmV.disconnect();
					} catch (Exception XYEwN0EM) {
						System.err.println(
								"Warning: Consolidation set true, but the online connection to Crossref fails.");
					}
					if (cCon != null) {
						PreparedStatement OGC9ybvZ = null;
						try {
							OGC9ybvZ = cCon.prepareStatement(INSERT_CROSSREF_SQL3);
							OGC9ybvZ.setString(1, L7265DIZ);
							OGC9ybvZ.setString(2, UYN3yxFz);
							OGC9ybvZ.executeUpdate();
							OGC9ybvZ.close();
						} catch (SQLException w4n9mMSO) {
							System.err.println("EXCEPTION HANDLING CROSSREF UPDATE");
						} finally {
							try {
								if (OGC9ybvZ != null)
									OGC9ybvZ.close();
							} catch (SQLException zvE1eifS) {
							}
						}
					}
				}
			}
		} else if ((orFUROGQ != null) & (N8GLYXyw != null)) {
			String tcDhjphV = null;
			if (cCon != null) {
				PreparedStatement h8ZeztZb = null;
				try {
					h8ZeztZb = cCon.prepareStatement(QUERY_CROSSREF_SQL);
					h8ZeztZb.setString(1, N8GLYXyw);
					h8ZeztZb.setString(2, orFUROGQ);
					ResultSet cfhI6PZv = h8ZeztZb.executeQuery();
					if (cfhI6PZv.next()) {
						tcDhjphV = cfhI6PZv.getString(1);
					}
					cfhI6PZv.close();
					h8ZeztZb.close();
				} catch (SQLException cD13VMXH) {
					System.err.println("EXCEPTION HANDLING CROSSREF CACHE");
					cD13VMXH.printStackTrace();
				} finally {
					try {
						if (h8ZeztZb != null)
							h8ZeztZb.close();
					} catch (SQLException meGmwFOQ) {
					}
				}
				if (tcDhjphV != null) {
					InputSource Q87Pf9hr = new InputSource();
					Q87Pf9hr.setCharacterStream(new StringReader(tcDhjphV));
					DefaultHandler tw4I4anv = new crossrefUnixrefSaxParser(r61ynxNu);
					SAXParserFactory HwCVNTXj = SAXParserFactory.newInstance();
					SAXParser ZwChycwR = HwCVNTXj.newSAXParser();
					ZwChycwR.parse(Q87Pf9hr, tw4I4anv);
					if (r61ynxNu.size() > 0) {
						if (!r61ynxNu.get(0).getError())
							Ryc1WKpG = true;
					}
				}
			}
			if (tcDhjphV == null) {
				String Md0LsAbe = String.format(TITLE_BASE_QUERY, crossref_id, crossref_pw, URLEncoder.encode(orFUROGQ),
						URLEncoder.encode(N8GLYXyw));
				URL CfQMz7Ml = new URL("http://" + crossref_host + "/" + Md0LsAbe);
				System.out.println("Sending: " + CfQMz7Ml.toString());
				HttpURLConnection APompRvH = null;
				try {
					APompRvH = (HttpURLConnection) CfQMz7Ml.openConnection();
				} catch (Exception YIuAsMsK) {
					this.setProxy();
					try {
						APompRvH = (HttpURLConnection) CfQMz7Ml.openConnection();
					} catch (Exception SwFKamsV) {
						SwFKamsV.printStackTrace();
						APompRvH = null;
					}
				}
				if (APompRvH != null) {
					try {
						APompRvH.setDoOutput(true);
						APompRvH.setDoInput(true);
						APompRvH.setRequestMethod("GET");
						APompRvH.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
						InputStream rw7w0jwW = APompRvH.getInputStream();
						tcDhjphV = TextUtilities.convertStreamToString(rw7w0jwW);
						InputSource YCxlHldt = new InputSource();
						YCxlHldt.setCharacterStream(new StringReader(tcDhjphV));
						DefaultHandler hBwhlr8b = new crossrefUnixrefSaxParser(r61ynxNu);
						SAXParserFactory w0tyoKDa = SAXParserFactory.newInstance();
						SAXParser by2FYGnb = w0tyoKDa.newSAXParser();
						by2FYGnb.parse(YCxlHldt, hBwhlr8b);
						if (r61ynxNu.size() > 0) {
							if (!r61ynxNu.get(0).getError())
								Ryc1WKpG = true;
						}
						APompRvH.disconnect();
					} catch (Exception wi2QmWie) {
						System.err.println(
								"Warning: Consolidation set true, but the online connection to Crossref fails.");
					}
					if (cCon != null) {
						PreparedStatement UbW3y143 = null;
						try {
							UbW3y143 = cCon.prepareStatement(INSERT_CROSSREF_SQL);
							UbW3y143.setString(1, N8GLYXyw);
							UbW3y143.setString(2, cnKBcPFC.getTitle());
							UbW3y143.setString(3, tcDhjphV);
							UbW3y143.executeUpdate();
							UbW3y143.close();
						} catch (SQLException Z6HzBjCp) {
							System.err.println("EXCEPTION HANDLING CROSSREF UPDATE");
						} finally {
							try {
								if (UbW3y143 != null)
									UbW3y143.close();
							} catch (SQLException vhZLwGrW) {
							}
						}
					}
				}
			}
		} else if ((KDo0Xo7E != null) & (cnKBcPFC.getJournal() != null) & (cnKBcPFC.getVolume() != null)) {
			String owRa8jS0 = String.format(JOURNAL_BASE_QUERY, crossref_id, crossref_pw,
					URLEncoder.encode(cnKBcPFC.getJournal()), URLEncoder.encode(cnKBcPFC.getVolume()), KDo0Xo7E);
			URL ZLPLnCWP = new URL("http://" + crossref_host + "/" + owRa8jS0);
			String HNqjQvOa = ZLPLnCWP.toString();
			System.out.println(HNqjQvOa);
			String RIpeyNbU = null;
			if (cCon != null) {
				PreparedStatement pfh7z9Kz = null;
				try {
					pfh7z9Kz = cCon.prepareStatement(QUERY_CROSSREF_SQL2);
					pfh7z9Kz.setString(1, HNqjQvOa);
					ResultSet no3XvKyi = pfh7z9Kz.executeQuery();
					if (no3XvKyi.next()) {
						RIpeyNbU = no3XvKyi.getString(1);
					}
					no3XvKyi.close();
					pfh7z9Kz.close();
				} catch (SQLException Bxjfe2X6) {
					System.err.println("EXCEPTION HANDLING CROSSREF CACHE");
					Bxjfe2X6.printStackTrace();
				} finally {
					try {
						if (pfh7z9Kz != null)
							pfh7z9Kz.close();
					} catch (SQLException bnpvh1w2) {
					}
				}
				if (RIpeyNbU != null) {
					InputSource WHmq6x5M = new InputSource();
					WHmq6x5M.setCharacterStream(new StringReader(RIpeyNbU));
					DefaultHandler e5Bck1WJ = new crossrefUnixrefSaxParser(r61ynxNu);
					SAXParserFactory SwoCwCIH = SAXParserFactory.newInstance();
					SAXParser YINMhLti = SwoCwCIH.newSAXParser();
					YINMhLti.parse(WHmq6x5M, e5Bck1WJ);
					if (r61ynxNu.size() > 0) {
						if (!r61ynxNu.get(0).getError())
							Ryc1WKpG = true;
					}
				}
			}
			if (RIpeyNbU == null) {
				System.out.println("Sending: " + HNqjQvOa);
				HttpURLConnection WDK6eQFs = null;
				try {
					WDK6eQFs = (HttpURLConnection) ZLPLnCWP.openConnection();
				} catch (Exception LACF9hyX) {
					this.setProxy();
					try {
						WDK6eQFs = (HttpURLConnection) ZLPLnCWP.openConnection();
					} catch (Exception f26I59MX) {
						f26I59MX.printStackTrace();
						WDK6eQFs = null;
					}
				}
				if (WDK6eQFs != null) {
					try {
						WDK6eQFs.setDoOutput(true);
						WDK6eQFs.setDoInput(true);
						WDK6eQFs.setRequestMethod("GET");
						WDK6eQFs.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
						InputStream d9ofn6oT = WDK6eQFs.getInputStream();
						RIpeyNbU = TextUtilities.convertStreamToString(d9ofn6oT);
						InputSource v1AOlyOo = new InputSource();
						v1AOlyOo.setCharacterStream(new StringReader(RIpeyNbU));
						DefaultHandler sfwRAnPl = new crossrefUnixrefSaxParser(r61ynxNu);
						SAXParserFactory QlOXqPiS = SAXParserFactory.newInstance();
						SAXParser LJ9Yopu8 = QlOXqPiS.newSAXParser();
						LJ9Yopu8.parse(v1AOlyOo, sfwRAnPl);
						if (r61ynxNu.size() > 0) {
							if (!r61ynxNu.get(0).getError())
								Ryc1WKpG = true;
						}
						d9ofn6oT.close();
						WDK6eQFs.disconnect();
					} catch (Exception ryPpbD1r) {
						System.err.println(
								"Warning: Consolidation set true, but the online connection to Crossref fails.");
					}
					if (cCon != null) {
						PreparedStatement BwqWjx7E = null;
						try {
							BwqWjx7E = cCon.prepareStatement(INSERT_CROSSREF_SQL2);
							BwqWjx7E.setString(1, HNqjQvOa);
							BwqWjx7E.setString(2, RIpeyNbU);
							BwqWjx7E.executeUpdate();
							BwqWjx7E.close();
						} catch (SQLException YN1DMOK7) {
							System.err.println("EXCEPTION HANDLING CROSSREF UPDATE");
						} finally {
							try {
								if (BwqWjx7E != null)
									BwqWjx7E.close();
							} catch (SQLException TF8Ymr1T) {
							}
						}
					}
				}
			}
		}
		return Ryc1WKpG;
	}

}