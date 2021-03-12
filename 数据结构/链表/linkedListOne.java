package 数据结构.链表;

class HeroNode {
    public int id;
    public String name;
    public String nickName;
    public HeroNode next; //指向下一个节点的指针

    //构造方法
    public HeroNode(int id, String name,String nickName) {
        this.id = id;
        this.name = name;
        this.nickName = nickName;
    }

    //重写toString方法
    @Override
    public String toString() {
        return "HeroNode[排名="+id+", 名字="+name+", 外号="+nickName+"]";
    }
}

public class linkedListOne {
    public static void main(String[] args) {
        //进行测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        //创建要给链表
        ListArray list = new ListArray();
        //加入数据
//        list.add(hero1);
//        list.add(hero4);
//        list.add(hero2);
//        list.add(hero3);
        //加入按照编号的顺序
        list.addByOrder(hero1);
        list.addByOrder(hero4);
        list.addByOrder(hero2);
        list.addByOrder(hero3);
        //显示一把
        list.list();
        //测试修改节点的代码
//        HeroNode newHeroNode = new HeroNode(2, "小卢", "玉麒麟~~");
//        list.update(newHeroNode);
//        System.out.println("修改后的链表情况~~");
//        list.list();
        //删除一个节点
        list.del(1);
//        list.del(4);
        System.out.println("删除后的链表情况~~");
        list.list();
    }
}

class ListArray{


    //先初始化一个头节点, 头节点不要动, 不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");

    //添加节点
    public void add(HeroNode hero) {
        //创建一个临时变量，用来遍历链表
        HeroNode temp = head;
        //遍历链表，将指针移到最后
        while (true){
            //当指针的下一个结点为null，表示遍历到了链表结尾
            if (temp.next == null){
                break;
            }
            //否则继续遍历,指针后移
            temp = temp.next;
        }
        //将新的结点添加到后面
        temp.next = hero;
    }
    //按排名添加
    public void addByOrder(HeroNode hero) {

        HeroNode temp = head;
        boolean flag = false; //找到恰当的位置，改为true

//        if (head.next == null){
//            //链表为空时，直接添加
//            head.next = hero;
//        }

        while (true){
            if (temp.next == null){
                //已经遍历到最后
                break;
            }
            if (temp.next.id > hero.id){
                break;
            }else if (temp.id == hero.id){
                flag = true;
                break;
            } else {
                //仍然未找到，指针后移
                temp = temp.next;
            }
        }
        if (flag) {
            System.out.println("英雄" + hero.name + "已存在，无法添加！！！");
        }else {
            //其他情况直接添加在temp的后面
            hero.next = temp.next;
            temp.next = hero;
        }
    }

    //显示所有
    public void list() {
        HeroNode temp = head.next;
        if (head.next == null){
            System.out.println("链表为空！！！");
            return;
        }
        while (true){
            if (temp == null){
                break;
            }
            //输出结点信息
            System.out.println(temp);
            //指针后移
            temp = temp.next;
        }
    }

    //更新结点
    public void update(HeroNode newHeroNode) {
        if (head.next == null){
            System.out.println("链表为空！！！");
        }

        HeroNode temp = head.next;
        boolean flag = false; //默认未找到
        while (true){
            if (temp.next == null){
                break; //指针移到了最后
            }
            //链表不为空，查找该节点
            if (temp.id == newHeroNode.id){
                //找到了
                flag = true;
                break;
            }
            //指针后移
            temp = temp.next;
        }

        if (flag){  //找到了
            //更改结点数据
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        }else {
            //未找到
            System.out.println("没有该英雄，无法修改！！！");
        }
    }

    //删除结点
    public void del(int i) {

        if (head.next == null){
            System.out.println("链表为空，无法删除！！！");
        }

        //辅助变量
        HeroNode temp = head;
        boolean flag = false; //判断是否找到结点的标志
        while (true){
            if (temp.next == null){
                break;
            }
            if (temp.id == i){
                //找到了
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            //找到了
            temp.next = temp.next.next;
        }else {
            System.out.println("要删除的英雄不存在，无法删除！！！");
        }
    }


}