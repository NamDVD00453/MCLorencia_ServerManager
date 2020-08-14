package main.mclorencia.entity;

public class RequestCommand {
    private String SenderType;
    private String CmdType;
    private String CmdParam;

    public RequestCommand() {
    }

    public String getSenderType() {
        return SenderType;
    }

    public void setSenderType(String senderType) {
        SenderType = senderType;
    }

    public String getCmdType() {
        return CmdType;
    }

    public void setCmdType(String cmdType) {
        CmdType = cmdType;
    }

    public String getCmdParam() {
        return CmdParam;
    }

    public void setCmdParam(String cmdParam) {
        CmdParam = cmdParam;
    }
}
