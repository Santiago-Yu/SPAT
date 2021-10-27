    public SRWGuiClient(String initialURL) {
        super("Simple Swing Browser");
        this.initialURL = initialURL;
        addWindowListener(new ExitListener());
        WindowUtilities.setNativeLookAndFeel();
        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.lightGray);
        homeButton = new JIconButton("home.gif");
        homeButton.addActionListener(this);
        JLabel urlLabel = new JLabel("URL:");
        urlField = new JTextField(30);
        urlField.setText(initialURL);
        urlField.addActionListener(this);
        topPanel.add(homeButton);
        topPanel.add(urlLabel);
        topPanel.add(urlField);
        getContentPane().add(topPanel, BorderLayout.NORTH);
        try {
            URL url = new URL(initialURL);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            boolean xml = true;
            String inputLine;
            StringBuffer content = new StringBuffer(), stylesheet = null;
            Transformer transformer = null;
            inputLine = in.readLine();
            if (inputLine == null) {
                System.out.println("No input read from URL: " + initialURL);
                return;
            }
            if (!inputLine.startsWith("<?xml ")) {
                xml = false;
                content.append(inputLine);
            }
            if (xml) {
                inputLine = in.readLine();
                if (inputLine.startsWith("<?xml-stylesheet ")) {
                    int offset = inputLine.indexOf("href=");
                    String href = (inputLine.substring(inputLine.indexOf("href=") + 6));
                    href = href.substring(0, href.indexOf('"'));
                    System.out.println("href=" + href);
                    url = new URL(url, href);
                    String stylesheetURL = url.toString();
                    System.out.println("stylesheet URL=" + url.toString());
                    transformer = (Transformer) transformers.get(stylesheetURL);
                    if (transformer == null) {
                        BufferedReader sheetIn = new BufferedReader(new InputStreamReader(url.openStream()));
                        sheetIn.readLine();
                        stylesheet = new StringBuffer();
                        while ((inputLine = sheetIn.readLine()) != null) stylesheet.append(inputLine).append('\n');
                        System.out.println(stylesheet.toString());
                        TransformerFactory tFactory = TransformerFactory.newInstance();
                        StreamSource xslSource = new StreamSource(new StringReader(stylesheet.toString()));
                        transformer = tFactory.newTransformer(xslSource);
                        transformers.put(stylesheetURL, transformer);
                    }
                }
            }
            while ((inputLine = in.readLine()) != null) content.append(inputLine).append('\n');
            htmlPane = new JEditorPane();
            if (transformer != null) {
                StringReader stringRecordReader = new StringReader(content.toString());
                StringWriter xmlRecordWriter = new StringWriter();
                StreamSource streamXMLRecord = new StreamSource(stringRecordReader);
                transformer.transform(streamXMLRecord, new StreamResult(xmlRecordWriter));
                String html = xmlRecordWriter.toString();
                int i = html.indexOf('>');
                html = "<html>" + html.substring(html.indexOf('>') + 1);
                System.out.println(html);
                htmlPane.setContentType("text/html");
                htmlPane.setText("<html><head><META http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"><title>GSAFD Thesaurus</title></head><body><center><h2>GSAFD Thesaurus</h2></center><p>A thesaurus of genre terms to support the \"Guidelines on Subject Access to Individual Works of Fiction , Drama\" (GSAFD)</p><table cellspacing=\"5\" width=\"100%\"><tr><td><h3>Search</h3><p></p></td><td valign=\"top\"><h3>Browse</h3></td></tr></table></body></html>");
            } else htmlPane.setText(content.toString());
            htmlPane.setEditable(false);
            htmlPane.addHyperlinkListener(this);
            JScrollPane scrollPane = new JScrollPane(htmlPane);
            getContentPane().add(scrollPane, BorderLayout.CENTER);
        } catch (IOException ioe) {
            warnUser("Can't build HTML pane for " + initialURL + ": " + ioe);
        } catch (TransformerException e) {
        }
        Dimension screenSize = getToolkit().getScreenSize();
        int width = screenSize.width * 8 / 10;
        int height = screenSize.height * 8 / 10;
        setBounds(width / 8, height / 8, width, height);
        setVisible(true);
    }
