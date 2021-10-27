class n14390569 {
	private DialogHelper(String title, final URL imageURL) {
        jd = new JDialog();
        jd.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        jd.setAlwaysOnTop(true);
        jd.setLayout(new BoxLayout(jd.getContentPane(), BoxLayout.Y_AXIS));
        jd.setTitle(title);
        ImageIcon icon = new ImageIcon(imageURL);
        JLabel jl = new JLabel();
        jl.setIcon(icon);
        jd.add(new JScrollPane(jl));
        JPanel jp = new JPanel();
        final JFileChooser chooser = getSaveImageChooser();
        JButton jb = new JButton(getMessage("btn_save_as"));
        jb.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                int returnVal = chooser.showSaveDialog(jd);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = chooser.getSelectedFile();
                    String fileName = file.getPath();
                    String ext = StringUtil.getLowerExtension(fileName);
                    boolean doIt = true;
                    if (!"png".equals(ext)) {
						fileName += ".png";
						file = new File(fileName);
					}
                    if (file.exists()) {
                        int i = JOptionPane.showConfirmDialog(jd, getMessage("warn_file_exist"));
                        if (i != JOptionPane.YES_OPTION) doIt = false;
                    } else if (!file.getParentFile().exists()) {
                        doIt = file.getParentFile().mkdirs();
                    }
                    if (doIt) {
                        FileChannel dest = null;
                        FileChannel src = null;
                        try {
                            src = new FileInputStream(imageURL.getPath()).getChannel();
                            dest = new FileOutputStream(fileName).getChannel();
                            src.transferTo(0, src.size(), dest);
                        } catch (FileNotFoundException e1) {
                            warn(jd, getMessage("err_no_source_file"));
                        } catch (IOException e2) {
                            warn(jd, getMessage("err_output_target"));
                        } finally {
                            try {
                                if (src != null) src.close();
                            } catch (IOException e1) {
                            }
                            src = null;
                            try {
								if (dest != null)
									dest.close();
							} catch (IOException e1) {
							}
                            dest = null;
                        }
                    }
                }
            }
        });
        jp.add(jb);
        jb = new JButton(getMessage("btn_close"));
        jb.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                jd.dispose();
            }
        });
        jp.add(jb);
        jd.add(jp);
        jd.pack();
        setCentral(jd);
    }

}