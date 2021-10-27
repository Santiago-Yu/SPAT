class n2324866 {
	public SpreadSheetFrame(FileManager bjILvEyj, File hEhlsmom, Delimiter UmFyAWqO) {
        super(bjILvEyj, hEhlsmom.getPath());
        JPanel HJMwkidx = new JPanel(new BorderLayout());
        super.contentPane.add(HJMwkidx);
        this.tableModel = new BigTableModel(hEhlsmom, UmFyAWqO);
        this.table = new JTable(tableModel);
        this.table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        this.tableModel.setTable(this.table);
        HJMwkidx.add(new JScrollPane(this.table));
        addInternalFrameListener(new InternalFrameAdapter() {

            @Override
            public void internalFrameClosed(InternalFrameEvent zVT1KwH1) {
                tableModel.close();
            }
        });
        JMenu z0MbqpFh = new JMenu("Tools");
        getJMenuBar().add(z0MbqpFh);
        z0MbqpFh.add(new AbstractAction("NCBI") {

            @Override
            public void actionPerformed(ActionEvent hR4cSrb1) {
                try {
                    Pattern DaYaGCV7 = Pattern.compile("[ ]");
                    BufferedReader e0h4U3xg = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream("/home/lindenb/jeter.txt.gz"))));
                    String Ehy3Ie8A = null;
                    URL sGga53dF = new URL("http://eutils.ncbi.nlm.nih.gov/entrez/eutils/efetch.fcgi");
                    URLConnection sTTOcLFe = sGga53dF.openConnection();
                    sTTOcLFe.setDoOutput(true);
                    OutputStreamWriter IE19QDUV = new OutputStreamWriter(sTTOcLFe.getOutputStream());
                    IE19QDUV.write("db=snp&retmode=xml");
                    while ((Ehy3Ie8A = e0h4U3xg.readLine()) != null) {
                        String Fvn46mjM[] = DaYaGCV7.split(Ehy3Ie8A, 2);
                        if (!Fvn46mjM[0].startsWith("rs")) continue;
                        IE19QDUV.write("&id=" + Fvn46mjM[0].substring(2).trim());
                    }
                    IE19QDUV.flush();
                    e0h4U3xg.close();
                    InputStream Gar0YULP = sTTOcLFe.getInputStream();
                    IOUtils.copyTo(Gar0YULP, System.err);
                    Gar0YULP.close();
                    IE19QDUV.close();
                } catch (IOException u98IIoBo) {
                    u98IIoBo.printStackTrace();
                }
            }
        });
    }

}