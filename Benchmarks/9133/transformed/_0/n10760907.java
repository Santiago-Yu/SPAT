class n10760907 {
	public void send(org.hibernate.Session lrHuwIo8, Session HtSU6wzT, String MK1dORyg, Vector mNH979ba, int vghIf84G,
			String PafyNR87) throws FilesException {
		ByteArrayInputStream ym5tCwVL = null;
		FileOutputStream MrzBLxyy = null;
		try {
			if ((mNH979ba == null) || (mNH979ba.size() <= 0)) {
				return;
			}
			if (PafyNR87 == null) {
				PafyNR87 = MimeUtility.javaCharset(Charset.defaultCharset().displayName());
			}
			Users kJzxHnUP = getUser(lrHuwIo8, MK1dORyg);
			Identity UqbhYHlu = getDefaultIdentity(lrHuwIo8, kJzxHnUP);
			InternetAddress BKtxHhqR = new InternetAddress(UqbhYHlu.getIdeEmail(), UqbhYHlu.getIdeName());
			InternetAddress MKMSSD8U = new InternetAddress(UqbhYHlu.getIdeEmail(), UqbhYHlu.getIdeName());
			InternetAddress H912qwMW = new InternetAddress(UqbhYHlu.getIdeReplyTo(), UqbhYHlu.getIdeName());
			InternetAddress tc7uJ1UD = new InternetAddress(UqbhYHlu.getIdeEmail(), UqbhYHlu.getIdeName());
			for (int ObAf2trL = 0; ObAf2trL < mNH979ba.size(); ObAf2trL++) {
				MultiPartEmail cgrfAhHY = cgrfAhHY = new MultiPartEmail();
				cgrfAhHY.setCharset(PafyNR87);
				if (MKMSSD8U != null) {
					cgrfAhHY.setFrom(MKMSSD8U.getAddress(), MKMSSD8U.getPersonal());
				}
				if (BKtxHhqR != null) {
					cgrfAhHY.addHeader("Return-Path", BKtxHhqR.getAddress());
					cgrfAhHY.addHeader("Errors-To", BKtxHhqR.getAddress());
					cgrfAhHY.addHeader("X-Errors-To", BKtxHhqR.getAddress());
				}
				if (H912qwMW != null) {
					cgrfAhHY.addReplyTo(H912qwMW.getAddress(), H912qwMW.getPersonal());
				}
				if (tc7uJ1UD != null) {
					cgrfAhHY.addTo(tc7uJ1UD.getAddress(), tc7uJ1UD.getPersonal());
				}
				MailPartObj pXJiPFig = (MailPartObj) mNH979ba.get(ObAf2trL);
				cgrfAhHY.setSubject("Files-System " + pXJiPFig.getName());
				Date w1Qew0AP = new Date();
				cgrfAhHY.setSentDate(w1Qew0AP);
				File COgL2FTp = new File(System.getProperty("user.home") + File.separator + "tmp");
				if (!COgL2FTp.exists()) {
					COgL2FTp.mkdir();
				}
				File PBbJ08ng = new File(COgL2FTp, pXJiPFig.getName());
				ym5tCwVL = new ByteArrayInputStream(pXJiPFig.getAttachent());
				MrzBLxyy = new FileOutputStream(PBbJ08ng);
				IOUtils.copy(ym5tCwVL, MrzBLxyy);
				IOUtils.closeQuietly(ym5tCwVL);
				IOUtils.closeQuietly(MrzBLxyy);
				EmailAttachment xSdROJvG = new EmailAttachment();
				xSdROJvG.setPath(PBbJ08ng.getPath());
				xSdROJvG.setDisposition(EmailAttachment.ATTACHMENT);
				xSdROJvG.setDescription("File Attachment: " + PBbJ08ng.getName());
				xSdROJvG.setName(PBbJ08ng.getName());
				cgrfAhHY.attach(xSdROJvG);
				String IeDlBcCY = getId();
				cgrfAhHY.addHeader(RFC2822Headers.IN_REPLY_TO, "<" + IeDlBcCY + ".JavaMail.duroty@duroty" + ">");
				cgrfAhHY.addHeader(RFC2822Headers.REFERENCES, "<" + IeDlBcCY + ".JavaMail.duroty@duroty" + ">");
				cgrfAhHY.addHeader("X-DBox", "FILES");
				cgrfAhHY.addHeader("X-DRecent", "false");
				cgrfAhHY.setMailSession(HtSU6wzT);
				cgrfAhHY.buildMimeMessage();
				MimeMessage TZDWSvzG = cgrfAhHY.getMimeMessage();
				int UgOjSgyE = MessageUtilities.getMessageSize(TZDWSvzG);
				if (!controlQuota(lrHuwIo8, kJzxHnUP, UgOjSgyE)) {
					throw new MailException("ErrorMessages.mail.quota.exceded");
				}
				messageable.storeMessage(IeDlBcCY, TZDWSvzG, kJzxHnUP);
			}
		} catch (FilesException EUmIAjKy) {
			throw EUmIAjKy;
		} catch (Exception heTpepCN) {
			throw new FilesException(heTpepCN);
		} catch (java.lang.OutOfMemoryError NZwnRpEK) {
			System.gc();
			throw new FilesException(NZwnRpEK);
		} catch (Throwable xIUhlaQa) {
			throw new FilesException(xIUhlaQa);
		} finally {
			GeneralOperations.closeHibernateSession(lrHuwIo8);
			IOUtils.closeQuietly(ym5tCwVL);
			IOUtils.closeQuietly(MrzBLxyy);
		}
	}

}