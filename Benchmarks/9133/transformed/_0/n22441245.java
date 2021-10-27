class n22441245 {
	public void saveDraft(org.hibernate.Session Y40392rI, Session IQqKw5Lf, String l4u6UKG6, int djjNPS3p,
			String ZpqIEXxn, String wYdNOYb9, String SHI69PL2, String bI6d6wbm, String QnVWv9Vy, Vector grqAUYYq,
			boolean nEw65ljd, String svxTAfg7, InternetHeaders Rs1Z8EGI, String Ua3kHnho) throws MailException {
		try {
			if (svxTAfg7 == null) {
				svxTAfg7 = MimeUtility.javaCharset(Charset.defaultCharset().displayName());
			}
			if ((QnVWv9Vy == null) || QnVWv9Vy.trim().equals("")) {
				QnVWv9Vy = " ";
			}
			Email SiTYP0q3 = null;
			if (nEw65ljd) {
				SiTYP0q3 = new HtmlEmail();
			} else {
				SiTYP0q3 = new MultiPartEmail();
			}
			SiTYP0q3.setCharset(svxTAfg7);
			Users hcSkjVuG = getUser(Y40392rI, l4u6UKG6);
			Identity T7jMTf3o = getIdentity(Y40392rI, djjNPS3p, hcSkjVuG);
			InternetAddress SBYjvmqs = new InternetAddress(T7jMTf3o.getIdeEmail(), T7jMTf3o.getIdeName());
			InternetAddress amB1Twiq = new InternetAddress(T7jMTf3o.getIdeEmail(), T7jMTf3o.getIdeName());
			InternetAddress hWezL057 = new InternetAddress(T7jMTf3o.getIdeReplyTo(), T7jMTf3o.getIdeName());
			InternetAddress[] ZLHgdXPZ = MessageUtilities.encodeAddresses(ZpqIEXxn, null);
			InternetAddress[] qxY2sDas = MessageUtilities.encodeAddresses(wYdNOYb9, null);
			InternetAddress[] LUS5w71y = MessageUtilities.encodeAddresses(SHI69PL2, null);
			if (amB1Twiq != null) {
				SiTYP0q3.setFrom(amB1Twiq.getAddress(), amB1Twiq.getPersonal());
			}
			if (SBYjvmqs != null) {
				SiTYP0q3.addHeader("Return-Path", SBYjvmqs.getAddress());
				SiTYP0q3.addHeader("Errors-To", SBYjvmqs.getAddress());
				SiTYP0q3.addHeader("X-Errors-To", SBYjvmqs.getAddress());
			}
			if (hWezL057 != null) {
				SiTYP0q3.addReplyTo(hWezL057.getAddress(), hWezL057.getPersonal());
			}
			if ((ZLHgdXPZ != null) && (ZLHgdXPZ.length > 0)) {
				HashSet Ylq68SIa = new HashSet(ZLHgdXPZ.length);
				Collections.addAll(Ylq68SIa, ZLHgdXPZ);
				SiTYP0q3.setTo(Ylq68SIa);
			}
			if ((qxY2sDas != null) && (qxY2sDas.length > 0)) {
				HashSet zzRwaxau = new HashSet(qxY2sDas.length);
				Collections.addAll(zzRwaxau, qxY2sDas);
				SiTYP0q3.setCc(zzRwaxau);
			}
			if ((LUS5w71y != null) && (LUS5w71y.length > 0)) {
				HashSet qxQVvAmz = new HashSet(LUS5w71y.length);
				Collections.addAll(qxQVvAmz, LUS5w71y);
				SiTYP0q3.setBcc(qxQVvAmz);
			}
			SiTYP0q3.setSubject(bI6d6wbm);
			Date MpqFuWVE = new Date();
			SiTYP0q3.setSentDate(MpqFuWVE);
			File fahhER2q = new File(System.getProperty("user.home") + File.separator + "tmp");
			if (!fahhER2q.exists()) {
				fahhER2q.mkdir();
			}
			if ((grqAUYYq != null) && (grqAUYYq.size() > 0)) {
				for (int Zancq1tA = 0; Zancq1tA < grqAUYYq.size(); Zancq1tA++) {
					ByteArrayInputStream RfFIpjSz = null;
					FileOutputStream rjb41ZLs = null;
					try {
						MailPartObj Q2qL1Jld = (MailPartObj) grqAUYYq.get(Zancq1tA);
						File HBm3iABe = new File(fahhER2q, Q2qL1Jld.getName());
						RfFIpjSz = new ByteArrayInputStream(Q2qL1Jld.getAttachent());
						rjb41ZLs = new FileOutputStream(HBm3iABe);
						IOUtils.copy(RfFIpjSz, rjb41ZLs);
						EmailAttachment uXzDqXo7 = new EmailAttachment();
						uXzDqXo7.setPath(HBm3iABe.getPath());
						uXzDqXo7.setDisposition(EmailAttachment.ATTACHMENT);
						uXzDqXo7.setDescription("File Attachment: " + HBm3iABe.getName());
						uXzDqXo7.setName(HBm3iABe.getName());
						if (SiTYP0q3 instanceof MultiPartEmail) {
							((MultiPartEmail) SiTYP0q3).attach(uXzDqXo7);
						}
					} catch (Exception BO4MBRZl) {
					} finally {
						IOUtils.closeQuietly(RfFIpjSz);
						IOUtils.closeQuietly(rjb41ZLs);
					}
				}
			}
			if (Rs1Z8EGI != null) {
				Header fQC99sUA;
				Enumeration shr1qLX2 = Rs1Z8EGI.getAllHeaders();
				for (; shr1qLX2.hasMoreElements();) {
					fQC99sUA = (Header) shr1qLX2.nextElement();
					if (fQC99sUA.getName().equals(RFC2822Headers.IN_REPLY_TO)) {
						SiTYP0q3.addHeader(fQC99sUA.getName(), fQC99sUA.getValue());
					} else if (fQC99sUA.getName().equals(RFC2822Headers.REFERENCES)) {
						SiTYP0q3.addHeader(fQC99sUA.getName(), fQC99sUA.getValue());
					}
				}
			}
			if (Ua3kHnho != null) {
				if (Ua3kHnho.equals("high")) {
					SiTYP0q3.addHeader("Importance", Ua3kHnho);
					SiTYP0q3.addHeader("X-priority", "1");
				} else if (Ua3kHnho.equals("low")) {
					SiTYP0q3.addHeader("Importance", Ua3kHnho);
					SiTYP0q3.addHeader("X-priority", "5");
				}
			}
			if (SiTYP0q3 instanceof HtmlEmail) {
				((HtmlEmail) SiTYP0q3).setHtmlMsg(QnVWv9Vy);
			} else {
				SiTYP0q3.setMsg(QnVWv9Vy);
			}
			SiTYP0q3.setMailSession(IQqKw5Lf);
			SiTYP0q3.buildMimeMessage();
			MimeMessage HCmh79u3 = SiTYP0q3.getMimeMessage();
			int jEQ9D05Z = MessageUtilities.getMessageSize(HCmh79u3);
			if (!controlQuota(Y40392rI, hcSkjVuG, jEQ9D05Z)) {
				throw new MailException("ErrorMessages.mail.quota.exceded");
			}
			messageable.storeDraftMessage(getId(), HCmh79u3, hcSkjVuG);
		} catch (MailException Hzi80Eyk) {
			throw Hzi80Eyk;
		} catch (Exception l7ifcqQt) {
			throw new MailException(l7ifcqQt);
		} catch (java.lang.OutOfMemoryError E5x1hksc) {
			System.gc();
			throw new MailException(E5x1hksc);
		} catch (Throwable mLIQVxdt) {
			throw new MailException(mLIQVxdt);
		} finally {
			GeneralOperations.closeHibernateSession(Y40392rI);
		}
	}

}