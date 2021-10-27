class n1152136 {
	@SuppressWarnings("unchecked")
	public ArrayList<GmailContact> getAllContacts() throws GmailException {
		String L1BHOhPJ = properties.getString("export_page");
		L1BHOhPJ = L1BHOhPJ.replace("[RANDOM_INT]", "" + random.nextInt());
		int IK1M94dY = -1;
		GetMethod lTq249lO = new GetMethod(L1BHOhPJ);
		if (log.isInfoEnabled())
			log.info("getting all contacts ...");
		try {
			IK1M94dY = client.executeMethod(lTq249lO);
			if (IK1M94dY != 200)
				throw new GmailException(
						"In contacts export page: Status code expected: 200 -> Status code returned: " + IK1M94dY);
		} catch (HttpException uAzQy1HZ) {
			throw new GmailException("HttpException in contacts export page:" + uAzQy1HZ.getMessage());
		} catch (IOException egVuCpfO) {
			throw new GmailException("IOException in contacts export page:" + egVuCpfO.getMessage());
		} finally {
			lTq249lO.releaseConnection();
		}
		if (log.isTraceEnabled())
			log.trace("accessing contacts export page successful...");
		String uYtVH7oy = properties.getString("outlook_export_page");
		PostMethod Cu7DDC4d = new PostMethod(uYtVH7oy);
		Cu7DDC4d.addRequestHeader("Accept-Encoding", "gzip,deflate");
		Cu7DDC4d.addRequestHeader("Accept-Charset", "ISO-8859-1,utf-8;q=0.7,*;q=0.8");
		NameValuePair[] Mgp9VyLp = { new NameValuePair("at", getCookie("GMAIL_AT")), new NameValuePair("ecf", "o"),
				new NameValuePair("ac", "Export Contacts") };
		Cu7DDC4d.setRequestBody(Mgp9VyLp);
		if (log.isTraceEnabled())
			log.trace("getting contacts csv file...");
		try {
			IK1M94dY = client.executeMethod(Cu7DDC4d);
			if (IK1M94dY != 200)
				throw new GmailException(
						"In csv file post: Status code expected: 200 -> Status code returned: " + IK1M94dY);
			if (log.isTraceEnabled())
				log.trace("Gmail: csv charset: " + Cu7DDC4d.getResponseCharSet());
			GMAIL_OUTPUT_CHARSET = Cu7DDC4d.getResponseCharSet();
			InputStreamReader D0eahQv3 = new InputStreamReader(new GZIPInputStream(Cu7DDC4d.getResponseBodyAsStream()),
					Cu7DDC4d.getResponseCharSet());
			CSVReader XOc42fqx = new CSVReader(D0eahQv3);
			List A0SyTjAk = XOc42fqx.readAll();
			XOc42fqx.close();
			ArrayList<GmailContact> UZuACe3V = new ArrayList<GmailContact>();
			MessageDigest SZkRfDR1 = MessageDigest.getInstance("MD5");
			if (log.isTraceEnabled())
				log.trace("creating Gmail contacts...");
			for (int Xi2jl636 = 1; Xi2jl636 < A0SyTjAk.size(); Xi2jl636++) {
				GmailContact ssG63Q7U = new GmailContact();
				String[] YFxHz4Li = (String[]) A0SyTjAk.get(Xi2jl636);
				for (int mdmmGWTU = 0; mdmmGWTU < YFxHz4Li.length; mdmmGWTU++) {
					switch (mdmmGWTU) {
					case 0:
						ssG63Q7U.setName(YFxHz4Li[mdmmGWTU]);
						break;
					case 1:
						ssG63Q7U.setEmail(YFxHz4Li[mdmmGWTU]);
						if (ssG63Q7U.getName() == null)
							ssG63Q7U.setIdName(YFxHz4Li[mdmmGWTU]);
						else
							ssG63Q7U.setIdName(ssG63Q7U.getName() + YFxHz4Li[mdmmGWTU]);
						break;
					case 2:
						ssG63Q7U.setNotes(YFxHz4Li[mdmmGWTU]);
						break;
					case 3:
						ssG63Q7U.setEmail2(YFxHz4Li[mdmmGWTU]);
						break;
					case 4:
						ssG63Q7U.setEmail3(YFxHz4Li[mdmmGWTU]);
						break;
					case 5:
						ssG63Q7U.setMobilePhone(YFxHz4Li[mdmmGWTU]);
						break;
					case 6:
						ssG63Q7U.setPager(YFxHz4Li[mdmmGWTU]);
						break;
					case 7:
						ssG63Q7U.setCompany(YFxHz4Li[mdmmGWTU]);
						break;
					case 8:
						ssG63Q7U.setJobTitle(YFxHz4Li[mdmmGWTU]);
						break;
					case 9:
						ssG63Q7U.setHomePhone(YFxHz4Li[mdmmGWTU]);
						break;
					case 10:
						ssG63Q7U.setHomePhone2(YFxHz4Li[mdmmGWTU]);
						break;
					case 11:
						ssG63Q7U.setHomeFax(YFxHz4Li[mdmmGWTU]);
						break;
					case 12:
						ssG63Q7U.setHomeAddress(YFxHz4Li[mdmmGWTU]);
						break;
					case 13:
						ssG63Q7U.setBusinessPhone(YFxHz4Li[mdmmGWTU]);
						break;
					case 14:
						ssG63Q7U.setBusinessPhone2(YFxHz4Li[mdmmGWTU]);
						break;
					case 15:
						ssG63Q7U.setBusinessFax(YFxHz4Li[mdmmGWTU]);
						break;
					case 16:
						ssG63Q7U.setBusinessAddress(YFxHz4Li[mdmmGWTU]);
						break;
					case 17:
						ssG63Q7U.setOtherPhone(YFxHz4Li[mdmmGWTU]);
						break;
					case 18:
						ssG63Q7U.setOtherFax(YFxHz4Li[mdmmGWTU]);
						break;
					case 19:
						ssG63Q7U.setOtherAddress(YFxHz4Li[mdmmGWTU]);
						break;
					}
				}
				SZkRfDR1.update(ssG63Q7U.toString().getBytes());
				if (log.isTraceEnabled())
					log.trace("setting Md5 Hash...");
				ssG63Q7U.setMd5Hash(new BigInteger(SZkRfDR1.digest()).toString());
				UZuACe3V.add(ssG63Q7U);
			}
			if (log.isTraceEnabled())
				log.trace("Mapping contacts uid...");
			Collections.sort(UZuACe3V);
			ArrayList<GmailContact> BMmL6SYT = getAllContactsID();
			for (int oEktW2si = 0; oEktW2si < BMmL6SYT.size(); oEktW2si++) {
				UZuACe3V.get(oEktW2si).setId(BMmL6SYT.get(oEktW2si).getId());
			}
			if (log.isInfoEnabled())
				log.info("getting all contacts info successful...");
			return UZuACe3V;
		} catch (HttpException VR6w2cRa) {
			throw new GmailException("HttpException in csv file post:" + VR6w2cRa.getMessage());
		} catch (IOException es4Kem5r) {
			throw new GmailException("IOException in csv file post:" + es4Kem5r.getMessage());
		} catch (NoSuchAlgorithmException GYDABTDS) {
			throw new GmailException("No such md5 algorithm " + GYDABTDS.getMessage());
		} finally {
			Cu7DDC4d.releaseConnection();
		}
	}

}