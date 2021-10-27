class n1460670 {
	@Override
	public void execute(IAlert alert, IReport report, Rule rule, Row row) {
		try {
			URL url = new URL(getUrl());
			URLConnection con = url.openConnection();
			con.setConnectTimeout(getTimeout());
			con.setDoOutput(true);
			OutputStream out = con.getOutputStream();
			out.write(formatOutput(report, alert, rule, row).getBytes());
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			StringBuilder input = new StringBuilder();
			String line = null;
			for (; (line = in.readLine()) != null;) {
				input.append(line);
				input.append('\n');
			}
			in.close();
			this.lastResult = input.toString();
		} catch (Throwable e) {
			logError("Error sending alert", e);
			if (!isHeadless()) {
				alert.setEnabled(false);
				JOptionPane.showMessageDialog(null,
						"Can't send alert " + e + "\n" + alert.getName() + " alert disabled.", "Action Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}