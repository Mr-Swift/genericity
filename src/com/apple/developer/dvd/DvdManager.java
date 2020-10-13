package com.apple.developer.dvd;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@SuppressWarnings("all")
public class DvdManager {
    private Scanner input = new Scanner(System.in);
    private Map<String, DvdSet> dvd = new HashMap<String, DvdSet>();

    public void start() throws ParseException {                           //方法：开始，先进行系统初始化，然后菜单。
        this.initial();
        while (true) {
            this.menu();
        }
    }

    private void initial() {
        DvdSet dvd1 = new DvdSet();
        dvd1.countsAdd();
        dvd1.setState("已借出");
        dvd1.setDate("2010-07-01");
        dvd.put("罗马假日", dvd1);
        dvd.put("风声鹤唳", new DvdSet());
        dvd.put("浪漫满屋", new DvdSet());
    }

    private void menu() throws ParseException {
        System.out.println("\n欢迎来到迷你DVD管理器");
        //System.out.println("__________________");
        System.out.println("0、DVD排行榜");
        System.out.println("1、新增DVD");
        System.out.println("2、查看DVD");
        System.out.println("3、删除DVD");
        System.out.println("4、借出DVD");
        System.out.println("5、归还DVD");
        System.out.println("6、退出");
        System.out.println("__________________");
        System.out.print("请输入您的选择：");
        try {
            int choice = input.nextInt();

            switch (choice) {
//                case 0:
//                    //this.sortDVD();
//                    break;
                case 1:
                    this.addDVD();
                    break;
                case 2:
                    this.printDVD();
                    break;
                case 3:
                    this.delDVD();
                    break;
                case 4:
                    this.lendDVD();
                    break;
                case 5:
                    this.returnDVD();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("输入不正确，请重新输入！");
                    this.menu();
                    break;
            }
        } catch (InputMismatchException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return;
    }

    private void returnDVD() throws ParseException {
        System.out.print("请输入您要归还的DVD名字：");
        String name = input.next();
        Set set = dvd.keySet();
        if (!set.contains(name)) {
            System.out.println("对不起，你要还的这部DVD不存在！");
        } else {
            if (dvd.get(name).getState().equals("可出借")) {
                System.out.println("这部DVD尚未出借，无需归还！");
            } else {
                Date dateRetuen = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date dateLend = sdf.parse(dvd.get(name).getDate());
                long day = (dateRetuen.getTime() - dateLend.getTime()) / (1000 * 24 * 60 * 60);
                double money = day * 2;
                System.out.println("请付款：" + money);
                System.out.println("归还成功...");
                dvd.get(name).setDate(" ");
                dvd.get(name).setState("可出借");
                this.printDVD();
                System.out.print("是否继续归还：（y/n）");
                String s = input.next();
                if (s.equals("y")) {
                    this.returnDVD();
                } else {
                    return;
                }
            }
        }

    }

    private void lendDVD() {
        this.printDVD();
        System.out.print("请输入您要借的DVD名字：");
        String name = input.next();
        Set set = dvd.keySet();
        if (!set.contains(name)) {
            System.out.println("对不起，你要借的这部DVD不存在！");
        } else {
            if (dvd.get(name).getState().equals("已借出")) {
                System.out.println("对不起，这部DVD已借出，请在归还后再尝试借阅！");
            } else {
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String str = sdf.format(date);
                dvd.get(name).setDate(str);
                dvd.get(name).countsAdd();
                dvd.get(name).setState("已借出");
                System.out.println("借出成功...");
                this.printDVD();
                System.out.print("是否继续借DVD：（y/n）");
                String s = input.next();
                if (s.equals("y")) {
                    this.lendDVD();
                } else {
                    return;
                }
            }
        }
    }

    private void delDVD() {
        System.out.print("请输入您要删除的DVD名字：");
        String name = input.next();
        Set set = dvd.keySet();
        if (!set.contains(name)) {
            System.out.println("对不起，您要删除的DVD不存在！");
        } else {
            if (dvd.get(name).getState().equals("已借出")) {
                System.out.println("对不起，这部DVD已借出，请在归还后再尝试删除！");
            } else {
                dvd.remove(name);
                System.out.println("删除成功......");
                this.printDVD();
                System.out.print("是否继续删除：（y/n）");
                String s = input.next();
                if (s.equals("y")) {
                    this.delDVD();
                } else {
                    return;
                }
            }
        }
    }

    private void printDVD() {
        System.out.println("名字\t\t\t出借次数\t\t\t状态\t\t\t\t出借日期");
        Set set = dvd.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            System.out.println(key + "\t\t\t" + dvd.get(key));
        }
    }

    private void addDVD() {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入您要添加的DVD名字：");
        String name = input.nextLine();
        Set set = dvd.keySet();
        if (set.contains(name)) {
            System.out.println("对不起，" + name + "已经存在了,不能添加！");
        } else {
            dvd.put(name, new DvdSet());
            System.out.println("添加成功.......");
            this.printDVD();
            System.out.print("是否继续添加：（y/n）");
            String s = input.next();
            if (s.equals("y")) {
                this.addDVD();
            } else {
                return;
            }
        }
    }
}
