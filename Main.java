package com.company;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static javax.tools.Diagnostic.Kind.NOTE;

public class Main {
    private static int i,num, rola1,rola2,rola3, pho1,pho2,pho3,numa,personchange;
    private static Map<String, String> map1 = new LinkedHashMap<String, String>();
    private static Map<String, String> map2 = new LinkedHashMap<String, String>();
    private static Map<String, String> map3 = new LinkedHashMap<String, String>();
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        int x = 0;
        String s = "";
        while (!"5".equals(s)) {
            System.out.println("1. Создание пользователей");
            System.out.println("2. Редактирование пользователей");
            System.out.println("3. Удаление пользователя");
            System.out.println("4. Вывод на экран");
            System.out.println("5. Вывод из программы");
            s = scan.next();

            try {
                x = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод");
            }

            switch (x) {
                case 1:
                    person();
                    filewriter();
                    break;
                case 2:
                    personchange();
                    filewriter();
                    break;
                case 3:
                    personremove();
                    filewriter();
                    break;
                case 4:
                    filereader();
                    break;
            }
        }
        System.out.println("До свидания!");
    }
    public static void person() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        System.out.println("введите количество человек ");
        int num = Integer.parseInt(reader.readLine());
        Main.num = num;
        for (int i = 0; i < num; i++) {
            Main.i=i;
            if (num > 3 && num < 1) {
                System.out.println("слишком много или слишком мало");
                break;
            }
            names();
            secnames();
            emails();
            roles();
            phones();
            }
        }
    public static void personchange() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        System.out.println("выберите пользователя для изменения ");
        int personchange = Integer.parseInt(reader.readLine());
        Main.personchange=personchange;
        for (int i = 0; i < personchange; i++) {
        if (personchange>3 || personchange<1) {
            System.out.println("такого не существует");
            i--;
            break;
        }
        else if (personchange == 1 && Main.num >0 ) {
            System.out.println(map1.entrySet());
        }
        else if (personchange == 2 && Main.num==1) {
            System.out.println("такого не существует");
            i--;
            break;
        }
        else if (personchange == 2 && Main.num>1) {
            System.out.println(map2.entrySet());
        }
        else if (personchange == 3 && Main.num<3) {
            System.out.println("такого не существует");
            i--;
            break;
        }
        else if (personchange == 3 && Main.num==3) {
            System.out.println(map3.entrySet());
        }
            System.out.println("если хотите изменить имя введите 1");
            System.out.println("если хотите изменить фамилию введите 2");
            System.out.println("если хотите изменить почту введите 3");
            System.out.println("если хотите изменить роли введите 4");
            System.out.println("если хотите изменить телефон введите 5");
            System.out.println("если передумали введите 6");
            int numa = Integer.parseInt(reader.readLine());
            Main.numa=numa;
                if (numa == 1 && personchange==1) {
                    Main.i=personchange-1;
                    names();
                    }
                else if (numa == 1 && personchange==2) {
                    Main.i=personchange-1;
                    names();
            }
                else if (numa == 1 && personchange==3) {
                    Main.i=personchange-1;
                    names();
            }
                else if (numa == 2 && personchange==1) {
                    Main.i=personchange-1;
                    secnames();
                }
                else if (numa == 2 && personchange==2) {
                    Main.i=personchange-1;
                    secnames();
                }
                else if (numa == 2 && personchange==3) {
                    Main.i=personchange-1;
                    secnames();
                }
                else if (numa == 3 && personchange==1) {
                    Main.i=personchange-1;
                    emails();
                }
                else if (numa == 3 && personchange==2) {
                    Main.i=personchange-1;
                    emails();
                }
                else if (numa == 3 && personchange==3) {
                    Main.i=personchange-1;
                    emails();
                }
                else if (numa == 4 && personchange==1) {
                    Main.i=personchange-1;
                    changeroles();
                    }
                else if (numa == 4 && personchange==2) {
                    Main.i=personchange-1;
                    changeroles();
                }
                else if (numa == 4 && personchange==3) {
                    Main.i=personchange-1;
                    changeroles();
                }
                else if (numa == 5 && personchange==1) {
                    Main.i=personchange-1;
                    changephones();
                }
                else if (numa == 5 && personchange==2) {
                    Main.i=personchange-1;
                    changephones();
                }
                else if (numa == 5 && personchange==3) {
                    Main.i=personchange-1;
                    changephones();
                }
                }
            }
    public static void personremove() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("введите пользователя для удаления");
        int numremove = Integer.parseInt(reader.readLine());
            if (numremove>3 || numremove<1) {
                System.out.println("такого не существует");
            }
            else if (numremove == 1 && Main.num >0){
                map1.clear();
            }
            else if (numremove == 2 && Main.num==1){
                System.out.println("такого не существует");
            }
            else if (numremove == 2 && Main.num>1){
                map2.clear();
            }
            else if (numremove == 3 && Main.num<3){
                System.out.println("такого не существует");
            }
            else if (numremove == 3 && Main.num==3){
                map3.clear();
            }
    }
    public static void filereader(){
        try(FileReader reader = new FileReader("notes3.txt"))
        {
            char[] buf = new char[256];
            int c;
            while((c = reader.read(buf))>0){
                if(c < 256){
                    buf = Arrays.copyOf(buf, c);
                }
                System.out.print(buf);
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    public static void filewriter(){
        try(FileWriter writer = new FileWriter("notes3.txt", false)) {
            if (!map1.isEmpty() && !map2.isEmpty() && !map3.isEmpty()){
                writer.write(String.valueOf("user:" + 1 + map1+"\n"));
                writer.write(String.valueOf("user:" + 2 + map2+"\n"));
                writer.write(String.valueOf("user:" + 3 + map3+"\n"));
            }
            else if (!map1.isEmpty() && !map2.isEmpty() && map3.isEmpty()) {
                writer.write(String.valueOf("user:" + 1 + map1+"\n"));
                writer.write(String.valueOf("user:" + 2 + map2+"\n"));
            }
            else if (!map1.isEmpty() && map2.isEmpty() && map3.isEmpty()){
                writer.write(String.valueOf("user:" + 1 + map1+"\n"));
            }
            else if(map1.isEmpty() && !map2.isEmpty() && map3.isEmpty()){
                writer.write(String.valueOf("user:" + 2 + map2+"\n"));
            }
            else if(!map1.isEmpty() && map2.isEmpty() && !map3.isEmpty()){
                writer.write(String.valueOf("user:" + 1 + map1+"\n"));
                writer.write(String.valueOf("user:" + 3 + map3+"\n"));
            }
            if (map1.isEmpty() && !map2.isEmpty() && !map3.isEmpty()){
                writer.write(String.valueOf("user:" + 2 + map2+"\n"));
                writer.write(String.valueOf("user:" + 3 + map3+"\n"));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void names(){
        Scanner sc= new Scanner(System.in);
        for (int j =Main.i; j < Main.i+1; j++) {
        System.out.println("введите имя " + (j + 1));
        String name = sc.nextLine();
        if (j == 0) {
            map1.put("name " + (j + 1), name);
        } else if (j == 1) {
            map2.put("name " + (j + 1), name);
        } else if (j == 2) {
            map3.put("name " + (j + 1), name);
        }
    }
    }
    public static void secnames(){
        Scanner sc= new Scanner(System.in);
        for (int j = Main.i; j < Main.i+1; j++) {
            System.out.println("введите фамилию " + (j + 1));
            String secname = sc.nextLine();
            if (j == 0) {
                map1.put("second name " + (j + 1), secname);
            } else if (j == 1) {
                map2.put("second name " + (j + 1), secname);
            } else if (j == 2) {
                map3.put("second name " + (j + 1), secname);
            }
        }
    }
    public static void emails(){
        Scanner sc= new Scanner(System.in);
        for (int j = Main.i; j < Main.i+1; j++) {
            System.out.println("введите почту " + (j + 1));
            String mail = sc.nextLine();
            if (j == 0) {
                Pattern pattern=Pattern.compile("^((\\w|[-+])+(\\.[\\w-]+)*@[\\w-]+((\\.[\\d\\p{Alpha}]+)*(\\.\\p{Alpha}{2,})*)*)$");
                Matcher matcher=pattern.matcher(mail);
                if(matcher.matches()){
                    System.out.println(mail+" correct");
                    map1.put("email address " + (j + 1), mail);
                }
                else{
                    System.out.println(mail+" incorrect");
                    j--;
                }
            } else if (j == 1) {
                Pattern pattern=Pattern.compile("^((\\w|[-+])+(\\.[\\w-]+)*@[\\w-]+((\\.[\\d\\p{Alpha}]+)*(\\.\\p{Alpha}{2,})*)*)$");
                Matcher matcher=pattern.matcher(mail);
                if(matcher.matches()){
                    System.out.println(mail+" correct");
                    map2.put("email address " + (j + 1), mail);
                }
                else{
                    System.out.println(mail+" incorrect");
                    j--;
                }
            } else if (j == 2) {
                Pattern pattern=Pattern.compile("^((\\w|[-+])+(\\.[\\w-]+)*@[\\w-]+((\\.[\\d\\p{Alpha}]+)*(\\.\\p{Alpha}{2,})*)*)$");
                Matcher matcher=pattern.matcher(mail);
                if(matcher.matches()){
                    System.out.println(mail+" correct");
                    map3.put("email address " + (j + 1), mail);
                }
                else{
                    System.out.println(mail+" incorrect");
                    j--;
                }
            }
        }
    }
    public static void roles() throws IOException {
        Scanner sc= new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int k = Main.i; k < Main.i+1; k++) {
            System.out.println("введите количество ролей для пользователя " + (k + 1));
            if(k==0) {
                int rola1 = Integer.parseInt(reader.readLine());
                Main.rola1 = rola1;
                if(rola1>3 && rola1<1) {
                    System.out.println("такая роль не существует");
                    k--;
                    break;
                }
                for (int j = 0; j < rola1; j++) {
                    System.out.println("введите роль " + (j + 1));
                    String ro = sc.nextLine();
                    map1.put("role " + (j + 1), ro);
                }
            }
            else if(k==1) {
                int rola2 = Integer.parseInt(reader.readLine());
                Main.rola2 = rola2;
                if(rola2>3 && rola2<1) {
                    System.out.println("такая роль не существует");
                    k--;
                    break;
                }
                for (int j = 0; j < rola2; j++) {
                    System.out.println("введите роль " + (j + 1));
                    String ro = sc.nextLine();
                    map2.put("role " + (j + 1), ro);
                }
            }
            else if(k==2) {
                int rola3 = Integer.parseInt(reader.readLine());
                Main.rola3 = rola3;
                if(rola3>3 && rola3<1) {
                    System.out.println("такая роль не существует");
                    k--;
                    break;
                }
                for (int j = 0; j < rola3; j++) {
                    System.out.println("введите роль " + (j + 1));
                    String ro = sc.nextLine();
                    map3.put("role " + (j + 1), ro);
                }
            }
        }
    }
    public static void phones() throws IOException {
        Scanner sc= new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int k = Main.i; k < Main.i+1; k++) {
            System.out.println("введите количество номеров для пользователя " + (k + 1));
            if(k==0) {
                int pho1 = Integer.parseInt(reader.readLine());
                Main.pho1 = pho1;
                if(pho1>3 && pho1<1) {
                    System.out.println("такой номер не существует");
                    k--;
                    break;
                }
                for (int j = 0; j < pho1; j++) {
                    System.out.println("введите номер телефона " + (j + 1));
                    String phone = sc.nextLine();
                    Pattern pattern=Pattern.compile("^((375)([0-9]{2}[0-9]{7}))$");
                    Matcher matcher=pattern.matcher(phone);
                    if(matcher.matches()){
                        System.out.println(phone+" correct");
                        map1.put("phone " + (j + 1), phone);
                    }
                    else{
                        System.out.println(phone+" incorrect");
                        j--;
                    }
                }
            }
            else if(k==1) {
                int pho2 = Integer.parseInt(reader.readLine());
                Main.pho2 = pho2;
                if(pho2>3 && pho2<1) {
                    System.out.println("такой телефон не существует");
                    k--;
                    break;
                }
                for (int j = 0; j < pho2; j++) {
                    System.out.println("введите номер телефона " + (j + 1));
                    String phone = sc.nextLine();
                    Pattern pattern=Pattern.compile("^((375)([0-9]{2}[0-9]{7}))$");
                    Matcher matcher=pattern.matcher(phone);
                    if(matcher.matches()){
                        System.out.println(phone+" correct");
                        map2.put("phone " + (j + 1), phone);
                    }
                    else{
                        System.out.println(phone+" incorrect");
                        j--;
                    }
                }
            }
            if(k==2) {
                int pho3 = Integer.parseInt(reader.readLine());
                Main.pho3 = pho3;
                if(pho3>3 && pho3<1) {
                    System.out.println("такой телефон не существует");
                    k--;
                    break;
                }
                for (int j = 0; j < pho3; j++) {
                    System.out.println("введите номер телефона " + (j + 1));
                    String phone = sc.nextLine();
                    Pattern pattern=Pattern.compile("^((375)([0-9]{2}[0-9]{7}))$");
                    Matcher matcher=pattern.matcher(phone);
                    if(matcher.matches()){
                        System.out.println(phone+" correct");
                        map3.put("phone " + (j + 1), phone);
                    }
                    else{
                        System.out.println(phone+" incorrect");
                        j--;
                    }
                }
            }

    }
}
    public static void changeroles() throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int k = 0; k < 1; k++) {
         if (numa == 4 && personchange == 1) {
                System.out.println("выберите роль для изменения ");
                int rol = Integer.parseInt(reader.readLine());
                if (rol > Main.rola1) {
                    System.out.println("такой не существует");
                    break;
                } else if (rol == 1) {
                    System.out.println("введите role 1");
                    String ro = sc.nextLine();
                    map1.put("role 1", ro);
                } else if (rol == 2) {
                    System.out.println("введите role 2");
                    String ro = sc.nextLine();
                    map1.put("role 2", ro);
                } else if (rol == 3) {
                    System.out.println("введите role 3");
                    String ro = sc.nextLine();
                    map1.put("role 3", ro);
                }
            }
         else if (numa == 4 && personchange == 2) {
                System.out.println("выберите роль для изменения ");
                int rol = Integer.parseInt(reader.readLine());
                if (rol > Main.rola2) {
                    System.out.println("такой не существует");
                    break;
                } else if (rol == 1) {
                    System.out.println("введите role 1");
                    String ro = sc.nextLine();
                    map2.put("role 1", ro);
                } else if (rol == 2) {
                    System.out.println("введите role 2");
                    String ro = sc.nextLine();
                    map2.put("role 2", ro);
                } else if (rol == 3) {
                    System.out.println("введите role 3");
                    String ro = sc.nextLine();
                    map2.put("role 3", ro);
                }
            }
         else if (numa == 4 && personchange == 3) {
                System.out.println("выберите роль для изменения ");
                int rol = Integer.parseInt(reader.readLine());
                if (rol > Main.rola3) {
                    System.out.println("такой не существует");
                    break;
                } else if (rol == 1) {
                    System.out.println("введите role 1");
                    String ro = sc.nextLine();
                    map3.put("role 1", ro);
                } else if (rol == 2) {
                    System.out.println("введите role 2");
                    String ro = sc.nextLine();
                    map3.put("role 2", ro);
                } else if (rol == 3) {
                    System.out.println("введите role 3");
                    String ro = sc.nextLine();
                    map3.put("role 3", ro);
                }
            }
        }
    }
    public static void changephones() throws IOException {
        Scanner sc= new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int k = 0; k < 1; k++) {
             if (numa == 5 && personchange==1) {
                System.out.println("выберите телефон для изменения ");
                int pho = Integer.parseInt(reader.readLine());
                if(pho>Main.pho1) {
                    System.out.println("такой не существует");
                    break;
                }
                else if(pho==1){
                    System.out.println("введите phone 1");
                    String phone = sc.nextLine();
                    Pattern pattern=Pattern.compile("^((375)([0-9]{2}[0-9]{7}))$");
                    Matcher matcher=pattern.matcher(phone);
                    if(matcher.matches()){
                        System.out.println(phone+" correct");
                        map1.put("phone 1", phone);
                    }
                    else{
                        System.out.println(phone+" incorrect");
                        k--;
                    }
                }
                else if(pho==2){
                    System.out.println("введите phone 2");
                    String phone = sc.nextLine();
                    Pattern pattern=Pattern.compile("^((375)([0-9]{2}[0-9]{7}))$");
                    Matcher matcher=pattern.matcher(phone);
                    if(matcher.matches()){
                        System.out.println(phone+" correct");
                        map1.put("phone 2", phone);
                    }
                    else{
                        System.out.println(phone+" incorrect");
                        k--;
                    }
                }
                else if(pho==3){
                    System.out.println("введите phone 3");
                    String phone = sc.nextLine();
                    Pattern pattern=Pattern.compile("^((375)([0-9]{2}[0-9]{7}))$");
                    Matcher matcher=pattern.matcher(phone);
                    if(matcher.matches()){
                        System.out.println(phone+" correct");
                        map1.put("phone 3", phone);
                    }
                    else{
                        System.out.println(phone+" incorrect");
                        k--;
                    }
                }
            }
            else if (numa == 5 && personchange==2) {
                System.out.println("выберите телефон для изменения ");
                int pho = Integer.parseInt(reader.readLine());
                if(pho>Main.pho2) {
                    System.out.println("такой не существует");
                    break;
                }
                else if(pho==1){
                    System.out.println("введите phone 1");
                    String phone = sc.nextLine();
                    Pattern pattern=Pattern.compile("^((375)([0-9]{2}[0-9]{7}))$");
                    Matcher matcher=pattern.matcher(phone);
                    if(matcher.matches()){
                        System.out.println(phone+" correct");
                        map2.put("phone 1", phone);
                    }
                    else{
                        System.out.println(phone+" incorrect");
                        k--;
                    }
                }
                else if(pho==2){
                    System.out.println("введите phone 2");
                    String phone = sc.nextLine();
                    Pattern pattern=Pattern.compile("^((375)([0-9]{2}[0-9]{7}))$");
                    Matcher matcher=pattern.matcher(phone);
                    if(matcher.matches()){
                        System.out.println(phone+" correct");
                        map2.put("phone 2", phone);
                    }
                    else{
                        System.out.println(phone+" incorrect");
                        k--;
                    }
                }
                else if(pho==3){
                    System.out.println("введите phone 3");
                    String phone = sc.nextLine();
                    Pattern pattern=Pattern.compile("^((375)([0-9]{2}[0-9]{7}))$");
                    Matcher matcher=pattern.matcher(phone);
                    if(matcher.matches()){
                        System.out.println(phone+" correct");
                        map2.put("phone 3", phone);
                    }
                    else{
                        System.out.println(phone+" incorrect");
                        k--;
                    }
                }
            }
            else if (numa == 5 && personchange==3) {
                System.out.println("выберите телефон для изменения ");
                int pho = Integer.parseInt(reader.readLine());
                if(pho>Main.pho3) {
                    System.out.println("такой не существует");
                    break;
                }
                else if(pho==1){
                    System.out.println("введите phone 1");
                    String phone = sc.nextLine();
                    Pattern pattern=Pattern.compile("^((375)([0-9]{2}[0-9]{7}))$");
                    Matcher matcher=pattern.matcher(phone);
                    if(matcher.matches()){
                        System.out.println(phone+" correct");
                        map3.put("phone 1", phone);
                    }
                    else{
                        System.out.println(phone+" incorrect");
                        k--;
                    }
                }
                else if(pho==2){
                    System.out.println("введите phone 2");
                    String phone = sc.nextLine();
                    Pattern pattern=Pattern.compile("^((375)([0-9]{2}[0-9]{7}))$");
                    Matcher matcher=pattern.matcher(phone);
                    if(matcher.matches()){
                        System.out.println(phone+" correct");
                        map3.put("phone 2", phone);
                    }
                    else{
                        System.out.println(phone+" incorrect");
                        k--;
                    }
                }
                else if(pho==3){
                    System.out.println("введите phone 3");
                    String phone = sc.nextLine();
                    Pattern pattern=Pattern.compile("^((375)([0-9]{2}[0-9]{7}))$");
                    Matcher matcher=pattern.matcher(phone);
                    if(matcher.matches()){
                        System.out.println(phone+" correct");
                        map3.put("phone 3", phone);
                    }
                    else{
                        System.out.println(phone+" incorrect");
                        k--;
                    }
                }
            }
        }
    }
}