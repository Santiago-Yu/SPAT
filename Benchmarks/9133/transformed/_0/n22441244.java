class n22441244 {
	public void send(org.hibernate.Session RVviLQY6, Session EKDFdkXn, String dui1WyLr, int Fr4OIGaI, String Wz9Utf2U,
			String eZqWyOHk, String BAH42dj5, String Oom8SDws, String zP2YoDLz, Vector i9vZRUPA, boolean E8uuVpch,
			String K9fBIGwY, InternetHeaders NHHZ8NZk, String ySAGozfy) throws MailException {
		try {
			if (K9fBIGwY == null) {
				K9fBIGwY = MimeUtility.javaCharset(Charset.defaultCharset().displayName());
			}
			if ((zP2YoDLz == null) || zP2YoDLz.trim().equals("")) {
				zP2YoDLz = " ";
			}
			Email Fgr6VFVR = null;
			if (E8uuVpch) {
				Fgr6VFVR = new HtmlEmail();
			} else {
				Fgr6VFVR = new MultiPartEmail();
			}
			Fgr6VFVR.setCharset(K9fBIGwY);
			Users nFycleDB = getUser(RVviLQY6, dui1WyLr);
			Identity dkuMihJY = getIdentity(RVviLQY6, Fr4OIGaI, nFycleDB);
			InternetAddress pCkaQlxg = new InternetAddress(dkuMihJY.getIdeEmail(), dkuMihJY.getIdeName());
			InternetAddress WErPFUeQ = new InternetAddress(dkuMihJY.getIdeEmail(), dkuMihJY.getIdeName());
			InternetAddress sirLeU1b = new InternetAddress(dkuMihJY.getIdeReplyTo(), dkuMihJY.getIdeName());
			InternetAddress[] UqKAaCzr = MessageUtilities.encodeAddresses(Wz9Utf2U, null);
			InternetAddress[] VKy13m0l = MessageUtilities.encodeAddresses(eZqWyOHk, null);
			InternetAddress[] K5y8cWE7 = MessageUtilities.encodeAddresses(BAH42dj5, null);
			if (WErPFUeQ != null) {
				Fgr6VFVR.setFrom(WErPFUeQ.getAddress(), WErPFUeQ.getPersonal());
			}
			if (pCkaQlxg != null) {
				Fgr6VFVR.addHeader("Return-Path", pCkaQlxg.getAddress());
				Fgr6VFVR.addHeader("Errors-To", pCkaQlxg.getAddress());
				Fgr6VFVR.addHeader("X-Errors-To", pCkaQlxg.getAddress());
			}
			if (sirLeU1b != null) {
				Fgr6VFVR.addReplyTo(sirLeU1b.getAddress(), sirLeU1b.getPersonal());
			}
			if ((UqKAaCzr != null) && (UqKAaCzr.length > 0)) {
				HashSet C9wBafxY = new HashSet(UqKAaCzr.length);
				Collections.addAll(C9wBafxY, UqKAaCzr);
				Fgr6VFVR.setTo(C9wBafxY);
			}
			if ((VKy13m0l != null) && (VKy13m0l.length > 0)) {
				HashSet bWh8MWKg = new HashSet(VKy13m0l.length);
				Collections.addAll(bWh8MWKg, VKy13m0l);
				Fgr6VFVR.setCc(bWh8MWKg);
			}
			if ((K5y8cWE7 != null) && (K5y8cWE7.length > 0)) {
				HashSet tYCVLbJt = new HashSet(K5y8cWE7.length);
				Collections.addAll(tYCVLbJt, K5y8cWE7);
				Fgr6VFVR.setBcc(tYCVLbJt);
			}
			Fgr6VFVR.setSubject(Oom8SDws);
			Date Quq1GJZi = new Date();
			Fgr6VFVR.setSentDate(Quq1GJZi);
			File J6IXXdOu = new File(System.getProperty("user.home") + File.separator + "tmp");
			if (!J6IXXdOu.exists()) {
				J6IXXdOu.mkdir();
			}
			if ((i9vZRUPA != null) && (i9vZRUPA.size() > 0)) {
				for (int TWe9DCh7 = 0; TWe9DCh7 < i9vZRUPA.size(); TWe9DCh7++) {
					ByteArrayInputStream zjhCsm8y = null;
					FileOutputStream fI5ZBh6i = null;
					try {
						MailPartObj Ad8BPSTQ = (MailPartObj) i9vZRUPA.get(TWe9DCh7);
						File Tu7PFqHH = new File(J6IXXdOu, Ad8BPSTQ.getName());
						zjhCsm8y = new ByteArrayInputStream(Ad8BPSTQ.getAttachent());
						fI5ZBh6i = new FileOutputStream(Tu7PFqHH);
						IOUtils.copy(zjhCsm8y, fI5ZBh6i);
						EmailAttachment NvmZCTWV = new EmailAttachment();
						NvmZCTWV.setPath(Tu7PFqHH.getPath());
						NvmZCTWV.setDisposition(EmailAttachment.ATTACHMENT);
						NvmZCTWV.setDescription("File Attachment: " + Tu7PFqHH.getName());
						NvmZCTWV.setName(Tu7PFqHH.getName());
						if (Fgr6VFVR instanceof MultiPartEmail) {
							((MultiPartEmail) Fgr6VFVR).attach(NvmZCTWV);
						}
					} catch (Exception Cjb2jLJj) {
					} finally {
						IOUtils.closeQuietly(zjhCsm8y);
						IOUtils.closeQuietly(fI5ZBh6i);
					}
				}
			}
			String oKvYZOZg = getId();
			if (NHHZ8NZk != null) {
				Header EzEBt0Da;
				Enumeration UNCuWCIg = NHHZ8NZk.getAllHeaders();
				for (; UNCuWCIg.hasMoreElements();) {
					EzEBt0Da = (Header) UNCuWCIg.nextElement();
					if (EzEBt0Da.getName().equals(RFC2822Headers.IN_REPLY_TO)) {
						Fgr6VFVR.addHeader(EzEBt0Da.getName(), EzEBt0Da.getValue());
					} else if (EzEBt0Da.getName().equals(RFC2822Headers.REFERENCES)) {
						Fgr6VFVR.addHeader(EzEBt0Da.getName(), EzEBt0Da.getValue());
					}
				}
			} else {
				Fgr6VFVR.addHeader(RFC2822Headers.IN_REPLY_TO, "<" + oKvYZOZg + ".JavaMail.duroty@duroty" + ">");
				Fgr6VFVR.addHeader(RFC2822Headers.REFERENCES, "<" + oKvYZOZg + ".JavaMail.duroty@duroty" + ">");
			}
			if (ySAGozfy != null) {
				if (ySAGozfy.equals("high")) {
					Fgr6VFVR.addHeader("Importance", ySAGozfy);
					Fgr6VFVR.addHeader("X-priority", "1");
				} else if (ySAGozfy.equals("low")) {
					Fgr6VFVR.addHeader("Importance", ySAGozfy);
					Fgr6VFVR.addHeader("X-priority", "5");
				}
			}
			if (Fgr6VFVR instanceof HtmlEmail) {
				((HtmlEmail) Fgr6VFVR).setHtmlMsg(zP2YoDLz);
			} else {
				Fgr6VFVR.setMsg(zP2YoDLz);
			}
			Fgr6VFVR.setMailSession(EKDFdkXn);
			Fgr6VFVR.buildMimeMessage();
			MimeMessage CxiDPjo5 = Fgr6VFVR.getMimeMessage();
			int tPJ58iUA = MessageUtilities.getMessageSize(CxiDPjo5);
			if (!controlQuota(RVviLQY6, nFycleDB, tPJ58iUA)) {
				throw new MailException("ErrorMessages.mail.quota.exceded");
			}
			messageable.saveSentMessage(oKvYZOZg, CxiDPjo5, nFycleDB);
			Thread yx40tObk = new Thread(new SendMessageThread(Fgr6VFVR));
			yx40tObk.start();
		} catch (MailException KCLzOcJb) {
			throw KCLzOcJb;
		} catch (Exception F5zMz5a3) {
			throw new MailException(F5zMz5a3);
		} catch (java.lang.OutOfMemoryError IqnX6Q8s) {
			System.gc();
			throw new MailException(IqnX6Q8s);
		} catch (Throwable q5SDCIsP) {
			throw new MailException(q5SDCIsP);
		} finally {
			GeneralOperations.closeHibernateSession(RVviLQY6);
		}
	}

}