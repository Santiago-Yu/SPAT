class n7449124{
    private long getRecordedSessionLength() {
        long lRet = -1;
        String strLength = this.applet.getParameter(Constants.PLAYBACK_MEETING_LENGTH_PARAM);
        if (null != strLength) {
            lRet = (new Long(strLength)).longValue();
        } else {
            Properties recProps = new Properties();
            try {
                URL urlProps = new URL(applet.getDocumentBase(), Constants.RECORDED_SESSION_INFO_PROPERTIES);
                recProps.load(urlProps.openStream());
                lRet = (new Long(recProps.getProperty(Constants.PLAYBACK_MEETING_LENGTH_PARAM))).longValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return lRet;
    }

}