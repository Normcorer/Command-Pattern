package xyz.molzhao.standard;

/**
 * 具体命令类（Concrete Command）角色：是抽象命令类的具体实现类，它拥有接收者对象，并通过调用接收者的功能来完成命令要执行的操作
 */
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
