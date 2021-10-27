class n14794142 {
	public boolean consolidateCrossrefGet(BiblioItem Y0uco020, ArrayList<BiblioItem> aFPTOIIx) throws Exception {
		boolean WuXJWYIH = false;
		String zizm0IGJ = Y0uco020.getDOI();
		String urMsJ56Q = Y0uco020.getFirstAuthorSurname();
		String ovgqqqOg = Y0uco020.getTitle();
		String q9tG6Icn = null;
		String I4DwmlyO = Y0uco020.getPageRange();
		int SlZV4t4e = Y0uco020.getBeginPage();
		if (SlZV4t4e != -1) {
			q9tG6Icn = "" + SlZV4t4e;
		} else if (I4DwmlyO != null) {
			StringTokenizer dzpAvklA = new StringTokenizer(I4DwmlyO, "--");
			if (dzpAvklA.countTokens() == 2) {
				q9tG6Icn = dzpAvklA.nextToken();
			} else if (dzpAvklA.countTokens() == 1)
				q9tG6Icn = I4DwmlyO;
		}
		if (urMsJ56Q != null) {
			urMsJ56Q = TextUtilities.removeAccents(urMsJ56Q);
		}
		if (ovgqqqOg != null) {
			ovgqqqOg = TextUtilities.removeAccents(ovgqqqOg);
		}
		if (zizm0IGJ != null) {
			if (zizm0IGJ.startsWith("doi:") | zizm0IGJ.startsWith("DOI:")) {
				zizm0IGJ.substring(4, zizm0IGJ.length());
				zizm0IGJ = zizm0IGJ.trim();
			}
			zizm0IGJ = zizm0IGJ.replace(" ", "");
			String TN992TsW = null;
			if (cCon != null) {
				PreparedStatement WqisHvjX = null;
				try {
					WqisHvjX = cCon.prepareStatement(QUERY_CROSSREF_SQL3);
					WqisHvjX.setString(1, zizm0IGJ);
					ResultSet DMO2cGnX = WqisHvjX.executeQuery();
					if (DMO2cGnX.next()) {
						TN992TsW = DMO2cGnX.getString(1);
					}
					DMO2cGnX.close();
					WqisHvjX.close();
				} catch (SQLException fXs2byjS) {
					System.err.println("EXCEPTION HANDLING CROSSREF CACHE");
					throw new GROBIDServiceException("EXCEPTION HANDLING CROSSREF CACHE.", fXs2byjS);
				} finally {
					try {
						if (WqisHvjX != null)
							WqisHvjX.close();
					} catch (SQLException HdjQCsMS) {
					}
				}
				if (TN992TsW != null) {
					InputSource ohYo2dJ3 = new InputSource();
					ohYo2dJ3.setCharacterStream(new StringReader(TN992TsW));
					DefaultHandler rgBNy7FP = new crossrefUnixrefSaxParser(aFPTOIIx);
					SAXParserFactory HM0FUSkb = SAXParserFactory.newInstance();
					SAXParser fCJBLqFA = HM0FUSkb.newSAXParser();
					fCJBLqFA.parse(ohYo2dJ3, rgBNy7FP);
					if (aFPTOIIx.size() > 0) {
						if (!aFPTOIIx.get(0).getError())
							WuXJWYIH = true;
					}
				}
			}
			if (TN992TsW == null) {
				String WZ1A18uf = String.format(DOI_BASE_QUERY, crossref_id, crossref_pw, zizm0IGJ);
				URL DuU2vHMT = new URL("http://" + crossref_host + "/" + WZ1A18uf);
				System.out.println("Sending: " + DuU2vHMT.toString());
				HttpURLConnection s0fENe17 = null;
				try {
					s0fENe17 = (HttpURLConnection) DuU2vHMT.openConnection();
				} catch (Exception AU0BPosl) {
					this.setProxy();
					try {
						s0fENe17 = (HttpURLConnection) DuU2vHMT.openConnection();
					} catch (Exception G5hVMXj2) {
						s0fENe17 = null;
						throw new GROBIDServiceException("An exception occured while running Grobid.", G5hVMXj2);
					}
				}
				if (s0fENe17 != null) {
					try {
						s0fENe17.setDoOutput(true);
						s0fENe17.setDoInput(true);
						s0fENe17.setRequestMethod("GET");
						s0fENe17.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
						InputStream syF7QT8w = s0fENe17.getInputStream();
						TN992TsW = TextUtilities.convertStreamToString(syF7QT8w);
						InputSource AlNlSztu = new InputSource();
						AlNlSztu.setCharacterStream(new StringReader(TN992TsW));
						DefaultHandler TT3uX3KJ = new crossrefUnixrefSaxParser(aFPTOIIx);
						SAXParserFactory uIx4i6Ay = SAXParserFactory.newInstance();
						SAXParser AZWChDs2 = uIx4i6Ay.newSAXParser();
						AZWChDs2.parse(AlNlSztu, TT3uX3KJ);
						if (aFPTOIIx.size() > 0) {
							if (!aFPTOIIx.get(0).getError())
								WuXJWYIH = true;
						}
						s0fENe17.disconnect();
					} catch (Exception rAChsyG1) {
						System.err.println(
								"Warning: Consolidation set true, " + "but the online connection to Crossref fails.");
					}
					if (cCon != null) {
						PreparedStatement CYzHFEiq = null;
						try {
							CYzHFEiq = cCon.prepareStatement(INSERT_CROSSREF_SQL3);
							CYzHFEiq.setString(1, zizm0IGJ);
							CYzHFEiq.setString(2, TN992TsW);
							CYzHFEiq.executeUpdate();
							CYzHFEiq.close();
						} catch (SQLException kP9OCKPY) {
							System.err.println("EXCEPTION HANDLING CROSSREF UPDATE");
						} finally {
							try {
								if (CYzHFEiq != null)
									CYzHFEiq.close();
							} catch (SQLException JqkL30kG) {
							}
						}
					}
				}
			}
		} else if ((ovgqqqOg != null) & (urMsJ56Q != null)) {
			String YD9dlTP6 = null;
			if (cCon != null) {
				PreparedStatement ctudBdAv = null;
				try {
					ctudBdAv = cCon.prepareStatement(QUERY_CROSSREF_SQL);
					ctudBdAv.setString(1, urMsJ56Q);
					ctudBdAv.setString(2, ovgqqqOg);
					ResultSet LswbhLdw = ctudBdAv.executeQuery();
					if (LswbhLdw.next()) {
						YD9dlTP6 = LswbhLdw.getString(1);
					}
					LswbhLdw.close();
					ctudBdAv.close();
				} catch (SQLException Ck51gDb8) {
					throw new GROBIDServiceException("EXCEPTION HANDLING CROSSREF CACHE", Ck51gDb8);
				} finally {
					try {
						if (ctudBdAv != null)
							ctudBdAv.close();
					} catch (SQLException R555d424) {
					}
				}
				if (YD9dlTP6 != null) {
					InputSource iCvbAHky = new InputSource();
					iCvbAHky.setCharacterStream(new StringReader(YD9dlTP6));
					DefaultHandler yhy581dZ = new crossrefUnixrefSaxParser(aFPTOIIx);
					SAXParserFactory E9vFqiQ7 = SAXParserFactory.newInstance();
					SAXParser R3vYkYMa = E9vFqiQ7.newSAXParser();
					R3vYkYMa.parse(iCvbAHky, yhy581dZ);
					if (aFPTOIIx.size() > 0) {
						if (!aFPTOIIx.get(0).getError())
							WuXJWYIH = true;
					}
				}
			}
			if (YD9dlTP6 == null) {
				String oWUZZ94y = String.format(TITLE_BASE_QUERY, crossref_id, crossref_pw, URLEncoder.encode(ovgqqqOg),
						URLEncoder.encode(urMsJ56Q));
				URL l6zpyToo = new URL("http://" + crossref_host + "/" + oWUZZ94y);
				System.out.println("Sending: " + l6zpyToo.toString());
				HttpURLConnection lzg8Ll1Z = null;
				try {
					lzg8Ll1Z = (HttpURLConnection) l6zpyToo.openConnection();
				} catch (Exception foxtO2hF) {
					this.setProxy();
					try {
						lzg8Ll1Z = (HttpURLConnection) l6zpyToo.openConnection();
					} catch (Exception uEzDCxbs) {
						lzg8Ll1Z = null;
						throw new GROBIDServiceException("An exception occured while running Grobid.", uEzDCxbs);
					}
				}
				if (lzg8Ll1Z != null) {
					try {
						lzg8Ll1Z.setDoOutput(true);
						lzg8Ll1Z.setDoInput(true);
						lzg8Ll1Z.setRequestMethod("GET");
						lzg8Ll1Z.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
						InputStream o9PhmJVT = lzg8Ll1Z.getInputStream();
						YD9dlTP6 = TextUtilities.convertStreamToString(o9PhmJVT);
						InputSource ImPrC6RH = new InputSource();
						ImPrC6RH.setCharacterStream(new StringReader(YD9dlTP6));
						DefaultHandler HndLP6oh = new crossrefUnixrefSaxParser(aFPTOIIx);
						SAXParserFactory u0Axw8q6 = SAXParserFactory.newInstance();
						SAXParser aXotiRDp = u0Axw8q6.newSAXParser();
						aXotiRDp.parse(ImPrC6RH, HndLP6oh);
						if (aFPTOIIx.size() > 0) {
							if (!aFPTOIIx.get(0).getError())
								WuXJWYIH = true;
						}
						lzg8Ll1Z.disconnect();
					} catch (Exception tzRUwtjJ) {
						System.err.println(
								"Warning: Consolidation set true, " + "but the online connection to Crossref fails.");
					}
					if (cCon != null) {
						PreparedStatement Ls2LMTN5 = null;
						try {
							Ls2LMTN5 = cCon.prepareStatement(INSERT_CROSSREF_SQL);
							Ls2LMTN5.setString(1, urMsJ56Q);
							Ls2LMTN5.setString(2, Y0uco020.getTitle());
							Ls2LMTN5.setString(3, YD9dlTP6);
							Ls2LMTN5.executeUpdate();
							Ls2LMTN5.close();
						} catch (SQLException c0GoSxr9) {
							System.err.println("EXCEPTION HANDLING CROSSREF UPDATE");
						} finally {
							try {
								if (Ls2LMTN5 != null)
									Ls2LMTN5.close();
							} catch (SQLException AapwpUnp) {
							}
						}
					}
				}
			}
		} else if ((q9tG6Icn != null) & (Y0uco020.getJournal() != null) & (Y0uco020.getVolume() != null)) {
			String ioPYnHQM = String.format(JOURNAL_BASE_QUERY, crossref_id, crossref_pw,
					URLEncoder.encode(Y0uco020.getJournal()), URLEncoder.encode(Y0uco020.getVolume()), q9tG6Icn);
			URL qI2mxI4x = new URL("http://" + crossref_host + "/" + ioPYnHQM);
			String J2APnqWn = qI2mxI4x.toString();
			System.out.println(J2APnqWn);
			String RH7gXlI0 = null;
			if (cCon != null) {
				PreparedStatement cx2jEvN2 = null;
				try {
					cx2jEvN2 = cCon.prepareStatement(QUERY_CROSSREF_SQL2);
					cx2jEvN2.setString(1, J2APnqWn);
					ResultSet ctHNDhdl = cx2jEvN2.executeQuery();
					if (ctHNDhdl.next()) {
						RH7gXlI0 = ctHNDhdl.getString(1);
					}
					ctHNDhdl.close();
					cx2jEvN2.close();
				} catch (SQLException sLqnDyvt) {
					System.err.println("EXCEPTION HANDLING CROSSREF CACHE");
					throw new GROBIDServiceException("EXCEPTION HANDLING CROSSREF CACHE.", sLqnDyvt);
				} finally {
					try {
						if (cx2jEvN2 != null)
							cx2jEvN2.close();
					} catch (SQLException bLCMc9rF) {
					}
				}
				if (RH7gXlI0 != null) {
					InputSource bcksc0N1 = new InputSource();
					bcksc0N1.setCharacterStream(new StringReader(RH7gXlI0));
					DefaultHandler rLm2WTno = new crossrefUnixrefSaxParser(aFPTOIIx);
					SAXParserFactory Zp1tsYbr = SAXParserFactory.newInstance();
					SAXParser GzaX1S5k = Zp1tsYbr.newSAXParser();
					GzaX1S5k.parse(bcksc0N1, rLm2WTno);
					if (aFPTOIIx.size() > 0) {
						if (!aFPTOIIx.get(0).getError())
							WuXJWYIH = true;
					}
				}
			}
			if (RH7gXlI0 == null) {
				System.out.println("Sending: " + J2APnqWn);
				HttpURLConnection uEYLP3i0 = null;
				try {
					uEYLP3i0 = (HttpURLConnection) qI2mxI4x.openConnection();
				} catch (Exception iVHtmXvW) {
					this.setProxy();
					try {
						uEYLP3i0 = (HttpURLConnection) qI2mxI4x.openConnection();
					} catch (Exception Jtpk3Gby) {
						uEYLP3i0 = null;
						throw new GROBIDServiceException("An exception occured while running Grobid.", Jtpk3Gby);
					}
				}
				if (uEYLP3i0 != null) {
					try {
						uEYLP3i0.setDoOutput(true);
						uEYLP3i0.setDoInput(true);
						uEYLP3i0.setRequestMethod("GET");
						uEYLP3i0.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
						InputStream zujhW5Wh = uEYLP3i0.getInputStream();
						RH7gXlI0 = TextUtilities.convertStreamToString(zujhW5Wh);
						InputSource mBQ8sOGM = new InputSource();
						mBQ8sOGM.setCharacterStream(new StringReader(RH7gXlI0));
						DefaultHandler jXZr8baw = new crossrefUnixrefSaxParser(aFPTOIIx);
						SAXParserFactory WCczF7wd = SAXParserFactory.newInstance();
						SAXParser kWh2MOWl = WCczF7wd.newSAXParser();
						kWh2MOWl.parse(mBQ8sOGM, jXZr8baw);
						if (aFPTOIIx.size() > 0) {
							if (!aFPTOIIx.get(0).getError())
								WuXJWYIH = true;
						}
						zujhW5Wh.close();
						uEYLP3i0.disconnect();
					} catch (Exception vwO1pnTK) {
						System.err.println(
								"Warning: Consolidation set true, " + "but the online connection to Crossref fails.");
					}
					if (cCon != null) {
						PreparedStatement F0lFhdhz = null;
						try {
							F0lFhdhz = cCon.prepareStatement(INSERT_CROSSREF_SQL2);
							F0lFhdhz.setString(1, J2APnqWn);
							F0lFhdhz.setString(2, RH7gXlI0);
							F0lFhdhz.executeUpdate();
							F0lFhdhz.close();
						} catch (SQLException d0EMlw9K) {
							System.err.println("EXCEPTION HANDLING CROSSREF UPDATE");
						} finally {
							try {
								if (F0lFhdhz != null)
									F0lFhdhz.close();
							} catch (SQLException z6HpcI7a) {
							}
						}
					}
				}
			}
		}
		return WuXJWYIH;
	}

}