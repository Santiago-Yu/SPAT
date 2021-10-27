class n1460670 {
	@Override
	public void execute(IAlert yQwG3MCQ, IReport Ce6xecAd, Rule DEiAiKkY, Row BTVzRuoW) {
		try {
			URL n3nzDKPY = new URL(getUrl());
			URLConnection Bi8t4DSw = n3nzDKPY.openConnection();
			Bi8t4DSw.setConnectTimeout(getTimeout());
			Bi8t4DSw.setDoOutput(true);
			OutputStream nW9mDiBL = Bi8t4DSw.getOutputStream();
			nW9mDiBL.write(formatOutput(Ce6xecAd, yQwG3MCQ, DEiAiKkY, BTVzRuoW).getBytes());
			BufferedReader sNZPPYZp = new BufferedReader(new InputStreamReader(Bi8t4DSw.getInputStream()));
			StringBuilder Pp1AzjxL = new StringBuilder();
			String Ohxi71CJ = null;
			while ((Ohxi71CJ = sNZPPYZp.readLine()) != null) {
				Pp1AzjxL.append(Ohxi71CJ);
				Pp1AzjxL.append('\n');
			}
			sNZPPYZp.close();
			this.lastResult = Pp1AzjxL.toString();
		} catch (Throwable auPDMxEw) {
			logError("Error sending alert", auPDMxEw);
			if (!isHeadless()) {
				yQwG3MCQ.setEnabled(false);
				JOptionPane.showMessageDialog(null,
						"Can't send alert " + auPDMxEw + "\n" + yQwG3MCQ.getName() + " alert disabled.", "Action Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}