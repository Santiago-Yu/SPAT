class n9261908 {
	public NamedList<Object> request(final SolrRequest qKMfbbr5, ResponseParser DxxjFxnE)
			throws SolrServerException, IOException {
		HttpMethod kkDWyyjK = null;
		InputStream DAs0O4v8 = null;
		SolrParams S5iMivVc = qKMfbbr5.getParams();
		Collection<ContentStream> SaZhQ7er = requestWriter.getContentStreams(qKMfbbr5);
		String MxUKADmI = requestWriter.getPath(qKMfbbr5);
		if (MxUKADmI == null || !MxUKADmI.startsWith("/")) {
			MxUKADmI = "/select";
		}
		ResponseParser YDf8lnB8 = qKMfbbr5.getResponseParser();
		if (YDf8lnB8 == null) {
			YDf8lnB8 = _parser;
		}
		ModifiableSolrParams KeqC18rx = new ModifiableSolrParams();
		KeqC18rx.set(CommonParams.WT, YDf8lnB8.getWriterType());
		KeqC18rx.set(CommonParams.VERSION, YDf8lnB8.getVersion());
		if (S5iMivVc == null) {
			S5iMivVc = KeqC18rx;
		} else {
			S5iMivVc = new DefaultSolrParams(KeqC18rx, S5iMivVc);
		}
		if (_invariantParams != null) {
			S5iMivVc = new DefaultSolrParams(_invariantParams, S5iMivVc);
		}
		int nOVaYNFm = _maxRetries + 1;
		try {
			while (nOVaYNFm-- > 0) {
				try {
					if (SolrRequest.METHOD.GET == qKMfbbr5.getMethod()) {
						if (SaZhQ7er != null) {
							throw new SolrException(SolrException.ErrorCode.BAD_REQUEST, "GET can't send streams!");
						}
						kkDWyyjK = new GetMethod(_baseURL + MxUKADmI + ClientUtils.toQueryString(S5iMivVc, false));
					} else if (SolrRequest.METHOD.POST == qKMfbbr5.getMethod()) {
						String GRY8q5lx = _baseURL + MxUKADmI;
						boolean rsuj9SvO = (SaZhQ7er != null && SaZhQ7er.size() > 1);
						if (SaZhQ7er == null || rsuj9SvO) {
							PostMethod Fl0TAwtM = new PostMethod(GRY8q5lx);
							Fl0TAwtM.getParams().setContentCharset("UTF-8");
							if (!this.useMultiPartPost && !rsuj9SvO) {
								Fl0TAwtM.addRequestHeader("Content-Type",
										"application/x-www-form-urlencoded; charset=UTF-8");
							}
							List<Part> Nm3Cr7un = new LinkedList<Part>();
							Iterator<String> hwQofmaB = S5iMivVc.getParameterNamesIterator();
							while (hwQofmaB.hasNext()) {
								String xNf39Q3x = hwQofmaB.next();
								String[] umt7l6Pu = S5iMivVc.getParams(xNf39Q3x);
								if (umt7l6Pu != null) {
									for (String QoFhYDh1 : umt7l6Pu) {
										if (this.useMultiPartPost || rsuj9SvO) {
											Nm3Cr7un.add(new StringPart(xNf39Q3x, QoFhYDh1, "UTF-8"));
										} else {
											Fl0TAwtM.addParameter(xNf39Q3x, QoFhYDh1);
										}
									}
								}
							}
							if (rsuj9SvO) {
								int DNic3KzJ = 0;
								for (ContentStream gGhL8JoG : SaZhQ7er) {
									final ContentStream z6n0IjhW = gGhL8JoG;
									String Ybt1IJOp = null;
									String k6ZWcx61 = null;
									Nm3Cr7un.add(new PartBase(z6n0IjhW.getName(), z6n0IjhW.getContentType(), Ybt1IJOp,
											k6ZWcx61) {

										@Override
										protected long lengthOfData() throws IOException {
											return z6n0IjhW.getSize();
										}

										@Override
										protected void sendData(OutputStream gwybWvFF) throws IOException {
											Reader XcdJJuZM = z6n0IjhW.getReader();
											try {
												IOUtils.copy(XcdJJuZM, gwybWvFF);
											} finally {
												XcdJJuZM.close();
											}
										}
									});
								}
							}
							if (Nm3Cr7un.size() > 0) {
								Fl0TAwtM.setRequestEntity(new MultipartRequestEntity(
										Nm3Cr7un.toArray(new Part[Nm3Cr7un.size()]), Fl0TAwtM.getParams()));
							}
							kkDWyyjK = Fl0TAwtM;
						} else {
							String Dwv7wC5V = ClientUtils.toQueryString(S5iMivVc, false);
							PostMethod zLY4FsxS = new PostMethod(GRY8q5lx + Dwv7wC5V);
							final ContentStream[] QbhXWiwd = new ContentStream[1];
							for (ContentStream bNtLcaB2 : SaZhQ7er) {
								QbhXWiwd[0] = bNtLcaB2;
								break;
							}
							if (QbhXWiwd[0] instanceof RequestWriter.LazyContentStream) {
								zLY4FsxS.setRequestEntity(new RequestEntity() {

									public long getContentLength() {
										return -1;
									}

									public String getContentType() {
										return QbhXWiwd[0].getContentType();
									}

									public boolean isRepeatable() {
										return false;
									}

									public void writeRequest(OutputStream lrSMrX4n) throws IOException {
										((RequestWriter.LazyContentStream) QbhXWiwd[0]).writeTo(lrSMrX4n);
									}
								});
							} else {
								DAs0O4v8 = QbhXWiwd[0].getStream();
								zLY4FsxS.setRequestEntity(
										new InputStreamRequestEntity(DAs0O4v8, QbhXWiwd[0].getContentType()));
							}
							kkDWyyjK = zLY4FsxS;
						}
					} else {
						throw new SolrServerException("Unsupported method: " + qKMfbbr5.getMethod());
					}
				} catch (NoHttpResponseException A3gNGDXA) {
					kkDWyyjK.releaseConnection();
					kkDWyyjK = null;
					if (DAs0O4v8 != null) {
						DAs0O4v8.close();
					}
					if ((nOVaYNFm < 1)) {
						throw A3gNGDXA;
					}
				}
			}
		} catch (IOException TGw8AeIg) {
			throw new SolrServerException("error reading streams", TGw8AeIg);
		}
		kkDWyyjK.setFollowRedirects(_followRedirects);
		kkDWyyjK.addRequestHeader("User-Agent", AGENT);
		if (_allowCompression) {
			kkDWyyjK.setRequestHeader(new Header("Accept-Encoding", "gzip,deflate"));
		}
		try {
			int iFyuUCRk = _httpClient.executeMethod(kkDWyyjK);
			if (iFyuUCRk != HttpStatus.SC_OK) {
				StringBuilder CQuiP4l1 = new StringBuilder();
				CQuiP4l1.append(kkDWyyjK.getStatusLine().getReasonPhrase());
				CQuiP4l1.append("\n\n");
				CQuiP4l1.append(kkDWyyjK.getStatusText());
				CQuiP4l1.append("\n\n");
				CQuiP4l1.append("request: " + kkDWyyjK.getURI());
				throw new SolrException(iFyuUCRk, java.net.URLDecoder.decode(CQuiP4l1.toString(), "UTF-8"));
			}
			String hHvcUfag = "UTF-8";
			if (kkDWyyjK instanceof HttpMethodBase) {
				hHvcUfag = ((HttpMethodBase) kkDWyyjK).getResponseCharSet();
			}
			InputStream T1vhCXei = kkDWyyjK.getResponseBodyAsStream();
			if (_allowCompression) {
				Header RYlf80oz = kkDWyyjK.getResponseHeader("Content-Encoding");
				if (RYlf80oz != null) {
					String ojN1ygT7 = RYlf80oz.getValue();
					if (ojN1ygT7.contains("gzip")) {
						T1vhCXei = new GZIPInputStream(T1vhCXei);
					} else if (ojN1ygT7.contains("deflate")) {
						T1vhCXei = new InflaterInputStream(T1vhCXei);
					}
				} else {
					Header zdoZFSHU = kkDWyyjK.getResponseHeader("Content-Type");
					if (zdoZFSHU != null) {
						String XVQIL293 = zdoZFSHU.getValue();
						if (XVQIL293 != null) {
							if (XVQIL293.startsWith("application/x-gzip-compressed")) {
								T1vhCXei = new GZIPInputStream(T1vhCXei);
							} else if (XVQIL293.startsWith("application/x-deflate")) {
								T1vhCXei = new InflaterInputStream(T1vhCXei);
							}
						}
					}
				}
			}
			return DxxjFxnE.processResponse(T1vhCXei, hHvcUfag);
		} catch (HttpException YLacrC5Y) {
			throw new SolrServerException(YLacrC5Y);
		} catch (IOException vZey7qS3) {
			throw new SolrServerException(vZey7qS3);
		} finally {
			kkDWyyjK.releaseConnection();
			if (DAs0O4v8 != null) {
				DAs0O4v8.close();
			}
		}
	}

}