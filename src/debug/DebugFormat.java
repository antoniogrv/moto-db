package debug;

import config.Config;

public class DebugFormat {
    public enum DebugMessageType {
        SUCCESS, FAIL, WAIT, NOTIFY
    };

    private DebugMessageType type;
    private String message;
    private String color;

    public DebugFormat(DebugMessageType type, String message) {
        this.type = type;
        this.message = message;

        /*
         * Colore di default.
         */
        this.color = Config.DEFAULT_FONT_COLOR;

        switch (this.type) {
            case SUCCESS:
                this.color = Config.DEBUG_VIEWER_FRAME_COLOR_SUCCESS;
                break;

            case WAIT:
                this.color = Config.DEBUG_VIEWER_FRAME_COLOR_WAIT;
                break;

            case FAIL:
                this.color = Config.DEBUG_VIEWER_FRAME_COLOR_FAIL;
                break;

            case NOTIFY:
                this.color = Config.DEBUG_VIEWER_FRAME_COLOR_NOTIFY;
                break;
        }
    }

    public String getText() {
        String info[] = this.message.split("»");
        return "<div style='margin-bottom: 6px'><span style='font-family: " + Config.DEBUG_VIEWER_FRAME_FONT
                + "; font-size: " + Config.DEBUG_VIEWER_FRAME_FONT_SIZE + "; color: " + this.color + "'><strong>"
                + info[0].substring(1) + "»</strong> " + info[1] + "</span></div>";
    }

}
