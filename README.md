## 前言
在平时开发中**方法的请求者**和**方法的实现者**直接很容易产生耦合。

在现实生活中也有很多案例，比如windows的cmd面板，mac的terminal，操作电视的遥控器，只要给定相应的命令，或者按某个案件就能完成操作。就相当于命令模式。

如电视遥控器，就将换台请求和换台处理完全解耦了。电视机遥控器（命令发送者）通过按钮（具体命令）来遥控电视机（命令接收者）。
***

## 定义
将一个请求封装为一个对象，使发出请求的责任和执行请求的责任分割开。这样两者之间通过命令对象进行沟通，这样方便将命令对象进行储存、传递、调用、增加与管理。

***
## 结构

**命令模式包含以下主要角色：**
1. 抽象命令类（Command）角色：声明执行命令的接口，拥有执行命令的抽象方法 execute()。
2. 具体命令类（Concrete Command）角色：是抽象命令类的具体实现类，它拥有接收者对象，并通过调用接收者的功能来完成命令要执行的操作。
3. 实现者/接收者（Receiver）角色：执行命令功能的相关操作，是具体命令对象业务的真正实现者。
4. 调用者/请求者（Invoker）角色：是请求的发送者，它通常拥有很多的命令对象，并通过访问命令对象来执行相关请求，它不直接访问接收者。

![命令模式结构图](https://molzhao-pic.oss-cn-beijing.aliyuncs.com/2020-11-30/%E5%91%BD%E4%BB%A4%E6%A8%A1%E5%BC%8F%E7%BB%93%E6%9E%84%E5%9B%BE.png)
***

## 特点

**优点：**
1. 通过引入中间件（抽象接口）降低系统的耦合度。
2. 扩展性良好，增加或删除命令非常方便。采用命令模式增加与删除命令不会影响其他类，且满足“开闭原则”。
3. 可以实现宏命令。命令模式可以与组合模式结合，将多个命令装配成一个组合命令，即宏命令。
4. 方便实现 Undo和Redo操作。命令模式可以与后面介绍的备忘录模式结合，实现命令的撤销与恢复。
5. 可以在现有命令的基础上，增加额外功能。比如日志记录，结合装饰器模式会更加灵活。

**缺点：**
1. 可能产生大量具体的命令类。因为每一个具体操作都需要设计一个具体命令类，这会增加系统的复杂性。
2. 命令模式的结果其实就是接收方的执行结果，但是为了以命令的形式进行架构、解耦请求与实现，引入了额外类型结构（引入了请求方与抽象命令接口），增加了理解上的困难。不过这也是设计模式的通病，抽象必然会额外增加类的数量，代码抽离肯定比代码聚合更加难理解。

## 案例

### 通用案例

```java
package xyz.molzhao.standard;

/**
 * 抽象命令类（Command）角色：声明执行命令的接口，拥有执行命令的抽象方法execute()　
 */
public interface ICommand {
    void execute();
}
```

```java
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
```

```java
package xyz.molzhao.standard;

/**
 * 实现者/接收者（Receiver）角色：执行命令的相关操作，是具体命令对象业务的真正实现者
 */
public class ReceiverA {
    public void action() {
        System.out.println("ReceiverA执行操作....");
    }
}

```

```java
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

```

```java
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
```

```bash
#结果
CommandA命令被执行...
ReceiverA执行操作....
CommandB命令被执行...
ReceiverB执行操作...
```

### TODO 扩展-备忘录
### TODO 扩展-宏命令

***

## 案例地址
欢迎大家访问我的Github地址，如果喜欢的话，希望能给个Star，[点击此处获取本案例源码](https://github.com/Normcorer/Command-Pattern.git)
***

> 该文章引用的原文链接 http://c.biancheng.net/view/1380.html
> 如果有小伙伴，想要一起交流学习的，欢迎添加博主微信。

![weChat](https://molzhao-pic.oss-cn-beijing.aliyuncs.com/Common/WeChat.png)