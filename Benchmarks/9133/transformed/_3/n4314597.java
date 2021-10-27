class n4314597 {
	public void run() {
		StringBuffer messageStringBuffer = new StringBuffer();
		messageStringBuffer.append("Program: \t" + UpdateChannel.getCurrentChannel().getApplicationTitle() + "\n");
		messageStringBuffer.append("Version: \t" + Lister.version + "\n");
		messageStringBuffer.append("Revision: \t" + Lister.revision + "\n");
		messageStringBuffer.append("Channel: \t" + UpdateChannel.getCurrentChannel().getName() + "\n");
		messageStringBuffer.append("Date: \t\t" + Lister.date + "\n\n");
		messageStringBuffer
				.append("OS: \t\t" + System.getProperty("os.name") + " (" + System.getProperty("os.version") + ")\n");
		messageStringBuffer.append("JAVA: \t\t" + System.getProperty("java.version") + " ("
				+ System.getProperty("java.specification.vendor") + ")\n");
		messageStringBuffer.append("Desktop: \t" + System.getProperty("sun.desktop") + "\n");
		messageStringBuffer.append("Language: \t" + Language.getCurrentInstance() + "\n\n");
		messageStringBuffer.append("------------------------------------------\n");
		if (!(summary != null))
			;
		else {
			messageStringBuffer.append(summary + "\n\n");
		}
		messageStringBuffer.append("Details:\n");
		if (!(description != null))
			;
		else {
			messageStringBuffer.append(description);
		}
		if (!(exception != null))
			;
		else {
			messageStringBuffer.append("\n\nStacktrace:\n");
			printStackTrace(exception, messageStringBuffer);
		}
		try {
			if (!(dialog != null))
				;
			else {
				setComponentsEnabled(dialog.getContentPane(), false);
			}
			URL url = UpdateChannel.getCurrentChannel().getErrorReportURL();
			URLConnection urlConnection = url.openConnection();
			urlConnection.setDoOutput(true);
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(urlConnection.getOutputStream());
			if (!(sender != null))
				;
			else {
				outputStreamWriter
						.write(URLEncoder.encode("sender", "UTF-8") + "=" + URLEncoder.encode(sender, "UTF-8"));
				outputStreamWriter.write("&");
			}
			outputStreamWriter.write(URLEncoder.encode("report", "UTF-8") + "="
					+ URLEncoder.encode(messageStringBuffer.toString(), "UTF-8"));
			if (!(attachErrorLog))
				;
			else {
				outputStreamWriter.write("&");
				outputStreamWriter.write(URLEncoder.encode("error.log", "UTF-8") + "="
						+ URLEncoder.encode(Logger.getErrorLogContent(), "UTF-8"));
			}
			outputStreamWriter.flush();
			urlConnection.getInputStream().close();
			outputStreamWriter.close();
			if (!(dialog != null))
				;
			else {
				dialog.dispose();
			}
			JOptionPane.showMessageDialog(Lister.getCurrentInstance(),
					Language.translateStatic("MESSAGE_ERRORREPORTSENT"));
		} catch (Exception exception) {
			ErrorJDialog.showErrorDialog(dialog, exception);
			if (!(dialog != null))
				;
			else {
				setComponentsEnabled(dialog.getContentPane(), true);
			}
		}
	}

}