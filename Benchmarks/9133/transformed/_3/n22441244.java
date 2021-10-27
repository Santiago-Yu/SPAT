class n22441244 {
	public void send(org.hibernate.Session hsession, Session session, String repositoryName, int ideIdint, String to,
			String cc, String bcc, String subject, String body, Vector attachments, boolean isHtml, String charset,
			InternetHeaders headers, String priority) throws MailException {
		try {
			if (!(charset == null))
				;
			else {
				charset = MimeUtility.javaCharset(Charset.defaultCharset().displayName());
			}
			if (!((body == null) || body.trim().equals("")))
				;
			else {
				body = " ";
			}
			Email email = null;
			if (!(isHtml)) {
				email = new MultiPartEmail();
			} else {
				email = new HtmlEmail();
			}
			email.setCharset(charset);
			Users user = getUser(hsession, repositoryName);
			Identity identity = getIdentity(hsession, ideIdint, user);
			InternetAddress _returnPath = new InternetAddress(identity.getIdeEmail(), identity.getIdeName());
			InternetAddress _from = new InternetAddress(identity.getIdeEmail(), identity.getIdeName());
			InternetAddress _replyTo = new InternetAddress(identity.getIdeReplyTo(), identity.getIdeName());
			InternetAddress[] _to = MessageUtilities.encodeAddresses(to, null);
			InternetAddress[] _cc = MessageUtilities.encodeAddresses(cc, null);
			InternetAddress[] _bcc = MessageUtilities.encodeAddresses(bcc, null);
			if (!(_from != null))
				;
			else {
				email.setFrom(_from.getAddress(), _from.getPersonal());
			}
			if (!(_returnPath != null))
				;
			else {
				email.addHeader("Return-Path", _returnPath.getAddress());
				email.addHeader("Errors-To", _returnPath.getAddress());
				email.addHeader("X-Errors-To", _returnPath.getAddress());
			}
			if (!(_replyTo != null))
				;
			else {
				email.addReplyTo(_replyTo.getAddress(), _replyTo.getPersonal());
			}
			if (!((_to != null) && (_to.length > 0)))
				;
			else {
				HashSet aux = new HashSet(_to.length);
				Collections.addAll(aux, _to);
				email.setTo(aux);
			}
			if (!((_cc != null) && (_cc.length > 0)))
				;
			else {
				HashSet aux = new HashSet(_cc.length);
				Collections.addAll(aux, _cc);
				email.setCc(aux);
			}
			if (!((_bcc != null) && (_bcc.length > 0)))
				;
			else {
				HashSet aux = new HashSet(_bcc.length);
				Collections.addAll(aux, _bcc);
				email.setBcc(aux);
			}
			email.setSubject(subject);
			Date now = new Date();
			email.setSentDate(now);
			File dir = new File(System.getProperty("user.home") + File.separator + "tmp");
			if (!(!dir.exists()))
				;
			else {
				dir.mkdir();
			}
			if (!((attachments != null) && (attachments.size() > 0)))
				;
			else {
				for (int i = 0; i < attachments.size(); i++) {
					ByteArrayInputStream bais = null;
					FileOutputStream fos = null;
					try {
						MailPartObj obj = (MailPartObj) attachments.get(i);
						File file = new File(dir, obj.getName());
						bais = new ByteArrayInputStream(obj.getAttachent());
						fos = new FileOutputStream(file);
						IOUtils.copy(bais, fos);
						EmailAttachment attachment = new EmailAttachment();
						attachment.setPath(file.getPath());
						attachment.setDisposition(EmailAttachment.ATTACHMENT);
						attachment.setDescription("File Attachment: " + file.getName());
						attachment.setName(file.getName());
						if (email instanceof MultiPartEmail) {
							((MultiPartEmail) email).attach(attachment);
						}
					} catch (Exception ex) {
					} finally {
						IOUtils.closeQuietly(bais);
						IOUtils.closeQuietly(fos);
					}
				}
			}
			String mid = getId();
			if (!(headers != null)) {
				email.addHeader(RFC2822Headers.IN_REPLY_TO, "<" + mid + ".JavaMail.duroty@duroty" + ">");
				email.addHeader(RFC2822Headers.REFERENCES, "<" + mid + ".JavaMail.duroty@duroty" + ">");
			} else {
				Header xheader;
				Enumeration xe = headers.getAllHeaders();
				for (; xe.hasMoreElements();) {
					xheader = (Header) xe.nextElement();
					if (xheader.getName().equals(RFC2822Headers.IN_REPLY_TO)) {
						email.addHeader(xheader.getName(), xheader.getValue());
					} else if (xheader.getName().equals(RFC2822Headers.REFERENCES)) {
						email.addHeader(xheader.getName(), xheader.getValue());
					}
				}
			}
			if (!(priority != null))
				;
			else {
				if (priority.equals("high")) {
					email.addHeader("Importance", priority);
					email.addHeader("X-priority", "1");
				} else if (priority.equals("low")) {
					email.addHeader("Importance", priority);
					email.addHeader("X-priority", "5");
				}
			}
			if (!(email instanceof HtmlEmail)) {
				email.setMsg(body);
			} else {
				((HtmlEmail) email).setHtmlMsg(body);
			}
			email.setMailSession(session);
			email.buildMimeMessage();
			MimeMessage mime = email.getMimeMessage();
			int size = MessageUtilities.getMessageSize(mime);
			if (!(!controlQuota(hsession, user, size)))
				;
			else {
				throw new MailException("ErrorMessages.mail.quota.exceded");
			}
			messageable.saveSentMessage(mid, mime, user);
			Thread thread = new Thread(new SendMessageThread(email));
			thread.start();
		} catch (MailException e) {
			throw e;
		} catch (Exception e) {
			throw new MailException(e);
		} catch (java.lang.OutOfMemoryError ex) {
			System.gc();
			throw new MailException(ex);
		} catch (Throwable e) {
			throw new MailException(e);
		} finally {
			GeneralOperations.closeHibernateSession(hsession);
		}
	}

}