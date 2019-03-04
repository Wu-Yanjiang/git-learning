public class Animal {
    private String name;
    private int age;
    public Animal(String name, int age){
        this.name = name;
//        this调用自己的，super调用父类的
        this.age = age;
    }

    public void eat(){
        System.out.println(name + "正在吃!");
    }

    public void age(){
        System.out.println(name + age + "岁了!");
    }

    public void introduction(){
        System.out.println("我是" + name);
    }

}
