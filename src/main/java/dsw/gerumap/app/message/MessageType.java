package dsw.gerumap.app.message;

public enum MessageType {

    NODE_CANNOT_BE_DELETED("NODE CANNOT BE DELETED"),
    NODE_NOT_SELECTED("NODE NOT SELECTED"),
    NODE_NOT_COMPOSITE("NODE NOT COMPOSITE"),
    NAME_CANNOT_BE_EMPTY("NODE CANNOT BE EMPTY");

    private String text;

    private MessageType(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
