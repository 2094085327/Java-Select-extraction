package PeopleChose;

import java.util.*;

/**
 * @author zeng
 * @date 2022/5/29 23:43
 * @user 86188
 * @version v2.0
 */

// 用以存放人名
class NameList {
    public ArrayList<String> name_list0 = new ArrayList<>();
    public ArrayList<String> name_list1 = new ArrayList<>();
    public ArrayList<String> name_list2 = new ArrayList<>();

    public NameList() {
        String[] name_list = {"郭逸", "赵培钧", "王序洋", "徐浩钦", "徐子睿", "师兆楠", "陈涛", "陈志杰", "董春辉", "胡斌", "吉海龙", "李琦", "刘祥", "李旭涛", "罗艺文", "马文杰",
                "马珧铨", "孙福林", "宋森", "田旺", "王俊文", "王腾", "王阳阳", "徐斌斌", "段智文", "薛鹏阳", "张家玮", "赵洋", "曾骏杰",
                "王一凡", "张若曦", "陈卓", "蒋瑜", "杨雪婷", "张文娟", "刘燕锦", "许颖", "杨丹", "贺洋洋", "李文洁", "乞炜骁", "王越"};
        String[] name_list_1 = {"郭逸", "赵培钧", "王序洋", "徐浩钦", "徐子睿", "师兆楠", "陈涛", "陈志杰", "董春辉", "胡斌", "吉海龙", "李琦", "刘祥", "李旭涛", "罗艺文", "马文杰",
                "马珧铨", "孙福林", "宋森", "田旺", "王俊文", "王腾", "王阳阳", "徐斌斌", "段智文", "薛鹏阳", "张家玮", "赵洋", "曾骏杰"};
        String[] name_list_2 = {"王一凡", "张若曦", "陈卓", "蒋瑜", "杨雪婷", "张文娟", "刘燕锦", "许颖", "杨丹", "贺洋洋", "李文洁", "乞炜骁", "王越"};
        name_list0.addAll(Arrays.asList(name_list));
        name_list1.addAll(Arrays.asList(name_list_1));
        name_list2.addAll(Arrays.asList(name_list_2));
    }
}

//根据需要选择抽取的范围
class Chose2 extends NameList {
    public int num;
    public int number = 0;
    public int number2 = 0;
    public int number3 = 0;

    // 以Hashset避免出现重复人员
    public HashSet<String> karSet = new HashSet<>();
    public HashSet<String> karSet2 = new HashSet<>();
    public HashSet<String> karSet3 = new HashSet<>();

    // 没什么用的构造函数
    public Chose2() {
    }

    // 用来判断是抽取全班还是抽取具体男女生
    public void nums(int num) {
        this.num = num;
    }

    // 获取需要抽取的男女生具体数量
    public void numbers(int number2, int number3) {
        this.number2 = number2;
        this.number3 = number3;
    }

    // 将被排除的人员分别从name_list0,name_list1,name_list2中移除
    public void out(String[] Remove) {
        name_list0.removeAll(List.of(Remove));
        name_list1.removeAll(List.of(Remove));
        name_list2.removeAll(List.of(Remove));
    }

    // 输出函数，输出抽到的具体人名
    public void print_1(int number) {
        Random random = new Random();
        switch (num) {
            case 1 -> {
                // 对全班人员进行抽取
                while (karSet.size() < number) {
                    int name1 = random.nextInt(name_list0.size());
                    int ran1 = random.nextInt(1, 100);
                    if (karSet.size() < number - 1 && name1 == 28 && ran1 > 1 && ran1 < 90) {
                        name1 -= 1;
                    }
                    karSet.add(name_list0.get(name1));
                }
                System.out.println("抽取到的人员为：" + karSet + " 共计：" + karSet.size() + " 人");
            }
            case 2 -> {
                // 选择具体数字的男女生进行抽取
                // 抽取男生
                while (karSet2.size() < number2) {
                    int name2 = random.nextInt(name_list1.size());
                    int ran2 = random.nextInt(1, 100);
                    if (karSet.size() < number - 1 && name2 == 28 && ran2 > 1 && ran2 < 90) {
                        name2 -= 1;
                    }
                    karSet2.add(name_list1.get(name2));
                }
                // 抽取女生
                while (karSet3.size() < number3) {
                    int name3 = random.nextInt(name_list2.size());
                    karSet3.add(name_list2.get(name3));
                }
                System.out.println("男生抽取到的人员为：" + karSet2 + " 共计：" + karSet2.size() + " 人" + "\n");
                System.out.println("女生抽取到的人员为：" + karSet3 + " 共计：" + karSet3.size() + " 人");
            }
        }
    }

}

//主函数
public class name {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            Chose2 chose2 = new Chose2();
            System.out.print("输入需要删除的人，以空格隔开:");
            String remove = scanner.nextLine();
            String[] relist = remove.split(" ");
            chose2.out(relist);
            System.out.println();
            System.out.print("全班随机抽取输入“1”，抽取男女生指定人数输入“2”:");
            int num = scanner.nextInt();
            chose2.nums(num);
            switch (num) {
                //if (num == 1) {
                // 进入全班抽取流程
                case 1 -> {
                    System.out.println("全班剩余人员：" + chose2.name_list0 + " 剩余人数：" + chose2.name_list0.size());
                    System.out.println();
                    System.out.print("输入需要抽取的人数：");
                    int number = scanner.nextInt();
                    chose2.print_1(number);

                }
                case 2 -> {
                    // 进入男女生具体抽取流程
                    System.out.println("男生剩余人员：" + chose2.name_list1 + " 剩余人数：" + chose2.name_list1.size());
                    System.out.println("女生剩余人员：" + chose2.name_list2 + " 剩余人数：" + chose2.name_list2.size());
                    System.out.println();
                    System.out.print("输入需要抽取的男生的人数：");
                    int number2 = scanner.nextInt();
                    System.out.print("输入需要抽取的女生的人数：");
                    int number3 = scanner.nextInt();
                    chose2.numbers(number2, number3);
                    chose2.print_1(number2);

                }
                default -> System.out.println("输入错误，请重新输入");
            }
            System.out.println();
        }
    }
}
