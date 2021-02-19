package debug;

import config.Config;

public class DebugFormat {
    public enum DebugMessageType {
        SUCCESS, FAIL, WAIT
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
        this.color = "#FFFFFF";

        switch (this.type) {
            case SUCCESS:
                this.color = Config.DEBUG_MODE_FRAME_COLOR_SUCCESS;
                break;

            case WAIT:
                this.color = Config.DEBUG_MODE_FRAME_COLOR_WAIT;
                break;

            case FAIL:
                this.color = Config.DEBUG_MODE_FRAME_COLOR_FAIL;
                break;
        }
    }

    public String getText() {
        String info[] = this.message.split("»");
        return "<div style='margin-bottom: 6px'><span style='font-family: \"Inconsolata\",monospace; font-size: 12.5px; color: "
                + this.color + "'><strong>" + info[0].substring(1) + "»</strong> " + info[1] + "</span></div>";
    }

}
