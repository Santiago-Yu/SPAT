class n8831301 {
	public void run() {
		String iyzzs0DT;
		iyzzs0DT = "";
		try {
			URL OhKIjpYr = new URL("http://www.m-w.com/dictionary/" + word);
			BufferedReader VGk28y2G = new BufferedReader(new InputStreamReader(OhKIjpYr.openStream()));
			String qu3ByvTI;
			while (((qu3ByvTI = VGk28y2G.readLine()) != null) && (!stopped)) {
				iyzzs0DT = iyzzs0DT + qu3ByvTI;
			}
			VGk28y2G.close();
		} catch (MalformedURLException I6njENB6) {
		} catch (IOException tN7aJRJd) {
		}
		Pattern hn4OQzzR = Pattern.compile("Main Entry:.+?<br>(.+?)</td>", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		Matcher tNdSIOEw = hn4OQzzR.matcher(iyzzs0DT);
		java.io.StringWriter N0kWpO4e = new java.io.StringWriter();
		HTMLDocument FU2xhDa9 = null;
		HTMLEditorKit KctXXIw2 = (HTMLEditorKit) editor.getEditorKit();
		try {
			FU2xhDa9 = (HTMLDocument) editor.getDocument();
		} catch (Exception De7cPVyr) {
		}
		System.out.println(N0kWpO4e);
		editor.setContentType("text/html");
		if (tNdSIOEw.find())
			try {
				KctXXIw2.insertHTML(FU2xhDa9, editor.getCaretPosition(), "<HR>" + tNdSIOEw.group(1) + "<HR>", 0, 0,
						null);
			} catch (Exception w2iOZKZA) {
				System.out.println(w2iOZKZA.getMessage());
			}
		else
			try {
				KctXXIw2.insertHTML(FU2xhDa9, editor.getCaretPosition(), "<HR><FONT COLOR='RED'>NOT FOUND!!</FONT><HR>",
						0, 0, null);
			} catch (Exception QvoM1pRG) {
				System.out.println(QvoM1pRG.getMessage());
			}
		button.setEnabled(true);
	}

}