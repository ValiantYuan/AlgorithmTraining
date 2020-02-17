/**
 * @ClassName package-info
 * @Description: 设计模式七大原则
 * 1.开闭原则 Open Closed Principle，OCP
 * Software entities should be open for extension，but closed for modification
 * 软件实体对修改关闭，对扩展开发.开闭原则是总纲
 * 可以通过“抽象约束、封装变化”来实现开闭原则，即通过接口或者抽象类为软件实体定义一个相对稳定的抽象层，而将相同的可变因素封装在相同的具体实现类中。
 * 例如：
 * Windows主题，可以设计为一个抽象类，不同的主题则是这个抽象类的实现，用户可以使用不同的主题而不影响正常的主题功能
 *
 * 2.里氏替换原则 Liskov Substitution Principle，LSP
 * Inheritance should ensure that any property proved about supertype objects also holds for subtype objects
 * 继承必须确保超类所拥有的性质在子类中仍然成立
 * 里氏替换原则通俗来讲就是：子类可以扩展父类的功能，但不能改变父类原有的功能。也就是说：子类继承父类时，除添加新的方法完成新增功能外，尽量不要重写父类的方法。
 *
 * @Author: YuanQi
 * @Date: 2019/12/12
 */
package designpatern;