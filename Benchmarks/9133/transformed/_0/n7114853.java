class n7114853 {
	private MailBox authenticate() throws Exception {
		String DXfFuEoi = "POP3 Server Ready" + ((mChallenge == null) ? "" : (" " + mChallenge));
		MailBox kS9YpF5z = null;
		mStream.writeOk(DXfFuEoi);
		while (kS9YpF5z == null) {
			DXfFuEoi = mStream.readLine();
			if (isQuit(DXfFuEoi))
				break;
			String kPtB2bWN;
			if ((kPtB2bWN = isCommand(DXfFuEoi, "USER")) != null) {
				String SuYNXkHh = kPtB2bWN;
				MailBox lgln2lhJ = mRepository.getMailBox(SuYNXkHh);
				if (lgln2lhJ == null)
					mStream.writeErr("No mailbox for: " + DXfFuEoi);
				else {
					mStream.writeOk();
					String v83etn1B, NPppsJ9n = mStream.readLine();
					if (isQuit(NPppsJ9n))
						break;
					if ((v83etn1B = isCommand(NPppsJ9n, "PASS")) == null)
						mStream.writeErr("Expected PASS but got {" + NPppsJ9n + "}");
					else {
						String QViAYDJS = lgln2lhJ.getPassword();
						if ((QViAYDJS != null) ? v83etn1B.equals(QViAYDJS) : lgln2lhJ.checkPassword(v83etn1B)) {
							kS9YpF5z = lgln2lhJ;
							mStream.writeOk();
						} else
							mStream.writeErr("Bad password for " + SuYNXkHh);
					}
				}
			} else if ((kPtB2bWN = isCommand(DXfFuEoi, "APOP")) != null) {
				if (mChallenge == null)
					mStream.writeErr("APOP Not Supported");
				else {
					int fv6qaJkI = kPtB2bWN.indexOf(' ');
					if (fv6qaJkI < 0)
						mStream.writeErr("Bad APOP command {" + DXfFuEoi + "}");
					else {
						String dLwmHvxf = kPtB2bWN.substring(0, fv6qaJkI);
						String wWWhtVOm = kPtB2bWN.substring(fv6qaJkI + 1);
						MailBox Q1V4P52y = mRepository.getMailBox(dLwmHvxf);
						if (Q1V4P52y == null)
							mStream.writeErr("No mailbox for: " + DXfFuEoi);
						else if (Q1V4P52y.getPassword() == null)
							mStream.writeErr("User(" + dLwmHvxf + ") cannot login using APOP");
						else {
							String zBA6arUO = mChallenge + Q1V4P52y.getPassword();
							MessageDigest ZA6qVI94 = MessageDigest.getInstance("MD5");
							ZA6qVI94.update(zBA6arUO.getBytes("UTF-8"));
							byte[] QVXYkfZ7 = ZA6qVI94.digest();
							String O1sP69gA = new String(Hex.encodeHex(QVXYkfZ7));
							if (wWWhtVOm.equalsIgnoreCase(O1sP69gA)) {
								kS9YpF5z = Q1V4P52y;
								mStream.writeOk();
							} else
								mStream.writeErr("Bad password for " + dLwmHvxf);
						}
					}
				}
			} else
				mStream.writeErr("Authentication required (got '" + DXfFuEoi + "')");
		}
		return kS9YpF5z;
	}

}