package xyz.molzhao.standard;

/**
 * 实现者/接收者（Receiver）角色：执行命令的相关操作，是具体命令对象业务的真正实现者
 */
public class ReceiverA {
    public void action() {
        System.out.println("ReceiverA执行操作....");
    }
}
