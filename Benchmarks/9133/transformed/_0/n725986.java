class n725986 {
	public void writeToFtp(String gWtCPQxo, String AYdRk9Pe, String fty2i2N2, String ncb98Vgv, String hD5ab3n1) {
		String z0X3Zqg5 = System.getProperty("line.separator");
		try {
			URL BVbDiy8t = new URL("ftp://" + gWtCPQxo + ":" + AYdRk9Pe + "@ftp." + fty2i2N2 + ncb98Vgv + hD5ab3n1
					+ ".html" + ";type=i");
			URLConnection iSAsq9rq = BVbDiy8t.openConnection();
			iSAsq9rq.setDoOutput(true);
			OutputStreamWriter eZ7AVxh9 = new OutputStreamWriter(iSAsq9rq.getOutputStream());
			eZ7AVxh9.write("<html><title>" + title + "</title>" + z0X3Zqg5);
			eZ7AVxh9.write("<h1><b>" + title + "</b></h1>" + z0X3Zqg5);
			eZ7AVxh9.write("<h2>Table Of Contents:</h2><ul>" + z0X3Zqg5);
			for (int JyqCZLLt = 0; JyqCZLLt < rings.size(); JyqCZLLt++) {
				eZ7AVxh9.write("<li><i><a href=\"#");
				eZ7AVxh9.write(readNoteTitle(JyqCZLLt));
				eZ7AVxh9.write("\">");
				eZ7AVxh9.write(readNoteTitle(JyqCZLLt));
				eZ7AVxh9.write("</a></i></li>" + z0X3Zqg5);
			}
			eZ7AVxh9.write("</ul><hr>" + z0X3Zqg5 + z0X3Zqg5);
			for (int MsJEcc5q = 0; MsJEcc5q < rings.size(); MsJEcc5q++) {
				eZ7AVxh9.write("<h3><b>");
				eZ7AVxh9.write("<a name=\"");
				eZ7AVxh9.write(readNoteTitle(MsJEcc5q));
				eZ7AVxh9.write("\">");
				eZ7AVxh9.write(readNoteTitle(MsJEcc5q) + "</a>");
				eZ7AVxh9.write("</b></h3>" + z0X3Zqg5);
				eZ7AVxh9.write(readNoteBody(MsJEcc5q) + z0X3Zqg5);
			}
			eZ7AVxh9.write(z0X3Zqg5 + "<br><hr><a>This was created using Scribe, a free crutch editor.</a></html>");
			eZ7AVxh9.close();
		} catch (IOException Bv0Gl1tz) {
			System.out.println("There was an error: " + Bv0Gl1tz);
		}
	}

}