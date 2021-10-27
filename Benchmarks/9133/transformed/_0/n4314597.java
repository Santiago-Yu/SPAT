class n4314597 {
	public void run() {
		StringBuffer YAWtGeAt = new StringBuffer();
		YAWtGeAt.append("Program: \t" + UpdateChannel.getCurrentChannel().getApplicationTitle() + "\n");
		YAWtGeAt.append("Version: \t" + Lister.version + "\n");
		YAWtGeAt.append("Revision: \t" + Lister.revision + "\n");
		YAWtGeAt.append("Channel: \t" + UpdateChannel.getCurrentChannel().getName() + "\n");
		YAWtGeAt.append("Date: \t\t" + Lister.date + "\n\n");
		YAWtGeAt.append("OS: \t\t" + System.getProperty("os.name") + " (" + System.getProperty("os.version") + ")\n");
		YAWtGeAt.append("JAVA: \t\t" + System.getProperty("java.version") + " ("
				+ System.getProperty("java.specification.vendor") + ")\n");
		YAWtGeAt.append("Desktop: \t" + System.getProperty("sun.desktop") + "\n");
		YAWtGeAt.append("Language: \t" + Language.getCurrentInstance() + "\n\n");
		YAWtGeAt.append("------------------------------------------\n");
		if (summary != null) {
			YAWtGeAt.append(summary + "\n\n");
		}
		YAWtGeAt.append("Details:\n");
		if (description != null) {
			YAWtGeAt.append(description);
		}
		if (exception != null) {
			YAWtGeAt.append("\n\nStacktrace:\n");
			printStackTrace(exception, YAWtGeAt);
		}
		try {
			if (dialog != null) {
				setComponentsEnabled(dialog.getContentPane(), false);
			}
			URL fEX06PUV = UpdateChannel.getCurrentChannel().getErrorReportURL();
			URLConnection dSH7FNA2 = fEX06PUV.openConnection();
			dSH7FNA2.setDoOutput(true);
			OutputStreamWriter bD0gk5pA = new OutputStreamWriter(dSH7FNA2.getOutputStream());
			if (sender != null) {
				bD0gk5pA.write(URLEncoder.encode("sender", "UTF-8") + "=" + URLEncoder.encode(sender, "UTF-8"));
				bD0gk5pA.write("&");
			}
			bD0gk5pA.write(
					URLEncoder.encode("report", "UTF-8") + "=" + URLEncoder.encode(YAWtGeAt.toString(), "UTF-8"));
			if (attachErrorLog) {
				bD0gk5pA.write("&");
				bD0gk5pA.write(URLEncoder.encode("error.log", "UTF-8") + "="
						+ URLEncoder.encode(Logger.getErrorLogContent(), "UTF-8"));
			}
			bD0gk5pA.flush();
			dSH7FNA2.getInputStream().close();
			bD0gk5pA.close();
			if (dialog != null) {
				dialog.dispose();
			}
			JOptionPane.showMessageDialog(Lister.getCurrentInstance(),
					Language.translateStatic("MESSAGE_ERRORREPORTSENT"));
		} catch (Exception nIQas0Xb) {
			ErrorJDialog.showErrorDialog(dialog, nIQas0Xb);
			if (dialog != null) {
				setComponentsEnabled(dialog.getContentPane(), true);
			}
		}
	}

}