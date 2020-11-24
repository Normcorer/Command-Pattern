package xyz.molzhao.standard;

public class CommandB implements ICommand {
    private ReceiverB receiverB;

    public CommandB() {
        receiverB = new ReceiverB();
    }

    public void execute() {
        System.out.println("CommandB命令被执行...");
        receiverB.action();
    }
}
