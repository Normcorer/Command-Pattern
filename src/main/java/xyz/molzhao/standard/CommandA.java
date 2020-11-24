package xyz.molzhao.standard;

public class CommandA implements ICommand {
    private ReceiverA receiverA;

    public CommandA() {
        receiverA = new ReceiverA();
    }

    public void execute() {
        System.out.println("CommandA命令被执行...");
        receiverA.action();
    }
}
