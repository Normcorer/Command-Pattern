package xyz.molzhao.standard;

import org.junit.Test;

public class CommandTest {

    @Test
    public void testCommand() {
        Invoker invoker = new Invoker(new CommandA());
        invoker.call();
        invoker.setCommand(new CommandB());
        invoker.call();
    }
}
