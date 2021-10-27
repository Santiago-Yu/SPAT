class n14794142 {
	public boolean consolidateCrossrefGet(BiblioItem bib, ArrayList<BiblioItem> bib2) throws Exception {
		boolean result = false;
		String doi = bib.getDOI();
		String aut = bib.getFirstAuthorSurname();
		String title = bib.getTitle();
		String firstPage = null;
		String pageRange = bib.getPageRange();
		int beginPage = bib.getBeginPage();
		if (beginPage != -1) {
			firstPage = "" + beginPage;
		} else if (pageRange != null) {
			StringTokenizer st = new StringTokenizer(pageRange, "--");
			if (2 == st.countTokens()) {
				firstPage = st.nextToken();
			} else if (1 == st.countTokens())
				firstPage = pageRange;
		}
		if (aut != null) {
			aut = TextUtilities.removeAccents(aut);
		}
		if (title != null) {
			title = TextUtilities.removeAccents(title);
		}
		if (doi != null) {
			if (doi.startsWith("doi:") | doi.startsWith("DOI:")) {
				doi.substring(4, doi.length());
				doi = doi.trim();
			}
			doi = doi.replace(" ", "");
			String xml = null;
			if (cCon != null) {
				PreparedStatement pstmt = null;
				try {
					pstmt = cCon.prepareStatement(QUERY_CROSSREF_SQL3);
					pstmt.setString(1, doi);
					ResultSet res = pstmt.executeQuery();
					if (res.next()) {
						xml = res.getString(1);
					}
					res.close();
					pstmt.close();
				} catch (SQLException se) {
					System.err.println("EXCEPTION HANDLING CROSSREF CACHE");
					throw new GROBIDServiceException("EXCEPTION HANDLING CROSSREF CACHE.", se);
				} finally {
					try {
						if (pstmt != null)
							pstmt.close();
					} catch (SQLException se) {
					}
				}
				if (xml != null) {
					InputSource is = new InputSource();
					is.setCharacterStream(new StringReader(xml));
					DefaultHandler crossref = new crossrefUnixrefSaxParser(bib2);
					SAXParserFactory spf = SAXParserFactory.newInstance();
					SAXParser parser = spf.newSAXParser();
					parser.parse(is, crossref);
					if (bib2.size() > 0) {
						if (!bib2.get(0).getError())
							result = true;
					}
				}
			}
			if (null == xml) {
				String subpath = String.format(DOI_BASE_QUERY, crossref_id, crossref_pw, doi);
				URL url = new URL("http://" + crossref_host + "/" + subpath);
				System.out.println("Sending: " + url.toString());
				HttpURLConnection urlConn = null;
				try {
					urlConn = (HttpURLConnection) url.openConnection();
				} catch (Exception e) {
					this.setProxy();
					try {
						urlConn = (HttpURLConnection) url.openConnection();
					} catch (Exception e2) {
						urlConn = null;
						throw new GROBIDServiceException("An exception occured while running Grobid.", e2);
					}
				}
				if (urlConn != null) {
					try {
						urlConn.setDoOutput(true);
						urlConn.setDoInput(true);
						urlConn.setRequestMethod("GET");
						urlConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
						InputStream in = urlConn.getInputStream();
						xml = TextUtilities.convertStreamToString(in);
						InputSource is = new InputSource();
						is.setCharacterStream(new StringReader(xml));
						DefaultHandler crossref = new crossrefUnixrefSaxParser(bib2);
						SAXParserFactory spf = SAXParserFactory.newInstance();
						SAXParser parser = spf.newSAXParser();
						parser.parse(is, crossref);
						if (bib2.size() > 0) {
							if (!bib2.get(0).getError())
								result = true;
						}
						urlConn.disconnect();
					} catch (Exception e) {
						System.err.println(
								"Warning: Consolidation set true, " + "but the online connection to Crossref fails.");
					}
					if (cCon != null) {
						PreparedStatement pstmt2 = null;
						try {
							pstmt2 = cCon.prepareStatement(INSERT_CROSSREF_SQL3);
							pstmt2.setString(1, doi);
							pstmt2.setString(2, xml);
							pstmt2.executeUpdate();
							pstmt2.close();
						} catch (SQLException se) {
							System.err.println("EXCEPTION HANDLING CROSSREF UPDATE");
						} finally {
							try {
								if (pstmt2 != null)
									pstmt2.close();
							} catch (SQLException se) {
							}
						}
					}
				}
			}
		} else if ((title != null) & (aut != null)) {
			String xml = null;
			if (cCon != null) {
				PreparedStatement pstmt = null;
				try {
					pstmt = cCon.prepareStatement(QUERY_CROSSREF_SQL);
					pstmt.setString(1, aut);
					pstmt.setString(2, title);
					ResultSet res = pstmt.executeQuery();
					if (res.next()) {
						xml = res.getString(1);
					}
					res.close();
					pstmt.close();
				} catch (SQLException se) {
					throw new GROBIDServiceException("EXCEPTION HANDLING CROSSREF CACHE", se);
				} finally {
					try {
						if (pstmt != null)
							pstmt.close();
					} catch (SQLException se) {
					}
				}
				if (xml != null) {
					InputSource is = new InputSource();
					is.setCharacterStream(new StringReader(xml));
					DefaultHandler crossref = new crossrefUnixrefSaxParser(bib2);
					SAXParserFactory spf = SAXParserFactory.newInstance();
					SAXParser parser = spf.newSAXParser();
					parser.parse(is, crossref);
					if (bib2.size() > 0) {
						if (!bib2.get(0).getError())
							result = true;
					}
				}
			}
			if (null == xml) {
				String subpath = String.format(TITLE_BASE_QUERY, crossref_id, crossref_pw, URLEncoder.encode(title),
						URLEncoder.encode(aut));
				URL url = new URL("http://" + crossref_host + "/" + subpath);
				System.out.println("Sending: " + url.toString());
				HttpURLConnection urlConn = null;
				try {
					urlConn = (HttpURLConnection) url.openConnection();
				} catch (Exception e) {
					this.setProxy();
					try {
						urlConn = (HttpURLConnection) url.openConnection();
					} catch (Exception e2) {
						urlConn = null;
						throw new GROBIDServiceException("An exception occured while running Grobid.", e2);
					}
				}
				if (urlConn != null) {
					try {
						urlConn.setDoOutput(true);
						urlConn.setDoInput(true);
						urlConn.setRequestMethod("GET");
						urlConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
						InputStream in = urlConn.getInputStream();
						xml = TextUtilities.convertStreamToString(in);
						InputSource is = new InputSource();
						is.setCharacterStream(new StringReader(xml));
						DefaultHandler crossref = new crossrefUnixrefSaxParser(bib2);
						SAXParserFactory spf = SAXParserFactory.newInstance();
						SAXParser parser = spf.newSAXParser();
						parser.parse(is, crossref);
						if (bib2.size() > 0) {
							if (!bib2.get(0).getError())
								result = true;
						}
						urlConn.disconnect();
					} catch (Exception e) {
						System.err.println(
								"Warning: Consolidation set true, " + "but the online connection to Crossref fails.");
					}
					if (cCon != null) {
						PreparedStatement pstmt2 = null;
						try {
							pstmt2 = cCon.prepareStatement(INSERT_CROSSREF_SQL);
							pstmt2.setString(1, aut);
							pstmt2.setString(2, bib.getTitle());
							pstmt2.setString(3, xml);
							pstmt2.executeUpdate();
							pstmt2.close();
						} catch (SQLException se) {
							System.err.println("EXCEPTION HANDLING CROSSREF UPDATE");
						} finally {
							try {
								if (pstmt2 != null)
									pstmt2.close();
							} catch (SQLException se) {
							}
						}
					}
				}
			}
		} else if ((firstPage != null) & (bib.getJournal() != null) & (bib.getVolume() != null)) {
			String subpath = String.format(JOURNAL_BASE_QUERY, crossref_id, crossref_pw,
					URLEncoder.encode(bib.getJournal()), URLEncoder.encode(bib.getVolume()), firstPage);
			URL url = new URL("http://" + crossref_host + "/" + subpath);
			String urlmsg = url.toString();
			System.out.println(urlmsg);
			String xml = null;
			if (cCon != null) {
				PreparedStatement pstmt = null;
				try {
					pstmt = cCon.prepareStatement(QUERY_CROSSREF_SQL2);
					pstmt.setString(1, urlmsg);
					ResultSet res = pstmt.executeQuery();
					if (res.next()) {
						xml = res.getString(1);
					}
					res.close();
					pstmt.close();
				} catch (SQLException se) {
					System.err.println("EXCEPTION HANDLING CROSSREF CACHE");
					throw new GROBIDServiceException("EXCEPTION HANDLING CROSSREF CACHE.", se);
				} finally {
					try {
						if (pstmt != null)
							pstmt.close();
					} catch (SQLException se) {
					}
				}
				if (xml != null) {
					InputSource is = new InputSource();
					is.setCharacterStream(new StringReader(xml));
					DefaultHandler crossref = new crossrefUnixrefSaxParser(bib2);
					SAXParserFactory spf = SAXParserFactory.newInstance();
					SAXParser parser = spf.newSAXParser();
					parser.parse(is, crossref);
					if (bib2.size() > 0) {
						if (!bib2.get(0).getError())
							result = true;
					}
				}
			}
			if (null == xml) {
				System.out.println("Sending: " + urlmsg);
				HttpURLConnection urlConn = null;
				try {
					urlConn = (HttpURLConnection) url.openConnection();
				} catch (Exception e) {
					this.setProxy();
					try {
						urlConn = (HttpURLConnection) url.openConnection();
					} catch (Exception e2) {
						urlConn = null;
						throw new GROBIDServiceException("An exception occured while running Grobid.", e2);
					}
				}
				if (urlConn != null) {
					try {
						urlConn.setDoOutput(true);
						urlConn.setDoInput(true);
						urlConn.setRequestMethod("GET");
						urlConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
						InputStream in = urlConn.getInputStream();
						xml = TextUtilities.convertStreamToString(in);
						InputSource is = new InputSource();
						is.setCharacterStream(new StringReader(xml));
						DefaultHandler crossref = new crossrefUnixrefSaxParser(bib2);
						SAXParserFactory spf = SAXParserFactory.newInstance();
						SAXParser p = spf.newSAXParser();
						p.parse(is, crossref);
						if (bib2.size() > 0) {
							if (!bib2.get(0).getError())
								result = true;
						}
						in.close();
						urlConn.disconnect();
					} catch (Exception e) {
						System.err.println(
								"Warning: Consolidation set true, " + "but the online connection to Crossref fails.");
					}
					if (cCon != null) {
						PreparedStatement pstmt2 = null;
						try {
							pstmt2 = cCon.prepareStatement(INSERT_CROSSREF_SQL2);
							pstmt2.setString(1, urlmsg);
							pstmt2.setString(2, xml);
							pstmt2.executeUpdate();
							pstmt2.close();
						} catch (SQLException se) {
							System.err.println("EXCEPTION HANDLING CROSSREF UPDATE");
						} finally {
							try {
								if (pstmt2 != null)
									pstmt2.close();
							} catch (SQLException se) {
							}
						}
					}
				}
			}
		}
		return result;
	}

}