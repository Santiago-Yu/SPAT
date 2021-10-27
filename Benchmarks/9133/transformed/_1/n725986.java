class n725986 {
	public void writeToFtp(String login, String password, String address, String directory, String filename) {
		String newline = System.getProperty("line.separator");
		try {
			URL url = new URL(
					"ftp://" + login + ":" + password + "@ftp." + address + directory + filename + ".html" + ";type=i");
			URLConnection urlConn = url.openConnection();
			urlConn.setDoOutput(true);
			OutputStreamWriter stream = new OutputStreamWriter(urlConn.getOutputStream());
			stream.write("<html><title>" + title + "</title>" + newline);
			stream.write("<h1><b>" + title + "</b></h1>" + newline);
			stream.write("<h2>Table Of Contents:</h2><ul>" + newline);
			int xmSjH = 0;
			while (xmSjH < rings.size()) {
				stream.write("<li><i><a href=\"#");
				stream.write(readNoteTitle(xmSjH));
				stream.write("\">");
				stream.write(readNoteTitle(xmSjH));
				stream.write("</a></i></li>" + newline);
				xmSjH++;
			}
			stream.write("</ul><hr>" + newline + newline);
			int fbynq = 0;
			while (fbynq < rings.size()) {
				stream.write("<h3><b>");
				stream.write("<a name=\"");
				stream.write(readNoteTitle(fbynq));
				stream.write("\">");
				stream.write(readNoteTitle(fbynq) + "</a>");
				stream.write("</b></h3>" + newline);
				stream.write(readNoteBody(fbynq) + newline);
				fbynq++;
			}
			stream.write(newline + "<br><hr><a>This was created using Scribe, a free crutch editor.</a></html>");
			stream.close();
		} catch (IOException error) {
			System.out.println("There was an error: " + error);
		}
	}

}