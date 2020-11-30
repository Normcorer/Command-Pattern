package xyz.molzhao.standard;

/**
 * 具体命令类（Concrete Command）角色：是抽象命令类的具体实现类，它拥有接收者对象，并通过调用接收者的功能来完成命令要执行的操作
 */
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
