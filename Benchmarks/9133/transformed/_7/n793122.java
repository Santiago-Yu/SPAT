class n793122 {
	public void actionPerformed(ActionEvent e) {
		String line, days;
		String oldType, newType;
		String dept = "";
		buttonPressed = true;
		char first;
		int caretIndex;
		int tempIndex;
		int oldDisplayNum = displayNum;
		for (int i = 0; i < 10; i++) {
			if (e.getSource() == imageButtons[i]) {
				if (rePrintAnswer)
					printAnswer();
				print.setVisible(true);
				selectTerm.setVisible(true);
				displayNum = i;
				textArea2.setCaretPosition(textArea2.getText().length() - 1);
				caretIndex = textArea2.getText().indexOf("#" + (i + 1));
				if (caretIndex != -1)
					textArea2.setCaretPosition(caretIndex);
				repaint();
			}
		}
		if (e.getSource() == print) {
			if (textArea2.getText().charAt(0) != '#')
				printAnswer();
			String data = textArea2.getText();
			int start = data.indexOf("#" + (displayNum + 1));
			start = data.indexOf("\n", start);
			start++;
			int end = data.indexOf("\n---------", start);
			data = data.substring(start, end);
			String tr = "";
			if (term.getSelectedItem() == "Spring")
				tr = "SP";
			else if (term.getSelectedItem() == "Summer")
				tr = "SU";
			else
				tr = "FL";
			String s = getCodeBase().toString() + "schedule.cgi?term=" + tr + "&data=" + URLEncoder.encode(data);
			try {
				AppletContext a = getAppletContext();
				URL u = new URL(s);
				a.showDocument(u, "_blank");
			} catch (MalformedURLException rea) {
			}
		}
		if (e.getSource() == webSite) {
			String tr;
			if (term.getSelectedItem() == "Spring")
				tr = "SP";
			else if (term.getSelectedItem() == "Summer")
				tr = "SU";
			else
				tr = "FL";
			String num = courseNum.getText().toUpperCase();
			String s = "http://sis450.berkeley.edu:4200/OSOC/osoc?p_term=" + tr + "&p_deptname="
					+ URLEncoder.encode(lst.getSelectedItem().toString()) + "&p_course=" + num;
			try {
				AppletContext a = getAppletContext();
				URL u = new URL(s);
				a.showDocument(u, "_blank");
			} catch (MalformedURLException rea) {
			}
		}
		if (e.getSource() == loadButton) {
			printSign("Loading...");
			String fileName = idField.getText();
			fileName = fileName.replace(' ', '_');
			String text = readURL(fileName);
			if (!publicSign.equals("Error loading.")) {
				textArea1.setText(text);
				fileName = fileName + (".2");
				text = readURL(fileName);
				absorb(text);
				printAnswer();
				for (int i = 0; i < 10; i++) {
					if (answer[i].gap != -1 && answer[i].gap != 9999 && answer[i].gap != 10000) {
						imageButtons[i].setVisible(true);
					} else
						imageButtons[i].setVisible(false);
				}
				if (!imageButtons[0].isVisible()) {
					print.setVisible(false);
					selectTerm.setVisible(false);
				} else {
					print.setVisible(true);
					selectTerm.setVisible(true);
				}
				printSign("Load complete.");
			}
			displayNum = 0;
			repaint();
		}
		if (e.getSource() == saveButton) {
			String fileName = idField.getText();
			fileName = fileName.replace(' ', '_');
			printSign("Saving...");
			writeURL(fileName, 1);
			printSign("Saving......");
			fileName = fileName + (".2");
			writeURL(fileName, 2);
			printSign("Save complete.");
		}
		if (e.getSource() == instructions) {
			showInstructions();
		}
		if (e.getSource() == net) {
			drawWarning = false;
			String inputLine = "";
			String text = "";
			String out;
			String urlIn = "";
			textArea2.setText("Retrieving Data...");
			try {
				String tr;
				if (term.getSelectedItem() == "Spring")
					tr = "SP";
				else if (term.getSelectedItem() == "Summer")
					tr = "SU";
				else
					tr = "FL";
				String num = courseNum.getText().toUpperCase();
				dept = lst.getSelectedItem().toString();
				{
					urlIn = "http://sis450.berkeley.edu:4200/OSOC/osoc?p_term=" + tr + "&p_deptname="
							+ URLEncoder.encode(dept) + "&p_course=" + num;
					try {
						URL url = new URL(getCodeBase().toString() + "getURL.cgi");
						URLConnection con = url.openConnection();
						con.setDoOutput(true);
						con.setDoInput(true);
						con.setUseCaches(false);
						con.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
						DataOutputStream out2 = new DataOutputStream(con.getOutputStream());
						String content = "url=" + URLEncoder.encode(urlIn);
						out2.writeBytes(content);
						out2.flush();
						DataInputStream in = new DataInputStream(con.getInputStream());
						String s;
						while ((s = in.readLine()) != null) {
						}
						in.close();
					} catch (IOException err) {
					}
				}
				URL yahoo = new URL(this.getCodeBase(), "classData.txt");
				URLConnection yc = yahoo.openConnection();
				StringBuffer buf = new StringBuffer("");
				DataInputStream in = new DataInputStream(new BufferedInputStream(yc.getInputStream()));
				while ((inputLine = in.readLine()) != null) {
					buf.append(inputLine);
				}
				text = buf.toString();
				in.close();
			} catch (IOException errr) {
			}
			String inText = (parseData(text, false));
			if (inText.equals("-1"))
				inText = parseData(text, true);
			if (inText.equals("\n")) {
				textArea2.append("\nNO DATA FOUND \n(" + urlIn + ")");
			} else
				textArea1.append(inText);
			repaint();
		}
		badInput = false;
		if (e.getSource() == button1) {
			if (t != null && t.isAlive()) {
				t.stop();
				epilogue();
				return;
			}
			displayNum = 0;
			textArea2.setCaretPosition(0);
			for (int i = 0; i < 30; i++)
				for (int j = 0; j < 20; j++) {
					matrix[i][j] = new entry();
					matrix[i][j].time = new Time[4];
					for (int k = 0; k < 4; k++) {
						matrix[i][j].time[k] = new Time();
						matrix[i][j].time[k].from = 0;
					}
				}
			val = new entry[30];
			for (int i = 0; i < 30; i++) {
				val[i] = new entry();
				val[i].time = new Time[4];
				for (int j = 0; j < 4; j++) {
					val[i].time[j] = new Time();
					val[i].time[j].from = 0;
				}
			}
			oldPercentDone = -5;
			oldAmountDone = -1 * PRINTINTERVAL;
			percentDone = 0;
			amountDone = 0;
			drawWarning = false;
			errorMessage = "";
			String text1 = textArea1.getText();
			if (text1.toUpperCase().indexOf("OR:") == -1)
				containsOR = false;
			else
				containsOR = true;
			text1 = removeOR(text1.toUpperCase());
			StringTokenizer st = new StringTokenizer(text1, "\n");
			clss = -1;
			timeEntry = -1;
			boolean noTimesListed = false;
			while (st.hasMoreTokens()) {
				line = st.nextToken().toString();
				if (line.equals(""))
					break;
				else
					first = line.charAt(0);
				if (first == '0') {
					badInput = true;
					repaint();
					break;
				}
				if (first >= '1' && first <= '9') {
					noTimesListed = false;
					timeEntry++;
					if (timeEntry == 30) {
						rePrintAnswer = true;
						textArea2.setText("Error: Exceeded 30 time entries per class.");
						badInput = true;
						repaint();
						return;
					}
					nextTime = -1;
					StringTokenizer andST = new StringTokenizer(line, ",");
					while (andST.hasMoreTokens()) {
						String temp;
						String entry;
						int index, fromTime, toTime;
						nextTime++;
						if (nextTime == 4) {
							rePrintAnswer = true;
							textArea2.setText("Error: Exceeded 4 time intervals per entry!");
							badInput = true;
							repaint();
							return;
						}
						StringTokenizer timeST = new StringTokenizer(andST.nextToken());
						temp = timeST.nextToken().toString();
						entry = "";
						index = 0;
						if (temp.equals(""))
							break;
						while (temp.charAt(index) != '-') {
							entry = entry + (temp.charAt(index));
							index++;
							if (index >= temp.length()) {
								rePrintAnswer = true;
								textArea2.setText("Error: There should be no space before hyphens.");
								badInput = true;
								repaint();
								return;
							}
						}
						try {
							fromTime = Integer.parseInt(entry);
						} catch (NumberFormatException re) {
							rePrintAnswer = true;
							textArea2.setText("Error: There should be no a/p sign after FROM_TIME.");
							badInput = true;
							repaint();
							return;
						}
						index++;
						entry = "";
						if (index >= temp.length()) {
							badInput = true;
							repaint();
							rePrintAnswer = true;
							textArea2.setText("Error: am/pm sign missing??");
							return;
						}
						while (temp.charAt(index) >= '0' && temp.charAt(index) <= '9') {
							entry = entry + (temp.charAt(index));
							index++;
							if (index >= temp.length()) {
								badInput = true;
								repaint();
								rePrintAnswer = true;
								textArea2.setText("Error: am/pm sign missing??");
								return;
							}
						}
						toTime = Integer.parseInt(entry);
						if (temp.charAt(index) == 'a' || temp.charAt(index) == 'A') {
						} else {
							if (isLesse(fromTime, toTime) && !timeEq(toTime, 1200)) {
								if (String.valueOf(fromTime).length() == 4 || String.valueOf(fromTime).length() == 3) {
									fromTime = fromTime + (1200);
								} else
									fromTime = fromTime + (12);
							}
							if (!timeEq(toTime, 1200)) {
								if (String.valueOf(toTime).length() == 4 || String.valueOf(toTime).length() == 3) {
									toTime = toTime + (1200);
								} else
									toTime = toTime + (12);
							}
						}
						if (String.valueOf(fromTime).length() == 2 || String.valueOf(fromTime).length() == 1)
							fromTime = fromTime * (100);
						if (String.valueOf(toTime).length() == 2 || String.valueOf(toTime).length() == 1)
							toTime = toTime * (100);
						matrix[timeEntry][clss].time[nextTime].from = fromTime;
						matrix[timeEntry][clss].time[nextTime].to = toTime;
						if (timeST.hasMoreTokens())
							days = timeST.nextToken().toString();
						else {
							rePrintAnswer = true;
							textArea2.setText("Error: days not specified?");
							badInput = true;
							repaint();
							return;
						}
						if (days.equals(""))
							return;
						if (days.indexOf("M") != -1 || days.indexOf("m") != -1)
							matrix[timeEntry][clss].time[nextTime].m = 1;
						if (days.indexOf("TU") != -1 || days.indexOf("Tu") != -1 || days.indexOf("tu") != -1)
							matrix[timeEntry][clss].time[nextTime].tu = 1;
						if (days.indexOf("W") != -1 || days.indexOf("w") != -1)
							matrix[timeEntry][clss].time[nextTime].w = 1;
						if (days.indexOf("TH") != -1 || days.indexOf("Th") != -1 || days.indexOf("th") != -1)
							matrix[timeEntry][clss].time[nextTime].th = 1;
						if (days.indexOf("F") != -1 || days.indexOf("f") != -1)
							matrix[timeEntry][clss].time[nextTime].f = 1;
					}
				} else {
					if (noTimesListed)
						clss--;
					clss++;
					if (clss == 20) {
						rePrintAnswer = true;
						textArea2.setText("Error: No more than 20 class entries!");
						badInput = true;
						repaint();
						return;
					}
					timeEntry = -1;
					line = line.trim();
					for (int i = 0; i < 30; i++)
						matrix[i][clss].name = line;
					noTimesListed = true;
				}
			}
			for (int i = 0; i < 30; i++) {
				for (int j = 0; j < 4; j++) {
					val[i].time[j].from = 0;
				}
			}
			for (int i = 0; i < 10; i++) {
				beat10[i] = 10000;
				answer[i].gap = 10000;
				for (int j = 0; j < 30; j++)
					answer[i].classes[j].name = "";
			}
			time = 0;
			calcTotal = 0;
			int k = 0;
			calculateTotalPercent(0, "\n");
			amountToReach = calcTotal;
			button1.setLabel("...HALT GENERATION...");
			printWarn();
			if (t != null && t.isAlive())
				t.stop();
			t = new Thread(this, "Generator");
			t.start();
		}
	}

}