package xyz.molzhao.standard;

/**
 * 调用者/请求者（Invoker）角色：是请求的发送者，它通常拥有很多的命令对象，并通过访问命令对象来执行相关请求，它不直接访问接收者
 */
public class Invoker {
    private ICommand command;

    public Invoker(ICommand command) {
        this.command = command;
    }

    public void setCommand(ICommand command) {
        this.command = command;
    }

    public void call() {
        command.execute();
    }
}
